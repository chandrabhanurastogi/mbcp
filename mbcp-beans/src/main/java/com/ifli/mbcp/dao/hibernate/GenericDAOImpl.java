package com.ifli.mbcp.dao.hibernate;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ifli.mbcp.dao.GenericDAO;
import com.ifli.mbcp.util.MBCPUtil;

/**
 * Class Used to perform Hibernate Basic CRUD Operations.
 * 
 * @author Niranjan
 * @since 6 May 2013
 * @version 1.0
 */

@Repository("genericDAO")
@Transactional
public class GenericDAOImpl<T> implements GenericDAO<T>
{

	@SuppressWarnings("unused")
	private SessionFactory		sessionFactory;
	protected HibernateTemplate	hibernateTemplate;
	private static final Logger	logger	= LoggerFactory.getLogger(GenericDAOImpl.class);

	/**
	 * Persist the given transient instance
	 * 
	 * @param pojo
	 * @return Id
	 */
	public Serializable save(T pojo)
	{
		Serializable Id = null;
		try
		{
			Id = hibernateTemplate.save(pojo);
		}
		catch (HibernateException e)
		{
			logger.error("save failed", e);
			throw e;
		}
		return Id;
	}

	/**
	 * Update the persistent instance
	 * 
	 * @param pojo
	 */
	public void update(T pojo)
	{
		try
		{
			hibernateTemplate.update(pojo);
		}
		catch (HibernateException e)
		{
			throw e;
		}
	}

	public void merge(T pojo)
	{
		try
		{
			hibernateTemplate.merge(pojo);
		}
		catch (HibernateException e)
		{
			throw e;
		}
	}

	/**
	 * Either save(Object) or update(Object) the given instance, depending upon
	 * resolution of the unsaved-value checks
	 * 
	 * @param pojo
	 */
	public void saveOrUpdate(T pojo)
	{
		try
		{
			hibernateTemplate.saveOrUpdate(pojo);
		}
		catch (HibernateException e)
		{
			throw e;
		}
	}

	/**
	 * Remove a persistent instance from the data store
	 * 
	 * @param pojo
	 */
	public void delete(T pojo)
	{
		try
		{
			hibernateTemplate.delete(pojo);
		}
		catch (HibernateException e)
		{
			throw e;
		}
	}

	/**
	 * Deletes the persistent instance of the given entity class with the given
	 * identifier
	 * 
	 * @param classObject
	 * @param Id
	 */
	public void deleteById(Class<T> classObject, Serializable Id)
	{
		try
		{
			T pojo = findById(classObject, Id);
			if (pojo != null)
			{
				delete(pojo);
			}
		}
		catch (HibernateException e)
		{
			throw e;
		}
	}

	/**
	 * Return the persistent instance of the given entity class with the given
	 * identifier, or null if there is no such persistent instance.
	 * 
	 * @param classObject
	 * @param Id
	 * @return object
	 */
	public T findById(Class<T> classObject, Serializable Id)
	{

		T pojo = null;
		try
		{
			pojo = (T) hibernateTemplate.get(classObject, Id);

		}
		catch (HibernateException e)
		{

			throw e;
		}

		return pojo;
	}

