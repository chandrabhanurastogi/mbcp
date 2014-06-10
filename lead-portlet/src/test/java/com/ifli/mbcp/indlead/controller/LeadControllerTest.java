package com.ifli.mbcp.indlead.controller;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.mock.web.portlet.MockActionRequest;
import org.springframework.mock.web.portlet.MockActionResponse;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.support.SimpleSessionStatus;

import com.ifli.mbcp.common.controller.CommonController;
import com.ifli.mbcp.controller.BaseMBCPTest;
import com.ifli.mbcp.domain.AddressType;
import com.ifli.mbcp.domain.BDMCode;
import com.ifli.mbcp.domain.BMRMCode;
import com.ifli.mbcp.domain.BranchCode;
import com.ifli.mbcp.domain.Channel;
import com.ifli.mbcp.domain.City;
import com.ifli.mbcp.domain.CustomerAddress;
import com.ifli.mbcp.domain.IndividualProposal;
import com.ifli.mbcp.domain.InsurancePlan;
import com.ifli.mbcp.domain.Lead;
import com.ifli.mbcp.domain.LeadCategory;
import com.ifli.mbcp.domain.LeadGeneratorCode;
import com.ifli.mbcp.domain.LeadStatus;
import com.ifli.mbcp.domain.LeadType;
import com.ifli.mbcp.domain.MaritalStatus;
import com.ifli.mbcp.domain.PremiumFrequency;
import com.ifli.mbcp.domain.Proposal;	
import com.ifli.mbcp.domain.Salutation;
import com.ifli.mbcp.domain.State;
import com.ifli.mbcp.service.LeadService;
import com.ifli.mbcp.service.LookupService;
import com.ifli.mbcp.util.MBCPConstants;
import com.ifli.mbcp.validator.LeadFormValidator;
import com.ifli.mbcp.vo.CustomerDetailsVO;
import com.ifli.mbcp.vo.LeadVO;

public class LeadControllerTest extends BaseMBCPTest
{

	@Mock(name = "leadService")
	private LeadService			leadService;

	@Mock(name = "lookupService")
	private LookupService		lookupService;

	@InjectMocks
	private LeadFormValidator	leadFormValidator	= new LeadFormValidator();

	@Mock(name = "commonController")
	private CommonController	commonController;

	@InjectMocks
	private LeadController		leadController		= new LeadController();

	/*
	 * Test case specific fields
	 */
	private LeadVO				leadModelBean;
	private CustomerDetailsVO	custDetails;
	private Salutation			salutation;
	private MaritalStatus		maritalStatus;
	private CustomerAddress		address;
	private LeadCategory		leadCategory;
	private LeadType			leadType;
	private LeadStatus			leadStatus;
	private BranchCode			branchCode;
	private BDMCode				bdmCode;
	private BMRMCode			bmrmCode;
	private LeadGeneratorCode	leadGeneratorCode;
	private Channel				channel;

	@SuppressWarnings("unchecked")
	@Before
	public void init() throws Exception
	{
		populateLead();

		List<String> myMappingFiles = new ArrayList<String>();
		myMappingFiles.add("lead-DozerBeanMapping.xml");

		DozerBeanMapper mapper = new DozerBeanMapper();
		mapper.setMappingFiles(myMappingFiles);
		
		ReflectionTestUtils.setField(leadController, "leadFormValidator", leadFormValidator);
		ReflectionTestUtils.setField(leadController, "leadDozerMapper", mapper);
		
		doReturn(1l).when(leadService).addLead(any(Lead.class));
		doReturn(true).when(lookupService).exists(any(Class.class), any(Serializable.class));
	}

	/**
	 * A Lead instance is available with all the mandatory fields pre-populated,
	 * which can be saved directly using the service, before execution of every
	 * test method
	 */

