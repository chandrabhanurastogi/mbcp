package com.ifli.mbcp.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Represents an insurance product. Each lead is interested in a specific
 * product, and IFLI attempts to sell this product to the customer.
 * 
 * @author FL867
 * @since 29 April 2013
 * @version 1.0
 */
@Entity
@Table(name = "tbl_lookup_insurance_plan")
public class InsurancePlan extends GenericLookup implements Serializable
{
	private static final long	serialVersionUID	= -8305888565205710570L;

//	private PlanType			planType;

	// private Set<Fund> allFundsForThisPlan;

	private Set<AudioVideo>		audioVideos;

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "planId")
	public Long getId()
	{
		return super.getId();
	}

	@Override
	@Column(name = "planName", length = 60, nullable = false)
	public String getName()
	{
		return super.getName();
	}

	@Override
	@Column(name = "planDescription", length = 128, nullable = false)
	public String getDescription()
	{
		return super.getDescription();
	}

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "planTypeId", nullable = false)
//	public PlanType getPlanType()
//	{
//		return planType;
//	}
//
//	public void setPlanType(PlanType planType)
//	{
//		this.planType = planType;
//	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "planId")
	public Set<AudioVideo> getAudioVideos()
	{
		return audioVideos;
	}

	public void setAudioVideos(Set<AudioVideo> audioVideos)
	{
		this.audioVideos = audioVideos;
	}

}
