package com.ifli.mbcp.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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

@Entity
@Table(name = "tbl_assured_person")
public class AssuredPerson extends Person implements Serializable
{
	private static final long			serialVersionUID	= 1302762101163391273L;
	private Long						assuredPersonId;
	private Boolean						isAssuredAnEmployeeOfIFLI;
	private Date						assuredProposalStartDate;
	private Set<Parent>					parentsOfAssured;
	private Spouse						spouseOfAssured;
	private Set<Child>					childrenOfAssured;
	private String						assuredIdentificationMarks;
	private Set<CustomerAddress>		allAddresses;
	private String						assuredTelephoneNumber;
	private String						assuredMobileNumber;
	private String						assuredEmailAddress;
	private String						assuredPhotograph;
	private String						assuredSignature;
	private EducationalQualifications	educationalQualifications;
	private String						lengthOfService;
	private Boolean						isSelfEmployed;
	private String						employerSchemeInsurance;
	private BigDecimal					personalContribution;
	private Short						retirementAge;
	private BigDecimal					anticipatedValueOfInsurance;
	private String						bankAccountNumber;							// Encrypt
	private String						bankAccountType;
	private String						bankName;
	private String						bankBranch;
	private Set<DependentPerson>		personsDependentOnTheAssured;
	// private Set<MedicalHistory> familyMedicalHistory;
	// private Set<Illness> previousIllnesses;
	private String						tpaAuthorizationCode;
	private LTRF						ltrf;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getAssuredPersonId()
	{
		return assuredPersonId;
	}

	public void setAssuredPersonId(Long assuredPersonId)
	{
		this.assuredPersonId = assuredPersonId;
	}

	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	public Boolean getIsAssuredAnEmployeeOfIFLI()
	{
		return isAssuredAnEmployeeOfIFLI;
	}

	public void setIsAssuredAnEmployeeOfIFLI(Boolean isAssuredAnEmployeeOfIFLI)
	{
		this.isAssuredAnEmployeeOfIFLI = isAssuredAnEmployeeOfIFLI;
	}

	@Column
	public Date getAssuredProposalStartDate()
	{
		return assuredProposalStartDate;
	}

	public void setAssuredProposalStartDate(Date assuredProposalStartDate)
	{
		this.assuredProposalStartDate = assuredProposalStartDate;
	}

	@Column(length = 50)
	public String getAssuredIdentificationMarks()
	{
		return assuredIdentificationMarks;
	}

	public void setAssuredIdentificationMarks(String assuredIdentificationMarks)
	{
		this.assuredIdentificationMarks = assuredIdentificationMarks;
	}

	/**
	 * Unidirectional One-to-Many on Address. A single AssuredPerson can own
	 * many Addresses, but we don't need the return relationship. However, other
	 * domain objects can also own Address instances. Hence we use a JoinTable
	 * instead of a JoinColumn.
	 * 
	 * @return
	 */
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tbl_mapping_assuredperson_address", joinColumns = { @JoinColumn(name = "assuredPersonId") }, inverseJoinColumns = { @JoinColumn(name = "customerAddressId") })
	public Set<CustomerAddress> getAllAddresses()
	{
		return allAddresses;
	}

	public void setAllAddresses(Set<CustomerAddress> allAddresses)
	{
		this.allAddresses = allAddresses;
	}

	@Column(length = 10)
	public String getAssuredTelephoneNumber()
	{
		return assuredTelephoneNumber;
	}

	public void setAssuredTelephoneNumber(String assuredTelephoneNumber)
	{
		this.assuredTelephoneNumber = assuredTelephoneNumber;
	}

	@Column(length = 10)
	public String getAssuredMobileNumber()
	{
		return assuredMobileNumber;
	}

	public void setAssuredMobileNumber(String assuredMobileNumber)
	{
		this.assuredMobileNumber = assuredMobileNumber;
	}

	@Column(length = 50)
	public String getAssuredEmailAddress()
	{
		return assuredEmailAddress;
	}

	public void setAssuredEmailAddress(String assuredEmailAddress)
	{
		this.assuredEmailAddress = assuredEmailAddress;
	}

	@Column(length = 40)
	public String getLengthOfService()
	{
		return lengthOfService;
	}

	public void setLengthOfService(String lengthOfService)
	{
		this.lengthOfService = lengthOfService;
	}

	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	public Boolean getIsSelfEmployed()
	{
		return isSelfEmployed;
	}

