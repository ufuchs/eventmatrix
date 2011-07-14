package de.z35.commons.collections.exam.freedays;

import java.util.Vector;

public class FixedHolidayProvider {

	/**
	 *  ISO 8601 date format without year
	 */
	public static String[][] fixedHolidays_de_DE = new String[][] {
		{"01-01", "New Year's Day"},
		{"05-01", "May Day"},
		{"10-03	", "Day of German Unity"},
		{"12-25", "Christmas Day"},
		{"12-26", "Second Christmas Day"},
	};

	/**
	 * state 'Berlin'
	 */
	public static String[][] extraHolidays_de_DE_BE = new String[][] {
	};

	/**
	 * state 'North Rhine-Westphalia'
	 */
	public static String[][] extraHolidays_de_DE_NW = new String[][] {
		{"06-23", "Corpus Christi"},
		{"11-01", "All Saints' Day"},
	};

	/**
	 *
	 * @return
	 */
	public Vector<Holiday> getFixedHolidays(int year) {

		Vector<Holiday> holidays = new Vector<Holiday>();

		for (String[] h : fixedHolidays_de_DE) {

			String format = "%d-" + h[0];

			String date = String.format(format, year);

			holidays.add(Holiday.createHoliday(date, h[1]));

		}

		return holidays;

	}

}
