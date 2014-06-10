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
import javax.persistence.Transient;

import com.ifli.mbcp.util.MBCPConstants;

/**
 * Represents the basic information about a customer or prospective customer.
 * 
 * @author FL867
 * @since 29 April 2013
 * @version 1.0
 */
@Entity
@Table(name = "tbl_customer_details")
public class CustomerDetails extends Person implements Comparable<CustomerDetails>, Serializable
{
	private static final long			serialVersionUID	= 7978490264863047771L;
	private Long						customerDetailsId;
	private Set<CustomerAddress>		customerAddress;
	private Integer						bankAccountNumber;
	private String						bankAccountType;
	private String						bankNameBranch;
	private String						coveredUnderPensionScheme;
	private EducationalQualifications	educationQualification;
	private String						emailId;
	private String						identificationMarks;
	private String						incomeProofSubmitted;
	private String						lengthOfService;
	private String						mobileNumber;
	private String						landLineNumber;
	private String						nationality;
	private String						natureOfWork;
	private Integer						normalRetirementAge;
	private BigDecimal					pensionAnticipatedValue;
	private String						pensionEmployeerScheme;
	private BigDecimal					pensionPersonalContribution;
	private BigDecimal					pensionRetirementAge;
	private BigDecimal					selfEmployedAnnualIncome;
	private Integer						selfEmployedLabourDays;
	private String						selfEmployedNatureOfWork;
	private String						selfEmployedOccupation;
	private String						selfEmployedProjectedWorkingLife;
//	private Set<Nominee>				nominees;
	private Set<ExistingInsurance>		allExistingInsurance;
	private Spouse						spouse;
	private Set<Child>					allChildren;
	private Set<Parent>					allParents;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getCustomerDetailsId()
	{
		return customerDetailsId;
	}

	public void setCustomerDetailsId(Long customerDetailsId)
	{
		this.customerDetailsId = customerDetailsId;
	}

	@Column(length = 16)
	public Integer getBankAccountNumber()
	{
		return bankAccountNumber;
	}

	public void setBankAccountNumber(Integer bankAccountNumber)
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
	public String getBankNameBranch()
	{
		return bankNameBranch;
	}

	public void setBankNameBranch(String bankNameBranch)
	{
		this.bankNameBranch = bankNameBranch;
	}

	@Column(length = 50)
	public String getCoveredUnderPensionScheme()
	{
		return coveredUnderPensionScheme;
	}

