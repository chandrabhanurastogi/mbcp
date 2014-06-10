package com.ifli.mbcp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Represents a customer address. Standard address fields will apply. Standard
 * field validations will also apply.
 * 
 * @author FL867
 * @version 1.0
 * @since 29 April 2013
 */
@Entity
@Table(name = "tbl_address")
public class CustomerAddress implements Serializable 
{
	private Long		customerAddressId;
	private String		addressLine1;
	private String		addressLine2;
	private String		addressLine3;
	private City		city;
	private State		state;
	private String		pinCode;
	private AddressType	addressType;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getCustomerAddressId()
	{
		return customerAddressId;
	}

	public void setCustomerAddressId(Long customerAddressId)
	{
		this.customerAddressId = customerAddressId;
	}

	@Column(length = 50, nullable = false)
	public String getAddressLine1()
	{
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1)
	{
		this.addressLine1 = addressLine1;
	}

	@Column(length = 50, nullable = true)
	public String getAddressLine2()
	{
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2)
	{
		this.addressLine2 = addressLine2;
	}

	@Column(length = 50, nullable = true)
	public String getAddressLine3()
	{
		return addressLine3;
	}

	public void setAddressLine3(String addressLine3)
	{
		this.addressLine3 = addressLine3;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cityId", nullable = true)
	public City getCity()
	{
		return city;
	}

	public void setCity(City city)
	{
		this.city = city;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "stateId", nullable = true)
	public State getState()
	{
		return state;
	}

	public void setState(State state)
	{
		this.state = state;
	}

	@Column(length = 6, nullable = true)
	public String getPinCode()
	{
		return pinCode;
	}

	public void setPinCode(String pinCode)
	{
		this.pinCode = pinCode;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "addressTypeId", nullable = true)
	public AddressType getAddressType()
	{
		return addressType;
	}

	public void setAddressType(AddressType addressType)
	{
		this.addressType = addressType;
	}

	// public CustomerDetails getOwningCustomer()
	// {
	// return owningCustomer;
	// }
	//
	// public void setOwningCustomer(CustomerDetails owningCustomer)
	// {
	// this.owningCustomer = owningCustomer;
	// }

	private static final long	serialVersionUID	= 1852136072612620394L;

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("CustomerAddress [customerAddressId=");
		builder.append(customerAddressId);
		builder.append(", addressLine1=");
		builder.append(addressLine1);
		builder.append(", addressLine2=");
		builder.append(addressLine2);
		builder.append(", addressLine3=");
		builder.append(addressLine3);
		builder.append(", city=");
		builder.append(city);
		builder.append(", state=");
		builder.append(state);
		builder.append(", pinCode=");
		builder.append(pinCode);
		builder.append(", addressType=");
		builder.append(addressType);
		builder.append(", owningCustomer=");
		// builder.append(owningCustomer);
		builder.append("]");
		return builder.toString();
	}

	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerAddressId == null) ? 0 : customerAddressId.hashCode());
		return result;
	}

	
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (!(obj instanceof CustomerAddress))
		{
			return false;
		}
		CustomerAddress other = (CustomerAddress) obj;
		if (customerAddressId == null)
		{
			if (other.customerAddressId != null)
			{
				return false;
			}
		}
		else if (!customerAddressId.equals(other.customerAddressId))
		{
			return false;
		}
		return true;
	}
	
	
}
