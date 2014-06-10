package com.ifli.mbcp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents a City.
 * 
 * @author FL889
 * @version 1.0
 * @since 14 May 2013
 */
@Entity
@Table(name = "tbl_lookup_city")
public class City implements Serializable, Comparable<City>
{
	private static final long	serialVersionUID	= 3993545215645442392L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long	cityId;

	@Column(length = 50, nullable = false)
	private String	cityName;
	
	public Long getCityId()
	{
		return cityId;
	}

	public void setCityId(Long cityId)
	{
		this.cityId = cityId;
	}

	public String getCityName()
	{
		return cityName;
	}

	public void setCityName(String cityName)
	{
		this.cityName = cityName;
	}

	public int compareTo(City that)
	{
		return (this.getCityName().compareTo(that.getCityName()));
	}
	
}
