package com.ifli.mbcp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents an instance of large text (64 to 256 characters). Can represent
 * any large-length text value in Proposal.
 * 
 * @author FL867
 * @since 06 June 2013
 * @version 1.0
 */
@Entity
@Table(name = "tbl_dynamic_text_large")
public class DynamicTextLarge extends DynamicText implements Serializable
{
	private static final long	serialVersionUID	= 4819094078390173724L;

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	public Long getId()
	{
		return super.getId();
	}

	@Override
	@Column(length = 64, nullable = false)
	public String getFieldName()
	{
		return super.getFieldName();
	}

	@Override
	@Column(length = 256, nullable = true)
	public String getValue()
	{
		return super.getValue();
	}
}