	/**
	 * Return the list of persistent instances of the given entity class which
	 * matches the given pojo object
	 * 
	 * @param classObject
	 * @param pojo
	 * @param strict
	 *            false if pattern matching, true if exact matching
	 * @return list of objects
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByExample(T pojo)
	{

		List<T> list = null;
		try
		{
			list = (List<T>) hibernateTemplate.findByExample(pojo);

		}
		catch (HibernateException e)
		{

			throw e;
		}

		return list;
	}

	/**
	 * Return the list of all persistent instances of the given entity class
	 * 
	 * @param classObject
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> findAll(Class<T> classObject)
	{

		List<T> list;
		try
		{
			list = (List<T>) hibernateTemplate.findByCriteria(DetachedCriteria.forClass(classObject));

		}
		catch (HibernateException e)
		{

			throw e;
		}

		return list;
	}

	/**
	 * Method used to set sessionFactory.
	 * 
	 * @param sessionFactory
	 */
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory)
	{

		this.sessionFactory = sessionFactory;
		if (this.hibernateTemplate == null || sessionFactory != this.hibernateTemplate.getSessionFactory())
		{
			this.hibernateTemplate = new HibernateTemplate(sessionFactory);
		}

	}

	/**
	 * Method used to return list of entities based on the property.
	 * 
	 * @param classObject
	 * @param propertyName
	 * @param value
	 * @return List<T>
	 */

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> findByProperty(Class<T> classObject, String propertyName, final Object value)
	{

		List<T> list = null;
		try
		{
			final String queryString = "from " + classObject.getName() + " as model where model." + propertyName + "= ?";
			HibernateCallback hc = new HibernateCallback()
			{
				public List<T> doInHibernate(Session session) throws HibernateException, SQLException
				{
					return session.createQuery(queryString).setParameter(0, value).list();
				}
			};
			list = (List<T>) hibernateTemplate.execute(hc);
		}
		catch (RuntimeException re)
		{

			throw re;
		}

		return list;
	}

	/**
	 * Method used to return the identifier(PK) of the Entity based on the
	 * property. The special property (lowercase) <b>id<b> may be used to
	 * reference the identifier property of an entity provided that the entity
	 * does not define a non-identifier property named id.<br>
	 * Reference : <a href=
	 * "http://docs.jboss.org/hibernate/core/3.6/reference/en-US/html_single/#queryhql-identifier-property"
	 * >HQL usage</a>
	 * 
	 * 
	 * @param classObject
	 * @param propertyName
	 * @param value
	 * @return Id Identifier(PK) of the Entity
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Serializable findIdByProperty(Class<T> classObject, String propertyName, final Object value)
	{
		Serializable id = null;
		try
		{

			final String queryString = "select id from " + classObject.getName() + " as model where model." + propertyName
					+ "= ?";
			HibernateCallback hc = new HibernateCallback()
			{
				public List<T> doInHibernate(Session session) throws HibernateException, SQLException
				{
					return session.createQuery(queryString).setParameter(0, value).setMaxResults(1).list();
				}
			};
			id = (Serializable) ((List) hibernateTemplate.execute(hc)).get(0);
		}
		catch (RuntimeException re)
		{

			throw re;
		}

		return id;
	}

	/**
	 * Method used to return list of Strings based on the property.
	 * 
	 * @param classObject
	 * @param returnColumnName
	 * @param propertyName
	 * @param value
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<String> findDistinctByProperty(Class<T> classObject, String returnColumnName, String propertyName,
			final Object value)
	{

		List<String> list = null;
		try
		{
			final String queryString = "select distinct model." + returnColumnName + " from " + classObject.getName()
					+ " as model where model." + propertyName + "= ?";
			HibernateCallback hc = new HibernateCallback()
			{
				public List<T> doInHibernate(Session session) throws HibernateException, SQLException
				{
					return session.createQuery(queryString).setParameter(0, value).list();
				}
			};
			list = (List<String>) hibernateTemplate.execute(hc);
		}
		catch (RuntimeException re)
		{

			throw re;
		}

		return list;
	}

	/**
	 * Method used to return a list of entities based on the property
	 * considering only the Date and ignoring the Timestamp
	 * 
	 * @param classObject
	 * @param property
	 * @param date
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByDateIgnoringTS(Class<T> classObject, String propertyName, Date date)
	{
		DetachedCriteria criteria = DetachedCriteria.forClass(classObject);
		criteria.add(Restrictions.between(propertyName, MBCPUtil.getLeadingDate(date), MBCPUtil.getTrailingDate(date)));
		List<T> list = (List<T>) hibernateTemplate.findByCriteria(criteria);
		return list;
	}

	/**
	 * Returns contextual session
	 * 
	 * @return current or contextual session
	 */
	public Session getSession()
	{

		Session session = null;
		if (hibernateTemplate != null && hibernateTemplate.getSessionFactory() != null)
		{
			session = hibernateTemplate.getSessionFactory().getCurrentSession();
		}

		return session;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByCriteria(DetachedCriteria criteria)
	{
		return hibernateTemplate.findByCriteria(criteria, -1, -1);
	}

}
