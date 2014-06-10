package com.ifli.mbcp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_occupation")
public class Occupation extends GenericLookup implements Serializable
{
	private static final long	serialVersionUID	= 8096690374300411306L;

	@Override
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "occupationId", unique=true, nullable=false)
	public Long getId()
	{
		return super.getId();
	}

	@Override
	@Column(name = "occupationName", length = 50, nullable = false)
	public String getName()
	{
		return super.getName();
	}

	@Override
	@Column(name = "occupationDesc", nullable = true)
	public String getDescription()
	{
		// TODO Auto-generated method stub
		return super.getDescription();
	}
}
