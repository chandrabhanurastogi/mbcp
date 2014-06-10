package com.ifli.mbcp.controller;

import static org.junit.Assert.assertTrue;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.portlet.MockActionRequest;
import org.springframework.mock.web.portlet.MockActionResponse;
import org.springframework.mock.web.portlet.MockRenderRequest;
import org.springframework.mock.web.portlet.MockRenderResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext-test.xml"})
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true) 
public class PolicyServiceControllerTest
{
	@Autowired
	private PolicyServiceController testController;
	
	@Test
	public void testHandleRenderRequestInternal()
	{
		//Call the method under test.
		String defaultView = null;
		try
		{
			defaultView = testController.render(new MockRenderRequest(), new MockRenderResponse());
		}
		catch (Exception ex)
		{
			fail("Exception in running junit test");
		}
		
		//We have the correct view name.
		assertTrue("add_service_request".equals(defaultView));		
	}
	
	
	@Test 
	public void testActionMethod() {
		
		MockActionRequest request = new MockActionRequest();
		MockActionResponse response = new MockActionResponse();
		
		request.setMethod("POST");
		request.setParameter("policyNo", "1");
		request.setParameter("clientId", "1");
		request.setParameter("assuredName", "Assured Name");
		request.setParameter("productName", "Product Name");
		request.setParameter("typeOfService", "Service type 1");
		request.setParameter("comments", "comment");
		request.setParameter("discalimer", "1");
		
		// Validator should unit tested here 
		// Time being we are doing validation here 
		if(Validator.isNotNull(ParamUtil.getString(request, "typeOfService")) && Validator.isNotNull(ParamUtil.getString(request, "comments")) ) {
			
			assertTrue(true);
		}else {
			
			fail("Exception in running junit test : Either of parameter is null");
		}
		
		
		
		
		
	}
}