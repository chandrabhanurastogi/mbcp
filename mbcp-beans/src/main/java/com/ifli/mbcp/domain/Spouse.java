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
 * Represents a spouse - husband or wife.
 * @author FL867
 * @since 25 May 2013
 * @version 1.0
 */
@Entity
@Table(name = "tbl_spouse")
public class Spouse extends Person implements Serializable
{
	private static final long	serialVersionUID	= 6989796971934719823L;
	private Long				spouseId;
	private Date				weddingAnniversary;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	public Long getSpouseId()
	{
		return spouseId;
	}

	public void setSpouseId(Long spouseId)
	{
		this.spouseId = spouseId;
	}

	@Column(nullable = false)
	public Date getWeddingAnniversary()
	{
		return weddingAnniversary;
	}

	public void setWeddingAnniversary(Date weddingAnniversary)
	{
		this.weddingAnniversary = weddingAnniversary;
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
	@OneToOne
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
