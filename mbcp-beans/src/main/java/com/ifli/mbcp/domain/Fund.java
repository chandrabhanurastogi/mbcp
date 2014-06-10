package com.ifli.mbcp.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tbl_fund database table.
 * @author FL703
 * @version 1.0
 * @since 09 May 2013
 */
@Entity
@Table(name="tbl_fund")
public class Fund implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long PK_FundID;

	@Column(length=50)
	private String created_by;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created_date;

	@Column(length=100)
	private String fundName;

	@Column(length=50)
	private String modified_by;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modified_Date;

	//bi-directional many-to-one association to TblBenefitIllustration
	/*@ManyToOne
	@JoinColumn(name="FK_BenefitIllustrationId")
	private BenefitIllustration tblBenefitIllustration;*/

	public Fund() {
	}

	public Long getPK_FundID() {
		return this.PK_FundID;
	}

	public void setPK_FundID(Long PK_FundID) {
		this.PK_FundID = PK_FundID;
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

	public String getFundName() {
		return this.fundName;
	}

	public void setFundName(String fundName) {
		this.fundName = fundName;
	}

	public String getModified_by() {
		return this.modified_by;
	}

	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}

	public Date getModified_Date() {
		return this.modified_Date;
	}

	public void setModified_Date(Date modified_Date) {
		this.modified_Date = modified_Date;
	}

	/*public BenefitIllustration getTblBenefitIllustration() {
		return this.tblBenefitIllustration;
	}

	public void setTblBenefitIllustration(BenefitIllustration tblBenefitIllustration) {
		this.tblBenefitIllustration = tblBenefitIllustration;
	}*/

	
}