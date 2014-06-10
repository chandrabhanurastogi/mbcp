package com.ifli.mbcp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents an address type. Examples include Current Address, Permanent
 * Address, etc.
 * 
 * @author FL867
 * @since 22 May 2013
 * @version 1.0
 */

@Entity
@Table(name = "tbl_lookup_address_type")
public class AddressType extends GenericLookup implements Serializable
{
	private static final long	serialVersionUID	= -8764573512544241013L;

	/**
	 * Unique identifier of the AddressType instance
	 */
	@Id
	@Column(name = "addressTypeId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Override
	public Long getId()
	{
		return super.getId();
	}

	/**
	 * Actual Address type. Ex. Permanent, Temporary, Communication etc.
	 */
	@Column(name = "addressTypeName", length = 30, nullable = false)
	@Override
	public String getName()
	{
		return super.getName();
	}

	/**
	 * Additional information about the Address Type
	 */
	@Column(name = "addressTypeDescription", length = 50, nullable = true)
	@Override
	public String getDescription()
	{
		return super.getDescription();
	}

}
