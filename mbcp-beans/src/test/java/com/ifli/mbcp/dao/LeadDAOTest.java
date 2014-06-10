package com.ifli.mbcp.dao;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Rollback;

import com.ifli.mbcp.BaseMBCPTest;
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
import com.ifli.mbcp.domain.KindOfLead;
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
import com.ifli.mbcp.util.MBCPConstants;
import com.ifli.mbcp.util.MBCPConstants.PageType;
import com.ifli.mbcp.util.MBCPConstants.SearchBy;
import com.ifli.mbcp.vo.SearchCriteriaBean;

/**
 * This class is responsible for unit testing all the methods available in
 * LeadDAO along with some of the methods available in GenericDAO.<br>
 * As of 23-May-2013 The sample data contains minimum of 2 records for each of
 * the following entities with Ids 1 and 2 respectively, which is available for
 * testing. More sample data can be added in future depending on the methods
 * covered in unit testing.<br>
 * Please refer to @see sample-data.xml in src/test/resources folder for
 * available sample data. <br>
 * <b> Entities with sample data</b>
 * <ul>
 * <li>BMRMCode</li>
 * <li>BDMCode</li>
 * <li>BranchCode</li>
 * <li>Channel</li>
 * <li>CustomerDetails</li>
 * <li>CustomerAddress</li>
 * <li>AddressType</li>
 * <li>State</li>
 * <li>City</li>
 * <li>InsurancePlan</li>
 * <li>Lead</li>
 * <li>LeadGeneratorCode</li>
 * <li>LeadStatus</li>
 * <li>LeadCategory</li>
 * <li>LeadType</li>
 * <li>MaritalStatus</li>
 * <li>PremiumFrequency</li>
 * <li>Salutation</li>
 * <li>PlanType</li>
 * <li>Proposal</li>
 * <li>TaskType</li>
 * <li>Language</li>
 * </ul>
 * 
 * @author Niranjan
 * 
 */
public class LeadDAOTest extends BaseMBCPTest
{
	@Autowired
	@Qualifier("leadDAO")
	private LeadDAO				leadDAO;
	private Lead				testLead;
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
	private SearchCriteriaBean	searchCriteria;

	/**
	 * A Lead instance is available with all the mandatory fields pre-populated,
	 * which can be saved to DB directly, before execution of every test method
	 */

	@Before
	public void init()
	{
		testLead = new Lead();

		custDetails = new CustomerDetails();

		salutation = new Salutation();
		salutation.setSalutationId((long) 1);

		custDetails.setSalutation(salutation);

		custDetails.setFirstName("Chamataka");
		custDetails.setMiddleName("The");
		custDetails.setLastName("Fox");
		custDetails.setGender(MBCPConstants.MALE);
		custDetails.setMobileNumber("1234567890");

		maritalStatus = new MaritalStatus();
		maritalStatus.setId((long) 1);

		custDetails.setMaritalStatus(maritalStatus);

		address = new CustomerAddress();
		address.setAddressLine1("Kalia the Crow Stories");
		address.setAddressLine2("The Jungle");
		address.setAddressLine3("Tinkle");

		AddressType addressType = new AddressType();
		addressType.setId((long) 1);

		address.setAddressType(addressType);

		State state = new State();
		state.setStateId((long) 1);

		address.setState(state);

		City city = new City();
		city.setCityId((long) 1);

		address.setCity(city);

		address.setPinCode("112233");

		Set<CustomerAddress> customerAddresses = new TreeSet<CustomerAddress>();
		customerAddresses.add(address);

		custDetails.setCustomerAddress(customerAddresses);

		Set<Proposal> proposals = new TreeSet<Proposal>();

		IndividualProposal p = new IndividualProposal();

		InsurancePlan plan = new InsurancePlan();
		plan.setId((long) 1);

		PremiumFrequency premiumFrequency = new PremiumFrequency();
		premiumFrequency.setId((long) 1);

		p.setInsuranceProduct(plan);
		p.setPremiumAmount(BigDecimal.valueOf(50000));
		p.setPremiumFrequency(premiumFrequency);

		proposals.add(p);
		testLead.setProposalsMade(proposals);

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

		testLead.setLeadCustomerDetails(custDetails);
		testLead.setBdmCode(bdmCode);
		testLead.setBmRmCode(bmrmCode);
		testLead.setBranchCode(branchCode);
		testLead.setChannelSelection(channel);
		testLead.setLeadCategory(leadCategory);
		testLead.setLeadGeneratorCode(leadGeneratorCode);
		testLead.setLeadStatus(leadStatus);
		testLead.setLeadType(leadType);
		testLead.setCreatedDate(new Date());
		testLead.setModifiedDate(new Date());
		
		//Search Initialization
		searchCriteria = new SearchCriteriaBean();

		//These are default values for testing the search scenarios
		//Override them in respective testmethods to the change the search criteria
		searchCriteria.setPageType(PageType.LEAD);
		searchCriteria.setLeadType(KindOfLead.INDIVIDUAL);
		
	}

