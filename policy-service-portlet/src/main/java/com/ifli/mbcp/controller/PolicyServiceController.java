package com.ifli.mbcp.controller;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.ifli.mbcp.validator.ServiceRequestValidator;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

@Controller("policyServiceController")
@RequestMapping(value = "VIEW")
public class PolicyServiceController
{
	private static final Logger		logger	= LoggerFactory.getLogger(PolicyServiceController.class);
	
	@Autowired
	ServiceRequestValidator serviceRequestValidator;
	
	/**
	 * Default render method for this portlet. This will render add service request form
	 * 
	 * @param request
	 * @param renderResponse
	 * @return
	 */
	@RenderMapping
	public String render(RenderRequest request, RenderResponse renderResponse)
	{
		return "add_service_request";
	}

	/**
	 * This method is used to create policy service request for user.
	 * 
	 * @param actionRequest
	 *            - portlet request
	 * @param actionResponse
	 *            -portlet response
	 * @param sessionStatus
	 *            - ???
	 * @throws Exception
	 */
	@ActionMapping(params = "action=addServiceRequest")
	public void addServiceRequest(ActionRequest request, ActionResponse response) throws Exception
	{
		String typeOfService = ParamUtil.getString(request, "typeOfService");
		String comments = ParamUtil.getString(request, "comments");

		if (Validator.isNotNull(comments) && Validator.isNotNull(typeOfService))
		{
			SessionMessages.add(request, "got-parameters");
		}
		else
		{
			SessionErrors.add(request, "error-getting-parameters");
		}
	}
}