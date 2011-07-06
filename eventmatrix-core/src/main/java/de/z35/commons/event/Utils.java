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

public class Utils {

	public static String DATE_FORMAT = "yyyy-MM-dd";

	/**
	 *
	 * @param date Expects 'yyyy-MM-dd'
	 * @return
	 * @throws ParseException
	 */
	public static Calendar dateToCalendar(String date) throws ParseException {

		Calendar cal =Calendar.getInstance();
		cal.setTime((Date)new SimpleDateFormat(DATE_FORMAT).parse(date));

		return cal;
	}

}
