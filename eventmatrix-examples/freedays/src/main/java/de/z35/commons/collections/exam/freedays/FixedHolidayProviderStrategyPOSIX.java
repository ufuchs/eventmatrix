package de.z35.commons.collections.exam.freedays;

import java.util.Calendar;

public class FixedHolidayProviderStrategyPOSIX implements FixedHolidayProviderStrategy {

	@Override
	public String transformTemplate(int year, String dateTemplate) {
		
		String template = dateTemplate.substring(1);
		
		String parts[] = template.split("\\.");
		
		Calendar cal = Calendar.getInstance();
		
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, Integer.parseInt(parts[0]) - 1);
		cal.set(Calendar.WEEK_OF_MONTH, Integer.parseInt(parts[1]));
		cal.set(Calendar.DAY_OF_WEEK, Integer.parseInt(parts[2]) + 1);
		
		return DateTimeUtils.calToString(cal);
	}

}
