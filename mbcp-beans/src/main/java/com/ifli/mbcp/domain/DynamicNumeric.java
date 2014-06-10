package com.ifli.mbcp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents an instance of a numeric value. This can be any numeric value used
 * in a Proposal, Individual or Group.
 * 
 * @author FL867
 * @since 06 June 2013
 * @version 1.0
 */
@Entity
@Table(name = "tbl_dynamic_numeric")
public class DynamicNumeric extends DynamicField implements Serializable
{
	private static final long	serialVersionUID	= 223479263447581460L;
	private Long				value;

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
}
