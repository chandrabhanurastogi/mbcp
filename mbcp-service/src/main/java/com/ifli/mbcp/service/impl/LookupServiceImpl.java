package com.ifli.mbcp.service.impl;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ifli.mbcp.dao.GenericDAO;
import com.ifli.mbcp.service.LookupService;

/**
 * This is a Generic Service class responsible for Lookup of data in Master
 * Tables via a DAO and also performing some common operations across multiple
 * entities.
 * 
 * @author Niranjan
 * @since 20 May 2013
 * @version 1.0
 */
@Service("lookupService")
@Transactional
public class LookupServiceImpl implements LookupService
{
	@SuppressWarnings("rawtypes")
	@Autowired
	@Qualifier("genericDAO")
	protected GenericDAO					genericDAO;

	private static final Logger	logger	= LoggerFactory.getLogger(LookupServiceImpl.class);

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> getAll(Class<T> classObject) throws Exception
	{
		return genericDAO.findAll(classObject);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> getByProperty(Class<T> classObject, String propertyName, Object value) throws Exception
	{
		return genericDAO.findByProperty(classObject, propertyName, value);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public <T> boolean exists(Class<T> classObject, Serializable id)
	{
		T entity = null;
		try
		{
			entity = (T) genericDAO.findById(classObject, id);
		}
		catch (Exception e)
		{
			logger.error("Exception while determining the existence of the Entity " + classObject.getName() + "\n"
					+ e.getMessage());
		}
		if (entity != null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 *  {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public <T> Serializable getIdByProperty(Class<T> classObject, String propertyName, Object propertyValue)
	{
		Serializable id = null;
		try
		{
			id = genericDAO.findIdByProperty(classObject, propertyName, propertyValue);
		}
		catch (Exception e)
		{
			logger.error("Exception while fetching the Id for " + classObject.getName() + "\n" + e.getMessage());
		}
		return id;
	}
	
	/**
	 *  {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public <T> T getUniqueEntityByProperty(Class<T> classObject, String propertyName, Object propertyValue)
	{
		List<T> listValue = genericDAO.findByProperty(classObject, propertyName, propertyValue);
		
		if(listValue.size() == 0) 
			return null;
		else 
			return listValue.get(0);
	}

	/**
	 *  {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> getByExample(T example) throws Exception
	{
		return genericDAO.findByExample(example);
	}

}
