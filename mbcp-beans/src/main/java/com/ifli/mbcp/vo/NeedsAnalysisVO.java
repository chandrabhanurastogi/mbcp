package com.ifli.mbcp.vo;

import java.util.Date;

import com.ifli.mbcp.domain.InsurancePlan;
import com.ifli.mbcp.domain.Person;

public class NeedsAnalysisVO extends Person
{
	private Long			needsAnalysisId;
	private Date			dateOfAnalysis;
	private Double			annualAffordableContribution;
	private Short			yearsOfContribtion;
	private Double			annualContributionIncrement;
	private Double			desirableLifeCover;
	private Double			desirableHealthCover;
	private Double			returnOnInvestments;
	private Double			desirableAnnualPension;
	private String			lifeStage;
	private String			protectionNeeds;
	private String			appetite;
	private InsurancePlan	recommendedPlans;
	private String			commitmentDetails;
	private String			riskElementExplanation;
	private String			linkToCustomerSignature;
	private String			linkToBDMSignature;

	public Long getNeedsAnalysisId()
	{
		return needsAnalysisId;
	}

	public void setNeedsAnalysisId(Long needsAnalysisId)
	{
		this.needsAnalysisId = needsAnalysisId;
	}

	public Date getDateOfAnalysis()
	{
		return dateOfAnalysis;
	}

	public void setDateOfAnalysis(Date dateOfAnalysis)
	{
		this.dateOfAnalysis = dateOfAnalysis;
	}

	public Double getAnnualAffordableContribution()
	{
		return annualAffordableContribution;
	}

	public void setAnnualAffordableContribution(Double annualAffordableContribution)
	{
		this.annualAffordableContribution = annualAffordableContribution;
	}

	public Short getYearsOfContribtion()
	{
		return yearsOfContribtion;
	}

	public void setYearsOfContribtion(Short yearsOfContribtion)
	{
		this.yearsOfContribtion = yearsOfContribtion;
	}

	public Double getAnnualContributionIncrement()
	{
		return annualContributionIncrement;
	}

	public void setAnnualContributionIncrement(Double annualContributionIncrement)
	{
		this.annualContributionIncrement = annualContributionIncrement;
	}

	public Double getDesirableLifeCover()
	{
		return desirableLifeCover;
	}

	public void setDesirableLifeCover(Double desirableLifeCover)
	{
		this.desirableLifeCover = desirableLifeCover;
	}

	public Double getDesirableHealthCover()
	{
		return desirableHealthCover;
	}

	public void setDesirableHealthCover(Double desirableHealthCover)
	{
		this.desirableHealthCover = desirableHealthCover;
	}

	public Double getReturnOnInvestments()
	{
		return returnOnInvestments;
	}

	public void setReturnOnInvestments(Double returnOnInvestments)
	{
		this.returnOnInvestments = returnOnInvestments;
	}

	public Double getDesirableAnnualPension()
	{
		return desirableAnnualPension;
	}

	public void setDesirableAnnualPension(Double desirableAnnualPension)
	{
		this.desirableAnnualPension = desirableAnnualPension;
	}

	public String getLifeStage()
	{
		return lifeStage;
	}

	public void setLifeStage(String lifeStage)
	{
		this.lifeStage = lifeStage;
	}

	public String getProtectionNeeds()
	{
		return protectionNeeds;
	}

	public void setProtectionNeeds(String protectionNeeds)
	{
		this.protectionNeeds = protectionNeeds;
	}

	public String getAppetite()
	{
		return appetite;
	}

	public void setAppetite(String appetite)
	{
		this.appetite = appetite;
	}

	public InsurancePlan getRecommendedPlans()
	{
		return recommendedPlans;
	}

	public void setRecommendedPlans(InsurancePlan recommendedPlans)
	{
		this.recommendedPlans = recommendedPlans;
	}

	public String getCommitmentDetails()
	{
		return commitmentDetails;
	}

	public void setCommitmentDetails(String commitmentDetails)
	{
		this.commitmentDetails = commitmentDetails;
	}

	public String getRiskElementExplanation()
	{
		return riskElementExplanation;
	}

	public void setRiskElementExplanation(String riskElementExplanation)
	{
		this.riskElementExplanation = riskElementExplanation;
	}

	public String getLinkToCustomerSignature()
	{
		return linkToCustomerSignature;
	}

	public void setLinkToCustomerSignature(String linkToCustomerSignature)
	{
		this.linkToCustomerSignature = linkToCustomerSignature;
	}

	public String getLinkToBDMSignature()
	{
		return linkToBDMSignature;
	}

	public void setLinkToBDMSignature(String linkToBDMSignature)
	{
		this.linkToBDMSignature = linkToBDMSignature;
	}

}
