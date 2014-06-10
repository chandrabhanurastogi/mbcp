package com.ifli.mbcp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
/**
 * Represents a type of person. type will be customer, proposer, assurer etc.
 * * 
 * @author FL703
 * @since 21 May 2013
 * @version 1.0
 */
@Entity
@Table(name = "tbl_lookup_person_type")
public class PersonType extends GenericLookup implements Serializable
{
	private static final long	serialVersionUID	= -5649490786666347871L;

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "personTypeId")
	public Long getId()
	{
		return super.getId();
	}

	@Override
	@Column(name = "personTypeName", length = 30, nullable = false)
	public String getName()
	{
		return super.getName();
	}

	@Override
	@Transient
	public String getDescription()
	{
		return super.getDescription();
	}
}
