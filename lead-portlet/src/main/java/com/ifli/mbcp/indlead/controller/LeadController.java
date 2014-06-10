package com.ifli.mbcp.indlead.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.lang3.StringUtils;
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
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.ifli.mbcp.domain.BDMCode;
import com.ifli.mbcp.domain.BMRMCode;
import com.ifli.mbcp.domain.BranchCode;
import com.ifli.mbcp.domain.Channel;
import com.ifli.mbcp.domain.City;
import com.ifli.mbcp.domain.CustomerAddress;
import com.ifli.mbcp.domain.IndividualProposal;
import com.ifli.mbcp.domain.InsurancePlan;
import com.ifli.mbcp.domain.KindOfLead;
import com.ifli.mbcp.domain.Lead;
import com.ifli.mbcp.domain.LeadCategory;
import com.ifli.mbcp.domain.LeadGeneratorCode;
import com.ifli.mbcp.domain.LeadStatus;
import com.ifli.mbcp.domain.LeadType;
import com.ifli.mbcp.domain.PremiumFrequency;
import com.ifli.mbcp.domain.Proposal;
import com.ifli.mbcp.domain.Salutation;
import com.ifli.mbcp.domain.State;
import com.ifli.mbcp.domain.TaskType;
import com.ifli.mbcp.editors.DateEditor;
import com.ifli.mbcp.service.LeadService;
import com.ifli.mbcp.util.MBCPConstants;
import com.ifli.mbcp.util.MBCPConstants.Lifecycle;
import com.ifli.mbcp.util.Views;
import com.ifli.mbcp.util.WebUtil;
import com.ifli.mbcp.vo.LeadVO;

@Transactional
@Controller("leadController")
@RequestMapping(value = "VIEW")
public class LeadController
{

	private static final Logger	logger	= LoggerFactory.getLogger(LeadController.class);


	@Autowired
	@Qualifier("leadFormValidator")
	private Validator			leadFormValidator;

	@Autowired
	@Qualifier("leadService")
	private LeadService			leadService;

