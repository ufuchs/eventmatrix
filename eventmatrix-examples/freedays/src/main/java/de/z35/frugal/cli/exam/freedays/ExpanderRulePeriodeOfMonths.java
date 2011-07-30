/*
 * Copyright (c) 2011. Uli Fuchs <ufuchs@gmx.com>
 * Released under the terms of the GNU GPL v2.0.
 */

package de.z35.frugal.cli.exam.freedays;

import de.z35.frugal.cli.ArgumentExpanderRule;

import java.util.Calendar;

/**
 * Created by IntelliJ IDEA.
 * User: ufuchs
 * Date: 30/07/11
 * Time: 21:13
 * To change this template use File | Settings | File Templates.
 */
public class ExpanderRulePeriodeOfMonths implements ArgumentExpanderRule<TimeFrame> {

	@Override
	public String getRuleName() {
		return "timeframe-periodeOfmonths";
	}

	/**
	 * Expands a period of months , e.g. 01.2011-07.2011, into an API-usable
	 * time frame.
	 * Which means, it starts on the Jan 01 and ends on the Jul 31.
	 *
	 * @param argument
	 * @return
	 */
	@Override
	public TimeFrame expand(String argument) {

		String[] fromTo = argument.split("-");

		TimeFrame tf = new TimeFrame();

		extractFromDate(fromTo[0], tf);

		extractToDate(fromTo[1], tf);

		return tf;
	}

	/**
	 *
	 * @param date
	 * @param tf
	 */
	private void extractToDate(String date, TimeFrame tf) {

		String[] to = date.split(".");

		int month = Integer.parseInt(to[0]);

		int year = Integer.parseInt(to[1]);

		tf.setToFields(year, month, Calendar.getInstance().getActualMaximum(Calendar.DATE));
	}

	/**
	 *
	 * @param date
	 * @param tf
	 */
	private void extractFromDate(String date, TimeFrame tf) {

		String[] from = date.split(".");

		int month = Integer.parseInt(from[0]);

		int year = Integer.parseInt(from[1]);

		tf.setFromFields(year, month, 1);

	}

}
