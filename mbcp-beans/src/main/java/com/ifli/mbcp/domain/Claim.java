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
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Represents a claim filed on behalf of one or more assured persons on a given
 * IFLI policy.
 * 
 * @author FL867
 * 
 */
@Entity
@Table(name = "tbl_claims")
public class Claim implements Serializable
{
	private Long				claimId;
	private ClaimantPerson		claimant;
	private Set<AssuredPerson>	deceasedAssureds;
	private Set<MBCPDocument>	claimDocuments;
	private ClaimStatus			claimStatus;
	private String				policyPossessor;
	private Boolean				wasHospitalized;
	private Boolean				isDeathCertifierDetailAvailable;
	private Boolean				isDeathDueToAnAccident;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getClaimId()
	{
		return claimId;
	}

	public void setClaimId(Long claimId)
	{
		this.claimId = claimId;
	}

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "claimantId", nullable = false)
	public ClaimantPerson getClaimant()
	{
		return claimant;
	}

	public void setClaimant(ClaimantPerson claimant)
	{
		this.claimant = claimant;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "tbl_mapping_claim_assuredpersons", joinColumns = { @JoinColumn(name = "claimId") }, inverseJoinColumns = { @JoinColumn(name = "assuredPersonId") })
	public Set<AssuredPerson> getDeceasedAssureds()
	{
		return deceasedAssureds;
	}

	public void setDeceasedAssureds(Set<AssuredPerson> deceasedAssureds)
	{
		this.deceasedAssureds = deceasedAssureds;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "tbl_mapping_claim_documents", joinColumns = { @JoinColumn(name = "claimId") }, inverseJoinColumns = { @JoinColumn(name = "documentId") })
	public Set<MBCPDocument> getClaimDocuments()
	{
		return claimDocuments;
	}

	public void setClaimDocuments(Set<MBCPDocument> claimDocuments)
	{
		this.claimDocuments = claimDocuments;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "claimStatusId")
	public ClaimStatus getClaimStatus()
	{
		return claimStatus;
	}

	public void setClaimStatus(ClaimStatus claimStatus)
	{
		this.claimStatus = claimStatus;
	}

	@Column(nullable = false)
	public String getPolicyPossessor()
	{
		return policyPossessor;
	}

	public void setPolicyPossessor(String policyPossessor)
	{
		this.policyPossessor = policyPossessor;
	}

	@Column(nullable = false)
	public Boolean getWasHospitalized()
	{
		return wasHospitalized;
	}

	public void setWasHospitalized(Boolean wasHospitalized)
	{
		this.wasHospitalized = wasHospitalized;
	}

	@Column(nullable = false)
	public Boolean getIsDeathCertifierDetailAvailable()
	{
		return isDeathCertifierDetailAvailable;
	}

	public void setIsDeathCertifierDetailAvailable(Boolean isDeathCertifierDetailAvailable)
	{
		this.isDeathCertifierDetailAvailable = isDeathCertifierDetailAvailable;
	}

	@Column(nullable = false)
	public Boolean getIsDeathDueToAnAccident()
	{
		return isDeathDueToAnAccident;
	}

	public void setIsDeathDueToAnAccident(Boolean isDeathDueToAnAccident)
	{
		this.isDeathDueToAnAccident = isDeathDueToAnAccident;
	}

	private static final long	serialVersionUID	= 7480053767410895153L;
}