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
 * Represents a BM/RM Code entity. This also represents the servicing bank
 * branch through which the business (lead) has been acquired.
 * 
 * @author FL867
 * @since 29 April 2013
 * @version 1.0
 */
@Entity
@Table(name = "tbl_lookup_bmrm_code")
public class BMRMCode extends GenericLookup implements Serializable
{
	private static final long	serialVersionUID	= -7422120840464337713L;
/**
 * Unique identifier of the BM/RM Code instance
 */
	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bmRmCodeId")
	public Long getId()
	{
		return super.getId();
	}

	/**
	 * Actual Code 
	 */
	@Override
	@Column(name = "bmRmCodeName", length = 8, nullable = false)
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