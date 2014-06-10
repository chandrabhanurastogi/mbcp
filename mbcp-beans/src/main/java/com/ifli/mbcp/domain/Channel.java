package com.ifli.mbcp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents a channel entity. A channel represents the avenue through which the business (lead) has been acquired.
 * 
 * @author FL867
 * @since 29 April 2013
 * @version 1.0
 */
@Entity
@Table(name = "tbl_lookup_channel")
public class Channel extends GenericLookup implements Serializable
{
	private static final long	serialVersionUID	= 1453295230535603792L;

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "channelId")
	public Long getId()
	{
		return super.getId();
	}

	@Override
	@Column(name = "channelName", length = 30, nullable = false)
	public String getName()
	{
		return super.getName();
	}

	@Override
	@Column(name = "channelDescription", length = 128, nullable = true)
	public String getDescription()
	{
		return super.getDescription();
	}
}
