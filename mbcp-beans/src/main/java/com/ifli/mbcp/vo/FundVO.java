package com.ifli.mbcp.vo;

import java.util.Date;

public class FundVO
{
	private Long PK_FundID;

	private String created_by;

	private Date created_date;

	private String fundName;

	private String modified_by;

	private Date modified_Date;

	public Long getPK_FundID()
	{
		return PK_FundID;
	}

	public String getCreated_by()
	{
		return created_by;
	}

	public Date getCreated_date()
	{
		return created_date;
	}

	public String getFundName()
	{
		return fundName;
	}

	public String getModified_by()
	{
		return modified_by;
	}

	public Date getModified_Date()
	{
		return modified_Date;
	}

	public void setPK_FundID(Long pK_FundID)
	{
		PK_FundID = pK_FundID;
	}

	public void setCreated_by(String created_by)
	{
		this.created_by = created_by;
	}

	public void setCreated_date(Date created_date)
	{
		this.created_date = created_date;
	}

	public void setFundName(String fundName)
	{
		this.fundName = fundName;
	}

	public void setModified_by(String modified_by)
	{
		this.modified_by = modified_by;
	}

	public void setModified_Date(Date modified_Date)
	{
		this.modified_Date = modified_Date;
	}

}
