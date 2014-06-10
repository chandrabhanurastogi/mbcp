package com.ifli.mbcp.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Represents a Proposal of insurance policy for an Individual Lead. <br>
 * This abstract class will be extended by the actual proposals, namely
 * Individual and Group. But other entities will refer to simply Proposal.
 * 
 * IMPORTANT: As of 06/June/2013 DO NOT WORK ON THIS DOMAIN OBJECT UNTIL FURTHER
 * NOTICE - JAGAN.
 * 
 * @author FL703
 * @version 1.0
 * @since 06 June 2013
 */
@Entity
@Table(name = "tbl_proposal")
@Inheritance(strategy=InheritanceType.JOINED)
public class Proposal implements Serializable 
{
	private static final long serialVersionUID = -4377164383163832613L;
	
	private Long	proposalId;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "proposalId")
	public Long getProposalId()
	{
		return proposalId;
	}

	public void setProposalId(Long proposalId)
	{
		this.proposalId = proposalId;
	}

	private Date	proposalDate;

	@Temporal(TemporalType.TIMESTAMP)
	public Date getProposalDate()
	{
		return proposalDate;
	}

	public void setProposalDate(Date proposalDate)
	{
		this.proposalDate = proposalDate;
	}

	
}
