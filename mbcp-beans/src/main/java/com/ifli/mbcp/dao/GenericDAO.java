package com.ifli.mbcp.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

/**
 * Interface used to perform Basic DML Operations.
 * 
 * @author Niranjan
 * @since 6 May 2013
 * @version 1.0
 */
public interface GenericDAO<T>
{

	/**
	 * Persist the given transient instance
	 * 
	 * @param pojo
	 * @return Id
	 */
	public Serializable save(T pojo);

	/**
	 * Update the persistent instance
	 * 
	 * @param pojo
	 */
	public void update(T pojo);

	/**
	 * Merge the changes and save it to the database
	 * 
	 * @param pojo
	 */
	public void merge(T pojo);

	/**
	 * Either save(Object) or update(Object) the given instance, depending upon
	 * resolution of the unsaved-value checks
	 * 
	 * @param pojo
	 */
	public void saveOrUpdate(T pojo);

	/**
	 * Remove a persistent instance from the data store
	 * 
	 * @param pojo
	 */
	public void delete(T pojo);

	/**
	 * Deletes the persistent instance of the given entity class with the given
	 * identifier
	 * 
	 * @param classObject
	 * @param Id
	 */
	public void deleteById(Class<T> classObject, Serializable Id);

	/**
	 * Return the persistent instance of the given entity class with the given
	 * identifier, or null if there is no such persistent instance.
	 * 
	 * @param classObject
	 * @param Id
	 * @return object
	 */
	public T findById(Class<T> classObject, Serializable Id);

	/**
	 * Return the list of persistent instances of the given entity class which
	 * matches the given pojo object
	 * 
	 * @param pojo
	 * @return list of objects
	 */
	public List<T> findByExample(T pojo);

	/**
	 * Return the list of all persistent instances of the given entity class
	 * 
	 * @param classObject
	 * @return
	 */
	public List<T> findAll(Class<T> classObject);

	/**
	 * Return the list of all persistent instances of the given entity class
	 * whose property matches with the given property value
	 * 
	 * @param classObject
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public List<T> findByProperty(Class<T> classObject, String propertyName, Object value);

	/**
	 * Method used to return a list of entities based on the property
	 * considering only the Date and ignoring the Timestamp
	 * 
	 * @param classObject
	 * @param property
	 * @param date
	 * @return
	 */
	public List<T> findByDateIgnoringTS(Class<T> classObject, String propertyName, Date date);

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
	public Serializable findIdByProperty(Class<T> classObject, String propertyName, Object value);

	/**
	 * Method used to return a list of entities based on the given
	 * DetachedCriteria
	 * 
	 * @param criteria
	 * @return
	 */
	public List<T> findByCriteria(DetachedCriteria criteria);
}
