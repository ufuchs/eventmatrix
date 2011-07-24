/*
 * Copyright (c) 2011 Uli Fuchs <ufuchs@gmx.com>
 * Released under the terms of the GNU GPL v2.0.
 */

package de.z35.frugal.collections.exam.freedays;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * User: fuchs
 * Date: 07.06.11
 * Time: 21:33
 * To change this template use File | Settings | File Templates.
 */
public class DateTimeUtils {

	public static String DATE_FORMAT = "yyyy-MM-dd";
	
	/**
	 *
	 * @param date
	 * @return
	 */
	public static Calendar intToCalendar(final int date) {

		 int yy = date / 10000;
		 int mm = date % 10000;
		 int dd = mm % 100;
		 mm = mm / 100;
		 mm--;

		Calendar result = Calendar.getInstance();

		result.set(yy, mm, dd);

		return result;

	}

	/**
	 *
	 * @param cal
	 * @return
	 */
	public static int calendarToInt(Calendar cal) {

		int yy = cal.get(Calendar.YEAR);
		int mm = cal.get(Calendar.MONTH) + 1;
		int dd = cal.get(Calendar.DATE);

		return yy * 10000 + mm * 100 + dd;

	}

	/**
	 *
	 * @param date Expects 'yyyy-MM-dd'
	 * @return
	 * @throws ParseException
	 */
	public static int dateToInt(String date) throws ParseException {

		assert date != null;

		String[] parts = date.split("-");

		int yy = 0;
		int dd = 0;
		int mm = 0;

		for (int i = 0; i < 3; i++) {

			int part = Integer.parseInt(parts[i]);

			switch (i) {
			case 0 : yy = part;
				break;
			case 1 : mm = part;
				break;
			case 2 : dd = part;
				break;
			}

		}

		return yy * 10000 + mm * 100 + dd;

	}
	

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
	
	/**
	 *
	 */
	public static String calToString(Calendar cal) {

		StringBuilder sb = new StringBuilder();

		int yy = cal.get(Calendar.YEAR);
		int mm = cal.get(Calendar.MONTH) + 1;
		int dd = cal.get(Calendar.DATE);

		String format = String.format("%%0%dd", 2);

		sb.append(yy)
			.append("-")
			.append(String.format(format, mm))
			.append("-")
			.append(String.format(format, dd));

		return sb.toString();
	}
	
	/**
	 *
	 * @param calFrom
	 * @param calTo
	 * @return
	 */
	public static Vector<Integer> getTimeFrame(final Calendar calFrom, final Calendar calTo) {

		assert calFrom != null : "'calFrom' can't be null";
		assert calTo != null : "'calTo' can't be null";

		int from = calendarToInt(calFrom);
		int to = calendarToInt(calTo);

		return getTimeFrame(from, to);

	}

	/**
	 *
	 * @param from
	 * @param to
	 * @return
	 */
	public static Vector<Integer> getTimeFrame(final int from, final int to) {

		// Protection
		assert from != 0 : "'from' can't be 0";
		assert to != 0 : "'to' can't be 0";
		assert from < to : "'from' must be lesser than 'to'.";

		int from_yy = from / 10000;
		int to_yy = to / 10000;

		// get all years into 'timeframe' starting with 'from_yy' to 'to_yy'
		Vector<Integer> timeFrame = new Vector<Integer>();
		for (int i = 0; from_yy + i <= to_yy; i++) {
			timeFrame.add(from_yy + i);
		}

		return timeFrame;

	}
	

}
