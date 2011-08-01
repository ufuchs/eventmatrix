/*
 * Copyright (c) 2011 Uli Fuchs <ufuchs@gmx.com>
 * Released under the terms of the GNU GPL v2.0.
 */

package de.z35.frugal.collections.exam.freedays;

import java.text.DateFormat;
import java.util.Vector;

import de.z35.frugal.cli.CliOptionService;
import de.z35.frugal.cli.exam.freedays.FreeDayCliOption;
import de.z35.frugal.cli.exam.freedays.TimeFrame;
import de.z35.frugal.cli.exam.freedays.TimeFrameArgumentProvider;
import de.z35.frugal.cli.exam.freedays.TimeFrameValidator;

public class FreeDays {

	public static FreeDays freedays;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		freedays = new FreeDays();

		CliOptionService cos = new CliOptionService()
				.withArgs(args)
				.withOptions(FreeDayCliOption.OPTIONS_DESC);

		// /////////////////////////////////////////////////////////////////////

		TimeFrameArgumentProvider timeFrameProv
			= TimeFrameArgumentProvider.createTimeFrameArgumentProvider();

		timeFrameProv.process("07.2011");

		TimeFrame tf = timeFrameProv.getApiArgument();

		// /////////////////////////////////////////////////////////////////////

		Vector<Holiday> holidays = getHolidays(2011);

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

			System.out.println(sb.toString());

		}

	}


	private static Vector<Holiday> getHolidays(int year) {

		HolidayProvider provider = new HolidayProvider(new ShiftHolidayStrategy_en_US());

		return getHolidays(provider, year);

	}

	private static Vector<Holiday> getHolidays(HolidayProvider provider, int year) {

		return provider.getHolidays(Holidays_en_US.HOLIDAYS_en_US, year);

	}

}
