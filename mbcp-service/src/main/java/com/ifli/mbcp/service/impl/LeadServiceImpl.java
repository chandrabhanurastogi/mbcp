package com.ifli.mbcp.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ifli.mbcp.dao.LeadDAO;
import com.ifli.mbcp.domain.Lead;
import com.ifli.mbcp.service.LeadService;
import com.ifli.mbcp.vo.SearchCriteriaBean;

/**
 * 
 * @author Niranjan
 * @since 6 May 2013
 * @version 1.0
 */
@Service(value = "leadService")
@Transactional
public class LeadServiceImpl extends LookupServiceImpl implements LeadService
{

	private static final Logger	logger	= LoggerFactory.getLogger(LeadServiceImpl.class);

	@Autowired
	@Qualifier("leadDAO")
	private LeadDAO				leadDAO;

	/**
	 * {@inheritDoc}
	 */
	public Long addLead(Lead lead) throws Exception
	{
		logger.debug("Adding lead ");
		Date d = new Date();
		lead.setCreatedDate(d);
		lead.setModifiedDate(d);
		Long leadId = (Long) leadDAO.save(lead);
		return leadId;
	}

	/**
	 * {@inheritDoc}
	 */
	public Lead getLeadByID(Long id) throws Exception
	{
		Lead lead = leadDAO.findById(Lead.class, id);
		return lead;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Lead> searchLead(SearchCriteriaBean searchCriteria) throws Exception
	{
		List<Lead> searchResultList = leadDAO.search(searchCriteria);
		return searchResultList;
	}

	/**
	 * {@inheritDoc}
	 */
	public void updateLead(Lead lead) throws Exception
	{
		Date d = new Date();
		lead.setModifiedDate(d);
		leadDAO.update(lead);
	}

	/**
	 * {@inheritDoc}
	 */
	public void mergeLead(Lead lead) throws Exception
	{
		Date d = new Date();
		lead.setModifiedDate(d);
		leadDAO.merge(lead);
	}
}
