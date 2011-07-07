/*
 * %W% %E%
 *
 * Copyright (c) 2011 Uli Fuchs <ufuchs@gmx.com>
 * All rights reserved.
 * Released under the terms of the GNU GPL v2.0.
 */

package de.z35.commons.event;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: fuchs
 * Date: 07.06.11
 * Time: 21:33
 * To change this template use File | Settings | File Templates.
 */
public class Utils {

	public static String DATE_FORMAT = "yyyy-MM-dd";

	/**
	 *
	 * @param date Expects 'yyyy-MM-dd'
	 * @return
	 * @throws ParseException
	 */
	public static Calendar dateToCalendar(final String date) {

		// Protection
		assert date != null : "'date' can't be null";
		assert date.length() != 0 : "'date' can't be empty";
		
		Calendar cal = Calendar.getInstance(); 

		try {
			cal.setTime((Date)new SimpleDateFormat(DATE_FORMAT).parse(date));
		} catch (ParseException e) {
			// If failed return a so called null object. Uninitialised.
		}

		return cal;
	}

}
