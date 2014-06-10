package com.ifli.mbcp.search.controller;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;

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
import com.ifli.mbcp.util.MBCPConstants.Lifecycle;
import com.ifli.mbcp.util.MBCPConstants.PageType;
import com.ifli.mbcp.util.MBCPConstants.SearchBy;
import com.ifli.mbcp.util.Views;
import com.ifli.mbcp.util.WebUtil;
import com.ifli.mbcp.vo.LeadVO;
import com.ifli.mbcp.vo.SearchByVO;
import com.ifli.mbcp.vo.SearchCriteriaBean;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletURLFactoryUtil;

@Transactional
@Controller("searchController")
@RequestMapping(value = "VIEW")
public class SearchController
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

	private static final Logger	logger	= LoggerFactory.getLogger(SearchController.class);

	@RenderMapping
	public String showSearch(Model model, RenderRequest renderRequest, RenderResponse renderResponse)
	{
		populateLeadSearchModel(model);
		return Views.SEARCH_PAGE;
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
		// When displaying search results, do we need to keep the leadId intact?
		//coz that will display pre-populated form  beneath the search results, which is not desired.
		actionResponse.setRenderParameter("selectedLeadId", ""); //reset leadId
	}
	

	private String getViewForSearchResults(int pageType)
	{
		String viewName = "lead-searchResults";
		
		if (pageType == PageType.NA)
		{
			viewName = "na-searchResults";
		}
		else if (pageType == PageType.BI)
		{
			viewName = "bi-searchResults";
		}
		else if (pageType == PageType.PROPOSAL)
		{
			viewName = "proposal-searchResults";
		}
		return viewName;
	}

	@RenderMapping(params = "render=searchresults")
	public String showsearchResults(@ModelAttribute("leadSearchBean") SearchCriteriaBean searchCriteria,Model model, RenderResponse renderResponse)
	{
		populateLeadSearchModel(model);
		return Views.SEARCH_RESULT_PAGE;
	}
	
	/**
	 * Action invoked after selecting a Lead in the search results
	 * @param selectedLeadId 
	 * @param lifecycleState the state of the selected Lead
	 * @param pageType the page on which the search is performed
	 * @param model
	 * @param request
	 * @param response
	 */
	@ActionMapping(params = "action=selectedLead")
	public void selectedLead(@RequestParam Long selectedLeadId, @RequestParam short lifecycleState, @RequestParam short pageType,
			Model model, ActionRequest request, ActionResponse response)
	{
		try
		{
			logger.info("Selected Lead Id : " + selectedLeadId);
			// You are on lead Page and selected a Lead with Lifecycle state
			// other than Created. So there should be a page redirection to
			// appropriate portlet
			if (pageType == PageType.LEAD && lifecycleState != Lifecycle.CREATED.getValue())
			{
				ThemeDisplay themeDisplay = WebUtil.getThemeDisplay(request);
				HttpServletRequest httpRequest = WebUtil.getHttpServletRequest(request);
				PortletURL url = null;
				// Need Analysis case
				if (lifecycleState == Lifecycle.PENDING_NA.getValue())
				{
					//build the url for corresponding portlet/page
					url = PortletURLFactoryUtil
							.create(httpRequest, "needanalysisportlet_WAR_needanalysisportlet", LayoutLocalServiceUtil
									.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), false, "/home").getPlid(),
									PortletRequest.RENDER_PHASE);
					url.setParameter("selectedLeadId", selectedLeadId.toString());
					url.setWindowState(WindowState.NORMAL);
				}
				// handle other cases in if/else block 

				response.sendRedirect(url.toString());
			}
			// you gonna stay on the same Page, hence no redirection
			else
			{

				response.setRenderParameter("selectedLeadId", selectedLeadId.toString());
			}

		}
		catch (Exception e)
		{
			model.addAttribute("message", "Error while Page redirection.");
		}
	}

}
