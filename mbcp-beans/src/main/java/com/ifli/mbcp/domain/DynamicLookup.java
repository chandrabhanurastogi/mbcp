package com.ifli.mbcp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents an instance of a lookup key value. This can be any lookup used in
 * a Proposal, be it Individual or Group.
 * 
 * @author FL867
 * @since 06 June 2013
 * @version 1.0
 */
@Entity
@Table(name = "tbl_dynamic_lookup")
public class DynamicLookup extends DynamicField implements Serializable
{
	private static final long	serialVersionUID	= -8100069527508034500L;
	private Long				value;
	private String				lookupEntity;

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	public Long getId()
	{
		return super.getId();
	}

	@Override
	@Column(length = 64, nullable = false)
	public String getFieldName()
	{
		return super.getFieldName();
	}

	@Column(nullable = true)
	public Long getValue()
	{
		return value;
	}

	public void setValue(Long value)
	{
		this.value = value;
	}

	@Column(nullable = true)
	public String getLookupEntity()
	{
		return lookupEntity;
	}

	public void setLookupEntity(String lookupEntity)
	{
		this.lookupEntity = lookupEntity;
	}
}