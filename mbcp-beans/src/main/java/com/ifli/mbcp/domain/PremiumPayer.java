package com.ifli.mbcp.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 * Represents a person who is paying the premium. Lead, AssuredPerson, Nominee,
 * and Payer may all be different people within the context of a single policy.
 * 
 * @author FL867
 * 
 */
@Entity
@Table(name = "tbl_premium_payer")
public class PremiumPayer extends Person implements Serializable
{
	private static final long	serialVersionUID	= 7233643728083582147L;
	private Long				payerId;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getPayerId()
	{
		return payerId;
	}

	public void setPayerId(Long payerId)
	{
		this.payerId = payerId;
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
	@Column
	public String getPanCard()
	{
		return super.getPanCard();
	}
}