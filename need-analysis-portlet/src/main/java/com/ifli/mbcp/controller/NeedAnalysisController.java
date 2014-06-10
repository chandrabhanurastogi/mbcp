package com.ifli.mbcp.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.ServletResponse;

import net.sf.jasperreports.engine.JRException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.ifli.mbcp.domain.City;
import com.ifli.mbcp.domain.CustomerAddress;
import com.ifli.mbcp.domain.CustomerDetails;
import com.ifli.mbcp.domain.ExistingInsurance;
import com.ifli.mbcp.domain.InsurancePlan;
import com.ifli.mbcp.domain.Lead;
import com.ifli.mbcp.domain.MaritalStatus;
import com.ifli.mbcp.domain.NeedsAnalysis;
import com.ifli.mbcp.domain.Salutation;
import com.ifli.mbcp.domain.State;
import com.ifli.mbcp.service.IReportsService;
import com.ifli.mbcp.service.LeadService;
import com.ifli.mbcp.util.MBCPConstants;
import com.ifli.mbcp.util.WebUtil;
import com.ifli.mbcp.vo.CustomerDetailsVO;
import com.ifli.mbcp.vo.LeadVO;
import com.ifli.mbcp.vo.NeedsAnalysisVO;
import com.liferay.portal.util.PortalUtil;

/**
 * @author root
 *
 */
@Controller("needAnalysisController")
@RequestMapping(value = "VIEW")
@Transactional
@SessionAttributes({"selectedLeadId_NA"})  //We may put many Lead Ids in Session in BI, Proposal Controllers etc. so adding a namespace(_NA)to avoid any clash
public class NeedAnalysisController
{
	private static final Logger	logger	= LoggerFactory.getLogger(NeedAnalysisController.class);

	@Autowired
	@Qualifier("needAnalysisFormValidator")
	private Validator			needAnalysisFormValidator;

	@Autowired
	@Qualifier("currentAnnualContributionValidator")
	private Validator			currentAnnualContributionValidator;

	@Autowired
	@Qualifier("myNeedsValidator")
	private Validator			myNeedsValidator;

	@Autowired
	@Qualifier("signatureValidator")
	private Validator			signatureValidator;

	@Autowired
	@Qualifier("leadService")
	private LeadService			leadService;

    @Autowired
	@Qualifier("needAnalysisReportsService")
	private IReportsService needAnalysisReportsService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat(MBCPConstants.LEAD_DATE_FORMAT), true);
		binder.registerCustomEditor(Date.class, editor);
	}
	

	/**
	 * This method is default render method. It will redirect to view.jsp, the landing page.
	 * 
	 * @param model
	 * @param renderResponse
	 * @throws Exception 
	 */
	@RenderMapping
	public String render(@RequestParam(value= "selectedLeadId", required = false) Long selectedLeadId, Model model, RenderRequest renderRequest, RenderResponse renderResponse, PortletSession session) throws Exception
	{
		String view = "view";
		logger.info("Inside Default render.............");
		if(selectedLeadId != null){
			session.setAttribute("selectedLeadId_NA", selectedLeadId);
			view = showEditNeedForm(selectedLeadId, model, renderRequest, renderResponse);
		}
		return view;
	}

