package com.ifli.mbcp.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class DynamicDecimal extends DynamicField implements Serializable
{
	private static final long	serialVersionUID	= 223479263447581460L;
	private BigDecimal			value;

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

	@Column(precision = 10, scale = 2, nullable = true)
	public BigDecimal getValue()
	{
		return value;
	}

	public void setValue(BigDecimal value)
	{
		this.value = value;
	}
}