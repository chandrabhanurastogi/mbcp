package com.ifli.mbcp.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_group_proposal")
@PrimaryKeyJoinColumn(name = "proposalId")
public class GroupProposal extends Proposal implements Serializable
{
	private static final long			serialVersionUID	= -2292065844496015845L;
	private Set<DynamicNumeric>			allNumericFields;
	private Set<DynamicDate>			allDateFields;
	private Set<DynamicTextSmall>		allSmallTextFields;
	private Set<DynamicTextNormal>		allNormalTextFields;
	private Set<DynamicTextLarge>		allLargeTextFields;
	private Set<DynamicTextGargantuan>	allGargantuanTextFields;
	private Set<DynamicLookup>			allLookupFields;

    public GroupProposal(){
		
	}
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "proposalId")
	public Set<DynamicNumeric> getAllNumericFields()
	{
		return allNumericFields;
	}

	public void setAllNumericFields(Set<DynamicNumeric> allNumericFields)
	{
		this.allNumericFields = allNumericFields;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "proposalId")
	public Set<DynamicDate> getAllDateFields()
	{
		return allDateFields;
	}

	public void setAllDateFields(Set<DynamicDate> allDateFields)
	{
		this.allDateFields = allDateFields;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "proposalId")
	public Set<DynamicTextSmall> getAllSmallTextFields()
	{
		return allSmallTextFields;
	}

	public void setAllSmallTextFields(Set<DynamicTextSmall> allSmallTextFields)
	{
		this.allSmallTextFields = allSmallTextFields;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "proposalId")
	public Set<DynamicTextNormal> getAllNormalTextFields()
	{
		return allNormalTextFields;
	}

	public void setAllNormalTextFields(Set<DynamicTextNormal> allNormalTextFields)
	{
		this.allNormalTextFields = allNormalTextFields;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "proposalId")
	public Set<DynamicTextLarge> getAllLargeTextFields()
	{
		return allLargeTextFields;
	}

	public void setAllLargeTextFields(Set<DynamicTextLarge> allLargeTextFields)
	{
		this.allLargeTextFields = allLargeTextFields;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "proposalId")
	public Set<DynamicTextGargantuan> getAllGargantuanTextFields()
	{
		return allGargantuanTextFields;
	}

	public void setAllGargantuanTextFields(Set<DynamicTextGargantuan> allGargantuanTextFields)
	{
		this.allGargantuanTextFields = allGargantuanTextFields;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "proposalId")
	public Set<DynamicLookup> getAllLookupFields()
	{
		return allLookupFields;
	}

	public void setAllLookupFields(Set<DynamicLookup> allLookupFields)
	{
		this.allLookupFields = allLookupFields;
	}
}
