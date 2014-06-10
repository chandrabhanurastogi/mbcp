package com.ifli.mbcp.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the tbl_family_dependent database table.
 * 
 */
@Entity
@Table(name="tbl_family_dependent")
public class FamilyDependent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long pk_FamilyDependentID;

	@Column(length=50)
	private String created_by;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created_date;

	@Temporal(TemporalType.TIMESTAMP)
	private Date familyDOB;

	@Column(length=1)
	private String familyFinanciallyDependent;

	@Column(length=10)
	private String familyGender;

	@Column(length=100)
	private String familyName;

	@Column(length=100)
	private String familyOccupation;

	@Column(length=100)
	private String familyRelationship;

	//private BigInteger fK_CustomerDetailsID;

	@Column(length=50)
	private String modified_by;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modified_date;

	//bi-directional many-to-one association to TblCustomerDetail
	@ManyToOne
	@JoinColumn(name="fK_CustomerDetailsID")
	private CustomerDetails tblCustomerDetail;

	public FamilyDependent() {
	}

	public Long getPk_FamilyDependentID() {
		return this.pk_FamilyDependentID;
	}

	public void setPk_FamilyDependentID(Long pk_FamilyDependentID) {
		this.pk_FamilyDependentID = pk_FamilyDependentID;
	}

	public String getCreated_by() {
		return this.created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public Date getCreated_date() {
		return this.created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public Date getFamilyDOB() {
		return this.familyDOB;
	}

	public void setFamilyDOB(Date familyDOB) {
		this.familyDOB = familyDOB;
	}

	public String getFamilyFinanciallyDependent() {
		return this.familyFinanciallyDependent;
	}

	public void setFamilyFinanciallyDependent(String familyFinanciallyDependent) {
		this.familyFinanciallyDependent = familyFinanciallyDependent;
	}

	public String getFamilyGender() {
		return this.familyGender;
	}

	public void setFamilyGender(String familyGender) {
		this.familyGender = familyGender;
	}

	public String getFamilyName() {
		return this.familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getFamilyOccupation() {
		return this.familyOccupation;
	}

	public void setFamilyOccupation(String familyOccupation) {
		this.familyOccupation = familyOccupation;
	}

	public String getFamilyRelationship() {
		return this.familyRelationship;
	}

	public void setFamilyRelationship(String familyRelationship) {
		this.familyRelationship = familyRelationship;
	}

	/*public BigInteger getFK_CustomerDetailsID() {
		return this.fK_CustomerDetailsID;
	}

	public void setFK_CustomerDetailsID(BigInteger fK_CustomerDetailsID) {
		this.fK_CustomerDetailsID = fK_CustomerDetailsID;
	}*/

	public String getModified_by() {
		return this.modified_by;
	}

	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}

	public Date getModified_date() {
		return this.modified_date;
	}

	public void setModified_date(Date modified_date) {
		this.modified_date = modified_date;
	}

	public CustomerDetails getTblCustomerDetail() {
		return this.tblCustomerDetail;
	}

	public void setTblCustomerDetail(CustomerDetails tblCustomerDetail) {
		this.tblCustomerDetail = tblCustomerDetail;
	}

	
}