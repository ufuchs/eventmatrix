/*
 * Copyright (c) 2011. Uli Fuchs <ufuchs@gmx.com>
 * Released under the terms of the GNU GPL v2.0.
 */

package de.z35.frugal.cli.exam.freedays;

import java.util.Calendar;

/**
 * Created by IntelliJ IDEA.
 * User: ufuchs
 * Date: 29/07/11
 * Time: 22:20
 * To change this template use File | Settings | File Templates.
 */
public class TimeFrame {

	// /////////////////////////////////////////////////////////////////////////
	// fields
	// /////////////////////////////////////////////////////////////////////////

	Calendar from;

	Calendar to;

	// /////////////////////////////////////////////////////////////////////////
	// ctor
	// /////////////////////////////////////////////////////////////////////////

	public TimeFrame() {
		this.from = Calendar.getInstance();
		this.to = Calendar.getInstance();
	}

	// /////////////////////////////////////////////////////////////////////////
	// getters
	// /////////////////////////////////////////////////////////////////////////

	/**
	 * Gets the start date of the time frame
	 * @return
	 */
	public Calendar getFrom() {
		return this.from;
	}

	/**
	 * Gets the end date of the time frame
	 * @return
	 */
	public Calendar getTo() {
		return this.to;
	}

	// /////////////////////////////////////////////////////////////////////////
	// setters
	// /////////////////////////////////////////////////////////////////////////

	/**
	 *
	 * @param yy
	 * @param mm
	 * @param dd
	 */
	public void setFromFields(int yy, int mm, int dd) {
		this.setFields(this.from, yy, mm, dd);
	}

	/**
	 *
	 * @param yy
	 * @param mm
	 * @param dd
	 */
	public void setToFields(int yy, int mm, int dd) {
		this.setFields(this.to, yy, mm, dd);
	}

	/**
	 *
	 * @param cal
	 * @param yy
	 * @param mm
	 * @param dd
	 */
	private void setFields(Calendar cal, int yy, int mm, int dd) {
		cal.set(yy, mm - 1, dd);
	}
}
