package com.ifli.mbcp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents one of the 28 states or 11 union territories of India.
 * 
 * @author FL867
 * @version 1.0
 * @since 29 April 2013
 */
@Entity
@Table(name = "tbl_lookup_state")
public class State implements Serializable, Comparable<State>
{
	/**
	 * Unique Identifier for the State
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long	stateId;
	/**
	 * Name of the State
	 */
	@Column(length = 50, nullable = false)
	private String	stateName;

	/**
	 * 2 digit State Code, Ex. MH - Maharashtra, KA - Karnataka etc.
	 */
	@Column(length = 2, nullable = false)
	private String	stateCode;

	public Long getStateId()
	{
		return stateId;
	}

	public void setStateId(Long stateId)
	{
		this.stateId = stateId;
	}

	public String getStateName()
	{
		return stateName;
	}

	public void setStateName(String stateName)
	{
		this.stateName = stateName;
	}

	public String getStateCode()
	{
		return stateCode;
	}

	public void setStateCode(String stateCode)
	{
		this.stateCode = stateCode;
	}

	public int compareTo(State thatState)
	{
		return (this.getStateName().compareTo(thatState.getStateName()));
	}

	private static final long	serialVersionUID	= 8102350106487316713L;
}
