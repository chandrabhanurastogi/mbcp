package com.ifli.mbcp.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Represents a needs analysis. As per IRDA regulations, before an insurance
 * product can be pitched to a prospect, the insurer must conduct a mandatory
 * needs analysis to identify whether or not the prospect actually needs the
 * insurance products in question.
 * 
 * @author FL867
 * @version 1.0
 * @since 29 April 2013
 */
@Entity
@Table(name = "tbl_needs_analysis")
public class NeedsAnalysis implements Serializable, Comparable<NeedsAnalysis>
{
	private Long				needsAnalysisId;
	private Date				dateOfAnalysis;
	private Double				annualAffordableContribution;
	private Short				yearsOfContribtion;
	private Double				annualContributionIncrement;
	private Double				desirableLifeCover;
	private Double				desirableHealthCover;
	private Double				returnOnInvestments;
	private Double				desirableAnnualPension;
	private String				lifeStage;
	private String				protectionNeeds;
	private String				appetite;

	private Set<InsurancePlan>	recommendedPlans;

	private String				commitmentDetails;
	private String				riskElementExplanation;
	private String				linkToCustomerSignature;
	private String				linkToBDMSignature;

	// @ManyToOne
	// @JoinColumn(name = "leadId", nullable = false)
	// private Lead owningLead;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getNeedsAnalysisId()
	{
		return needsAnalysisId;
	}

	public void setNeedsAnalysisId(Long needsAnalysisId)
	{
		this.needsAnalysisId = needsAnalysisId;
	}

	@Column(nullable = true)
	public Date getDateOfAnalysis()
	{
		return dateOfAnalysis;
	}

	public void setDateOfAnalysis(Date dateOfAnalysis)
	{
		this.dateOfAnalysis = dateOfAnalysis;
	}

	@Column(nullable = true)
	public Double getAnnualAffordableContribution()
	{
		return annualAffordableContribution;
	}

	public void setAnnualAffordableContribution(Double annualAffordableContribution)
	{
		this.annualAffordableContribution = annualAffordableContribution;
	}

	@Column(nullable = true)
	public Short getYearsOfContribtion()
	{
		return yearsOfContribtion;
	}

	public void setYearsOfContribtion(Short yearsOfContribtion)
	{
		this.yearsOfContribtion = yearsOfContribtion;
	}

	@Column(nullable = true)
	public Double getAnnualContributionIncrement()
	{
		return annualContributionIncrement;
	}

	public void setAnnualContributionIncrement(Double annualContributionIncrement)
	{
		this.annualContributionIncrement = annualContributionIncrement;
	}

	@Column(nullable = true)
	public Double getDesirableLifeCover()
	{
		return desirableLifeCover;
	}

	public void setDesirableLifeCover(Double desirableLifeCover)
	{
		this.desirableLifeCover = desirableLifeCover;
	}

	@Column(nullable = true)
	public Double getDesirableHealthCover()
	{
		return desirableHealthCover;
	}

	public void setDesirableHealthCover(Double desirableHealthCover)
	{
		this.desirableHealthCover = desirableHealthCover;
	}

	@Column(nullable = true)
	public Double getReturnOnInvestments()
	{
		return returnOnInvestments;
	}

	public void setReturnOnInvestments(Double returnOnInvestments)
	{
		this.returnOnInvestments = returnOnInvestments;
	}

	@Column(nullable = true)
	public Double getDesirableAnnualPension()
	{
		return desirableAnnualPension;
	}

	public void setDesirableAnnualPension(Double desirableAnnualPension)
	{
		this.desirableAnnualPension = desirableAnnualPension;
	}

	@Column(nullable = true, length = 30)
	public String getLifeStage()
	{
		return lifeStage;
	}

	public void setLifeStage(String lifeStage)
	{
		this.lifeStage = lifeStage;
	}

	@Column(nullable = true, length = 30)
	public String getProtectionNeeds()
	{
		return protectionNeeds;
	}

	public void setProtectionNeeds(String protectionNeeds)
	{
		this.protectionNeeds = protectionNeeds;
	}

	@Column(nullable = true)
	public String getAppetite()
	{
		return appetite;
	}

	public void setAppetite(String appetite)
	{
		this.appetite = appetite;
	}

	@Column(nullable = true)
	public String getCommitmentDetails()
	{
		return commitmentDetails;
	}

	public void setCommitmentDetails(String commitmentDetails)
	{
		this.commitmentDetails = commitmentDetails;
	}

	@Column(nullable = true)
	public String getRiskElementExplanation()
	{
		return riskElementExplanation;
	}

	public void setRiskElementExplanation(String riskElementExplanation)
	{
		this.riskElementExplanation = riskElementExplanation;
	}

	@Column(nullable = true)
	public String getLinkToCustomerSignature()
	{
		return linkToCustomerSignature;
	}

	public void setLinkToCustomerSignature(String linkToCustomerSignature)
	{
		this.linkToCustomerSignature = linkToCustomerSignature;
	}

	@Column(nullable = true)
	public String getLinkToBDMSignature()
	{
		return linkToBDMSignature;
	}

	public void setLinkToBDMSignature(String linkToBDMSignature)
	{
		this.linkToBDMSignature = linkToBDMSignature;
	}

	public int compareTo(NeedsAnalysis thatNeedsAnalysis)
	{
		return (this.getDateOfAnalysis().compareTo(thatNeedsAnalysis.getDateOfAnalysis()));
	}

	private static final long	serialVersionUID	= -3884580937814771116L;

	@OneToMany
	@JoinTable(name = "tbl_mapping_needsanalysis_insuranceplans", joinColumns = { @JoinColumn(name = "needsAnalysisId") }, inverseJoinColumns = { @JoinColumn(name = "planId") })
	public Set<InsurancePlan> getRecommendedPlans()
	{
		return recommendedPlans;
	}

	// public Lead getOwningLead()
	// {
	// return owningLead;
	// }
	//
	public void setRecommendedPlans(Set<InsurancePlan> recommendedPlans)
	{
		this.recommendedPlans = recommendedPlans;
	}
	//
	// public void setOwningLead(Lead owningLead)
	// {
	// this.owningLead = owningLead;
	// }
}
