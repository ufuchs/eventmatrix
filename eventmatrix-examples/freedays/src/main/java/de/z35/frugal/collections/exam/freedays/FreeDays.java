/*
 * Copyright (c) 2011 Uli Fuchs <ufuchs@gmx.com>
 * Released under the terms of the GNU GPL v2.0.
 */

package de.z35.frugal.collections.exam.freedays;

import java.util.Vector;

import de.z35.frugal.cli.CliOptionService;

public class FreeDays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		CliOptionService cos = new CliOptionService()
				.withArgs(args)
				.withOptions(FreeDayCliOption.OPTIONS_DESC);

		
		HolidayProvider provider = new HolidayProvider(null);

		Vector<Holiday> holidays = provider.getHolidays(Holidays_en_US.HOLIDAYS_en_US, 2011);
		
		for (Holiday holiday : holidays) {
			System.out.print(holiday.toString());
		}
		
	}

}
