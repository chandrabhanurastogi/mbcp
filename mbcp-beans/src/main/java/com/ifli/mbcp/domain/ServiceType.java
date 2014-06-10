package com.ifli.mbcp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents an instance from the range of possible service types.
 * @author FL867
 * @version 1.0
 * @since 26 May 2013
 */
@Entity
@Table(name = "tbl_lookup_service_type")
public class ServiceType extends GenericLookup implements Serializable
{
	private static final long	serialVersionUID	= 94012622604453181L;

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "serviceTypeId")
	public Long getId()
	{
		return super.getId();
	}

	@Override
	@Column(name = "serviceTypeName", length = 50, nullable = false)
	public String getName()
	{
		return super.getName();
	}

	@Override
	@Column(name = "serviceTypeDescription", length = 128, nullable = true)
	public String getDescription()
	{
		return super.getDescription();
	}
}
