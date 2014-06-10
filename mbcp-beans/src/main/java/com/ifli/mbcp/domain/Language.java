package com.ifli.mbcp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents a Language
 * 
 * @author FL867
 * @version 1.0
 * @since 22 May 2013
 * 
 */
@Entity
@Table(name = "tbl_lookup_language")
public class Language extends GenericLookup implements Serializable
{

	private static final long	serialVersionUID	= 1294081797940690241L;

	/**
	 * Unique Identifier of a Language instance
	 */
	@Id
	@Column(name = "languageId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Override
	public Long getId()
	{
		return super.getId();
	}

	/**
	 * The combination of a valid <STRONG>ISO Language Code</STRONG>
	 * (lower-case, two-letter code as defined by ISO-639) <br>
	 * and a valid <STRONG>ISO Country Code</STRONG> (upper-case, two-letter
	 * code as defined by ISO-3166) separated by an underscore '_'.<br>
	 * Ex. en_US is the Language code for American English
	 */
	@Column(name = "languageCode", length = 5, nullable = false)
	@Override
	public String getName()
	{
		return super.getName();
	}

	/**
	 * Descriptive name of the Language. <br>
	 * Ex. Simplified Chinese (zh_CN)
	 */
	@Column(name = "languageDesc", length = 50, nullable = true)
	@Override
	public String getDescription()
	{
		return super.getDescription();
	}

}
