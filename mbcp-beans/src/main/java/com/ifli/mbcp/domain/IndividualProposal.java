package com.ifli.mbcp.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.ifli.mbcp.util.CounterUtil;
import com.ifli.mbcp.util.MBCPConstants;

/**
 * Represents a Proposal of insurance policy for an Individual Lead. <br>
 * Basically its an application form for the potential customer of IFLI.
 * 
 * IMPORTANT: As of 06/June/2013 DO NOT WORK ON THIS DOMAIN OBJECT UNTIL FURTHER
 * NOTICE - JAGAN.
 * 
 * @author FL703
 * @version 1.0
 * @since 29 April 2013
 */
@Entity
@Table(name = "tbl_individual_proposal")
@PrimaryKeyJoinColumn(name = "proposalId")
public class IndividualProposal extends Proposal implements Serializable, Comparable<IndividualProposal>
{
	private static final long	serialVersionUID	= 7218785280495044858L;

	private String				signatureOfBDM;
	private String				isMedicalRequired;
	private Set<AssuredPerson>	assuredPersons;

	// Why is this here? -Jagan.
	private Date				policyIssueDate;

	private InsurancePlan		insuranceProduct;
	private BigDecimal			premiumAmount;
	private BigDecimal			sumAssured;
	private PremiumFrequency	premiumFrequency;
	private Set<MBCPDocument>	proposalDocuments;

	private String				paddedProposalId;

	private BenefitIllustration	sourceBenefitIllustration;

	public IndividualProposal()
	{
	}

	@Column(length = 1)
	public String getIsMedicalRequired()
	{
		return this.isMedicalRequired;
	}

	public void setIsMedicalRequired(String isMedicalRequired)
	{
		this.isMedicalRequired = isMedicalRequired;
	}

	public Date getPolicyIssueDate()
	{
		return this.policyIssueDate;
	}

	@Column
	public void setPolicyIssueDate(Date policyIssueDate)
	{
		this.policyIssueDate = policyIssueDate;
	}

	@OneToOne
	@JoinColumn(name = "planId", nullable = true)
	public InsurancePlan getInsuranceProduct()
	{
		return insuranceProduct;
	}

	public void setInsuranceProduct(InsurancePlan insuranceProduct)
	{
		this.insuranceProduct = insuranceProduct;
	}

	@OneToOne
	@JoinColumn(name = "premiumFrequencyId", nullable = true)
	public PremiumFrequency getPremiumFrequency()
	{
		return premiumFrequency;
	}

	public void setPremiumFrequency(PremiumFrequency premiumFrequency)
	{
		this.premiumFrequency = premiumFrequency;
	}

	/**
	 * Implements a padded proposalId getter. In the database we save the
	 * proposalId as a Long for efficient storage and good performance. However,
	 * the business requirement states that the proposalId should be an
	 * alphanumeric field. To get around this, we pad the Long proposalId with
	 * the text characters by either suffixing or prefixing the necessary amount
	 * of padding. <br>
	 * <br>
	 * The service layer will interact with the padded methods, while the DAO
	 * will work with the actual getter and setter for the leadId. <br>
	 * <br>
	 * Clarified with BA (Gaurav K) on 13-May-2013 at 16:10; see e-mail with
	 * subject: "Fields Format Counter Details"
	 */
	@Transient
	public String getPaddedProposalId()
	{
		try
		{
			paddedProposalId = (MBCPConstants.APPNO_PREFIX + CounterUtil.zeroPad(getProposalId().longValue(), MBCPConstants.FIELD_WIDTH));
		}
		catch (Exception e)
		{

		}
		return paddedProposalId;
	}

	/**
	 * Implements a padded proposalId setter. In the database we save the
	 * proposalId as a Long for efficient storage and good performance. However,
	 * the business requirement states that the proposalId should be an
	 * alphanumeric field. To get around this, we pad the Long proposalId with
	 * the text characters by either suffixing or prefixing the necessary amount
	 * of padding. <br>
	 * <br>
	 * The service layer will interact with the padded methods, while the DAO
	 * will work with the actual getter and setter for the leadId. <br>
	 * <br>
	 * Clarified with BA (Gaurav K) on 13-May-2013 at 16:10; see e-mail with
	 * subject: "Fields Format Counter Details"
	 */
	public void setPaddedProposalId(String applicationId)
	{
		// Strip out the padding and save to the actual proposalId
		try
		{
			if ((applicationId != null) && (applicationId.contains(MBCPConstants.APPNO_PREFIX)))
			{
				paddedProposalId = CounterUtil.removeLeadingZeros(applicationId.substring(applicationId.lastIndexOf(MBCPConstants.APPNO_PREFIX) + 2, applicationId.length()));
			}
			else
			{
				paddedProposalId = applicationId;
			}
			setProposalId(Long.parseLong(paddedProposalId));
		}
		catch (Exception e)
		{

		}
	}

	@Column
	public String getSignatureOfBDM()
	{
		return signatureOfBDM;
	}

	public void setSignatureOfBDM(String signatureOfBDM)
	{
		this.signatureOfBDM = signatureOfBDM;
	}

	@Column(precision = 10, scale = 2)
	public BigDecimal getPremiumAmount()
	{
		return premiumAmount;
	}

	public void setPremiumAmount(BigDecimal premiumAmount)
	{
		this.premiumAmount = premiumAmount;
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

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "tbl_mapping_proposal_documents", joinColumns = { @JoinColumn(name = "proposalId") }, inverseJoinColumns = { @JoinColumn(name = "documentId") })
	public Set<MBCPDocument> getProposalDocuments()
	{
		return proposalDocuments;
	}

	public void setProposalDocuments(Set<MBCPDocument> proposalDocuments)
	{
		this.proposalDocuments = proposalDocuments;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "tbl_mapping_proposal_assuredpersons", joinColumns = { @JoinColumn(name = "proposalId") }, inverseJoinColumns = { @JoinColumn(name = "assuredPersonId") })
	public Set<AssuredPerson> getAssuredPersons()
	{
		return assuredPersons;
	}

	/**
	 * This looks wrong to me. Why on earth would you want to sort by id?
	 * Wouldn't it be better to sort by descending order of last modified date,
	 * so that the most recently-worked on proposal is displayed first?
	 * 
	 * - Jagan (07/June/2013).
	 * 
	 * @param assuredPersons
	 */
	public void setAssuredPersons(Set<AssuredPerson> assuredPersons)
	{
		this.assuredPersons = assuredPersons;
	}
	
	public int compareTo(IndividualProposal that)
	{
		return super.getProposalId().compareTo(that.getProposalId());
	}
}