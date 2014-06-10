package com.ifli.mbcp.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Represents an abstract person. Implementations can be CustomerDetails,
 * AssuredPerson, Child, Spouse, ClaimantPerson, DependentPerson, etc.
 * 
 * @author FL867
 * @since 29 April 2013
 * @version 1.0
 */
public abstract class Person
{
	private String			firstName;
	private String			middleName;
	private String			lastName;
	private Salutation		salutation;
	private Date			dateOfBirth;
	private Short			gender;
	private PersonType		personType;
	private MaritalStatus	maritalStatus;
	private Occupation		occupation;
	private String			natureOfOccupation;
	private BigDecimal		annualIncome;
	private String			sourceOfIncome;
	private String			panCard;			// Save encrypted

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getMiddleName()
	{
		return middleName;
	}

	public void setMiddleName(String middleName)
	{
		this.middleName = middleName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public Salutation getSalutation()
	{
		return salutation;
	}

	public void setSalutation(Salutation salutation)
	{
		this.salutation = salutation;
	}

	public Date getDateOfBirth()
	{
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth)
	{
		this.dateOfBirth = dateOfBirth;
	}

	public Short getGender()
	{
		return gender;
	}

	public void setGender(Short gender)
	{
		this.gender = gender;
	}

	public PersonType getPersonType()
	{
		return personType;
	}

	public void setPersonType(PersonType personType)
	{
		this.personType = personType;
	}

	public MaritalStatus getMaritalStatus()
	{
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus)
	{
		this.maritalStatus = maritalStatus;
	}

	public Occupation getOccupation()
	{
		return occupation;
	}

	public void setOccupation(Occupation occupation)
	{
		this.occupation = occupation;
	}

	public String getNatureOfOccupation()
	{
		return natureOfOccupation;
	}

	public void setNatureOfOccupation(String natureOfOccupation)
	{
		this.natureOfOccupation = natureOfOccupation;
	}

	public BigDecimal getAnnualIncome()
	{
		return annualIncome;
	}

	public void setAnnualIncome(BigDecimal annualIncome)
	{
		this.annualIncome = annualIncome;
	}

	public String getSourceOfIncome()
	{
		return sourceOfIncome;
	}

	public void setSourceOfIncome(String sourceOfIncome)
	{
		this.sourceOfIncome = sourceOfIncome;
	}

	public String getPanCard()
	{
		return panCard;
	}

	public void setPanCard(String panCard)
	{
		this.panCard = panCard;
	}
}
