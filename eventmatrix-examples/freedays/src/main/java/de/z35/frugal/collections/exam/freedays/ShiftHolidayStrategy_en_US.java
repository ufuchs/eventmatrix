/*
 * Copyright (c) 2011 Uli Fuchs <ufuchs@gmx.com>
 * Released under the terms of the GNU GPL v2.0.
 */

package de.z35.frugal.collections.exam.freedays;

import java.util.Calendar;

/**
 * Created by IntelliJ IDEA.
 * User: ufuchs
 * Date: 21/07/11
 * Time: 22:00
 * To change this template use File | Settings | File Templates.
 */
public class ShiftHolidayStrategy_en_US implements ShiftHolidayStrategy {

	private static String FRIDAY = "Friday";
	private static String MONDAY = "Monday";

	/**
	 * Creates an extra holiday closest to the next weekday.
	 *
	 * @param originData The <code>date</code> of the originally holiday.
	 * @param originName The <code>name</code> of the originally holiday.
	 * @param shiftUp If <code>true</code> shifts plus one day otherwise minus
	 * 					one day.
	 * @return An extra holiday on Friday or on Monday.
	 */
	private Holiday createShifted(Calendar originData, String originName,
								  boolean shiftUp) {

		String name = String.format("%s : Shifted to %s", originName,
				((shiftUp) ? MONDAY : FRIDAY));

		Calendar date = (Calendar) originData.clone();

		date.roll(Calendar.DATE, shiftUp);

		return Holiday.createHoliday(date, name);

	}

	/**
	 * If a holiday falls on a weekend, an extra day close to the nearest
	 * weekday will be created.
	 *
	 * @param origin The originally holiday
	 * @return A new holiday if <code>origin</code> falls on a weekend otherwise
	 * 			null
	 */
	@Override
	public Holiday shiftHoliday(Holiday origin) {

		if (!origin.isOnWeekEnd()) {
			return null;
		}

		Calendar date = origin.getDate();

		String name = origin.getName();

		boolean shiftUp = date.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY;

		return createShifted(date, name, shiftUp);

	}

}
