package com.ifli.mbcp.vo;

import java.util.Date;

public class NomineeVO
{
	private Long PK_NomineeId;

	private String address;

	private String created_by;

	private Date created_date;

	private Date dob;

	private String modified_by;

	private Date modified_date;

	private String nomineeNAME;

	private int percentageofEntitlement;

	private String relationship;

	//bi-directional many-to-one association to TblCustomerDetail
	private CustomerDetailsVO tblCustomerDetail;

	public Long getPK_NomineeId()
	{
		return PK_NomineeId;
	}

	public String getAddress()
	{
		return address;
	}

	public String getCreated_by()
	{
		return created_by;
	}

	public Date getCreated_date()
	{
		return created_date;
	}

	public Date getDob()
	{
		return dob;
	}

	public String getModified_by()
	{
		return modified_by;
	}

	public Date getModified_date()
	{
		return modified_date;
	}

	public String getNomineeNAME()
	{
		return nomineeNAME;
	}

	public int getPercentageofEntitlement()
	{
		return percentageofEntitlement;
	}

	public String getRelationship()
	{
		return relationship;
	}

	public CustomerDetailsVO getTblCustomerDetail()
	{
		return tblCustomerDetail;
	}

	public void setPK_NomineeId(Long pK_NomineeId)
	{
		PK_NomineeId = pK_NomineeId;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public void setCreated_by(String created_by)
	{
		this.created_by = created_by;
	}

	public void setCreated_date(Date created_date)
	{
		this.created_date = created_date;
	}

	public void setDob(Date dob)
	{
		this.dob = dob;
	}

	public void setModified_by(String modified_by)
	{
		this.modified_by = modified_by;
	}

	public void setModified_date(Date modified_date)
	{
		this.modified_date = modified_date;
	}

	public void setNomineeNAME(String nomineeNAME)
	{
		this.nomineeNAME = nomineeNAME;
	}

	public void setPercentageofEntitlement(int percentageofEntitlement)
	{
		this.percentageofEntitlement = percentageofEntitlement;
	}

	public void setRelationship(String relationship)
	{
		this.relationship = relationship;
	}

	public void setTblCustomerDetail(CustomerDetailsVO tblCustomerDetail)
	{
		this.tblCustomerDetail = tblCustomerDetail;
	}
}
