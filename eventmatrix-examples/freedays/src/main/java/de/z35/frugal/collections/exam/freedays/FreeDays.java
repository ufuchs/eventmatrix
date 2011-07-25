/*
 * Copyright (c) 2011 Uli Fuchs <ufuchs@gmx.com>
 * Released under the terms of the GNU GPL v2.0.
 */

package de.z35.frugal.collections.exam.freedays;

import java.text.DateFormat;
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

		HolidayProvider provider = new HolidayProvider(new ShiftHolidayStrategy_en_US());

		Vector<Holiday> holidays = provider.getHolidays(Holidays_en_US.HOLIDAYS_en_US, 2012);

		FreeDaysMvc mvc = new FreeDaysMvc(DateFormat.FULL);

		mvc.calcDimensions(holidays);

		int holidayLen = mvc.getMaxNameLen();

		String format = String.format("%%%ds", holidayLen);

		StringBuilder sb = new StringBuilder(200);

		for (Holiday holiday : holidays) {

			sb.setLength(0);

			String name = String.format(format, holiday.getName());

			String date = mvc.formatDate(holiday.getDate().getTime());

			String shiftedFrom = "";

			if (holiday.getShiftedFrom() != null) {
				shiftedFrom = mvc.formatDate(holiday.getShiftedFrom().getTime());
			}

			sb
					.append("PH")
					.append(" | ")
					.append(date)
					.append(" | ")
					.append(name)
					.append(" | ")
					.append(shiftedFrom);


			//System.out.println(name + " | " + date + " | " + shiftedFrom);
			System.out.println(sb.toString());

		}

	}

}
