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
 * Represents a dependent person; one who is financially dependent on the person
 * whom this instance is owned by.
 * 
 * @author FL867
 * 
 */
@Entity
@Table(name = "tbl_dependents")
public class DependentPerson extends Person implements Serializable
{
	private static final long	serialVersionUID	= 4490648558082753399L;
	private Long				dependentId;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	public Long getDependentId()
	{
		return dependentId;
	}

	public void setDependentId(Long dependentId)
	{
		this.dependentId = dependentId;
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
}
