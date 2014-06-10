package com.ifli.mbcp.util;

import java.util.Calendar;
import java.util.Date;

public class MBCPUtil
{
	public static Date getLeadingDate(Date date){

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.AM_PM, Calendar.AM);
		return cal.getTime();
	}


	public static Date getTrailingDate(Date date){

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR,11);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.AM_PM, Calendar.PM);
		return cal.getTime();
	}

}
