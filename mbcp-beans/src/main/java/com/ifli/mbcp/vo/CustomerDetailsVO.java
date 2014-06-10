package com.ifli.mbcp.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.ifli.mbcp.domain.Child;
import com.ifli.mbcp.domain.CustomerAddress;
import com.ifli.mbcp.domain.CustomerDetails;
import com.ifli.mbcp.domain.EducationalQualifications;
import com.ifli.mbcp.domain.ExistingInsurance;
import com.ifli.mbcp.domain.Occupation;
import com.ifli.mbcp.domain.Parent;
import com.ifli.mbcp.domain.Person;
import com.ifli.mbcp.domain.Salutation;
import com.ifli.mbcp.domain.Spouse;
import com.liferay.portal.kernel.util.StringPool;

public class CustomerDetailsVO extends Person 
{
	private Long						customerDetailsId;
	private List<CustomerAddress>		customerAddress;
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
	private List<ExistingInsurance>		allExistingInsurance;
	private Spouse						spouse;
	private List<Child>					allChildren;
	private List<Parent>				allParents;
	
	public Long getCustomerDetailsId()
	{
		return customerDetailsId;
	}

	public void setCustomerDetailsId(Long customerDetailsId)
	{
		this.customerDetailsId = customerDetailsId;
	}

	public Integer getBankAccountNumber()
	{
		return bankAccountNumber;
	}

