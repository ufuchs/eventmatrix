package de.z35.commons.test.white.publicholiday;

import java.util.Calendar;

public class Holiday {

	public static Holiday createHoliday(Calendar date, String name) {
		return new Holiday();
	}

	private Calendar date;
	private String name;
	private boolean onWeekEnd;
	
	public boolean isOnWeekEnd() {
		return onWeekEnd;
	}

	public void setOnWeekEnd(boolean onWeekEnd) {
		this.onWeekEnd = onWeekEnd;
	}

	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
		this.onWeekEnd = isWeekEnd();
	}
	
	/**
	 * 
	 * @param date
	 * @return
	 */
	private boolean isWeekEnd() {
		
		int dayOfWeek = this.date.get(Calendar.DAY_OF_WEEK);
		
		return dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY;

	}
	
	
}
