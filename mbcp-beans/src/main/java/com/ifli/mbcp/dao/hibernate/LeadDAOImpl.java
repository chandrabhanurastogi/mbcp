package com.ifli.mbcp.dao.hibernate;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ifli.mbcp.dao.LeadDAO;
import com.ifli.mbcp.dao.exceptions.DAOException;
import com.ifli.mbcp.domain.Lead;
import com.ifli.mbcp.util.MBCPConstants;
import com.ifli.mbcp.util.MBCPConstants.Lifecycle;
import com.ifli.mbcp.util.MBCPConstants.PageType;
import com.ifli.mbcp.util.MBCPConstants.SearchBy;
import com.ifli.mbcp.util.MBCPUtil;
import com.ifli.mbcp.vo.SearchCriteriaBean;
import com.liferay.portal.kernel.util.StringPool;

/**
 * Class responsible for performing operations specific to Lead Entity
 * 
 * @author Niranjan
 * @since 6 May 2013
 * @version 1.0
 */
@Repository("leadDAO")
@Transactional
public class LeadDAOImpl extends GenericDAOImpl<Lead> implements LeadDAO
{

	public LeadDAOImpl()
	{
	}

	/**
	 * Returns a list of Lead instances whose First name or Last name starts
	 * with the given value or an empty list if no results found
	 * 
	 * @param value
	 *            search lead by this value
	 * 
	 * @return list of Lead instances matching the give search criteria or empty
	 *         list if no results found
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Lead> findByFirstOrLastName(final String value)
	{

		List<Lead> list = null;
		try
		{
			final String queryString = "from Lead as lead where lead.leadCustomerDetails.firstName like '" + value
					+ "%' or lead.leadCustomerDetails.lastName like '" + value + "%'";
			HibernateCallback hc = new HibernateCallback()
			{
				public List<Lead> doInHibernate(Session session) throws HibernateException, SQLException
				{
					return session.createQuery(queryString).list();
				}
			};
			list = (List<Lead>) hibernateTemplate.execute(hc);
		}
		catch (RuntimeException re)
		{

			throw re;
		}

		return list;
	}

	/**
	 * Generic search method which returns the Leads matching the given search
	 * criteria. The value field can be parsed to its respective expected type
	 * without fearing the Cast exceptions because the value field for
	 * corresponding search criteria is already been validated in
	 * LeadSearchValidator
	 * 
	 * @param searchCriteria
	 *            search criteria
	 * @return list of Lead instances matching the given search criteria or
	 *         empty list if results not found or null for any unsupported
	 *         searchBy clause
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Lead> search(final SearchCriteriaBean searchCriteria)
	{
		boolean includeLifecycleInWhereClause = true;
		int searchBy = searchCriteria.getSearchById();
		String value = searchCriteria.getSearchText();
		// Create the main Criteria
		final DetachedCriteria leadCriteria = DetachedCriteria.forClass(Lead.class);

		// Restriction to Search Individual or Group Lead
		leadCriteria.createAlias("kindOfLead", "kol").add(Restrictions.eq("kol.name", searchCriteria.getLeadType()));

		if (searchBy == SearchBy.LEAD_ID.getValue())
		{
			leadCriteria.add(Restrictions.eq("leadId", Long.valueOf(value)));

		}

		else if (searchBy == SearchBy.PRODUCT.getValue())
		{
			/* TODO For Performance improvement
			only: This is selecting all the non-sense in the world along with what we are interested in, check if can be fine tuned
			 */
			leadCriteria.createAlias("proposalsMade", "p",CriteriaSpecification.INNER_JOIN)
						.createAlias("p.insuranceProduct", "ip")
									.add(Restrictions.eq("ip.name", value));
		/*	
		 	String hql = "select lead from Lead lead join fetch lead.proposalsMade p where p.insuranceProduct.name = ?";
			return hibernateTemplate.find(hql, value);
		 */
		}
		else if (searchBy == SearchBy.FIRST_OR_LAST_NAME.getValue())
		{
			leadCriteria.createAlias("leadCustomerDetails", "lcd").add(
					Restrictions.or(Restrictions.like("lcd.firstName", value + StringPool.PERCENT),
							Restrictions.like("lcd.lastName", value + StringPool.PERCENT)));

		}
		else if (searchBy == SearchBy.LEAD_STATUS.getValue())
		{

			leadCriteria.createAlias("leadStatus", "ls").add(Restrictions.eq("ls.name", value));

		}
		else if (searchBy == SearchBy.MOBILE_NO.getValue())
		{
			leadCriteria.createAlias("leadCustomerDetails", "lcd").add(Restrictions.eq("lcd.mobileNumber", value));

		}
		else if (searchBy == SearchBy.LEAD_CREATED_DATE.getValue())
		{

			try
			{
				Date date = new SimpleDateFormat(MBCPConstants.LEAD_DATE_FORMAT).parse(value);
				leadCriteria.add(Restrictions.between("createdDate", MBCPUtil.getLeadingDate(date),
						MBCPUtil.getTrailingDate(date)));

			}
			catch (ParseException e)
			{
				throw new RuntimeException("Incorrect Date Format : " + value);
			}

		}
		else if (searchBy == SearchBy.PENDING_STAGE.getValue())
		{
			includeLifecycleInWhereClause = false;
			leadCriteria.add(Restrictions.eq("lifecycleState", Short.valueOf(value)));

		}
		else
		{

			/*
			 * If you are here then we have a search criteria which we cant
			 * handle, someone broke into our site or Intercepting and injecting
			 * wrong Search Criteria knowing we can handle that. To the hacker :
			 * Poor kid, we cant handle ur query but can break ourselves!!
			 */
			throw new DAOException("Invalid Search Criteria");
		}

		/*
		 * Impose an implicit restriction on Lifecycle if search itself is not
		 * on Lifecycle State i.e, PENDING_STAGE. Fetch all the Leads whose
		 * lifecyclestate corresponds to the PageType when the search is
		 * performed on a page other than Lead
		 */
		if (includeLifecycleInWhereClause && searchCriteria.getPageType() != PageType.LEAD)
		{
			leadCriteria.add(Restrictions.eq("lifecycleState",
					Lifecycle.getLifecycleByState((short) searchCriteria.getPageType()).getValue()));
		}

		// Now that we have framed the search criteria Its time to run the query
		// on Executable Criteria
		List<Lead> list = null;
		try
		{
			HibernateCallback hc = new HibernateCallback()
			{
				public List<Lead> doInHibernate(Session session) throws HibernateException, SQLException
				{
					Criteria criteria = leadCriteria.getExecutableCriteria(session);

					// setFetchSize and setFirstResult will come handy when u
					// introduce pagination for search results
					if (searchCriteria.getFetchSize() > -1)
					{
						criteria.setFetchSize(searchCriteria.getFetchSize());
					}
					if (searchCriteria.getStart() > -1)
					{
						criteria.setFirstResult(searchCriteria.getStart());
					}
					return criteria.list();
				}
			};
			list = (List<Lead>) hibernateTemplate.execute(hc);
		}
		catch (RuntimeException re)
		{

			throw re;
		}

		return list;

	}

	/*
	 * Previous public List<Lead> search(SearchCriteriaBean searchCriteria) {
	 * 
	 * int searchBy = searchCriteria.getSearchById(); String value =
	 * searchCriteria.getSearchText();
	 * 
	 * if (searchBy == SearchBy.LEAD_ID.getValue()) {
	 * 
	 * return findByProperty(Lead.class, "leadId", Long.valueOf(value));
	 * 
	 * }
	 * 
	 * else if (searchBy == SearchBy.PRODUCT.getValue()) {
	 * 
	 * String hql =
	 * "select lead from Lead lead join fetch lead.proposalsMade p where p.insuranceProduct.name = ?"
	 * ;
	 * 
	 * return hibernateTemplate.find(hql, value);
	 * 
	 * } else if (searchBy == SearchBy.FIRST_OR_LAST_NAME.getValue()) {
	 * 
	 * return findByFirstOrLastName(value);
	 * 
	 * } else if (searchBy == SearchBy.LEAD_STATUS.getValue()) {
	 * 
	 * return findByProperty(Lead.class, "leadStatus.name", value);
	 * 
	 * } else if (searchBy == SearchBy.MOBILE_NO.getValue()) {
	 * 
	 * return findByProperty(Lead.class, "leadCustomerDetails.mobileNumber",
	 * value);
	 * 
	 * } else if (searchBy == SearchBy.LEAD_CREATED_DATE.getValue()) {
	 * 
	 * try { return findByDateIgnoringTS(Lead.class, "createdDate", new
	 * SimpleDateFormat(MBCPConstants.LEAD_DATE_FORMAT).parse(value)); } catch
	 * (ParseException e) { throw new
	 * RuntimeException("Incorrect Date Format : " + value); }
	 * 
	 * } else if (searchBy == SearchBy.PENDING_STAGE.getValue()) { return
	 * findByProperty(Lead.class, "lifecycleState", Short.valueOf(value));
	 * 
	 * }
	 * 
	 * return null; }
	 */
}
