package com.ifli.mbcp.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents an instance of a date. This will be used to store all dates in
 * Proposal.
 * 
 * @author FL867
 * @since 06 June 2013
 * @version 1.0
 */
@Entity
@Table(name = "tbl_dynamic_date")
public class DynamicDate extends DynamicField implements Serializable
{
	private static final long	serialVersionUID	= 7508616774444737418L;
	private Date value;

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
	public Date getValue()
	{
		return value;
	}

	public void setValue(Date value)
	{
		this.value = value;
	}
}
