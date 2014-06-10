package com.ifli.mbcp.domain;


public abstract class DynamicText extends DynamicField
{
	private String value;

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}
}
