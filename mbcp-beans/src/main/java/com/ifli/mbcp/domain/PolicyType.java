package com.ifli.mbcp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents a policy type, such as CoI, Master Policy, etc.
 * 
 * @author FL867
 * @since 22 May 2013
 * @version 1.0
 */
@Entity
@Table(name = "tbl_lookup_policy_type")
public class PolicyType extends GenericLookup implements Serializable
{
	private static final long	serialVersionUID	= -6040398149124440143L;

	/**
	 * Unique Identifier of a Policy type
	 */
	@Override
	@Id
	@Column(name = "policyTypeId")
	public Long getId()
	{
		return super.getId();
	}

	/**
	 * The type of Policy
	 */
	@Override
	@Column(name = "policyTypeName", nullable = false)
	public String getName()
	{
		return super.getName();
	}

	/**
	 * Description or Additional information about the Policy Type
	 */
	@Override
	@Column(name = "policyTypeDesc", nullable = true)
	public String getDescription()
	{
		return super.getDescription();
	}

}