	public void setIsSelfEmployed(Boolean isSelfEmployed)
	{
		this.isSelfEmployed = isSelfEmployed;
	}

	@Column(length = 40)
	public String getEmployerSchemeInsurance()
	{
		return employerSchemeInsurance;
	}

	public void setEmployerSchemeInsurance(String employerSchemeInsurance)
	{
		this.employerSchemeInsurance = employerSchemeInsurance;
	}

	@Column(precision = 10, scale = 2)
	public BigDecimal getPersonalContribution()
	{
		return personalContribution;
	}

	public void setPersonalContribution(BigDecimal personalContribution)
	{
		this.personalContribution = personalContribution;
	}

	@Column(precision = 6, scale = 0)
	public Short getRetirementAge()
	{
		return retirementAge;
	}

	public void setRetirementAge(Short retirementAge)
	{
		this.retirementAge = retirementAge;
	}

	@Column(precision = 10, scale = 2)
	public BigDecimal getAnticipatedValueOfInsurance()
	{
		return anticipatedValueOfInsurance;
	}

	public void setAnticipatedValueOfInsurance(BigDecimal anticipatedValueOfInsurance)
	{
		this.anticipatedValueOfInsurance = anticipatedValueOfInsurance;
	}

	@Column(length = 50)
	public String getBankAccountNumber()
	{
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber)
	{
		this.bankAccountNumber = bankAccountNumber;
	}

	@Column(length = 20)
	public String getBankAccountType()
	{
		return bankAccountType;
	}

	public void setBankAccountType(String bankAccountType)
	{
		this.bankAccountType = bankAccountType;
	}

	@Column(length = 50)
	public String getBankName()
	{
		return bankName;
	}

	public void setBankName(String bankName)
	{
		this.bankName = bankName;
	}

	@Column(length = 50)
	public String getBankBranch()
	{
		return bankBranch;
	}

	public void setBankBranch(String bankBranch)
	{
		this.bankBranch = bankBranch;
	}

	@Override
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maritalStatusId", nullable = false)
	public MaritalStatus getMaritalStatus()
	{
		return super.getMaritalStatus();
	}

