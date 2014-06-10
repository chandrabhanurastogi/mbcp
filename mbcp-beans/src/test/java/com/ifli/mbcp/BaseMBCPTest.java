package com.ifli.mbcp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext-test.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public abstract class BaseMBCPTest
{
	protected transient final Log testLog = LogFactory.getLog(getClass());
	private DateFormat sDF = new SimpleDateFormat("hh:MM:ss:SS");
	
	protected void printTitle()
	{
		String callingMethod = new Exception().getStackTrace()[1].getMethodName(); 
		System.out.println(("\n\n******* " + callingMethod + " | " + sDF.format(Calendar.getInstance().getTime())) + " ********\n\n");
	}	
}
