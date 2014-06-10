package com.ifli.mbcp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents an educational qualification, such as B.Sc., MBA, Ph.D, BE,
 * X-Pass, XII-Pass, MBBS, etc.
 * 
 * @author FL867
 * @since 25 May 2013
 * @version 1.0
 */
@Entity
@Table(name = "tbl_lookup_educational_qualifications")
public class EducationalQualifications extends GenericLookup implements Serializable
{
	private static final long	serialVersionUID	= -410286897080075364L;

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "educationalQualificationId")
	public Long getId()
	{
		return super.getId();
	}

	@Override
	public String getName()
	{
		return super.getName();
	}

	@Override
	public String getDescription()
	{
		return super.getDescription();
	}
}