	public void setCoveredUnderPensionScheme(String coveredUnderPensionScheme)
	{
		this.coveredUnderPensionScheme = coveredUnderPensionScheme;
	}

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "educationalQualificationId")
	public EducationalQualifications getEducationQualification()
	{
		return educationQualification;
	}

	public void setEducationQualification(EducationalQualifications educationQualification)
	{
		this.educationQualification = educationQualification;
	}

	@Column(length = 100)
	public String getEmailId()
	{
		return emailId;
	}

	public void setEmailId(String emailId)
	{
		this.emailId = emailId;
	}

	@Column(length = 100)
	public String getIdentificationMarks()
	{
		return identificationMarks;
	}

	public void setIdentificationMarks(String identificationMarks)
	{
		this.identificationMarks = identificationMarks;
	}

	@Column(length = 1)
	public String getIncomeProofSubmitted()
	{
		return incomeProofSubmitted;
	}

	public void setIncomeProofSubmitted(String incomeProofSubmitted)
	{
		this.incomeProofSubmitted = incomeProofSubmitted;
	}

	@Column(length = 50)
	public String getLengthOfService()
	{
		return lengthOfService;
	}

	public void setLengthOfService(String lengthOfService)
	{
		this.lengthOfService = lengthOfService;
	}

	@Column(length = 10)
	public String getMobileNumber()
	{
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber)
	{
		this.mobileNumber = mobileNumber;
	}

	@Column(length = 15)
	public String getLandLineNumber()
	{
		return landLineNumber;
	}

	public void setLandLineNumber(String landLineNumber)
	{
		this.landLineNumber = landLineNumber;
	}

	@Column(length = 50)
	public String getNationality()
	{
		return nationality;
	}

	public void setNationality(String nationality)
	{
		this.nationality = nationality;
	}

	@Column(length = 100)
	public String getNatureOfWork()
	{
		return natureOfWork;
	}

	public void setNatureOfWork(String natureOfWork)
	{
		this.natureOfWork = natureOfWork;
	}

	@Column(length = 3)
	public Integer getNormalRetirementAge()
	{
		return normalRetirementAge;
	}

	public void setNormalRetirementAge(Integer normalRetirementAge)
	{
		this.normalRetirementAge = normalRetirementAge;
	}

	@Column(precision = 10, scale = 2)
	public BigDecimal getPensionAnticipatedValue()
	{
		return pensionAnticipatedValue;
	}

	public void setPensionAnticipatedValue(BigDecimal pensionAnticipatedValue)
	{
		this.pensionAnticipatedValue = pensionAnticipatedValue;
	}

	@Column(length = 50)
	public String getPensionEmployeerScheme()
	{
		return pensionEmployeerScheme;
	}

	public void setPensionEmployeerScheme(String pensionEmployeerScheme)
	{
		this.pensionEmployeerScheme = pensionEmployeerScheme;
	}

	@Column(precision = 10, scale = 2)
	public BigDecimal getPensionPersonalContribution()
	{
		return pensionPersonalContribution;
	}

	public void setPensionPersonalContribution(BigDecimal pensionPersonalContribution)
	{
		this.pensionPersonalContribution = pensionPersonalContribution;
	}

	@Column(precision = 10, scale = 2)
	public BigDecimal getPensionRetirementAge()
	{
		return pensionRetirementAge;
	}

	public void setPensionRetirementAge(BigDecimal pensionRetirementAge)
	{
		this.pensionRetirementAge = pensionRetirementAge;
	}

	@Column
	public BigDecimal getSelfEmployedAnnualIncome()
	{
		return selfEmployedAnnualIncome;
	}

	public void setSelfEmployedAnnualIncome(BigDecimal selfEmployedAnnualIncome)
	{
		this.selfEmployedAnnualIncome = selfEmployedAnnualIncome;
	}

	@Column
	public Integer getSelfEmployedLabourDays()
	{
		return selfEmployedLabourDays;
	}

	public void setSelfEmployedLabourDays(Integer selfEmployedLabourDays)
	{
		this.selfEmployedLabourDays = selfEmployedLabourDays;
	}

	@Column(length = 100)
	public String getSelfEmployedNatureOfWork()
	{
		return selfEmployedNatureOfWork;
	}

	public void setSelfEmployedNatureOfWork(String selfEmployedNatureOfWork)
	{
		this.selfEmployedNatureOfWork = selfEmployedNatureOfWork;
	}

	@Column(length = 100)
	public String getSelfEmployedOccupation()
	{
		return selfEmployedOccupation;
	}

	public void setSelfEmployedOccupation(String selfEmployedOccupation)
	{
		this.selfEmployedOccupation = selfEmployedOccupation;
	}

	@Column(length = 50)
	public String getSelfEmployedProjectedWorkingLife()
	{
		return selfEmployedProjectedWorkingLife;
	}

	public void setSelfEmployedProjectedWorkingLife(String selfEmployedProjectedWorkingLife)
	{
		this.selfEmployedProjectedWorkingLife = selfEmployedProjectedWorkingLife;
	}