	@Override
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "occupationId")
	public Occupation getOccupation()
	{
		return super.getOccupation();
	}

	@Override
	@Column
	public String getNatureOfOccupation()
	{
		return super.getNatureOfOccupation();
	}

	@Override
	@Column
	public BigDecimal getAnnualIncome()
	{
		return super.getAnnualIncome();
	}

	@Override
	@Column
	public String getSourceOfIncome()
	{
		return super.getSourceOfIncome();
	}

	@Override
	@Column
	public String getPanCard()
	{
		return super.getPanCard();
	}

	/**
	 * Unidirectional One-to-One on Spouse. Unlike a Lookup, the Spouse cannot
	 * exist outside the lifecycle of the owning object. Hence we implement the
	 * CascadeType.ALL to ensure changes to the owner are reflected in the
	 * Spouse and vice-versa.
	 * 
	 * @return
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "spouseId")
	public Spouse getSpouseOfAssured()
	{
		return spouseOfAssured;
	}

	public void setSpouseOfAssured(Spouse spouse)
	{
		this.spouseOfAssured = spouse;
	}

	/**
	 * Unidirectional One-to-Many on Children. A single customer can own many
	 * Children, but we don't need the return relationship. However, other
	 * domain objects can also own Child instances. Hence we use a JoinTable
	 * instead of a JoinColumn.
	 * 
	 * @return
	 */
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tbl_mapping_leadcustomer_children", joinColumns = { @JoinColumn(name = "customerDetailsId") }, inverseJoinColumns = { @JoinColumn(name = "childId") })
	@JoinColumn(name = "customer")
	public Set<Child> getChildrenOfAssured()
	{
		return childrenOfAssured;
	}

	public void setChildrenOfAssured(Set<Child> allChildren)
	{
		this.childrenOfAssured = allChildren;
	}

	/**
	 * Unidirectional One-to-Many on Parents. A single customer can own many
	 * Parents, but we don't need the return relationship. However, other domain
	 * objects can also own Parent instances. Hence we use a JoinTable instead
	 * of a JoinColumn.
	 * 
	 * @return
	 */
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tbl_mapping_leadcustomer_parents", joinColumns = { @JoinColumn(name = "customerDetailsId") }, inverseJoinColumns = { @JoinColumn(name = "parentId") })
	public Set<Parent> getParentsOfAssured()
	{
		return parentsOfAssured;
	}

	public void setParentsOfAssured(Set<Parent> allParents)
	{
		this.parentsOfAssured = allParents;
	}

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "educationalQualificationId")
	public EducationalQualifications getEducationalQualifications()
	{
		return educationalQualifications;
	}

	public void setEducationalQualifications(EducationalQualifications educationalQualifications)
	{
		this.educationalQualifications = educationalQualifications;
	}

	/**
	 * Using a JoinColumn-based OneToMany mapping. This presupposes that
	 * AssuredPerson is the SOLE, ie ONE AND ONLY, OWNER of DependentPerson.
	 * Hence we are able to map using just the JoinColumn. If more than one
	 * owner needs to contain DependentPerson, then we must use a JoinTable like
	 * we do in for Address.
	 * 
	 * @return
	 */
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "assuredPersonId")
	public Set<DependentPerson> getPersonsDependentOnTheAssured()
	{
		return personsDependentOnTheAssured;
	}

	public void setPersonsDependentOnTheAssured(Set<DependentPerson> personsDependentOnTheAssured)
	{
		this.personsDependentOnTheAssured = personsDependentOnTheAssured;
	}

	/**
	 * Using a JoinColumn-based OneToMany mapping. This presupposes that
	 * AssuredPerson is the SOLE, ie ONE AND ONLY, OWNER of Medical History.
	 * Hence we are able to map using just the JoinColumn. If more than one
	 * owner needs to contain MedicalHistory, then we must use a JoinTable like
	 * we do in for Address.
	 * 
	 * @return
	 */
	// @OneToMany(cascade = CascadeType.ALL)
	// @JoinColumn(name = "assuredPersonId")
	// public Set<MedicalHistory> getFamilyMedicalHistory()
	// {
	// return familyMedicalHistory;
	// }
	//
	// public void setFamilyMedicalHistory(Set<MedicalHistory>
	// familyMedicalHistory)
	// {
	// this.familyMedicalHistory = familyMedicalHistory;
	// }

	/**
	 * Using a JoinColumn-based OneToMany mapping. This presupposes that
	 * AssuredPerson is the SOLE, ie ONE AND ONLY, OWNER of Prior Illness. Hence
	 * we are able to map using just the JoinColumn. If more than one owner
	 * needs to contain Prior Illness, then we must use a JoinTable like we do
	 * in for Address.
	 * 
	 * @return
	 */
	// @OneToMany(cascade = CascadeType.ALL)
	// @JoinColumn(name = "assuredPersonId")
	// public Set<Illness> getPreviousIllnesses()
	// {
	// return previousIllnesses;
	// }
	//
	// public void setPreviousIllnesses(Set<Illness> previousIllnesses)
	// {
	// this.previousIllnesses = previousIllnesses;
	// }

	@Column
	public String getTpaAuthorizationCode()
	{
		return tpaAuthorizationCode;
	}

	public void setTpaAuthorizationCode(String tpaAuthorizationCode)
	{
		this.tpaAuthorizationCode = tpaAuthorizationCode;
	}

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "ltrfId")
	public LTRF getLtrf()
	{
		return ltrf;
	}

	public void setLtrf(LTRF ltrf)
	{
		this.ltrf = ltrf;
	}

	@Column
	public String getAssuredPhotograph()
	{
		return assuredPhotograph;
	}

	public void setAssuredPhotograph(String assuredPhotograph)
	{
		this.assuredPhotograph = assuredPhotograph;
	}

	@Column
	public String getAssuredSignature()
	{
		return assuredSignature;
	}

	public void setAssuredSignature(String assuredSignature)
	{
		this.assuredSignature = assuredSignature;
	}

	@Override
	@Column(length = 30, nullable = false)
	public String getFirstName()
	{
		return super.getFirstName();
	}

	@Override
	@Column(length = 30)
	public String getMiddleName()
	{
		return super.getMiddleName();
	}

	@Override
	@Column(length = 30, nullable = false)
	public String getLastName()
	{
		return super.getLastName();
	}

	@Override
	@JoinColumn(name = "salutationId", nullable = false)
	public Salutation getSalutation()
	{
		return super.getSalutation();
	}
}