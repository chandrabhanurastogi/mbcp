package com.ifli.mbcp.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Represents a person who makes a claim on behalf of one or more assured
 * persons on a policy, usually in case of the lamented passing away of the
 * assured person or persons.
 * 
 * @author FL867
 * 
 */
@Entity
@Table(name = "tbl_claimants")
public class ClaimantPerson extends Person implements Serializable
{
	private static final long	serialVersionUID	= 2555229356620666879L;
	private Long				claimantId;
	private Relationship		relationship;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	public Long getClaimantId()
	{
		return claimantId;
	}

	public void setClaimantId(Long claimantId)
	{
		this.claimantId = claimantId;
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
}