//	Commented out for now, as Policy owns Nominee. If CustomerDetail must also own Nominee
//	then both it and Policy must implement a JoinTable for Nominee.
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "customerDetailsId")
//	public Set<Nominee> getNominees()
//	{
//		return nominees;
//	}
//
//	public void setNominees(Set<Nominee> tblNominees)
//	{
//		this.nominees = tblNominees;
//	}

	/**
	 * Unidirectional One-to-Many on Address. A single customer can own many
	 * Addresses, but we don't need the return relationship. However, other
	 * domain objects can also own Address instances. Hence we use a JoinTable
	 * instead of a JoinColumn.
	 * 
	 * @return
	 */
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tbl_mapping_leadcustomer_address", joinColumns = { @JoinColumn(name = "customerDetailsId") }, inverseJoinColumns = { @JoinColumn(name = "customerAddressId") })
	public Set<CustomerAddress> getCustomerAddress()
	{
		return customerAddress;
	}

	public void setCustomerAddress(Set<CustomerAddress> customerAddress)
	{
		this.customerAddress = customerAddress;
	}

	@Override
	@Column(length = 30)
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
	@Column(length = 30)
	public String getLastName()
	{
		return super.getLastName();
	}

	@Transient
	public String getFullCustomerName()
	{
		return (this.getLastName() + ", " + this.getFirstName() + " " + this.getMiddleName());
	}

	@Override
	@OneToOne
	@JoinColumn(name = "salutationId", nullable = false)
	public Salutation getSalutation()
	{
		return super.getSalutation();
	}

	@Override
	@Column
	public Date getDateOfBirth()
	{
		return super.getDateOfBirth();
	}

	@Override
	@Column(length = 10)
	public Short getGender()
	{
		return super.getGender();
	}

	@Override
	@OneToOne
	@JoinColumn(name = "maritalStatusId", nullable = true)
	public MaritalStatus getMaritalStatus(){
		
		return super.getMaritalStatus();
	}
	@Transient
	public String getGenderType(){
		
		return (this.getGender().equals(MBCPConstants.MALE) ? "Male": "Female");
	}
	
	@Override
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "occupationId")
	public Occupation getOccupation()
	{
		return super.getOccupation();
	}

	@Override
	@Column(length = 50)
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
	@Column(length = 40)
	public String getSourceOfIncome()
	{
		return super.getSourceOfIncome();
	}

	@Override
	@Column(length = 10)
	public String getPanCard()
	{
		return super.getPanCard();
	}

	/**
	 * Unidirectional One-to-Many on ExistingInsurance. A single customer can
	 * own many Insurances, but we don't need the return relationship. However,
	 * other domain objects can also own ExistingInsurance instances. Hence we
	 * use a JoinTable instead of a JoinColumn.
	 * 
	 * @return
	 */
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tbl_mapping_leadcustomer_existinginsurance", joinColumns = { @JoinColumn(name = "customerDetailsId") }, inverseJoinColumns = { @JoinColumn(name = "existingInsuranceId") })
	public Set<ExistingInsurance> getAllExistingInsurance()
	{
		return allExistingInsurance;
	}

	public void setAllExistingInsurance(Set<ExistingInsurance> allExistingInsurance)
	{
		this.allExistingInsurance = allExistingInsurance;
	}

	public int compareTo(CustomerDetails thatCustomerDetails)
	{
		return (this.getFullCustomerName().compareTo(thatCustomerDetails.getFullCustomerName()));
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
	public Spouse getSpouse()
	{
		return spouse;
	}

	public void setSpouse(Spouse spouse)
	{
		this.spouse = spouse;
	}

	/**
	 * Unidirectional One-to-Many on Children. A single customer can own many Children, but we don't need
	 * the return relationship. However, other domain objects can also own Child instances. Hence we use a
	 * JoinTable instead of a JoinColumn.
	 * @return
	 */
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tbl_mapping_leadcustomer_children", joinColumns = { @JoinColumn(name = "customerDetailsId") }, inverseJoinColumns = { @JoinColumn(name = "childId") })
	@JoinColumn(name = "customer")
	public Set<Child> getAllChildren()
	{
		return allChildren;
	}

	public void setAllChildren(Set<Child> allChildren)
	{
		this.allChildren = allChildren;
	}

	/**
	 * Unidirectional One-to-Many on Parents. A single customer can own many Parents, but we don't need
	 * the return relationship. However, other domain objects can also own Parent instances. Hence we use a
	 * JoinTable instead of a JoinColumn.
	 * @return
	 */
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tbl_mapping_leadcustomer_parents", joinColumns = { @JoinColumn(name = "customerDetailsId") }, inverseJoinColumns = { @JoinColumn(name = "parentId") })
	public Set<Parent> getAllParents()
	{
		return allParents;
	}

	public void setAllParents(Set<Parent> allParents)
	{
		this.allParents = allParents;
	}
}