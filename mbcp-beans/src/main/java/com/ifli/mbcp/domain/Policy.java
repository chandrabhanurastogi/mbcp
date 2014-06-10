package com.ifli.mbcp.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Represents a policy that has been purchased by a Lead.
 * 
 * @author FL867
 * @since 22 May 2013
 * @version 1.0
 */
@Entity
@Table(name = "tbl_policy")
public class Policy implements Serializable
{
	private static final long	serialVersionUID	= 1897418113276801688L;
	private Long				mbcpPolicyId;
	private String				ifliBackendPolicyId;
	private PolicyType			policyType;
	private InsurancePlan		policyPlan;
	private BigDecimal			sumAssured;
	private Set<Nominee>		nomineesOfTheAssured;
	private PremiumPayer		premiumPayer;
	private Premium				policyPremium;
	private PremiumFrequency	premiumFrequency;
	private Set<AssuredPerson>	assuredPersons;
	private Set<ServiceRequest>	serviceRequests;
	private Set<Claim>			policyClaims;
	private Set<MBCPDocument>	policyDocuments;
	private Long				clientId;
	private Proposal			sourceProposal;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getMbcpPolicyId()
	{
		return mbcpPolicyId;
	}

	public void setMbcpPolicyId(Long mbcpPolicyId)
	{
		this.mbcpPolicyId = mbcpPolicyId;
	}

	@Column
	public String getIfliBackendPolicyId()
	{
		return ifliBackendPolicyId;
	}

	public void setIfliBackendPolicyId(String ifliBackendPolicyId)
	{
		this.ifliBackendPolicyId = ifliBackendPolicyId;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "policyTypeId")
	public PolicyType getPolicyType()
	{
		return policyType;
	}

	public void setPolicyType(PolicyType policyType)
	{
		this.policyType = policyType;
	}

	@OneToOne
	@JoinColumn(name = "planId")
	public InsurancePlan getPolicyPlan()
	{
		return policyPlan;
	}

	public void setPolicyPlan(InsurancePlan policyPlan)
	{
		this.policyPlan = policyPlan;
	}

	@Column
	public BigDecimal getSumAssured()
	{
		return sumAssured;
	}

	public void setSumAssured(BigDecimal sumAssured)
	{
		this.sumAssured = sumAssured;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "premiumId")
	public Premium getPolicyPremium()
	{
		return policyPremium;
	}

	public void setPolicyPremium(Premium policyPremium)
	{
		this.policyPremium = policyPremium;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "premiumFrequencyId")
	public PremiumFrequency getPremiumFrequency()
	{
		return premiumFrequency;
	}

	public void setPremiumFrequency(PremiumFrequency premiumFrequency)
	{
		this.premiumFrequency = premiumFrequency;
	}

	/**
	 * A policy must have one or more AssuredPersons. However, many other domain
	 * objects can also own AssuredPersons, hence this relationship is via a
	 * join table.
	 * 
	 * @return
	 */
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tbl_mapping_policy_assuredpersons", joinColumns = { @JoinColumn(name = "policyId") }, inverseJoinColumns = { @JoinColumn(name = "assuredPersonId") })
	public Set<AssuredPerson> getAssuredPersons()
	{
		return assuredPersons;
	}

	public void setAssuredPersons(Set<AssuredPerson> assuredPersons)
	{
		this.assuredPersons = assuredPersons;
	}

	/**
	 * Unidirectional One-To-Many on Claim. A policyId will be placed in
	 * ServiceRequest. No other domain object can own a ServiceRequest.
	 * 
	 * @return
	 */
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "policyId")
	public Set<ServiceRequest> getServiceRequests()
	{
		return serviceRequests;
	}

	public void setServiceRequests(Set<ServiceRequest> serviceRequests)
	{
		this.serviceRequests = serviceRequests;
	}

	/**
	 * Unidirectional One-To-Many on Claim. A policyId will be placed in Claim.
	 * No other domain object can own a Claim.
	 * 
	 * @return
	 */
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "policyId")
	public Set<Claim> getPolicyClaims()
	{
		return policyClaims;
	}

	public void setPolicyClaims(Set<Claim> policyClaims)
	{
		this.policyClaims = policyClaims;
	}

	/**
	 * Unidirectional One-To-Many on Nominee. A policyId will be placed in
	 * Nomine. No other domain object can own a Nominee.
	 * 
	 * @return
	 */
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "policyId")
	public Set<Nominee> getNomineesOfTheAssured()
	{
		return nomineesOfTheAssured;
	}

	public void setNomineesOfTheAssured(Set<Nominee> nomineesOfTheAssured)
	{
		this.nomineesOfTheAssured = nomineesOfTheAssured;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "payerId")
	public PremiumPayer getPremiumPayer()
	{
		return premiumPayer;
	}

	public void setPremiumPayer(PremiumPayer premiumPayer)
	{
		this.premiumPayer = premiumPayer;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "tbl_mapping_policy_documents", joinColumns = { @JoinColumn(name = "policyId") }, inverseJoinColumns = { @JoinColumn(name = "documentId") })
	public Set<MBCPDocument> getPolicyDocuments()
	{
		return policyDocuments;
	}

	public void setPolicyDocuments(Set<MBCPDocument> policyDocuments)
	{
		this.policyDocuments = policyDocuments;
	}

	@Column
	public Long getClientId()
	{
		return clientId;
	}

	public void setClientId(Long clientId)
	{
		this.clientId = clientId;
	}
}
