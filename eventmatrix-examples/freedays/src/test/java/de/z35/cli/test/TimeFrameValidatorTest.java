/*
 * Copyright (c) 2011. Uli Fuchs <ufuchs@gmx.com>
 * Released under the terms of the GNU GPL v2.0.
 */

package de.z35.cli.test;

import de.z35.frugal.cli.TimeFrameValidator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by IntelliJ IDEA.
 * User: ufuchs
 * Date: 28/07/11
 * Time: 21:18
 * To change this template use File | Settings | File Templates.
 */
public class TimeFrameValidatorTest {

	/**
	 * accepted time frames
	 */
	private static Object[][] TIMEFRAMES = new Object[][] {

			{"01.2011-02.2011"},
			{"1.2011-02.2011"},
			{"01.2011-2.2011"},
			{"1.2011-2.2011"},
			{"1.2011-10.2011"},
			{"2011"}
	};

	/**
	 * error prune time frames
	 */
	private static Object[][] TIMEFRAMES_ERR = new Object[][] {

			{"01.2011-02.201"},
			{"01.201-02.201"},
			{"00.2011-02.2011"},
			{"0.2011-02.2011"},
			{"201"}

	};

	/**
	 *
	 * @return
	 */
	@DataProvider(name = "timeFrameProvider")
	public Object[][] timeFrameProvider() {

		return TIMEFRAMES;
	}

	/**
	 *
	 * @return
	 */
	@DataProvider(name = "timeFrameProviderErr")
	public Object[][] timeFrameProviderErr() {

		return TIMEFRAMES_ERR;
	}

	/**
	 *
	 */
	@Test
	public void X_010_Test() {
		TimeFrameValidator validator = new TimeFrameValidator();
		Assert.assertNotNull(validator);
	}

	/**
	 * with 'timeFrameProvider'
	 */
	@Test(dataProvider = "timeFrameProvider")
	public void X_020_Test(String timeFrame) {

		TimeFrameValidator validator = new TimeFrameValidator();
		validator.validate(timeFrame);

	}

	/**
	 * with 'timeFrameProviderErr'
	 */
	@Test(dataProvider = "timeFrameProviderErr", expectedExceptions = IllegalArgumentException.class)
	public void X_030_Test(String timeFrame) {

		TimeFrameValidator validator = new TimeFrameValidator();
		validator.validate(timeFrame);

	}

}
