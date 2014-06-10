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
 * Represents the marital status of a lead/customer. Examples include SINGLE, MARRIED, DIVORCED, etc.
 * 
 * @author FL867
 * @since 29 April 2013
 * @version 1.0
 */
@Entity
@Table(name = "tbl_lookup_marital_status")
public class MaritalStatus extends GenericLookup implements Serializable
{
	private static final long	serialVersionUID	= 6352820654395201654L;

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "maritalStatusId")
	public Long getId()
	{
		return super.getId();
	}

	@Override
	@Column(name = "maritalStatusName", length = 10, nullable = false)
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