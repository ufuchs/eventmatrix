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

	/**
	 * Calculates the date of an extra holiday closest to the next weekday.
	 *
	 * @param originDate The <code>date</code> of the originally holiday.
	 * @return The date of an extra holiday on Friday or on Monday.
	 */
	private Calendar calculateShiftedToDate(Calendar originDate) {

        boolean shiftUp = originDate.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY;

		Calendar shiftedTo = (Calendar) originDate.clone();

		if ((!shiftUp)
				&& shiftedTo.get(Calendar.MONTH) == Calendar.JANUARY
				&& shiftedTo.get(Calendar.DAY_OF_MONTH) == 1) {

			shiftedTo.roll(Calendar.YEAR, false);
			shiftedTo.roll(Calendar.MONTH, false);
		}

		shiftedTo.roll(Calendar.DAY_OF_MONTH, shiftUp);

		return shiftedTo;

	}

	/**
	 * If a holiday falls on a weekend, the date of an extra day close to the
	 * nearest weekday will be created.
	 *
	 * @param holiday The originally holiday
	 * @return The same holiday with an alternative date in
	 * 			<code>shiftedTo</code>. Null if there isn't a holiday which
	 * 			falls on a weekend.
	 *
	 */
	@Override
	public Holiday shiftHoliday(Holiday holiday) {

		if (!holiday.isOnWeekEnd()) {
			return holiday;
		}

		Calendar shiftedTo = calculateShiftedToDate(holiday.getDate());

		holiday.setShiftedFrom(holiday.getDate());

		holiday.setDate(shiftedTo);

		return holiday;

	}

}
