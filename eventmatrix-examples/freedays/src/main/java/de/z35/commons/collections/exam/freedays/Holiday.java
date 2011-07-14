package de.z35.commons.collections.exam.freedays;

import java.util.Calendar;

public class Holiday {

	/**
	 *
	 * @param date
	 * @param name
	 * @return
	 */
	public static Holiday createHoliday(String date, String name) {
		return createHoliday(DateTimeUtils.dateToCalendar(date), name);
	}

	/**
	 *
	 * @param date
	 * @param name
	 * @return
	 */
	public static Holiday createHoliday(Calendar date, String name) {

		Holiday result = new Holiday();

		result.setDate(date);
		result.setName(name);

		return result;
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

	public String toString() {

		String LS = System.getProperty("line.separator");

		StringBuilder sb = new StringBuilder();
		
		sb.append(name)
			.append(" on ")
			.append(DateTimeUtils.calToString(date))
			.append(LS);

		return sb.toString();

	}


}