	@Autowired
	@Qualifier("leadDozerMapper")
	private DozerBeanMapper	leadDozerMapper;



	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		binder.registerCustomEditor(Date.class, new DateEditor(new SimpleDateFormat(MBCPConstants.LEAD_DATE_FORMAT)));
	}

	@RenderMapping
	public String showLeadForm(@RequestParam(required = false) Long selectedLeadId, Model model, RenderRequest renderRequest, RenderResponse renderResponse)
	{
		String view = Views.LEAD_CREATE_FORM_PAGE;
		Map<String, String> paramMap = WebUtil.getPageParamMap(renderRequest);
		String type = paramMap.get("type");
		if (StringUtils.equalsIgnoreCase("search", type))
		{
			if(selectedLeadId != null){
				view = selectedLead(selectedLeadId, model, renderRequest, renderResponse);
			}else{
				view = Views.LEAD_EMPTY;
			}
		}
		return view;
	}

	@ModelAttribute("leadModelBean")
	public LeadVO getCommandObject()
	{
		LeadVO leadModelBean = new LeadVO();
		
		return leadModelBean;
	}

	@ModelAttribute
	public Model getModelObjects(Model model) throws Exception
	{

		model.addAttribute("leadSalutationList", leadService.getAll(Salutation.class));

		model.addAttribute("leadStatusList", leadService.getAll(LeadStatus.class));

		model.addAttribute("channelSelectionList", leadService.getAll(Channel.class));

		model.addAttribute("insuranceProductList", leadService.getAll(InsurancePlan.class));

		model.addAttribute("premiumFrequencyList", leadService.getAll(PremiumFrequency.class));

		model.addAttribute("leadCategoryList", leadService.getAll(LeadCategory.class));

		model.addAttribute("leadTypeList", leadService.getAll(LeadType.class));

		model.addAttribute("stateList", leadService.getAll(State.class));

		model.addAttribute("cityList", leadService.getAll(City.class));

		model.addAttribute("taskTypeList", leadService.getAll(TaskType.class));

		return model;
	}

	@ActionMapping(params = "action=createLead")
	public void createLead(@ModelAttribute("leadModelBean") LeadVO leadModelBean, BindingResult bindingResult,
			ActionRequest actionRequest, ActionResponse actionResponse, SessionStatus sessionStatus)
	{

		logger.info("Request received to create the Lead...");
		leadFormValidator.validate(leadModelBean, bindingResult);

		if (!bindingResult.hasErrors())
		{
			try
			{
				logger.info("Lead successfully validated...");
				Lead lead = populateLeadModelBean(leadModelBean, actionRequest);
				createProposal(leadModelBean, lead);
				lead.setKindOfLead(leadService.getUniqueEntityByProperty(KindOfLead.class, "name", KindOfLead.INDIVIDUAL));
				lead.setLifecycleState(Lifecycle.CREATED.getValue());
				Long leadId = leadService.addLead(lead);
				leadModelBean.setLeadId(leadId);
				leadModelBean.setPaddedLeadId(lead.getPaddedLeadId());

				if (leadModelBean.getAssignApplicationNumber())
				{

					IndividualProposal proposal = (IndividualProposal) lead.getProposalsMade().iterator().next();
					IndividualProposal proposalVO = (IndividualProposal)leadModelBean.getProposalsMade().get(0);
					proposalVO.setPaddedProposalId(proposal.getPaddedProposalId());

				}
				leadModelBean.setSuccess(true);

			}
			catch (Exception e)
			{
				e.printStackTrace();
				leadModelBean.setSuccess(false);
			}

		}
		else
		{
			leadModelBean.setSuccess(false);
		}
	}

	private void createProposal(LeadVO leadModelBean, Lead lead)
	{

		if (leadModelBean.getAssignApplicationNumber())
		{
			Set<IndividualProposal> proposals = WebUtil.copyProperties(leadDozerMapper, leadModelBean.getProposalsMade(), new TreeSet<IndividualProposal>());
			lead.setProposalsMade((Set<Proposal>)((Object)proposals));
		}

	}

	@RenderMapping(params = "render=updateLeadForm")
	public String renderUpdateLeadForm(Model model, RenderRequest request, RenderResponse response)
	{
		return Views.LEAD_UPDATE_FORM_PAGE;

	}

	@RenderMapping(params = "action=selectedLead")
	public String selectedLead(@RequestParam(required = false) Long selectedLeadId, Model model, RenderRequest request, RenderResponse response)
	{
		try
		{
			Lead lead = leadService.getLeadByID(selectedLeadId);
			LeadVO leadModelBean = WebUtil.copyProperties(leadDozerMapper, lead, new LeadVO(), "getUpdateLead");
			model.addAttribute("leadModelBean", leadModelBean);
		}
		catch (Exception e)
		{
			model.addAttribute("message", "Error while fetching Lead Details");
			e.printStackTrace();
		}
		//response.setRenderParameter("render", "updateLeadForm");
		return Views.LEAD_UPDATE_FORM_PAGE;
	}

	@ActionMapping(params = "action=updateLead")
	public void updateLead(@ModelAttribute("leadModelBean") LeadVO leadModelBean, BindingResult bindingResult, Model model,
			ActionRequest request, ActionResponse response)
	{
		try
		{
			leadFormValidator.validate(leadModelBean, bindingResult);
			if (!bindingResult.hasErrors())
			{
				Lead lead = leadService.getLeadByID(leadModelBean.getLeadId());
				updateLookups(leadModelBean, lead);
				WebUtil.copyProperties(leadDozerMapper, leadModelBean, lead, "updateLead");

				// TODO - check how to maintain lifecycle of lead

				if(Lifecycle.CREATED.getValue() == lead.getLifecycleState())
				{
					lead.setLifecycleState(Lifecycle.PENDING_NA.getValue());
				}

				leadService.mergeLead(lead);
				leadModelBean.setCreatedDate(lead.getCreatedDate());
				leadModelBean.setModifiedDate(lead.getModifiedDate());
				leadModelBean.setPaddedLeadId(lead.getPaddedLeadId());

				if (leadModelBean.getAssignApplicationNumber())
				{
					IndividualProposal proposal = (IndividualProposal) lead.getProposalsMade().iterator().next();
					IndividualProposal proposalVO = (IndividualProposal)leadModelBean.getProposalsMade().get(0);
					proposalVO.setPaddedProposalId(proposal.getPaddedProposalId());
				}
				leadModelBean.setSuccess(true);
			}
			else
			{
				leadModelBean.setSuccess(false);
			}
		}
		catch (Exception e)
		{
			leadModelBean.setSuccess(false);
			e.printStackTrace();
		}

		response.setRenderParameter("render", "updateLeadForm");

	}

	private void updateLookups(LeadVO leadModelBean, Lead lead) throws Exception
	{
		BDMCode bdmCode = leadService.getUniqueEntityByProperty(BDMCode.class, "id", leadModelBean.getBdmCode().getId());
		lead.setBdmCode(bdmCode);

		BMRMCode bmrmCode = leadService.getUniqueEntityByProperty(BMRMCode.class, "id", leadModelBean.getBmRmCode().getId());
		lead.setBmRmCode(bmrmCode);

		BranchCode branchCode = leadService.getUniqueEntityByProperty(BranchCode.class, "id", leadModelBean.getBranchCode()
				.getId());
		lead.setBranchCode(branchCode);

		LeadGeneratorCode lgCode = leadService.getUniqueEntityByProperty(LeadGeneratorCode.class, "id", leadModelBean
				.getLeadGeneratorCode().getId());
		lead.setLeadGeneratorCode(lgCode);

		LeadCategory lcCode = leadService.getUniqueEntityByProperty(LeadCategory.class, "id", leadModelBean.getLeadCategory()
				.getId());
		lead.setLeadCategory(lcCode);

		Channel channel = leadService.getUniqueEntityByProperty(Channel.class, "id", leadModelBean.getChannelSelection().getId());
		lead.setChannelSelection(channel);

		Salutation salutation = leadService.getUniqueEntityByProperty(Salutation.class, "salutationId", leadModelBean
				.getLeadCustomerDetails().getSalutation().getSalutationId());
		lead.getLeadCustomerDetails().setSalutation(salutation);

		LeadType leadType = leadService.getUniqueEntityByProperty(LeadType.class, "id", leadModelBean.getLeadType().getId());
		lead.setLeadType(leadType);

		LeadStatus leadStatus = leadService.getUniqueEntityByProperty(LeadStatus.class, "id", leadModelBean.getLeadStatus()
				.getId());
		lead.setLeadStatus(leadStatus);

		CustomerAddress addr = lead.getLeadCustomerDetails().getCustomerAddress().iterator().next();
		CustomerAddress addrVO = leadModelBean.getLeadCustomerDetails().getCustomerAddress().iterator().next();

		State State = leadService.getUniqueEntityByProperty(State.class, "stateId", addrVO.getState().getStateId());
		addr.setState(State);

		City City = leadService.getUniqueEntityByProperty(City.class, "cityId", addrVO.getCity().getCityId());
		addr.setCity(City);

		TaskType taskType = leadService.getUniqueEntityByProperty(TaskType.class, "id", leadModelBean.getTaskType().getId());
		lead.setTaskType(taskType);

		createOrUpdateProposal(leadModelBean, lead);

	}

	private void createOrUpdateProposal(LeadVO leadModelBean, Lead lead) throws Exception
	{

		if (leadModelBean.getAssignApplicationNumber())
		{

			// Creating proposal for the first time, this is during updateLead
			if (lead.getProposalsMade() == null || lead.getProposalsMade().isEmpty())
			{

				Set<Proposal> proposals = WebUtil.copyProperties(leadDozerMapper, leadModelBean.getProposalsMade(), new TreeSet<Proposal>());
				lead.setProposalsMade(proposals);

			}
			// A proposal already exists so don't create new Set, rather get the
			// updated data from DB for lookup fields and update the non-lookup fields directly
			else
			{

				IndividualProposal proposalVO = (IndividualProposal) leadModelBean.getProposalsMade().iterator().next();

				IndividualProposal p = (IndividualProposal) lead.getProposalsMade().iterator().next();

				InsurancePlan insurancePlan = leadService.getUniqueEntityByProperty(InsurancePlan.class, "id", proposalVO
						.getInsuranceProduct().getId());
				p.setInsuranceProduct(insurancePlan);

				PremiumFrequency premiumFrequency = leadService.getUniqueEntityByProperty(PremiumFrequency.class, "id",
						proposalVO.getPremiumFrequency().getId());
				p.setPremiumFrequency(premiumFrequency);
			}

		}
	}

	@ResourceMapping("addUser")
	private Lead populateLeadModelBean(LeadVO leadModelBean, ActionRequest actionRequest) throws Exception
	{
		Lead lead = WebUtil.copyProperties(leadDozerMapper, leadModelBean, new Lead(), "createLead");
		return lead;
	}
}
