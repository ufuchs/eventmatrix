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

	int fromYY;
	int fromMM;
	int fromDD;

	Calendar to;

	int toYY;
	int toMM;
	int toDD;

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

	public Calendar getFrom() {
		return from;
	}

	public Calendar getTo() {
		return this.to;
	}

	// /////////////////////////////////////////////////////////////////////////
	// setters
	// /////////////////////////////////////////////////////////////////////////

	/**
	 *
	 * @param YY
	 * @param MM
	 * @param DD
	 */
	public void setFromParams(int YY, int MM, int DD) {
		this.fromYY = YY;
		this.fromMM = MM;
		this.fromDD = DD;
	}

	/**
	 *
	 * @param YY
	 * @param MM
	 * @param DD
	 */
	public void setToParams(int YY, int MM, int DD) {
		this.fromYY = YY;
		this.fromMM = MM;
		this.fromDD = DD;
	}

}
