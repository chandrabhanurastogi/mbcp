package com.ifli.mbcp.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.ifli.mbcp.dao.GenericDAO;
import com.ifli.mbcp.domain.Salutation;
import com.ifli.mbcp.service.impl.LookupServiceImpl;

/**
 * 
 * @author Niranjan
 * 
 */
public class LookupServiceTest extends BaseMBCPTest
{
	/**
	 * @see {@link LeadServiceTest#leadDAO }
	 */
	@Mock(name = "genericDAO")
	@SuppressWarnings("rawtypes")
	private GenericDAO				genericDAO;

	/**
	 * @see {@link LeadServiceTest#leadService }
	 */
	@InjectMocks
	private LookupService			lookupService	= new LookupServiceImpl();

	private ArrayList<Salutation>	salutationList;

	/*
	 * Test case specific fields
	 */

	@SuppressWarnings("unchecked")
	@Before
	public void init()
	{
		salutationList = new ArrayList<Salutation>();
		Salutation s = new Salutation();
		s.setSalutationId(1l);
		s.setSalutationText("Mr");
		salutationList.add(s);
		doReturn(salutationList).when(genericDAO).findAll(Salutation.class);
	}

	@Test
	public void testGetAll()
	{
		printTitle();
		try
		{
			List<Salutation> actualSalutationList = lookupService.getAll(Salutation.class);
			assertEquals(salutationList, actualSalutationList);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			fail("Exception while fetching Entities");
		}
	}
}
