package de.z35.commons.collections.exam.freedays;

import java.util.Vector;

public class FixedHolidayProvider {

    private HolidayProviderStrategyFixed strategyFixed =
    	new HolidayProviderStrategyFixed();

    private HolidayProviderStrategyMoveable strategyMoveable =
    	new HolidayProviderStrategyMoveable();


	/**
	 *  ISO 8601 date format without year
	 */
	public static String[][] fixedHolidays_de_DE = new String[][] {
		{"01-01", "New Year's Day"},
		{"05-01", "May Day"},
		{"10-03	", "Day of German Unity"},
		{"12-25", "Christmas Day"},
		{"12-26", "Second Christmas Day"},
		{"M3.2.0", "Start of Day Light Savings"},
		{"M11.1.0", "End of Day Light Savings"},
	};

    /**
     * Public Holiday USA
     */
    public static String[][] publicHolidays_en_US = new String[][] {

    	// January 1, 2011 (saturday): New Year's Day [Jan. 1 every year]
    	{"01-01", "New Year's Day"},

    	//January 17, 2011 (monday): Martin Luther King Day [3rd monday in Jan]
        {"M1.3.2", "Martin Luther King Day"},

        // February 21, 2011 (monday): Presidents Day (observed) [3rd monday in Feb]
        // note: Presidents Day is also Washington's Birthday (observed)
        {"M2.3.2", "Presidents Day"},

        // May 30, 2011 (monday): Memorial Day (observed) [last monday in May]
        {"M5.5.2", "Memorial Day"},

        // July 4, 2011 (monday): Independence Day [July 4th every year]
        {"07-04", "Independence Day"},

        // September 5, 2011 (monday): Labor Day [1st monday in Sept]
        {"M9.F.2", "Labor Day"},

        // October 10, 2011 (monday): Columbus Day (observed) [2nd monday in Oct]
        {"M10.2.2", "Columbus Day"},

        // November 11, 2011 (friday): Veterans' Day [Nov. 11 every year]
        {"11-11", "Veterans' Day"},

        // November 24, 2011 (thursday): Thanksgiving Day [4th thursday in Nov]
        {"M11.4.5", "Thanksgiving Day"},

        // December 25, 2011 (sunday): Christmas Day [Dec. 25 every year]
        {"12-25", "Christmas Day"},

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
	public Vector<Holiday> getFixedHolidays(String[][] fixedHolidays, int year) {

		Vector<Holiday> holidays = new Vector<Holiday>();

		for (String[] part : fixedHolidays) {

			String date = null;

			boolean isDigit = Character.isDigit(part[0].charAt(0));

			FixedHolidayProviderStrategy strategy;

			if (isDigit) {
				strategy = strategyFixed;
			} else {
				strategy = strategyMoveable;
			}

			strategy.setParams(year, part[0]);
			date = strategy.transformTemplate();

			holidays.add(Holiday.createHoliday(date, part[1]));

		}

		return holidays;

	}

}
