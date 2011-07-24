/*
 * Copyright (c) 2011 Uli Fuchs <ufuchs@gmx.com>
 * Released under the terms of the GNU GPL v2.0.
 */

package de.z35.frugal.collections.exam.freedays;

import de.z35.frugal.collections.Transformer;
import de.z35.frugal.collections.exam.freedays.EasterTideProvider.DayOfTide;
import de.z35.frugal.collections.exam.freedays.EasterTideProvider.EasterTide;

/**
 * 
 * @author ufuchs
 *
 */
public class EasterTideTransformer implements Transformer<DayOfTide, Holiday> {

	/**
	 *
	 * @return
	 */
	private String nameOfDay(EasterTide dayOfTide) {

		String result = null;

		String[] parts = dayOfTide.name().split("_");

		for (String part : parts) {

			String capitalized = part.substring(0,1)
				+ part.substring(1).toLowerCase() + " ";

			if (result == null) {
				result = capitalized;
			} else {
				result += capitalized;
			}

		}

		return result.trim();
	}

	/**
	 *
	 */
	@Override
	public Holiday transform(DayOfTide t) {

		return Holiday.createHoliday(t.getDate(), nameOfDay(t.getDayOfTide()));

	}

}
