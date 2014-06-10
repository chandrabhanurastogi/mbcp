package com.ifli.mbcp.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Represents a previously-held insurance policy. This may or may not be from
 * IFLI. Only basic information is represented in this entity. <br/>
 * <br/>
 * 
 * @author FL867
 * @version 1.0
 * @since 29 April 2013
 */
@Entity
@Table(name = "tbl_existing_insurance")
public class ExistingInsurance implements Comparable<ExistingInsurance>, Serializable
{
	private Long			existingInsuranceId;
	private InsurancePlan	insurancePlan;
	private BigDecimal		sumAssured;
	private BigDecimal		annualPremium;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	public Long getExistingInsuranceId()
	{
		return existingInsuranceId;
	}

	public void setExistingInsuranceId(Long existingInsuranceId)
	{
		this.existingInsuranceId = existingInsuranceId;
	}

	@OneToOne
	@JoinColumn(name = "planId")
	public InsurancePlan getInsurancePlan()
	{
		return insurancePlan;
	}

	public void setInsurancePlan(InsurancePlan insurancePlan)
	{
		this.insurancePlan = insurancePlan;
	}

	@Column(precision = 10, scale = 2)
	public BigDecimal getSumAssured()
	{
		return sumAssured;
	}

	public void setSumAssured(BigDecimal sumAssured)
	{
		this.sumAssured = sumAssured;
	}

	@Column(precision = 10, scale = 2)
	public BigDecimal getAnnualPremium()
	{
		return annualPremium;
	}

	public void setAnnualPremium(BigDecimal annualPremium)
	{
		this.annualPremium = annualPremium;
	}

	public int compareTo(ExistingInsurance thatExistingInsurance)
	{
		return (this.getAnnualPremium().compareTo(thatExistingInsurance.getAnnualPremium()));
	}

	private static final long	serialVersionUID	= -965877769194293398L;
}