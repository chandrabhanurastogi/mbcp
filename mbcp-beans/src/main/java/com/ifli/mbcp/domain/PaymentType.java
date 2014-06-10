package com.ifli.mbcp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents a payment type, which can be Cheque, Cash, Online, etc.
 * @author FL867
 * @since 22 May 2013
 * @version 1.0
 */
@Entity
@Table(name = "tbl_lookup_payment_type")
public class PaymentType extends GenericLookup implements Serializable
{
	private static final long	serialVersionUID	= 7474260697269075784L;

	@Override
	@Id
	@Column(name = "paymentTypeId")
	public Long getId()
	{
		return super.getId();
	}

	@Override
	@Column(name = "paymentTypeName", nullable = false)
	public String getName()
	{
		return super.getName();
	}

	@Override
	@Column(name = "paymentTypeDescription", nullable = true)
	public String getDescription()
	{
		return super.getDescription();
	}
}
