package com.ifli.mbcp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Represents a servicing lead generator entity. This represents the agent who acquired this business (lead).
 * 
 * @author FL867
 * @since 29 April 2013
 * @version 1.0
 */
@Entity
@Table(name = "tbl_lookup_lead_generator_code")
public class LeadGeneratorCode extends GenericLookup implements Serializable
{
	private static final long	serialVersionUID	= -7458487378643016849L;

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "leadGeneratorCodeId")
	public Long getId()
	{
		return super.getId();
	}

	@Override
	@Column(name = "leadGeneratorCodeName", length = 8, nullable = false)
	public String getName()
	{
		return super.getName();
	}

	@Override
	@Transient
	public String getDescription()
	{
		return super.getDescription();
	}
}
