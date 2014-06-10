package com.ifli.mbcp.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ifli.mbcp.domain.Lead;
import com.ifli.mbcp.vo.SearchCriteriaBean;

@Component
public interface LeadService extends LookupService
{
	/**
	 * Adds a new Lead
	 * @param lead Lead instance
	 * @return
	 * @throws Exception
	 */
	public Long addLead(Lead lead) throws Exception;

	/**
	 * Returns a Lead instance or null if no Lead exists with the given identifier
	 * @param id Unique identifier of a Lead instance
	 * @return A lead instance if found or null otherwise
	 * @throws Exception
	 */
	public Lead getLeadByID(Long id) throws Exception;

	/**
	 * Returns a List of Leads matching the given search criteria
	 * @param searchCriteria
	 * @return list of Lead instances matching the given search criteria or empty list if results not found or null
	 *         for any unsupported searchBy clause
	 * @throws Exception
	 */
	public List<Lead> searchLead(SearchCriteriaBean searchCriteria) throws Exception;

	/**
	 * Updates the existing Lead with the details of given Lead instance
	 * @param lead
	 * @throws Exception
	 */
	public void updateLead(Lead lead) throws Exception;

	/**
	 * Merges the changes in the give Lead with the existing Lead
	 * @param lead
	 * @throws Exception
	 */
	public void mergeLead(Lead lead) throws Exception;
}
