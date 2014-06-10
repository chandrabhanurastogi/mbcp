package com.ifli.mbcp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents a possible salutation - Mr., Mrs., Shri., Smt., M/s., etc. This
 * is entirely up to IFLI to define. For us it is a lookup entity.
 * 
 * @author FL867
 * @version 1.0
 * @since 29 April 2013
 */
@Entity
@Table(name = "tbl_lookup_salutation")
public class Salutation extends GenericLookup implements Serializable
{
	/**
	 *  Unique Identifier of a Salutation
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getSalutationId()
	{
		return (super.getId());
	}
	
	public void setSalutationId(Long salutationId)
	{
		super.setId(salutationId);
	}
	
	/**
	 * The actual salutation title
	 */
	@Column(length = 8, nullable = false)
	public String getSalutationText()
	{
		return (super.getName());
	}

	public void setSalutationText(String salutationText)
	{
		super.setName(salutationText);
	}
	
	public int compareTo(Salutation thatSaluation)
	{
		return (this.getSalutationText().compareTo(thatSaluation.getSalutationText()));
	}

	@Override
	public String toString()
	{
		return ("Salutation: " + this.getSalutationId() + " | " + this.getSalutationText());
	}

	private static final long	serialVersionUID	= 6668514493030241494L;
}
