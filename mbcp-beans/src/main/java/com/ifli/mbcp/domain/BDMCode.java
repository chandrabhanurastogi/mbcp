package com.ifli.mbcp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents a Code of a Business Development Manager through which the
 * business (lead) has been acquired.
 * 
 * @author FL867
 * @since 29 April 2013
 * @version 1.0
 * 
 */
@Entity

@Table(name = "tbl_lookup_bdm_code")
public class BDMCode extends GenericLookup implements Serializable
{

	/**
	 * Unique identifier of the BDMCode instance
	 */

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bdmCodeId")
	public Long getId()
	{
		return super.getId();
	}

	/**
	 * Actual Code
	 */
	@Override
	@Column(name = "bdmCodeName", length = 8, nullable = false)
	public String getName()
	{
		return super.getName();
	}

	/**
	 * Descriptive Name or Additional information of the code
	 */
	@Override
	@Column(name = "bdmCodeDescription", length = 128, nullable = true)
	public String getDescription()
	{
		return super.getDescription();
	}

	private static final long	serialVersionUID	= 2677991942498741732L;
}
