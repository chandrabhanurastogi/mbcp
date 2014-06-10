package com.ifli.mbcp.vo;

import java.util.Date;
import java.util.List;

import com.ifli.mbcp.domain.BDMCode;
import com.ifli.mbcp.domain.BMRMCode;
import com.ifli.mbcp.domain.BranchCode;
import com.ifli.mbcp.domain.Channel;
import com.ifli.mbcp.domain.IndividualProposal;
import com.ifli.mbcp.domain.LeadCategory;
import com.ifli.mbcp.domain.LeadGeneratorCode;
import com.ifli.mbcp.domain.LeadStatus;
import com.ifli.mbcp.domain.LeadType;
import com.ifli.mbcp.domain.Policy;
import com.ifli.mbcp.domain.TaskType;

public class LeadVO
{
	private String				paddedLeadId; 
	private Long				leadId;
	private CustomerDetailsVO	leadCustomerDetails;
	private LeadType			leadType;
	private LeadStatus			leadStatus;
	private BDMCode				bdmCode;
	private LeadCategory		leadCategory;
	private Channel				channelSelection;
	private BranchCode			branchCode;
	private BMRMCode			bmRmCode;
	private LeadGeneratorCode	leadGeneratorCode;
	private Date				appointmentScheduled;
	private String				comments;
	private Integer				type;
	private Date				modifiedDate;
	private Date				createdDate;
	private TaskType			taskType;
	private List<NeedsAnalysisVO>	needsAnalysis;
	private List<IndividualProposal>		proposalsMade;
	private List<Policy>		purchasedPolicies;
	private boolean				assignApplicationNumber;
	private boolean				success;
	private Short				lifecycleState;

	public boolean getSuccess()
	{
		return success;
	}

	public void setSuccess(boolean success)
	{
		this.success = success;
	}

	public Long getLeadId()
	{
		return leadId;
	}

	public void setLeadId(Long leadId)
	{
		this.leadId = leadId;
	}

	public CustomerDetailsVO getLeadCustomerDetails()
	{
		return leadCustomerDetails;
	}

	public void setLeadCustomerDetails(CustomerDetailsVO leadCustomerDetails)
	{
		this.leadCustomerDetails = leadCustomerDetails;
	}

	public LeadType getLeadType()
	{
		return leadType;
	}

	public void setLeadType(LeadType leadType)
	{
		this.leadType = leadType;
	}

	public LeadStatus getLeadStatus()
	{
		return leadStatus;
	}

	public void setLeadStatus(LeadStatus leadStatus)
	{
		this.leadStatus = leadStatus;
	}

	public BDMCode getBdmCode()
	{
		return bdmCode;
	}

	public void setBdmCode(BDMCode bdmCode)
	{
		this.bdmCode = bdmCode;
	}

	public LeadCategory getLeadCategory()
	{
		return leadCategory;
	}

	public void setLeadCategory(LeadCategory leadCategory)
	{
		this.leadCategory = leadCategory;
	}

	public Channel getChannelSelection()
	{
		return channelSelection;
	}

	public void setChannelSelection(Channel channelSelection)
	{
		this.channelSelection = channelSelection;
	}

	public BranchCode getBranchCode()
	{
		return branchCode;
	}

	public void setBranchCode(BranchCode branchCode)
	{
		this.branchCode = branchCode;
	}

	public BMRMCode getBmRmCode()
	{
		return bmRmCode;
	}

	public void setBmRmCode(BMRMCode bmRmCode)
	{
		this.bmRmCode = bmRmCode;
	}

	public LeadGeneratorCode getLeadGeneratorCode()
	{
		return leadGeneratorCode;
	}

	public void setLeadGeneratorCode(LeadGeneratorCode leadGeneratorCode)
	{
		this.leadGeneratorCode = leadGeneratorCode;
	}

	public Date getAppointmentScheduled()
	{
		return appointmentScheduled;
	}

	public void setAppointmentScheduled(Date appointmentScheduled)
	{
		this.appointmentScheduled = appointmentScheduled;
	}

	public String getComments()
	{
		return comments;
	}

	public void setComments(String comments)
	{
		this.comments = comments;
	}

	public Integer getType()
	{
		return type;
	}

	public void setType(Integer type)
	{
		this.type = type;
	}

	public Date getModifiedDate()
	{
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate)
	{
		this.modifiedDate = modifiedDate;
	}

	public Date getCreatedDate()
	{
		return createdDate;
	}

	public void setCreatedDate(Date createdDate)
	{
		this.createdDate = createdDate;
	}

	public TaskType getTaskType()
	{
		return taskType;
	}

	public void setTaskType(TaskType taskType)
	{
		this.taskType = taskType;
	}

	public List<NeedsAnalysisVO> getNeedsAnalysis()
	{
		return needsAnalysis;
	}

	public void setNeedsAnalysis(List<NeedsAnalysisVO> needsAnalysis)
	{
		this.needsAnalysis = needsAnalysis;
	}

	public List<IndividualProposal> getProposalsMade()
	{
		return proposalsMade;
	}

	public void setProposalsMade(List<IndividualProposal> proposalsMade)
	{
		this.proposalsMade = proposalsMade;
	}

	public List<Policy> getPurchasedPolicies()
	{
		return purchasedPolicies;
	}

	public void setPurchasedPolicies(List<Policy> purchasedPolicies)
	{
		this.purchasedPolicies = purchasedPolicies;
	}

	public boolean getAssignApplicationNumber()
	{
		return assignApplicationNumber;
	}

	public void setAssignApplicationNumber(boolean assignApplicationNumber)
	{
		this.assignApplicationNumber = assignApplicationNumber;
	}

	public String getPaddedLeadId()
	{
		return paddedLeadId;
	}

	public void setPaddedLeadId(String paddedLeadId)
	{
		this.paddedLeadId = paddedLeadId;
	}

	public Short getLifecycleState()
	{
		return lifecycleState;
	}

	public void setLifecycleState(Short lifecycleState)
	{
		this.lifecycleState = lifecycleState;
	}

}
