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
 * Represents the frequency with which the premium must be paid for a given policy/plan instance.
 * 
 * @author FL867
 * @since 29 April 2013
 * @version 1.0
 */
@Entity
@Table(name = "tbl_lookup_premium_frequency")
public class PremiumFrequency extends GenericLookup implements Serializable
{
	private static final long	serialVersionUID	= -3526896338155651727L;

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "premiumFrequencyId")
	public Long getId()
	{
		return super.getId();
	}

	@Override
	@Column(name = "premiumFrequencyName", length = 30, nullable = false)
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