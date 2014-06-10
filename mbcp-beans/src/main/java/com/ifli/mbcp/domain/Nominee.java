package com.ifli.mbcp.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

import java.util.Date;

/**
 * Represents the nominee for a Policy. Currently, even if there is more than
 * one assured person for a policy, there can only be one nominee. If each
 * assured person can have a different nominee then the nominee will have to be
 * moved to AssuredPerson.
 * 
 */
@Entity
@Table(name = "tbl_nominee")
public class Nominee extends Person implements Serializable
{
	private static final long	serialVersionUID	= 3376479306786755372L;
	private Long				nomineeId;
	private Relationship		relationship;
	private BigDecimal			percentageOfEntitlement;

	public Nominee()
	{
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getNomineeId()
	{
		return nomineeId;
	}

	public void setNomineeId(Long nomineeId)
	{
		this.nomineeId = nomineeId;
	}

	@OneToOne
	@JoinColumn(name = "relationshipId", nullable = false)
	public Relationship getRelationship()
	{
		return relationship;
	}

	public void setRelationship(Relationship relationship)
	{
		this.relationship = relationship;
	}

	@Column(precision = 5, scale = 2, nullable = false)
	public BigDecimal getPercentageOfEntitlement()
	{
		return percentageOfEntitlement;
	}

	public void setPercentageOfEntitlement(BigDecimal percentageOfEntitlement)
	{
		this.percentageOfEntitlement = percentageOfEntitlement;
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
	@Column
	public String getPanCard()
	{
		return super.getPanCard();
	}
}