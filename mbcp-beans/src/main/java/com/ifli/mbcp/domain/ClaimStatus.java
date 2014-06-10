package com.ifli.mbcp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents a claim status, such as Filed, Paid, Denied, etc. This will be updated 
 * by the backend service that handles claims.
 * @author FL867
 * @since 22 May 2013
 * @version 1.0
 */
@Entity
@Table(name = "tbl_lookup_claim_status")
public class ClaimStatus extends GenericLookup implements Serializable
{
	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "claimStatusId")
	public Long getId()
	{
		return super.getId();
	}

	@Override
	@Column(name = "claimStatusName", nullable = false)
	public String getName()
	{
		return super.getName();
	}

	@Override
	@Column(name = "claimStatusDesc", nullable = true)
	public String getDescription()
	{
		return super.getDescription();
	}

	private static final long	serialVersionUID	= 8487798671404111678L;
}
