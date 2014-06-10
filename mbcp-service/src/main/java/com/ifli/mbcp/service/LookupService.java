package com.ifli.mbcp.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * This is a Generic Service class responsible for Lookup of data in Master
 * Tables via a DAO and also performing some common operations across multiple
 * entities.
 * 
 * @author Niranjan
 * @since 20 May 2013
 * @version 1.0
 */
@Component
public interface LookupService
{
	/**
	 * Fetches all the instances of the given Entity class
	 * 
	 * @param classObject
	 *            Entity type
	 * @return A list of all the instances of the given type.
	 * @throws Exception
	 */
	<T> List<T> getAll(Class<T> classObject) throws Exception;

	/**
	 * Return a list of all instances of the given Entity class whose property
	 * matches with the given property value
	 * 
	 * @param classObject
	 *            Entity type
	 * @param propertyName
	 * @param propertyValue
	 * @return A list of instances of the given entity type with matching
	 *         property value
	 * @throws Exception
	 */
	<T> List<T> getByProperty(Class<T> classObject, String propertyName, Object propertyValue) throws Exception;

	/**
	 * Returns a boolean value of true if any instance of the given Entity class
	 * exists with give identifier, otherwise false
	 * 
	 * @param classObject
	 *            Entity type
	 * @param id
	 *            Unique identifier of the Instance
	 * @return true if exists or false otherwise
	 */
	<T> boolean exists(Class<T> classObject, Serializable id);

	/**
	 * Method used to return the identifier(PK) of the instance of the given
	 * Entity based on the given property Name and Value.
	 * 
	 * @param classObject
	 * @param propertyName
	 * @param propertyValue
	 * @return Unique Identifier of the Entity matching the given property Name,
	 *         Value or null, if the Entity is not found or any exception occurred while
	 *         retrieving the entity
	 */
	<T> Serializable getIdByProperty(Class<T> classObject, String propertyName, Object propertyValue);
	
	/**
	 * Return a unique instance of the given Entity class whose property
	 * matches with the given property value
	 * 
	 * @param classObject
	 *            Entity type
	 * @param propertyName
	 * @param propertyValue
	 * @return A instance of the given entity type with matching
	 *         property value
	 * 
	 */
	<T> T getUniqueEntityByProperty(Class<T> classObject, String propertyName, Object propertyValue) throws Exception;
	
	/**
	 * Return a List Entities matching the given Entity 
	 * @param example Entity 
	 * @return List of Entities of given Entity type
	 * @throws Exception
	 */
	<T> List<T> getByExample(T example) throws Exception;
	
}
