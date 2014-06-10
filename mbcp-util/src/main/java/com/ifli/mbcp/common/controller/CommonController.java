package com.ifli.mbcp.common.controller;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.ifli.mbcp.domain.Lead;
import com.ifli.mbcp.service.LeadService;
import com.ifli.mbcp.util.MBCPConstants.SearchBy;
import com.ifli.mbcp.util.Views;
import com.ifli.mbcp.util.WebUtil;
import com.ifli.mbcp.vo.SearchCriteriaBean;
import com.ifli.mbcp.vo.LeadVO;
import com.ifli.mbcp.vo.SearchByVO;

@Transactional
@Controller("commonController")
@RequestMapping(value = "VIEW")
public class CommonController
{

	@Autowired
	@Qualifier("leadSearchValidator")
	private Validator			leadSearchValidator;

	@Autowired
	@Qualifier("leadService")
	private LeadService			leadService;

	@Autowired
	@Qualifier("leadDozerMapper")
	private DozerBeanMapper		leadDozerMapper;

	private static final Logger	logger	= LoggerFactory.getLogger(CommonController.class);

	@RenderMapping(params = "render=gotoNextPage")
	public String gotoNextPage(@RequestParam Long leadId, Model model, RenderRequest renderRequest, RenderResponse renderResponse)
	{
		logger.info("Fetching default Lead for leadId : " + leadId);
		model.addAttribute("leadId", leadId);
		populateLeadSearchModel(model);
		return Views.LEAD_SEARCH_PAGE;
	}

	public void populateLeadSearchModel(Model model)
	{

		List<SearchByVO> searchByList = new ArrayList<SearchByVO>();
		for (SearchBy searchBy : SearchBy.values())
		{
			searchByList.add(new SearchByVO(searchBy.getValue(), searchBy.getDisplayValue()));

		}
		model.addAttribute("searchByList", searchByList);
		if (!model.containsAttribute("leadSearchBean"))
		{
			model.addAttribute("leadSearchBean", new SearchCriteriaBean());
		}

	}

	@RenderMapping(params = "render=searchresults")
	public String showsearchResults(Model model, RenderResponse renderResponse)
	{
		populateLeadSearchModel(model);
		return Views.LEAD_SEARCH_RESULT_PAGE;
	}

	@ActionMapping(params = "action=searchLead")
	public void searchLead(@ModelAttribute("leadSearchBean") SearchCriteriaBean searchCriteria, BindingResult binder, Model model,
			ActionRequest actionRequest, ActionResponse actionResponse)
	{
		logger.info("Search Text :" + searchCriteria.getSearchText());
		logger.info("Search By : " + searchCriteria.getSearchById());
		leadSearchValidator.validate(searchCriteria, binder);

		if (!binder.hasErrors())
		{
			searchCriteria.setSuccess(true);
			try
			{

				List<Lead> searchResultList = leadService.searchLead(searchCriteria);

				if (searchResultList == null || searchResultList.size() == 0)
				{
					model.addAttribute("message", "No results found");
				}
				else
				{
					List<LeadVO> leadVOList = new ArrayList<LeadVO>(searchResultList.size());

					for (Lead lead : searchResultList)
					{
						LeadVO leadVO = WebUtil.copyProperties(leadDozerMapper, lead, new LeadVO(), "getUpdateLead");
						leadVOList.add(leadVO);
					}
					model.addAttribute("searchResultList", leadVOList);
				}

			}
			catch (Exception e)
			{
				model.addAttribute("message", "Error while searching");
				e.printStackTrace();
			}
		}
		else
		{
			searchCriteria.setSuccess(false);
		}
		actionResponse.setRenderParameter("render", "searchresults");
	}

}
