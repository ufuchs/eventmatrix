/*
 * Copyright (c) 2011 Uli Fuchs <ufuchs@gmx.com>
 * Released under the terms of the GNU GPL v2.0.
 */

package de.z35.frugal.collections.exam.freedays;

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

	/**
	 * Represents the month of the year minus 1.
	 * </br>It's the first number in the sequence 'M11.4.5'
	 * 
	 */
	private int month;

	/**
	 * The number of the occurrence of the target day.
     * </br>It's the second number in the sequence 'M11.4.5'
     * </br>Be aware! It's not related to the week in month.
     * If the target day is a Monday but the month starts a week before on
     * Tuesday then the first occurrence will be in the second week of the
     * month.
	 */
	private int nThOccurenceInMonth;

    /**
     * Represents the day of the week.
     * </br>It's the last number in the sequence 'M11.4.5'
     * </br>It starts with Sunday = 1 and ends with Saturday = 7
     */
	private int targetDay;

	/**
	 *
	 * @param dateTemplate A string like 'M2.3.1'
	 */
	public void setParams(int year, String dateTemplate) {

		this.year = year;

		// drops the leading character 'M'
		String template = dateTemplate.substring(1);

		// splits into single figures, e.g '1.2.0' to {"1","2","0"}
		String[] parts = template.split("\\.");

		// the first digit represents the month of year minus 1
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

        int corr = 0;

		if (this.nThOccurenceInMonth >= 5) {
			corr = 1;
		}

		cal.set(Calendar.MONTH, this.month + corr);

		cal.set(Calendar.DAY_OF_MONTH, 1);

		int firstDayInMonth = cal.get(Calendar.DAY_OF_WEEK);
		
		int weeks = convertOccurenceToWeeks(this.targetDay, firstDayInMonth, 
				this.nThOccurenceInMonth);

		int offset = calcOffset(this.targetDay, firstDayInMonth);

	    cal.add(Calendar.DAY_OF_MONTH, weeks * 7 + offset);

		return DateTimeUtils.calToString(cal);

	}

	/**
	 *
	 * @param targetDay
	 * @param firstDayInMonth
	 * @return
	 */
	private int convertOccurenceToWeeks(int targetDay, int firstDayInMonth, int nThOccurence) {

        if (nThOccurence >= 5) {
            nThOccurence = 0;
        }

       if (targetDay >= firstDayInMonth) {

	       	// If the target day is greater or equal than the number of the day
	       	// the month starts with then subtract one week.
	       	nThOccurence -= 1;

       }

       return nThOccurence;

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
	private int calcOffset(int targetDay, int weekDay) {

		// Sorry, melted down.
		return targetDay - weekDay;

	}

}
