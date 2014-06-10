package com.ifli.mbcp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents a branch entity. This represents the servicing bank branch through
 * which the business (lead) has been acquired.
 * 
 * @author FL867
 * @since 29 April 2013
 * @version 1.0
 */
@Entity
@Table(name = "tbl_lookup_branch_code")
public class BranchCode extends GenericLookup implements Serializable
{
	private static final long	serialVersionUID	= -1235986151218357435L;

	/**
	 * Unique identifier of the BranchCode instance
	 */
	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "branchCodeId")
	public Long getId()
	{
		return super.getId();
	}

	/**
	 * Actual Branch Code
	 */
	@Override
	@Column(name = "branchCodeName", length = 5, nullable = false)
	public String getName()
	{
		return super.getName();
	}

	/**
	 * Description or Additional information about the Branch
	 */
	@Override
	@Column(name = "branchCodeDescription", length = 128, nullable = true)
	public String getDescription()
	{
		return super.getDescription();
	}
}
