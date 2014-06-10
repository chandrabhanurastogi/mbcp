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

/**
 * Represents either a father, mother, father-in-law, or mother-in-law.
 * 
 * @author FL703, updated by FL867
 * @version 1.1
 * @since 09 May 2013, 26 May 2013
 */
@Entity
@Table(name = "tbl_parents")
public class Parent extends Person implements Serializable
{
	private static final long	serialVersionUID	= -8585766606512941556L;
	private Long				parentId;
	private Relationship		parentalRelationship;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	public Long getParentId()
	{
		return parentId;
	}

	public void setParentId(Long parentId)
	{
		this.parentId = parentId;
	}

	@OneToOne
	@JoinColumn(name = "relationshipId", nullable = false)
	public Relationship getParentalRelationship()
	{
		return parentalRelationship;
	}

	public void setParentalRelationship(Relationship parentalRelationship)
	{
		this.parentalRelationship = parentalRelationship;
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

	@Override
	@Column(nullable = false)
	public Date getDateOfBirth()
	{
		return super.getDateOfBirth();
	}

	@Override
	@Column(nullable = false)
	public Short getGender()
	{
		return super.getGender();
	}

	@Override
	@OneToOne
	@JoinColumn(name = "personTypeId")
	public PersonType getPersonType()
	{
		return super.getPersonType();
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
}