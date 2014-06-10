package com.ifli.mbcp.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_lookup_plan_type")
public class PlanType extends GenericLookup implements Serializable
{
	private Set<InsurancePlan>	insurancePlan;

	@Override
	@Id
	@Column(name = "planTypeId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId()
	{
		return super.getId();
	}

	@Override
	@Column(name = "planTypeName", length = 20, nullable = false)
	public String getName()
	{
		return super.getName();
	}

	@Override
	@Column(name = "planTypeDescription", length = 30, nullable = true)
	public String getDescription()
	{
		return super.getDescription();
	}

	//Confirm if this is the sole owner or not, in order to choose between
	//@JoinTable vs @JoinColumn.
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "planTypeId")
	public Set<InsurancePlan> getInsurancePlan()
	{
		return insurancePlan;
	}

	public void setInsurancePlan(Set<InsurancePlan> insurancePlan)
	{
		this.insurancePlan = insurancePlan;
	}

	private static final long	serialVersionUID	= -9151461232548558789L;

}
