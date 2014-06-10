package com.ifli.mbcp.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Represents a service request raised for a specific policy.
 * 
 * @author FL867
 * 
 */
@Entity
@Table(name = "tbl_service_requests")
public class ServiceRequest
{
	private Long				mbcpServiceRequestId;
	private String				serviceComments;
	private ServiceType			serviceType;
	private Set<MBCPDocument>	serviceDocuments;
	private String				customerSignature;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getMbcpServiceRequestId()
	{
		return mbcpServiceRequestId;
	}

	public void setMbcpServiceRequestId(Long mbcpServiceRequestId)
	{
		this.mbcpServiceRequestId = mbcpServiceRequestId;
	}

	@Column(length = 500, nullable = false)
	public String getServiceComments()
	{
		return serviceComments;
	}

	public void setServiceComments(String serviceComments)
	{
		this.serviceComments = serviceComments;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "serviceTypeId", nullable = false)
	public ServiceType getServiceType()
	{
		return serviceType;
	}

	public void setServiceType(ServiceType serviceType)
	{
		this.serviceType = serviceType;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tbl_mapping_servicerequest_documents", joinColumns = { @JoinColumn(name = "serviceRequestId") }, inverseJoinColumns = { @JoinColumn(name = "documentId") })
	public Set<MBCPDocument> getServiceDocuments()
	{
		return serviceDocuments;
	}

	public void setServiceDocuments(Set<MBCPDocument> serviceDocuments)
	{
		this.serviceDocuments = serviceDocuments;
	}

	@Column(nullable = false)
	public String getCustomerSignature()
	{
		return customerSignature;
	}

	public void setCustomerSignature(String customerSignature)
	{
		this.customerSignature = customerSignature;
	}
}
