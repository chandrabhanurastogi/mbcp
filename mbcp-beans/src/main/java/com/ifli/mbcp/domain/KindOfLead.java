package com.ifli.mbcp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents what kind of lead this is. It could be an individual lead, group lead, group individual, etc.
 * @author FL867
 * @since 06 June 2013
 * @version 1.0
 */
@Entity
@Table(name = "tbl_lookup_kind_of_lead")
public class KindOfLead extends GenericLookup implements Serializable
{
	
	public static final String INDIVIDUAL = "IND";
	public static final String GROUP = "GROUP";
	
	private static final long	serialVersionUID	= 2828412048085045237L;

	/**
	 * Unique identifier
	 */
	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "kindOfLeadId")
	public Long getId()
	{
		return super.getId();
	}

	/**
	 * Name of the Lead Type
	 */
	@Override
	@Column(name = "kindOfLeadName", length = 5, nullable = false)
	public String getName()
	{
		return super.getName();
	}

	/**
	 * Description or Additional information about the Lead Type
	 */
	@Column(name = "leadPrefix", length = 2, nullable = true)
	public String getDescription()
	{
		return super.getDescription();
	}
	
		
}
