/*
 * Copyright (c) 2011. Uli Fuchs <ufuchs@gmx.com>
 * All rights reserved.
 * Released under the terms of the GNU GPL v2.0.
 */

package de.z35.commons.test.white.event.impl;

import java.util.Calendar;
import java.util.Vector;

import de.z35.commons.event.Event;
import de.z35.commons.event.EventImpl;
import de.z35.commons.event.Utils;

/**
 * Created by IntelliJ IDEA.
 * User: fuchs
 * Date: 07.07.11
 * Time: 20:09
 * To change this template use File | Settings | File Templates.
 */
public class ProviderEasterDate {

	/**
	 * Easter from 2010 to 2030
	 */
	private static String[] EASTER = {

		"2010-04-04",
		"2011-04-24",
		"2012-04-08",
		"2013-03-31",
		"2014-04-20",
		"2015-04-05",
		"2016-03-27",
		"2017-04-16",
		"2018-04-01",
		"2019-04-21",
		"2020-04-12",
		"2021-04-04",
		"2022-04-17",
		"2023-04-09",
		"2024-03-31",
		"2025-04-20",
		"2026-04-05",
		"2027-03-28",
		"2028-04-16",
		"2029-04-01",
		"2030-04-21"

	};

	private static int GOD_FRIDAY_OFFS = -2;
	private static int EASTER_SUNDAY_OFFS = 0;
	private static int EASTER_MONDAY_OFFS = EASTER_SUNDAY_OFFS +1;
	private static int ASCENSION_DAY_OFFS = EASTER_SUNDAY_OFFS + 39;
	private static int WHIT_SUNDAY_OFFS = EASTER_SUNDAY_OFFS + 49;
	private static int WHIT_MONDAY_OFFS = WHIT_SUNDAY_OFFS + 1;
	private static int CORPUS_CHRISTI_OFFS = EASTER_SUNDAY_OFFS + 60;

	/**
	 *
	 */
	public static enum Eastercycle {
		
		GOD_FRIDAY(GOD_FRIDAY_OFFS),
		EASTER_SUNDAY(EASTER_SUNDAY_OFFS),
		EASTER_MONDAY(EASTER_MONDAY_OFFS),
		ASCENSION_DAY(ASCENSION_DAY_OFFS),
		WHIT_SUNDAY(WHIT_SUNDAY_OFFS),
		WHIT_MONDAY(WHIT_MONDAY_OFFS),
		CORPUS_CHRISTI(CORPUS_CHRISTI_OFFS);

		private int offs;

		Eastercycle(int offs) {
			this.offs = offs;
		}

		public int Offs() { return this.offs; }

	}

	// save Easter date concerning performance issues. (sorry, no better idea. Yet.)
	int yy;
	int mm;
	int dd;

	Calendar easter;
	
	Vector<Event> easterCycle = new Vector<Event>();

	/**
	 *
	 * @param year
	 * @return
	 * @throws Exception
	 */
	public Vector<Event> getEasterCycleAsEvents(final Calendar year) {

		this.getEaster(year.get(Calendar.YEAR));

		this.getEasterCycleDays();

		return this.easterCycle;

	}

	/**
	 *
	 */
	private void getEasterCycleDays() {
		
		// save easter date
		this.yy = easter.get(Calendar.YEAR);
		this.mm = easter.get(Calendar.MONTH);
		this.dd = easter.get(Calendar.DAY_OF_MONTH);

		for (Eastercycle cycle : Eastercycle.values()) {
			
			this.easterCycle.add(this.rollCalendarAndGetCycleDay(cycle));
			
		}
		
	}

	/**
	 *
	 */
	public void getEaster(final int year) throws IllegalArgumentException {

		this.easter = null;

		// Protection
		if ((year < 2010) && (year > 2030)) {
			throw new IllegalArgumentException();
		}

		String yy = ((Integer) year).toString();

		for (String other : EASTER) {

			if (yy.equals(other.substring(0, 4))) {

				this.easter = Utils.dateToCalendar(other);
				break;
				
			}

		}

		// Protection
		assert this.easter != null : "oOps, 'easterDate' is null";

	}

	/**
	 *
	 * @param cycleDay a day of the Easter cycle
	 * @return A cycle day as <code>Event</code>
	 */
	private Event rollCalendarAndGetCycleDay(Eastercycle cycleDay) {

		int offsFromEaster = cycleDay.Offs();

		this.easter.roll(Calendar.DAY_OF_YEAR, offsFromEaster);

		Event e = EventImpl.createEvent(cycleDay.ordinal(), 
				(Calendar) this.easter.clone());

		// reset to Easter date
		this.easter.set(this.yy, this.mm, this.dd);

		return e;

	}

}
