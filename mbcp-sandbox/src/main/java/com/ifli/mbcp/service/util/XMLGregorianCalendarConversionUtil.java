package com.ifli.mbcp.service.util;

import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * A utility class for converting objects between java.util.Date and
 * XMLGregorianCalendar types
 * 
 */
public class XMLGregorianCalendarConversionUtil {

	// DatatypeFactory creates new javax.xml.datatype Objects that map XML
	// to/from Java Objects.
	private static DatatypeFactory df = null;

	static {
		try {
			df = DatatypeFactory.newInstance();
		} catch (DatatypeConfigurationException e) {
			throw new IllegalStateException(
					"Error while trying to obtain a new instance of DatatypeFactory",e);
		}
	}

	/**
	 * Converts a java.util.Date into an instance of XMLGregorianCalendar
	 * @param date
	 * @return XMLGregorianCalendar
	 */
	public static XMLGregorianCalendar asXMLGregorianCalendar(
			java.util.Date date) {
		if (date == null) {
			return null;
		} else {
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTimeInMillis(date.getTime());
			return df.newXMLGregorianCalendar(gc);
		}
	}

	/**Converts an XMLGregorianCalendar to an instance of java.util.Date
	 *
	 * @param xmlGC
	 * @return
	 */
	public static java.util.Date asDate(XMLGregorianCalendar xmlGC) {
		if (xmlGC == null) {
			return null;
		} else {
			return xmlGC.toGregorianCalendar().getTime();
		}
	}

}
