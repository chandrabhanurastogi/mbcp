package com.ifli.mbcp.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.ifli.mbcp.dao.LeadDAO;
import com.ifli.mbcp.domain.AddressType;
import com.ifli.mbcp.domain.BDMCode;
import com.ifli.mbcp.domain.BMRMCode;
import com.ifli.mbcp.domain.BranchCode;
import com.ifli.mbcp.domain.Channel;
import com.ifli.mbcp.domain.City;
import com.ifli.mbcp.domain.CustomerAddress;
import com.ifli.mbcp.domain.CustomerDetails;
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
import com.ifli.mbcp.service.impl.LeadServiceImpl;
import com.ifli.mbcp.util.MBCPConstants;

/**
 * 
 * @author Niranjan
 * 
 */
public class LeadServiceTest extends BaseMBCPTest
{
	/**
	 * @Mock Annotation will mock the instance of the given type (LeadDAOImpl in
	 *       our case) name = "leadDAO" here indicates the property name, which
	 *       is good to have as we are using property injection <a href=
	 *       "http://ahlearns.wordpress.com/2012/03/02/spring-3-autowired-unit-tests-with-mockito/"
	 *       >Reference </a>
	 */
	@Mock(name = "leadDAO")
	private LeadDAO				leadDAO;

	/**
	 * @InjectMock will inject all the @Mock annotated fields in this class to
	 *             the corresponding instance, LeadServiceImpl in our case
	 */
	@InjectMocks
	private LeadService			leadService	= new LeadServiceImpl();

	/*
	 * Test case specific fields
	 */
	private Lead				lead;
	private CustomerDetails		custDetails;
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

	@Before
	public void init()
	{
		populateLead();
		/*
		 * Define the Mock behavior for all the methods which are expected to be
		 * invoked by Injected Mock i.e, LeadDAO in our case
		 */
		doReturn(1l).when(leadDAO).save(lead);
		doNothing().doThrow(new RuntimeException()).when(leadDAO).saveOrUpdate(lead);
		doNothing().doThrow(new RuntimeException()).when(leadDAO).update(lead);
		// This is one more flavor for mocking method behavior
		when(leadDAO.findById(Lead.class, (long) 1)).thenReturn(lead);
	}

	/**
	 * A Lead instance is available with all the mandatory fields pre-populated,
	 * which can be saved directly using the service, before execution of every
	 * test method
	 */

	public void populateLead()
	{
		lead = new Lead();

		custDetails = new CustomerDetails();

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

		Set<CustomerAddress> customerAddresses = new TreeSet<CustomerAddress>();
		customerAddresses.add(address);

		custDetails.setCustomerAddress(customerAddresses);

		Set<Proposal> proposals = new TreeSet<Proposal>();

		IndividualProposal p = new IndividualProposal();
		proposals.add(p);

		InsurancePlan plan = new InsurancePlan();
		plan.setId((long) 1);

		PremiumFrequency premiumFrequency = new PremiumFrequency();
		premiumFrequency.setId((long) 1);

		p.setInsuranceProduct(plan);
		p.setPremiumAmount(BigDecimal.valueOf(50000d));
		p.setPremiumFrequency(premiumFrequency);

		lead.setProposalsMade(proposals);

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

		lead.setLeadCustomerDetails(custDetails);
		lead.setBdmCode(bdmCode);
		lead.setBmRmCode(bmrmCode);
		lead.setBranchCode(branchCode);
		lead.setChannelSelection(channel);
		lead.setLeadCategory(leadCategory);
		lead.setLeadGeneratorCode(leadGeneratorCode);
		lead.setLeadStatus(leadStatus);
		lead.setLeadType(leadType);
		lead.setCreatedDate(new Date());
		lead.setModifiedDate(new Date());

	}

	@Test
	public void testAddLead() throws Exception
	{
		printTitle();
		// Just save the available Lead with the default data
		Long leadId = (Long) leadService.addLead(lead);
		assertNotNull("Lead not created", leadId);
		assertEquals(1l, leadId.longValue());
	}

	@Test
	public void testUpdateLead() throws Exception
	{
		printTitle();
		// add Comments
		lead.setComments("Hello, This is Service Unit test");

		// Change the BranchCode
		BranchCode newBranchCode = new BranchCode();
		newBranchCode.setId((long) 2);

		lead.setBranchCode(newBranchCode);

		leadService.updateLead(lead);

		/*
		 * TODO Is this the right way to test void methods? I think so, just
		 * checking whether the service pertaining DAO methods are executed as
		 * many times as required will serve the purpose- Niranjan
		 */
		// verify(leadDAO, times(1)).saveOrUpdate(lead);
		verify(leadDAO, times(1)).update(lead);

	}

	@Test
	public void testGetLeadById() throws Exception
	{
		printTitle();
		Lead l = leadService.getLeadByID(1l);
		assertEquals(l.getLeadCustomerDetails().getFirstName(), "Tom");

	}
}