	public void populateLead()
	{
		leadModelBean = new LeadVO();

		custDetails = new CustomerDetailsVO();

		salutation = new Salutation();
		salutation.setSalutationId((long) 1);

		custDetails.setSalutation(salutation);

		custDetails.setFirstName("Tom");
		custDetails.setMiddleName("Dick");
		custDetails.setLastName("Harry");
		custDetails.setGender(MBCPConstants.MALE);
		custDetails.setMobileNumber("9856321457");

		maritalStatus = new MaritalStatus();
		maritalStatus.setId((long) 1);

		custDetails.setMaritalStatus(maritalStatus);

		address = new CustomerAddress();
		address.setAddressLine1("#304, 306");
		address.setAddressLine2("Bhau Patil Road, Pune IT Park");
		address.setAddressLine3("Aundh");

		AddressType addressType = new AddressType();
		addressType.setId((long) 1);

		address.setAddressType(addressType);

		State state = new State();
		state.setStateId((long) 1);

		address.setState(state);

		City city = new City();
		city.setCityId((long) 1);

		address.setCity(city);

		address.setPinCode("506001");

		List<CustomerAddress> customerAddresses = new ArrayList<CustomerAddress>();
		customerAddresses.add(address);

		custDetails.setCustomerAddress(customerAddresses);
		List<IndividualProposal> proposals = new ArrayList<IndividualProposal>();

		IndividualProposal p = new IndividualProposal();
		proposals.add(p);

		InsurancePlan plan = new InsurancePlan();
		plan.setId((long) 1);

		PremiumFrequency premiumFrequency = new PremiumFrequency();
		premiumFrequency.setId((long) 1);

		p.setPaddedProposalId("P00000001");
		p.setInsuranceProduct(plan);
		p.setPremiumAmount(BigDecimal.valueOf(50000d));
		p.setPremiumFrequency(premiumFrequency);

		leadModelBean.setProposalsMade(proposals);

		leadCategory = new LeadCategory();
		leadCategory.setId((long) 1);

		leadType = new LeadType();
		leadType.setId((long) 1);

		leadStatus = new LeadStatus();
		leadStatus.setId((long) 1);

		branchCode = new BranchCode();
		branchCode.setId((long) 1);

		bdmCode = new BDMCode();
		bdmCode.setId((long) 1);

		bmrmCode = new BMRMCode();
		bmrmCode.setId((long) 1);

		leadGeneratorCode = new LeadGeneratorCode();
		leadGeneratorCode.setId((long) 1);

		channel = new Channel();
		channel.setId((long) 1);

		leadModelBean.setLeadCustomerDetails(custDetails);
		leadModelBean.setBdmCode(bdmCode);
		leadModelBean.setBmRmCode(bmrmCode);
		leadModelBean.setBranchCode(branchCode);
		leadModelBean.setChannelSelection(channel);
		leadModelBean.setLeadCategory(leadCategory);
		leadModelBean.setLeadGeneratorCode(leadGeneratorCode);
		leadModelBean.setLeadStatus(leadStatus);
		leadModelBean.setLeadType(leadType);
		leadModelBean.setCreatedDate(new Date());
		leadModelBean.setModifiedDate(new Date());

	}

	@Test
	public void testCreateLead()
	{
		try
		{
			MockActionRequest request = new MockActionRequest();
			MockActionResponse response = new MockActionResponse();

			BindingResult bindingResult = new BeanPropertyBindingResult(leadModelBean, "leadModelBean");
			SessionStatus status = new SimpleSessionStatus();
			leadController.createLead(leadModelBean, bindingResult, request, response, status);
			System.out.println(bindingResult.getAllErrors());
			assertTrue("There are errors", !bindingResult.hasErrors());
			verify(leadService).addLead(any(Lead.class));
		}
		catch (Exception e)
		{
			e.printStackTrace();
			fail("Exception while adding Lead");
		}
	}

	/*
	 * @Test public void testInitBinder() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testShowLeadForm() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testGetCommandObject() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testGetModelObjects() { fail("Not yet implemented"); }
	 */

	/*
	 * @Test public void testRenderUpdateLeadForm() {
	 * fail("Not yet implemented"); }
	 * 
	 * @Test public void testSelectedLead() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testUpdateLead() { fail("Not yet implemented"); }
	 */

}