	@Test
	@Rollback(true)
	public void testAddLead()
	{
		printTitle();
		Long testID = (Long) leadDAO.save(testLead);
		assertTrue(testID.longValue() > 0);
		System.out.println("\n\n*** " + testID.longValue());

	}

	@Test
	public void testFindById()
	{
		printTitle();
		// Lead with Id 1 already exist in sample data
		Lead testLead = leadDAO.findById(Lead.class, 1L);
		assertNotNull("No Lead found with Id 1", testLead);

		// check indeed if the leadId is 1
		assertTrue("Selected a wrong Lead", testLead.getLeadId() == 1L);
	}

	@Test
	// @Ignore
	public void testSearchByName()
	{
		printTitle();
		String name = "Har";
		
		searchCriteria.setSearchById(SearchBy.FIRST_OR_LAST_NAME.getValue());
		searchCriteria.setSearchText(name);
		
		List<Lead> leadList = leadDAO.search(searchCriteria);
		assertTrue("No records found for the given Name", !leadList.isEmpty());
		Lead testLead = leadList.get(0);
		// check indeed if the Firstname or Lastname startswith what we are
		// expecting
		assertTrue("Name doesn't start with " + name, testLead.getLeadCustomerDetails().getFirstName().startsWith(name)
				|| testLead.getLeadCustomerDetails().getLastName().startsWith(name));
	}

	@Test
	// @Ignore
	public void testSearchByMobileNo()
	{
		printTitle();
		String expected = "9856321457";
		
		searchCriteria.setSearchById(MBCPConstants.SearchBy.MOBILE_NO.getValue());
		searchCriteria.setSearchText(expected);
		
		List<Lead> leadList = leadDAO.search(searchCriteria);
		assertTrue("No records found with the given Mobile Number " + expected, leadList.size() > 0);
		Lead testLead = leadList.get(0);
		// check indeed if the MobileNo is what we are expecting
		assertEquals(expected, testLead.getLeadCustomerDetails().getMobileNumber());
	}

	@Test
	@Rollback(true)
	public void testUpdateLead()
	{
		printTitle();
		// get the created Lead back from DB to update
		Lead newLead = leadDAO.findById(Lead.class, 1l);
		// add Comments
		newLead.setComments("Hello, This is India First Life Insurance");

		// Change the BranchCode
		BranchCode newBranchCode = new BranchCode();
		newBranchCode.setId((long) 2);

		newLead.setBranchCode(newBranchCode);

		// update it
		leadDAO.update(newLead);

		// fetch it back again and compare
		Lead updatedLead = leadDAO.findById(Lead.class, 1l);

		// currently just comparing the branchCode
		assertEquals((long) 2, (long) updatedLead.getBranchCode().getId());
	}

	@Test
	@Rollback(true)
	public void testDeleteLead()
	{
		printTitle();
		leadDAO.deleteById(Lead.class, 1L);
		Lead testLead = leadDAO.findById(Lead.class, 1L);
		assertNull("Lead with Id 1 isn't deleted", testLead);
	}

	@Test
	public void testFindAll()
	{
		printTitle();
		List<Lead> leadList = leadDAO.findAll(Lead.class);
		assertTrue("No records found for Lead", leadList.size() > 0);
	}

	@Test
	public void testSearchByInsuranceProductName()
	{
		printTitle();
		String expected = "Jeevan Suraksha";
		
		searchCriteria.setSearchById(MBCPConstants.SearchBy.PRODUCT.getValue());
		searchCriteria.setSearchText(expected);
		
		List<Lead> leadList = leadDAO.search(searchCriteria);
		assertTrue("No records found for the given Product Name", leadList.size() > 0);
		IndividualProposal iP = (IndividualProposal) leadList.get(0).getProposalsMade().iterator().next();
		String actual = iP.getInsuranceProduct().getName();
		// check indeed if the Product Name in the returned Lead is what we are
		// expecting
		assertEquals(expected, actual);

	}

	/*@Test
	// @Ignore
	public void testSearchLeadByApplicatioNumber()
	{
		printTitle();

		List<Lead> leadList = leadDAO.search(MBCPConstants.SearchBy.APPLICATION_NUMBER.getValue(), "1");
		assertTrue("No records found for the given application Number", leadList.size() > 0);
		String actual = leadList.get(0).getProposalsMade().iterator().next().getPaddedProposalId();
		// Check indeed if the returned Application no. is what we are expecting
		assertEquals("P00000001", actual);
	}
*/
	//@Ignore
	@Test
	public void testSearchLeadByCreateDate()
	{
		printTitle();
		
		String expected = "05/31/2013";
		
		searchCriteria.setSearchById(MBCPConstants.SearchBy.LEAD_CREATED_DATE.getValue());
		searchCriteria.setSearchText(expected);
		
		List<Lead> leadList = leadDAO.search(searchCriteria);
		assertTrue(leadList.size() > 0);
		// Check indeed if the dates are equal by converting the result into
		// string and then comparing
		assertEquals(expected, new SimpleDateFormat("MM/dd/yyyy").format(leadList.get(0).getCreatedDate()));
	}
}
