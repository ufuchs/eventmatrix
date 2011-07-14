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
		{"M3.2.0", "Start of Day Light Savings"},
		{"M11.1.0", "End of Day Light Savings"},
	};

    /**
     * @see http://wwp.greenwichmeantime.com/time-zone/rules/usa/
     *
     * Eastern : export TZ="EST5EDT4,M3.2.0/02:00,M11.1.0/02:00"
     * Central : export TZ="CST6CDT5,M3.2.0/02:00,M11.1.0/02:00"
     * Mountain: export TZ="MST7MDT6,M3.2.0/02:00,M11.1.0/02:00"
     * Pacific : export TZ="PST8PDT7,M3.2.0/02:00,M11.1.0/02:00"
     */
    public static String[][] dayLightSavings_en_US = new String[][] {
        {"M3.2.0", "Start of Day Light Savings"},
        {"M11.1.0", "End of Day Light Savings"},
    };

    FixedHolidayProviderStrategyISO fhpsISO = new FixedHolidayProviderStrategyISO();
    
    FixedHolidayProviderStrategyPOSIX fhpsPOSIX = new FixedHolidayProviderStrategyPOSIX();

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
			
			FixedHolidayProviderStrategy fhps;
			
			if (isDigit) {
				fhps = fhpsISO;
			} else {
				fhps = fhpsPOSIX;
			}

			date = fhps.transformTemplate(year, part[0]);
			
			holidays.add(Holiday.createHoliday(date, part[1]));

		}

		return holidays;

	}

}
