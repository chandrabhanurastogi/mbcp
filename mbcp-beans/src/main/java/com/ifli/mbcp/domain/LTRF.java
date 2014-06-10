package com.ifli.mbcp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Lookup class for the LTRF grid.
 * @author FL867
 * @since 23 May 2013
 * @version 1.0
 */
@Entity
@Table(name = "tbl_lookup_ltrf")
public class LTRF extends GenericLookup implements Serializable
{
	private Double	sumFloor;
	private Double	sumCeiling;
	private Short	ageFloor;
	private Short	ageCeiling;

	@Override
	@Id
	@Column(name = "ltrfId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId()
	{
		return super.getId();
	}

	@Override
	@Column(name = "ltrfTierName", nullable = false)
	public String getName()
	{
		return super.getName();
	}

	@Override
	@Column(name = "ltrfDesc", nullable = true)
	public String getDescription()
	{
		return super.getDescription();
	}

	@Column(nullable = false)
	public Double getSumFloor()
	{
		return sumFloor;
	}

	public void setSumFloor(Double sumFloor)
	{
		this.sumFloor = sumFloor;
	}

	@Column(nullable = false)
	public Double getSumCeiling()
	{
		return sumCeiling;
	}

	public void setSumCeiling(Double sumCeiling)
	{
		this.sumCeiling = sumCeiling;
	}

	@Column(nullable = false)
	public Short getAgeFloor()
	{
		return ageFloor;
	}

	public void setAgeFloor(Short ageFloor)
	{
		this.ageFloor = ageFloor;
	}

	@Column(nullable = false)
	public Short getAgeCeiling()
	{
		return ageCeiling;
	}

	public void setAgeCeiling(Short ageCeiling)
	{
		this.ageCeiling = ageCeiling;
	}

	private static final long	serialVersionUID	= 7201791782982877557L;
}
