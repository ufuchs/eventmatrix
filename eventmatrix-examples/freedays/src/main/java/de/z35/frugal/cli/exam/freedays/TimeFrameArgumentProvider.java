/*
 * Copyright (c) 2011. Uli Fuchs <ufuchs@gmx.com>
 * Released under the terms of the GNU GPL v2.0.
 */

package de.z35.frugal.cli.exam.freedays;

import de.z35.frugal.cli.ArgumentExpanderRule;
import de.z35.frugal.cli.ArgumentProvider;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: ufuchs
 * Date: 30/07/11
 * Time: 21:47
 * To change this template use File | Settings | File Templates.
 */
public class TimeFrameArgumentProvider extends ArgumentProvider<TimeFrame> {


	// /////////////////////////////////////////////////////////////////////////
	// ctor
	// /////////////////////////////////////////////////////////////////////////

	private TimeFrameArgumentProvider() {}

	/**
	 *
	 * @return
	 */
	public static TimeFrameArgumentProvider createTimeFrameArgumentProvider() {

		TimeFrameArgumentProvider prov = new TimeFrameArgumentProvider();

		prov.setValidator(new TimeFrameValidator());
		prov.setExpander(TimeFrameExpander.createTimeFrameExpander());

		return prov;
	}

}
