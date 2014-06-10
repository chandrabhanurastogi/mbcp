package com.ifli.mbcp.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ifli.mbcp.domain.Lead;
import com.ifli.mbcp.vo.SearchCriteriaBean;

/**
 * 
 * @author Niranjan
 * @since 6 May 2013
 * @version 1.0
 */
@Component
public interface LeadDAO extends GenericDAO<Lead>
{
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
	List<Lead> findByFirstOrLastName(String value);

	/**
	 * Generic search method which returns the Leads matching the given search
	 * criteria. The value field can be parsed to its respective expected type
	 * without fearing the Cast exceptions because the value field for
	 * corresponding search criteria is already been validated in
	 * LeadSearchValidator
	 * 
	 * @param searchCriteria
	 *            search criteria
	 * @return list of Lead instances matching the given search criteria or null
	 *         for any unsupported searchBy clause
	 */
	List<Lead> search(SearchCriteriaBean searchCriteria);

}
