package com.ifli.mbcp.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Represents the benefit illustration. This domain object explains the
 * potential returns and benefits that a lead would get by subscribing to a
 * particular IFLI insurance plan, and the costs associated with that plan, in
 * terms of premium, etc.
 * 
 * @author FL703
 * @version 1.0
 * @since 09 May 2013
 */
@Entity
@Table(name = "tbl_benefitillustration")
public class BenefitIllustration implements Serializable {
	
	private Long benefitIllustrationId;

	private InsurancePlan selectedPlan;

	//private Set<AssuredPerson> assuredPersons;

	// private PremiumType premiumType; //This may or may not be the same as
	// Premium Frequency
	private BigDecimal sumAssured;

	private Double productTerm;

	private Double premiumTerm;

	private BigDecimal installmentPremium;

	private BigDecimal annualPremium;

	private String fundBreakupAmounts;

	private String signatureOfProposer;

	private String signatureOfBDM;

	private String createdBy;

	private Date createdDate;

	private BigDecimal instalmentPremium;

	private String lastModifiedBy;

	private Date lastModifiedDate;

	private Boolean isSelectedForNextStage;

	//private Proposal correspondingProposal;
	public BenefitIllustration() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	public Long getBenefitIllustrationId() {
		return benefitIllustrationId;
	}

	public void setBenefitIllustrationId(Long benefitIllustrationId) {
		this.benefitIllustrationId = benefitIllustrationId;
	}

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "planId", nullable = false)
	public InsurancePlan getSelectedPlan() {
		return selectedPlan;
	}

	public void setSelectedPlan(InsurancePlan selectedPlan) {
		this.selectedPlan = selectedPlan;
	}

	@Column(precision = 10, scale = 2)
	public BigDecimal getSumAssured() {
		return sumAssured;
	}

	public void setSumAssured(BigDecimal sumAssured) {
		this.sumAssured = sumAssured;
	}

	@Column(name = "product_term", columnDefinition = "Decimal(10,2) default '0.00'")
	public Double getProductTerm() {
		return productTerm;
	}

	public void setProductTerm(Double productTerm) {
		this.productTerm = productTerm;
	}

	@Column(name = "premium_term", columnDefinition = "Decimal(10,2) default '0.00'")
	public Double getPremiumTerm() {
		return premiumTerm;
	}

	public void setPremiumTerm(Double premiumTerm) {
		this.premiumTerm = premiumTerm;
	}

	@Column(precision = 10, scale = 2)
	public BigDecimal getInstallmentPremium() {
		return installmentPremium;
	}

	public void setInstallmentPremium(BigDecimal installmentPremium) {
		this.installmentPremium = installmentPremium;
	}

	@Column(precision = 10, scale = 2)
	public BigDecimal getAnnualPremium() {
		return annualPremium;
	}

	public void setAnnualPremium(BigDecimal annualPremium) {
		this.annualPremium = annualPremium;
	}

	@Column(length = 100)
	public String getFundBreakupAmounts() {
		return fundBreakupAmounts;
	}

	public void setFundBreakupAmounts(String fundBreakupAmounts) {
		this.fundBreakupAmounts = fundBreakupAmounts;
	}

	@Column(length = 100)
	public String getSignatureOfProposer() {
		return signatureOfProposer;
	}

	public void setSignatureOfProposer(String signatureOfProposer) {
		this.signatureOfProposer = signatureOfProposer;
	}

	@Column(length = 100)
	public String getSignatureOfBDM() {
		return signatureOfBDM;
	}

	public void setSignatureOfBDM(String signatureOfBDM) {
		this.signatureOfBDM = signatureOfBDM;
	}

	@Column(length = 100)
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(precision = 10, scale = 2)
	public BigDecimal getInstalmentPremium() {
		return instalmentPremium;
	}

	public void setInstalmentPremium(BigDecimal instalmentPremium) {
		this.instalmentPremium = instalmentPremium;
	}

	@Column(length = 100)
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	public Boolean getIsSelectedForNextStage() {
		return isSelectedForNextStage;
	}

	public void setIsSelectedForNextStage(Boolean isSelectedForNextStage) {
		this.isSelectedForNextStage = isSelectedForNextStage;
	}

	/*@OneToOne
	@JoinColumn(name = "proposalId", nullable = false)
	public Proposal getCorrespondingProposal() {
		return correspondingProposal;
	}

	public void setCorrespondingProposal(Proposal correspondingProposal) {
		this.correspondingProposal = correspondingProposal;
	}*/

	/*@OneToMany(mappedBy = "owningBenefit", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public Set<AssuredPerson> getAssuredPersons() {
		return assuredPersons;
	}

	public void setAssuredPersons(Set<AssuredPerson> assuredPersons) {
		this.assuredPersons = assuredPersons;
	}*/

	private static final long serialVersionUID = -5655177649525951958L;
}