	public void setBankAccountNumber(Integer bankAccountNumber)
	{
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getBankAccountType()
	{
		return bankAccountType;
	}

	public void setBankAccountType(String bankAccountType)
	{
		this.bankAccountType = bankAccountType;
	}

	public String getBankNameBranch()
	{
		return bankNameBranch;
	}

	public void setBankNameBranch(String bankNameBranch)
	{
		this.bankNameBranch = bankNameBranch;
	}

	public String getCoveredUnderPensionScheme()
	{
		return coveredUnderPensionScheme;
	}

	public void setCoveredUnderPensionScheme(String coveredUnderPensionScheme)
	{
		this.coveredUnderPensionScheme = coveredUnderPensionScheme;
	}

	public EducationalQualifications getEducationQualification()
	{
		return educationQualification;
	}

	public void setEducationQualification(EducationalQualifications educationQualification)
	{
		this.educationQualification = educationQualification;
	}

	public String getEmailId()
	{
		return emailId;
	}

	public void setEmailId(String emailId)
	{
		this.emailId = emailId;
	}

	public String getIdentificationMarks()
	{
		return identificationMarks;
	}

	public void setIdentificationMarks(String identificationMarks)
	{
		this.identificationMarks = identificationMarks;
	}

	public String getIncomeProofSubmitted()
	{
		return incomeProofSubmitted;
	}

	public void setIncomeProofSubmitted(String incomeProofSubmitted)
	{
		this.incomeProofSubmitted = incomeProofSubmitted;
	}

	public String getLengthOfService()
	{
		return lengthOfService;
	}

	public void setLengthOfService(String lengthOfService)
	{
		this.lengthOfService = lengthOfService;
	}

	public String getMobileNumber()
	{
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber)
	{
		this.mobileNumber = mobileNumber;
	}

	public String getLandLineNumber()
	{
		return landLineNumber;
	}

	public void setLandLineNumber(String landLineNumber)
	{
		this.landLineNumber = landLineNumber;
	}

	public String getNationality()
	{
		return nationality;
	}

	public void setNationality(String nationality)
	{
		this.nationality = nationality;
	}

	public String getNatureOfWork()
	{
		return natureOfWork;
	}

	public void setNatureOfWork(String natureOfWork)
	{
		this.natureOfWork = natureOfWork;
	}

	public Integer getNormalRetirementAge()
	{
		return normalRetirementAge;
	}

	public void setNormalRetirementAge(Integer normalRetirementAge)
	{
		this.normalRetirementAge = normalRetirementAge;
	}

	public BigDecimal getPensionAnticipatedValue()
	{
		return pensionAnticipatedValue;
	}

	public void setPensionAnticipatedValue(BigDecimal pensionAnticipatedValue)
	{
		this.pensionAnticipatedValue = pensionAnticipatedValue;
	}

	public String getPensionEmployeerScheme()
	{
		return pensionEmployeerScheme;
	}

	public void setPensionEmployeerScheme(String pensionEmployeerScheme)
	{
		this.pensionEmployeerScheme = pensionEmployeerScheme;
	}

	public BigDecimal getPensionPersonalContribution()
	{
		return pensionPersonalContribution;
	}

	public void setPensionPersonalContribution(BigDecimal pensionPersonalContribution)
	{
		this.pensionPersonalContribution = pensionPersonalContribution;
	}

	public BigDecimal getPensionRetirementAge()
	{
		return pensionRetirementAge;
	}

	public void setPensionRetirementAge(BigDecimal pensionRetirementAge)
	{
		this.pensionRetirementAge = pensionRetirementAge;
	}

	public BigDecimal getSelfEmployedAnnualIncome()
	{
		return selfEmployedAnnualIncome;
	}

	public void setSelfEmployedAnnualIncome(BigDecimal selfEmployedAnnualIncome)
	{
		this.selfEmployedAnnualIncome = selfEmployedAnnualIncome;
	}

	public Integer getSelfEmployedLabourDays()
	{
		return selfEmployedLabourDays;
	}

	public void setSelfEmployedLabourDays(Integer selfEmployedLabourDays)
	{
		this.selfEmployedLabourDays = selfEmployedLabourDays;
	}

	public String getSelfEmployedNatureOfWork()
	{
		return selfEmployedNatureOfWork;
	}

	public void setSelfEmployedNatureOfWork(String selfEmployedNatureOfWork)
	{
		this.selfEmployedNatureOfWork = selfEmployedNatureOfWork;
	}

	public String getSelfEmployedOccupation()
	{
		return selfEmployedOccupation;
	}

	public void setSelfEmployedOccupation(String selfEmployedOccupation)
	{
		this.selfEmployedOccupation = selfEmployedOccupation;
	}

	public String getSelfEmployedProjectedWorkingLife()
	{
		return selfEmployedProjectedWorkingLife;
	}

	public void setSelfEmployedProjectedWorkingLife(String selfEmployedProjectedWorkingLife)
	{
		this.selfEmployedProjectedWorkingLife = selfEmployedProjectedWorkingLife;
	}


	public List<CustomerAddress> getCustomerAddress()
	{
		return customerAddress;
	}

	public void setCustomerAddress(List<CustomerAddress> customerAddress)
	{
		this.customerAddress = customerAddress;
	}

	public String getFirstName()
	{
		return super.getFirstName();
	}

	public String getMiddleName()
	{
		return super.getMiddleName();
	}

	public String getLastName()
	{
		return super.getLastName();
	}

	public String getFullCustomerName()
	{
		return (this.getLastName() + ", " + this.getFirstName() + " " + this.getMiddleName());
	}

	public Salutation getSalutation()
	{
		return super.getSalutation();
	}

	public Date getDateOfBirth()
	{
		return super.getDateOfBirth();
	}

	public Short getGender()
	{
		return super.getGender();
	}

	public Occupation getOccupation()
	{
		return super.getOccupation();
	}

	public String getNatureOfOccupation()
	{
		return super.getNatureOfOccupation();
	}

	public BigDecimal getAnnualIncome()
	{
		return super.getAnnualIncome();
	}

	public String getSourceOfIncome()
	{
		return super.getSourceOfIncome();
	}

	public String getPanCard()
	{
		return super.getPanCard();
	}

	public List<ExistingInsurance> getAllExistingInsurance()
	{
		return allExistingInsurance;
	}

	public void setAllExistingInsurance(List<ExistingInsurance> allExistingInsurance)
	{
		this.allExistingInsurance = allExistingInsurance;
	}

	public int compareTo(CustomerDetails thatCustomerDetails)
	{
		return (this.getFullCustomerName().compareTo(thatCustomerDetails.getFullCustomerName()));
	}

	public Spouse getSpouse()
	{
		return spouse;
	}

	public void setSpouse(Spouse spouse)
	{
		this.spouse = spouse;
	}
	public List<Child> getAllChildren()
	{
		return allChildren;
	}

	public void setAllChildren(List<Child> allChildren)
	{
		this.allChildren = allChildren;
	}

	public List<Parent> getAllParents()
	{
		return allParents;
	}

	public void setAllParents(List<Parent> allParents)
	{
		this.allParents = allParents;
	}

	public String getFullName()
	{
		return getFirstName() +StringPool.BLANK + getLastName();
	}


}