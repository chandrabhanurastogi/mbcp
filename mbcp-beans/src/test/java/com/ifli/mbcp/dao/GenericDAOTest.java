package com.ifli.mbcp.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ifli.mbcp.BaseMBCPTest;
import com.ifli.mbcp.domain.AudioVideo;

/**
 * This class is responsible for unit testing all the methods available in
 * GenericDAO.
 * 
 * @author Niranjan
 * 
 */
public class GenericDAOTest extends BaseMBCPTest
{
	@SuppressWarnings("rawtypes")
	@Autowired
	@Qualifier("genericDAO")
	private GenericDAO	genericDAO;

	@Before
	public void init()
	{

	}

	@SuppressWarnings("unchecked")
	@Test
	public void testFindByCriteria()
	{
		printTitle();

		DetachedCriteria c = DetachedCriteria.forClass(AudioVideo.class)
				.createAlias("language", "l")
				.add(Restrictions.eq("l.name", "en_US"))
				.add(Restrictions.eq("urlType", "av"))
				.add(Restrictions.eq("type", 1));
		
		List<AudioVideo> avList = genericDAO.findByCriteria(c);
		assertEquals(1, avList.size());
		
	}

}
