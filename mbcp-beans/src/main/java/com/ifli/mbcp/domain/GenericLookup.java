package com.ifli.mbcp.domain;

/**
 * Represents a Generic class with basic attributes which can be used by many
 * Entities across the IFLI Domain model.<br>
 * Some known Entities that are incarnated from this class are {@link BMRMCode},
 * {@link BDMCode}, {@link Language}, {@link AddressType} etc.
 * 
 * @author FL867
 * @version 1.0
 * @since 29 April 2013
 */
public abstract class GenericLookup implements Comparable<GenericLookup>
{
	private Long	id;
	private String	name;
	private String	description;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public int compareTo(GenericLookup thatLookup)
	{
		return (this.getName().compareTo(thatLookup.getName()));
	}
}
