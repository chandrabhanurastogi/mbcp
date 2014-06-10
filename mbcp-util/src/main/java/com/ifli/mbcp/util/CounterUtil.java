package com.ifli.mbcp.util;

/**
 * @author sureshkumar
 *
 */
public class CounterUtil {

	public static String zeroPad(long number, int width) {
		long wrapAt = (long) Math.pow(10, width);
		return String.valueOf(number % wrapAt + wrapAt).substring(1);
	}

}
