package com.ifli.mbcp.util;

/**
 * This util class is been used for padding zero's before the number.
 * 
 * @author FL703
 * @version 1.0
 * @since 29 April 2013
 * 
 */
public class CounterUtil {

	/**
	 * @param number
	 * @param width
	 * @return String
	 */
	public static String zeroPad(long number, int width) {
		long wrapAt = (long) Math.pow(10, width);
		return String.valueOf(number % wrapAt + wrapAt).substring(1);
	}

	/**
	 * @param str
	 * @return String
	 */
	public static String removeLeadingZeros(String str) {
		if (str == null) {
			return null;
		}
		char[] chars = str.toCharArray();
		int index = 0;
		for (; index < str.length(); index++) {
			if (chars[index] != '0') {
				break;
			}
		}
		return (index == 0) ? str : str.substring(index);
	}

}
