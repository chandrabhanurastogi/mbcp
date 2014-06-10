package com.ifli.mbcp.vo;

import java.util.Date;

public class FamilyDependentVO
{
	private Long pk_FamilyDependentID;

	private String created_by;

	private Date created_date;

	private Date familyDOB;

	private String familyFinanciallyDependent;

	private String familyGender;

	private String familyName;

	private String familyOccupation;

	private String familyRelationship;

	//private BigInteger fK_CustomerDetailsID;

	private String modified_by;

	private Date modified_date;

	//bi-directional many-to-one association to TblCustomerDetail
	private CustomerDetailsVO tblCustomerDetailVO;

	public Long getPk_FamilyDependentID()
	{
		return pk_FamilyDependentID;
	}

	public String getCreated_by()
	{
		return created_by;
	}

	public Date getCreated_date()
	{
		return created_date;
	}

	public Date getFamilyDOB()
	{
		return familyDOB;
	}

	public String getFamilyFinanciallyDependent()
	{
		return familyFinanciallyDependent;
	}

	public String getFamilyGender()
	{
		return familyGender;
	}

	public String getFamilyName()
	{
		return familyName;
	}

	public String getFamilyOccupation()
	{
		return familyOccupation;
	}

	public String getFamilyRelationship()
	{
		return familyRelationship;
	}

	public String getModified_by()
	{
		return modified_by;
	}

	public Date getModified_date()
	{
		return modified_date;
	}

	

	public void setPk_FamilyDependentID(Long pk_FamilyDependentID)
	{
		this.pk_FamilyDependentID = pk_FamilyDependentID;
	}

	public void setCreated_by(String created_by)
	{
		this.created_by = created_by;
	}

	public void setCreated_date(Date created_date)
	{
		this.created_date = created_date;
	}

	public void setFamilyDOB(Date familyDOB)
	{
		this.familyDOB = familyDOB;
	}

	public void setFamilyFinanciallyDependent(String familyFinanciallyDependent)
	{
		this.familyFinanciallyDependent = familyFinanciallyDependent;
	}

	public void setFamilyGender(String familyGender)
	{
		this.familyGender = familyGender;
	}

	public void setFamilyName(String familyName)
	{
		this.familyName = familyName;
	}

	public void setFamilyOccupation(String familyOccupation)
	{
		this.familyOccupation = familyOccupation;
	}

	public void setFamilyRelationship(String familyRelationship)
	{
		this.familyRelationship = familyRelationship;
	}

	public void setModified_by(String modified_by)
	{
		this.modified_by = modified_by;
	}

	public void setModified_date(Date modified_date)
	{
		this.modified_date = modified_date;
	}

	public CustomerDetailsVO getTblCustomerDetailVO()
	{
		return tblCustomerDetailVO;
	}

	public void setTblCustomerDetailVO(CustomerDetailsVO tblCustomerDetailVO)
	{
		this.tblCustomerDetailVO = tblCustomerDetailVO;
	}


}
