package com.ifli.mbcp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents a possible state for a lead. This will comprise all possible
 * lifecycle states for a lead.
 * 
 * @author FL867
 * @version 1.0
 * @since 29 April 2013
 */
@Entity
@Table(name = "tbl_lookup_lead_status")
public class LeadStatus extends GenericLookup implements Serializable
{
	private static final long	serialVersionUID	= 6172743477563374799L;

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "leadStatusId")
	public Long getId()
	{
		return super.getId();
	}

	@Override
	@Column(name = "leadStatusName", length = 30, nullable = false)
	public String getName()
	{
		return super.getName();
	}

	@Override
	@Column(name = "leadStatusDescription", length = 128, nullable = true)
	public String getDescription()
	{
		return super.getDescription();
	}
}
