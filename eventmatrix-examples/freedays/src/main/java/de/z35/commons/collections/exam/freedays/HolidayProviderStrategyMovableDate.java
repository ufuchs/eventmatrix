/*
 * Copyright (c) 2011 Uli Fuchs <ufuchs@gmx.com>
 * Released under the terms of the GNU GPL v2.0.
 */

package de.z35.commons.collections.exam.freedays;

import java.util.Calendar;

/**
 * Many thanks to Michael Thompson for his inspirations to solve this problem.
 *
 * @see  http://michaelthompson.org/technikos/holidays.php
 *
 * @author ufuchs
 */
public class HolidayProviderStrategyMovableDate implements HolidayProviderStrategy {

	static int MONTH = 0;
	static int OCCURRENCE_IN_MONTH = 1;
	static int DAY_OF_WEEK = 2;

	private int year;

	// params from 'dateTemplate'

	private int month;

	/**
	 * the number of the occurrence of the target day
	 */
	private int nThOccurenceInMonth;

	private int targetDay;

	/**
	 *
	 * @param dateTemplate like 'M2.3.1'
	 * @return
	 */
	public void setParams(int year, String dateTemplate) {

		this.year = year;

		// drops the leading character 'M'
		String template = dateTemplate.substring(1);

		// splits into single figures, e.g '1.2.0' to {"1","2","0"}
		String[] parts = template.split("\\.");

		// the first digit represents the month
		this.month = Integer.parseInt(parts[MONTH]) - 1;

		// the second digit represents the occurrence of the target day
		this.nThOccurenceInMonth = Integer.parseInt(parts[OCCURRENCE_IN_MONTH]);

		// the last digit represents the day of the week.
		// It starts with Sunday = 1 and ends with Saturday = 7
		this.targetDay = Integer.parseInt(parts[DAY_OF_WEEK]);

	}

	/**
	 *
	 */
	@Override
	public String transformTemplate() {

		Calendar cal = Calendar.getInstance();

		cal.set(Calendar.YEAR, this.year);

		cal.set(Calendar.MONTH,  this.month + ((this.nThOccurenceInMonth <= 0) ? 1 : 0));

		cal.set(Calendar.DAY_OF_MONTH, 1);

		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		
		int earliestDay = getEarliestDate(targetDay, dayOfWeek, this.nThOccurenceInMonth);

		int offset = getOffset(targetDay, dayOfWeek);

	    cal.add(Calendar.DAY_OF_MONTH, earliestDay + offset);

		return DateTimeUtils.calToString(cal);

	}

	/**
	 *
	 * @param targetDay
	 * @param weekDay
	 * @return
	 */
	private int getEarliestDate(int targetDay, int weekDay, int nThOccurence) {

       if (targetDay >= weekDay) {

	       	// If the day of week is greater or equal than the number of the day
	       	// the month starts with subtract one week.
	       	nThOccurence -= 1;

       }

       return (7 * nThOccurence);

	}

	/**
	 * [Citation by Michael Thompson ]
	 * "Find the offset between the target weekday and weekday of the earliest
	 *  possible date in the given year"
	 * @see http://michaelthompson.org/technikos/holidays.php
	 *
	 * @param weekDay
	 * @param targetDay
	 * @return
	 */
	private int getOffset(int targetDay, int weekDay) {

		return targetDay - weekDay;

	}

}
