package com.ifli.mbcp.service.remote;

import javax.xml.ws.Holder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This is an service handler class ,the service request will be created <br/>
 * in the external system using the method 'createServiceRequest'.
 * 
 * @author FL703
 * @version 1.0
 * @since 29 April 2013
 *
 */
@Service
public class ServiceRequestWSClient {

	@Autowired
	ServiceSoap createService;

	/**
	 * @param user
	 * @param channel
	 * @param createServiceRequest2
	 * @param attachments
	 * @param createServiceRequestResult
	 * @param errorDetails
	 * @param serviceRequestId
	 */
	public void createServiceRequest(User user, String channel,
			CreateServiceRequest2 createServiceRequest2,
			ArrayOfAttachment attachments,
			Holder<Boolean> createServiceRequestResult,
			Holder<ArrayOfError> errorDetails, Holder<String> serviceRequestId) {
		createService.createServiceRequest(user, channel, createServiceRequest2,
				attachments, createServiceRequestResult, errorDetails,
				serviceRequestId);
	}
}
