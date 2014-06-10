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
 * Represents a child - son or daughter.
 * 
 * @author FL703
 * @version 1.0
 * @since 09 May 2013
 */
@Entity
@Table(name = "tbl_child")
public class Child extends Person implements Serializable
{
	private static final long	serialVersionUID	= 7690957457776126172L;
	private Long				childId;
	private Relationship		relationship;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	public Long getChildId()
	{
		return childId;
	}

	public void setChildId(Long childId)
	{
		this.childId = childId;
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