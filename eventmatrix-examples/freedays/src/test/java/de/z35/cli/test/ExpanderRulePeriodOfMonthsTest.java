/*
 * Copyright (c) 2011. Uli Fuchs <ufuchs@gmx.com>
 * Released under the terms of the GNU GPL v2.0.
 */

package de.z35.cli.test;

import de.z35.frugal.cli.exam.freedays.TimeFrame;
import de.z35.frugal.cli.exam.freedays.TimeFrameExpander;
import de.z35.frugal.collections.exam.freedays.DateTimeUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by IntelliJ IDEA.
 * User: ufuchs
 * Date: 31/07/11
 * Time: 20:48
 * To change this template use File | Settings | File Templates.
 */
public class ExpanderRulePeriodOfMonthsTest {

	/**
	 *
	 */
	private Object[][] TIMEFRAME_PERIODS = new Object[][] {

			{"01.2011-01.2012", "2011-01-01:2012-01-31"},
			{"01.2011-01.2011", "2011-01-01:2011-01-31"},
			{"01.2011-07.2011", "2011-01-01:2011-07-31"}

	};

	/**
	 *
	 * @return
	 */
	@DataProvider(name = "timeFramePeriodsProvider")
	public Object[][] getTimeFrameArgs() {
		return TIMEFRAME_PERIODS;
	}

	/**
	 *
	 */
	@Test
	public void X_010_Test() {

		TimeFrameExpander.ExpanderRulePeriodOfMonths expander =
				new TimeFrameExpander.ExpanderRulePeriodOfMonths();
		Assert.assertNotNull(expander);

	}

	/**
	 *
	 */
	@Test(dataProvider = "timeFramePeriodsProvider")
	public void X_020_Test(String arg, String expected) {

		TimeFrameExpander.ExpanderRulePeriodOfMonths expander =
				new TimeFrameExpander.ExpanderRulePeriodOfMonths();

		TimeFrame tf = expander.expand(arg);

		String[] fromTo = expected.split(":");

		String expectedFrom = fromTo[0];
		String expectedTo = fromTo[1];

		String actualFrom = DateTimeUtils.calToString(tf.getFrom());
		String actualTo = DateTimeUtils.calToString(tf.getTo());

		Assert.assertEquals(actualFrom, expectedFrom);
		Assert.assertEquals(actualTo, expectedTo);

	}

}
