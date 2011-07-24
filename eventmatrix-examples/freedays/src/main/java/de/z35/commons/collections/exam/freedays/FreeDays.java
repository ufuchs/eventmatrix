/*
 * Copyright (c) 2011 Uli Fuchs <ufuchs@gmx.com>
 * Released under the terms of the GNU GPL v2.0.
 */

package de.z35.commons.collections.exam.freedays;

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

		provider.getHolidays(null, 2011);
		
	}

}
