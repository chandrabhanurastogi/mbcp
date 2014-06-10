package com.ifli.mbcp.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(MockitoJUnitRunner.class)
public abstract class BaseMBCPTest
{
	private final Logger	logger	= LoggerFactory.getLogger(getClass());
	private DateFormat sDF = new SimpleDateFormat("hh:MM:ss:SS");
	
	protected void printTitle()
	{
		String callingMethod = new Exception().getStackTrace()[1].getMethodName(); 
		logger.info("*** " + callingMethod + " | " + sDF.format(Calendar.getInstance().getTime()));
	}	
}
