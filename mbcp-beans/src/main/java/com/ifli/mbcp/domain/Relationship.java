package com.ifli.mbcp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents a Relationship(Association between any 2 persons). <br>
 * In IFLI perspective a Person can be a Claimant, Nominee or an AssuredPerson
 * etc.
 * 
 * @author FL867
 * @version 1.0
 * @since 24 May 2013
 * 
 */
@Entity
@Table(name = "tbl_lookup_relationship")
public class Relationship extends GenericLookup implements Serializable
{
	/**
	 * Unique Identifier of a Relationship
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "relationshipId")
	@Override
	public Long getId()
	{
		return super.getId();
	}

	/**
	 * Actual relationship
	 */
	@Override
	@Column(name = "relationshipName", nullable = false)
	public String getName()
	{
		return super.getName();
	}

	@Override
	@Column(name = "relationshipDesc", nullable = true)
	public String getDescription()
	{
		return super.getDescription();
	}

	private static final long	serialVersionUID	= 3863360690740243034L;
}
