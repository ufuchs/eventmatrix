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
 * Time: 20:59
 * To change this template use File | Settings | File Templates.
 */
public class ExpanderRuleMonthOfYear implements ArgumentExpanderRule<TimeFrame> {

	@Override
	public String getRuleName() {
		return TimeFrameValidator.KindOfTimeFrame.YYMM.name();
	}

	/**
	 * Expands a month of a year, e.g. 07.2011, into an API-usable time frame.
	 * Which means, it starts on the Jul 01 and ends on the Jul 31.
	 *
	 * @param argument
	 * @return
	 */
	@Override
	public TimeFrame expand(String argument) {

		String[] parts = argument.split("\\.");

		final int month = Integer.parseInt(parts[0]);

		final int year = Integer.parseInt(parts[1]);

		final Calendar cal = Calendar.getInstance();

		TimeFrame tf = new TimeFrame() {{
			setFromFields(year, month, 1);
			setToFields(year, month, cal.getActualMaximum(Calendar.DATE));
		}};

		return tf;

	}

}