//	public Long	leadId	= (long) 1;

	/*
	 *  This method is used for Generating  the Need  Analysis Report for a particular lead.
	 */
    @ResourceMapping
	public void handlePDF(@ModelAttribute("selectedLeadId_NA") Long selectedLeadId, ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws FileNotFoundException, IOException, JRException {
    	
    	ServletResponse servletResponse = PortalUtil.getHttpServletResponse(resourceResponse);
	    needAnalysisReportsService.generateNeedAnalysisReport(servletResponse, "PDF", selectedLeadId);
	}	
	
	@RenderMapping(params = "action=history") 
	public ModelAndView renderHistory(RenderRequest renderRequest, RenderResponse renderResponse,
			  			Model model, @ModelAttribute("selectedLeadId_NA") Long selectedLeadId) throws Exception
	{
		if(!model.containsAttribute("leadModelBean"))
		{
			getModelObjects(selectedLeadId, model, renderRequest);
	  //renderRequest.setAttribute("leadModelBean", leadModelBean);
		} 
			return new ModelAndView("history");
	}
	 

	@RenderMapping(params = "action=renderTabs")
	@Transactional
	public String showEditNeedForm(Long selectedLeadId, Model model, RenderRequest renderRequest, RenderResponse renderResponse) throws Exception
	{
		logger.info("-------------->>>>>>>>>> the current set tab is " + renderRequest.getParameter("tabs1"));
		if (!model.containsAttribute("leadModelBean"))
		{
			if (renderRequest.getParameter("tabs1") == null || renderRequest.getParameter("tabs1").equalsIgnoreCase("Home"))
			{
				getModelObjects(selectedLeadId, model, renderRequest);
			}
		}
		if (renderRequest.getParameter("tabs1") != null)
		{
			if (renderRequest.getParameter("tabs1").equalsIgnoreCase("Current Annual Contribution")
					|| renderRequest.getParameter("tabs1").equalsIgnoreCase("My Needs")
					|| renderRequest.getParameter("tabs1").equalsIgnoreCase("Signature"))
			{
				getModelObjects(selectedLeadId, model, renderRequest);
				LeadVO leadModelBean = (LeadVO) renderRequest.getAttribute("leadModelBean");
				setEmptyObj(model, leadModelBean, renderRequest.getParameter("tabs1"));
			}
		}
		return "tabs";
	}
	
	/**
	 * This method sets empty NeedsAnalysis domain object
	 * to model. Each time new need analysis needs to be created.
	 * To avoid sending existing need analysis to the frond
	 * end, this method is setting new need analysis to the
	 * model and sending to front end.
	 */
	private void setEmptyObj(Model model, LeadVO leadModelBean, String tab)
	{
		if (leadModelBean.getNeedsAnalysis().size() != 0)
		{
			List<NeedsAnalysisVO> nAnalysis = new ArrayList<NeedsAnalysisVO>();
			nAnalysis.add(new NeedsAnalysisVO());
			leadModelBean.setNeedsAnalysis(nAnalysis);
			// model.addAttribute("leadModelBean", leadModelBean);
		}

	}

	/**
	 * This method handles the first phase of the needs analysis data entry. At
	 * this point there isn't really data entry for the needs analysis itself
	 * per se; instead we allow the user to be able to tweak certain fields on
	 * the Lead (prospective customer) for whom this needs analysis is going to
	 * be run.
	 * 
	 * @param nAnalysisModelBean
	 *            - the form backing bean
	 * @param bindingResult
	 *            - validation bindings, will be used to transfer validations &
	 *            warnings
	 * @param actionRequest
	 *            - portlet request
	 * @param actionResponse
	 *            -portlet response
	 * @param sessionStatus
	 *            - ???
	 * @throws Exception
	 */
	@ActionMapping(params = "action=setCurrentAnnualContribution")
	public void setCurrentAnnualContribution(@ModelAttribute("leadModelBean") LeadVO leadModelBean, BindingResult bindingResult,
			ActionRequest actionRequest, ActionResponse actionResponse, SessionStatus sessionStatus, @ModelAttribute("selectedLeadId_NA") Long selectedLeadId) throws Exception
	{
		logger.info("inside setCurrentAnnualContribution..........");

		needAnalysisFormValidator.validate(leadModelBean, bindingResult);
		if (!bindingResult.hasErrors())
		{
			try
			{
				Lead lead = leadService.getLeadByID(leadModelBean.getLeadId());

				updateLookups(leadModelBean, lead);

				actionRequest.getPortletSession().setAttribute("lead", lead);
				System.out.println(selectedLeadId);

				// Update the CustomerDetails object with the values entered by
				// the user.
				CustomerDetailsVO cusDtlVO = leadModelBean.getLeadCustomerDetails();
				CustomerDetails cusDtls = lead.getLeadCustomerDetails();

				CustomerAddress custAddr = lead.getLeadCustomerDetails().getCustomerAddress().iterator().next();
				custAddr.setAddressLine1(cusDtlVO.getCustomerAddress().get(0).getAddressLine1());
				custAddr.setAddressLine2(cusDtlVO.getCustomerAddress().get(0).getAddressLine2());
				custAddr.setAddressLine3(cusDtlVO.getCustomerAddress().get(0).getAddressLine3());
				custAddr.setCity(cusDtlVO.getCustomerAddress().get(0).getCity());
				custAddr.setState(cusDtlVO.getCustomerAddress().get(0).getState());
				WebUtil.copyProperties(cusDtlVO, cusDtls);
				lead.setLeadCustomerDetails(cusDtls);
				
				 // Persist the lead object back to the underlying database.
				  leadService.updateLead(lead); 
				 

				// Everything was fine, we will move the user to the next tab to
				// continue with the data entry for the needs analysis.
				actionResponse.setRenderParameter("tabs1", "Current Annual Contribution");
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			logger.info("validation fails ....................");
			actionResponse.setRenderParameter("tabs1", "Home");
		}
		actionResponse.setRenderParameter("action", "renderTabs");
	}

	/**
	 * This method is called when the user has begun the data input process for
	 * creating a Needs Analysis. The form elements submitted in this tab are
	 * set in a new instance of NeedsAnalysis. This instance is then saved into
	 * the portal session and then control is returned to the next tab in the
	 * sequence, which is My Needs.
	 * 
	 * @param nAnalysisModelBean
	 *            - the form backing bean instance
	 * @param bindingResult
	 *            - validation processing
	 * @param actionRequest
	 *            - portlet request
	 * @param actionResponse
	 *            - portlet response
	 * @param sessionStatus
	 *            - ???
	 * @throws Exception
	 */
	@ActionMapping(params = "action=setMyNeeds")
	public void setMyNeeds(@ModelAttribute("leadModelBean") LeadVO leadModelBean, BindingResult bindingResult,
			ActionRequest actionRequest, ActionResponse actionResponse, SessionStatus sessionStatus, Model model)
	{
		logger.info("inside set MyNeeds......................");
		currentAnnualContributionValidator.validate(leadModelBean, bindingResult);
		if (!bindingResult.hasErrors())
		{
			logger.info("Validation pass ...................");
			try
			{
				// First, we will create a new NeedsAnalysis domain object (not
				// Value Object)
				// to hold the fields entered in this tab.
				NeedsAnalysis needsAnalysis = new NeedsAnalysis();
				NeedsAnalysisVO needsAnalysisVO = leadModelBean.getNeedsAnalysis().get(0);
				WebUtil.copyProperties(needsAnalysisVO, needsAnalysis);

				// Once this is done, we will plug this domain object instance
				// into the session,
				// so that it can be updated in the next tab.
				actionRequest.getPortletSession().setAttribute("needsAnalysis", needsAnalysis);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			// Data entry was validated and is successful; we will send the user
			// to do the next tab now.

			actionResponse.setRenderParameter("tabs1", "My Needs");
		}
		else
		{
			logger.info("validation fails in  currentAnnualContributionValidator....................");

			// Data validation failed, we want the user to repeat this tab.
			actionResponse.setRenderParameter("tabs1", "Current Annual Contribution");
		}
		actionResponse.setRenderParameter("action", "renderTabs");
	}

	/**
	 * This method is called when the user has input the data on the My Needs
	 * tab. This method extracts the form elements and updates the values in the
	 * NeedsAnalysis object that is currently in the session. If no Needs
	 * Analysis object is found, the data entry process is reset and the user is
	 * redirected to the first data entry tab.
	 * 
	 * @param nAnalysisModelBean
	 * @param bindingResult
	 * @param actionRequest
	 * @param actionResponse
	 * @param sessionStatus
	 * @throws Exception
	 */
	@ActionMapping(params = "action=setSignature")
	public void setSignatureTab(@ModelAttribute("leadModelBean") LeadVO leadModelBean, BindingResult bindingResult,
			ActionRequest actionRequest, ActionResponse actionResponse, SessionStatus sessionStatus, Model model, @ModelAttribute("selectedLeadId_NA") Long selectedLeadId)
			throws Exception
	{
		String gotoTab = "Signature"; // This is the default tab to which
										// control should go, if processing is
										// successful.

		logger.info("inside setSignature..........");
		myNeedsValidator.validate(leadModelBean, bindingResult);
		if (!bindingResult.hasErrors())
		{
			logger.info("Validation pass ...................");
			try
			{
				// We are now going to add the fields filled out in the My Needs
				// tab into the
				// Needs Analysis domain object.

				// First, we will retrieve the Needs Analysis object that we
				// plugged into the session
				// while processing the submission of the previous tab.
				// That object contains the values entered in the previous tab,
				// and we will add these values
				// to that same domain object.
				NeedsAnalysis nAnalysis = (NeedsAnalysis) actionRequest.getPortletSession().getAttribute("needsAnalysis");

				Lead lead = leadService.getLeadByID(selectedLeadId);

				// If this object is NULL, then it means that the user somehow
				// got here without entering anything in the first
				// data input tab. Kick the user out of here and to that tab, so
				// that he/she can enter the data in the
				// proper order.
				if (nAnalysis == null)
				{
					// Reset the tab to the first tab in the sequence, so that
					// the user gets redirected there.
					gotoTab = "Current Annual Contribution";
				}
				else
				{
					NeedsAnalysisVO needsAnalysisVO = leadModelBean.getNeedsAnalysis().get(0);
					// Plug the values from this request into the existing Needs
					// Analysis bean.
					nAnalysis = WebUtil.copyProperties(needsAnalysisVO, nAnalysis);

					// User is saving existing plans. We will create
					// CustomerDetails domain object to hold the fields
					// entered in this tab and plug this domain object instance
					// in to the session. So that it can be updated in the
					// next tab.
					CustomerDetails cusDtls = lead.getLeadCustomerDetails();
					Set<ExistingInsurance> exInsurSet = cusDtls.getAllExistingInsurance();
					if (exInsurSet.size() == 0)
					{
						exInsurSet = new TreeSet<ExistingInsurance>();
					}
					// ExistingInsurance exInsu = new ExistingInsurance();
					ExistingInsurance exInsu = leadModelBean.getLeadCustomerDetails().getAllExistingInsurance().get(0);
					exInsurSet.add(exInsu);
				
					cusDtls.setAllExistingInsurance(exInsurSet);
					lead.setLeadCustomerDetails(cusDtls);

					// Now we will plug this domain object instance into the
					// session,
					// so that it can be updated in the next (and final) tab.
					actionRequest.getPortletSession().setAttribute("needsAnalysis", nAnalysis);
					// actionRequest.getPortletSession().setAttribute("customerDetais",exInsurnc);

					// nAnalysisModelBean.setSuccess(true);
					// Set the tab to the final tab in the sequence so that the
					// user can
					// finish this data entry.
					gotoTab = "Signature";
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			logger.info("validation fails in myNeedsValidator....................");
			// Set the tab to the same tab that the user just filled in, so that
			// the user can correct the
			// errors in the submitted form data.
			gotoTab = "My Needs";
		}
		// Render the next tab to be viewed by the user.
		actionResponse.setRenderParameter("tabs1", gotoTab);
		//actionRequest.setAttribute("leadModelBean", leadModelBean);
		actionResponse.setRenderParameter("action", "renderTabs");
	}

	/**
	 * This method handles the form submit for the final tab. If validation is
	 * successful, it will add the needs analysis object to the Lead and then
	 * persist the Lead (which will in turn persist the needs analysis as well,
	 * thanks to cascading.)
	 * 
	 * @param nAnalysisModelBean
	 *            - the form backing bean
	 * @param bindingResult
	 *            - validation & error messaging
	 * @param actionRequest
	 *            - portlet request
	 * @param actionResponse
	 *            - portlet response
	 * @param sessionStatus
	 *            - foo
	 */
	@ActionMapping(params = "action=submitSignature")
	public void saveSignatureTab(@ModelAttribute("leadModelBean") LeadVO leadModelBean, BindingResult bindingResult,
			ActionRequest actionRequest, ActionResponse actionResponse, SessionStatus sessionStatus, @ModelAttribute("selectedLeadId_NA") Long selectedLeadId)
	{
		String gotoTab = "Signature"; // This is the default tab to which
										// control should go, if processing is
										// successful.

		logger.info("inside submitSignature..........");
		signatureValidator.validate(leadModelBean, bindingResult);

		if (!bindingResult.hasErrors())
		{
			logger.info("Validation pass ...................");
			// The validation was successful. Now we will go ahead with
			// persisting the needs analysis to the database 
			//by setting it in the owning lead object and then 
			//persisting the lead. This relies on cascading to persist the
			// child attribute when the parent is persisted.
			Lead lead;

			// Get the needs analysis off the portlet session.
			NeedsAnalysis nAnalysis = (NeedsAnalysis) actionRequest.getPortletSession().getAttribute("needsAnalysis");
			// CustomerDetails customerDetais =
			// (CustomerDetails)actionRequest.getPortletSession().getAttribute("customerDetais");
			try
			{
				if (nAnalysis==null || nAnalysis.getDesirableHealthCover() == null)
				{

					logger.info("last tab was not filled");
					// Reset the tab to the My Needs tab, so that
					// the user gets redirected there.
					gotoTab = "My Needs";
				}
				else
				{
					lead = leadService.getLeadByID(selectedLeadId);
					WebUtil.copyProperties(lead, new LeadVO());

					Set<NeedsAnalysis> naSet = lead.getNeedsAnalysis();

					// If this is the first needs analysis for this lead, this
					// set would be null. In that case we would create a new set.
					if (naSet == null)
					{
						naSet = new TreeSet<NeedsAnalysis>();
					}

					// Plug the values from this request into the existing Needs
					// Analysis bean.
					NeedsAnalysisVO needsAnalysisVO = leadModelBean.getNeedsAnalysis().get(0);
					nAnalysis = WebUtil.copyProperties(needsAnalysisVO, nAnalysis);

					// Add the needs analysis object to the set of Needs Analysis
					naSet.add(nAnalysis);

					// Add the updated set back to the Lead
					lead.setNeedsAnalysis(naSet);

					// Persist the lead
					leadService.updateLead(lead);
				}

			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			logger.info("validation fails in signatureValidator....................");
		}
		actionResponse.setRenderParameter("tabs1", gotoTab);
		actionResponse.setRenderParameter("action", "renderTabs");
	}

	@ModelAttribute
	public void getDefaultModelAttributes(Model model) throws Exception
	{
		// To populate List of salutation as drop-down in landing jsp form,
		// first fetch salutation using look-up service and store it in a
		// list

		model.addAttribute("needAnalysisSalutationList", leadService.getAll(Salutation.class));

		// To populate List of Insurance Plan as drop-down in MyNeeds form,
		// first fetch Insurance Plan using look-up service and store it in a
		// list.
		// Add the list of Insurance Product in model to populate the form.
		model.addAttribute("insuranceProductList", leadService.getAll(InsurancePlan.class));

		// To populate List of States as drop-down in landing form,
		// first fetch States using look-up service and store it in a list.
		// Add the list of states in model to populate the form.
		model.addAttribute("stateList", leadService.getAll(State.class));

		// To populate List of cities as drop-down in landing form,
		// first fetch cities using look-up service and store it in a list.
		// Add the list of cities in model to populate the form.
		model.addAttribute("cityList", leadService.getAll(City.class));

		// To populate List of cities as drop-down in landing form,
		// first fetch cities using look-up service and store it in a list.
		// Add the list of cities in model to populate the form.
		model.addAttribute("maritalStatusList", leadService.getAll(MaritalStatus.class));
	}

	private void updateLookups(LeadVO leadModelBean, Lead lead) throws Exception
	{
		Salutation salutation = leadService.getUniqueEntityByProperty(Salutation.class, "salutationId", leadModelBean
				.getLeadCustomerDetails().getSalutation().getSalutationId());
		lead.getLeadCustomerDetails().setSalutation(salutation);
		leadModelBean.getLeadCustomerDetails().setSalutation(salutation);
	}

	public Model getModelObjects(Long leadId, Model model, RenderRequest request)
	{
		Lead lead = null;
		try
		{
			lead = (Lead) leadService.getLeadByID(leadId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		LeadVO leadModelBean = (LeadVO) WebUtil.copyProperties(lead, new LeadVO());
		request.setAttribute("leadModelBean", leadModelBean);

		if (!model.containsAttribute("leadModelBean"))
		{
			model.addAttribute("leadModelBean", leadModelBean);
		}
		return model;
	}
}