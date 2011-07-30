/*
 * Copyright (c) 2011. Uli Fuchs <ufuchs@gmx.com>
 * Released under the terms of the GNU GPL v2.0.
 */

package de.z35.frugal.cli.exam.freedays;

import de.z35.frugal.cli.ArgumentExpanderRule;

/**
 * Created by IntelliJ IDEA.
 * User: ufuchs
 * Date: 30/07/11
 * Time: 20:41
 * To change this template use File | Settings | File Templates.
 */
public class ExpanderRulePureYear implements ArgumentExpanderRule<TimeFrame> {

	@Override
	public String getRuleName() {
		return "timeframe-year";
	}

	/**
	 * Expands a simple year, e.g. 2011, into an API-usable time frame.
	 * Which means, it starts on the Jan 01 and ends on the Dec 31.
	 *
	 * @param argument
	 * @return
	 */
	@Override
	public TimeFrame expand(String argument) {

		final int year = Integer.parseInt(argument);

		TimeFrame tf = new TimeFrame() {{
			setFromFields(year, 1, 1);
			setToFields(year, 12, 31);
		}};

		return tf;

	}

}
