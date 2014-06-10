package com.ifli.mbcp.domain;

/**
 * Represents a dynamic field within a Proposal.
 * @author FL867
 * @since 06 June 2013
 * @version 1.0
 */
public abstract class DynamicField
{
	private Long id;
	private String	fieldName;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getFieldName()
	{
		return fieldName;
	}

	public void setFieldName(String fieldName)
	{
		this.fieldName = fieldName;
	}
}
