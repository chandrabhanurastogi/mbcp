package com.ifli.mbcp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents the type of the Lead. Possible values can be COLD, WARM, HOT etc.
 * 
 * @author FL867
 * @version 1.0
 * @since 29 April 2013
 */
@Entity
@Table(name = "tbl_lookup_lead_type")
public class LeadType extends GenericLookup implements Serializable
{
	/**
	 * Unique identifier for the LeadType
	 */
	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "leadTypeId")
	public Long getId()
	{
		return super.getId();
	}

	/**
	 * Name of the Lead Type
	 */
	@Override
	@Column(name = "leadTypeName", length = 5, nullable = false)
	public String getName()
	{
		return super.getName();
	}

	/**
	 * Description or Additional information about the Lead Type
	 */
	@Override
	@Column(name = "leadTypeDescription", length = 128, nullable = true)
	public String getDescription()
	{
		return super.getDescription();
	}

	private static final long	serialVersionUID	= 2677991942498741732L;
}
