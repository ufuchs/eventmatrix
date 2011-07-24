/*
 * Copyright (c) 2011 Uli Fuchs <ufuchs@gmx.com>
 * Released under the terms of the GNU GPL v2.0.
 */

package de.z35.frugal.collections.exam.freedays;

import java.util.Calendar;
import java.util.Vector;

/**
 * 
 * @author ufuchs
 *
 */
public class HolidayProvider {

    private HolidayProviderStrategyFixedDate strategyFixedFixedDate =
    	new HolidayProviderStrategyFixedDate();

    private HolidayProviderStrategyMovableDate strategyMovableDate =
    	new HolidayProviderStrategyMovableDate();

    private ShiftHolidayStrategy shiftedHoliday;

    /**
     *
     * @param shiftedHoliday
     */
    public HolidayProvider(ShiftHolidayStrategy shiftedHoliday) {
        this.shiftedHoliday = shiftedHoliday;
    }

	/**
	 *
	 * @return
	 */
	public Vector<Holiday> getHolidays(String[][] holidayTemplates, int year) {

		Vector<Holiday> holidays = new Vector<Holiday>();

		for (String[] template : holidayTemplates) {

			String date = getDate(year, template[0]);

			Holiday holiday = Holiday.createHoliday(date, template[1]);

			holidays.add(holiday);

			if (this.shiftedHoliday != null) {

				Holiday shiftedHoliday = this.shiftedHoliday.shiftHoliday(holiday);

				if (shiftedHoliday != null) {
					holidays.add(shiftedHoliday);
				}
			}

		}

		return holidays;

	}

	/**
	 * 
	 * @param year
	 * @param dateTemplate
	 * @return
	 */
	private String getDate(int year, String dateTemplate) {
		
		char firstCharOfTemplate = dateTemplate.charAt(0);

		HolidayProviderStrategy strategy = 
			getProviderStrategy(firstCharOfTemplate);

		strategy.setParams(year, dateTemplate);
		
		return strategy.transformTemplate();
		
	}

	/**
	 * 
	 * @param firstCharOfTemplate
	 * @return
	 */
	private HolidayProviderStrategy getProviderStrategy(char firstCharOfTemplate) {
		
		HolidayProviderStrategy strategy;

		boolean isFixed = Character.isDigit(firstCharOfTemplate);
		
		if (isFixed) {
			strategy = this.strategyFixedFixedDate;
		} else {
			strategy = this.strategyMovableDate;
		}
		
		return strategy;
		
	}

}