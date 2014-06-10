package com.ifli.mbcp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents a Lead Category
 * 
 * @author FL867
 * @version 1.0
 * @since 29 April 2013
 */
@Entity
@Table(name = "tbl_lookup_lead_category")
public class LeadCategory extends GenericLookup implements Serializable
{

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "leadCategoryId")
	public Long getId()
	{
		return super.getId();
	}

	@Override
	@Column(name = "leadCategoryName", length = 30, nullable = false)
	public String getName()
	{
		return super.getName();
	}

	@Override
	@Column(name = "leadCategoryDescription", length = 128, nullable = true)
	public String getDescription()
	{
		return super.getDescription();
	}

	private static final long	serialVersionUID	= 2677991942498741732L;
}
