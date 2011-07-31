/*
 * Copyright (c) 2011. Uli Fuchs <ufuchs@gmx.com>
 * Released under the terms of the GNU GPL v2.0.
 */

package de.z35.cli.test;

import de.z35.frugal.cli.exam.freedays.*;
import de.z35.frugal.collections.exam.freedays.DateTimeUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Field;

/**
 * Created by IntelliJ IDEA.
 * User: ufuchs
 * Date: 30/07/11
 * Time: 12:01
 * To change this template use File | Settings | File Templates.
 */
public class TimeFrameExpanderTest {

	/**
	 *
	 */
	private Object[][] TIMEFRAME_ARGS = new Object[][] {

			{"2011", TimeFrameValidator.KindOfTimeFrame.YY},
			{"07.2011", TimeFrameValidator.KindOfTimeFrame.YYMM},
			{"01.2011-01.2012", TimeFrameValidator.KindOfTimeFrame.YYMM_YYMM}

	};

	private Field kindOf;

	private TimeFrameExpander expander;

	/**
	 *
	 * @return
	 */
	@DataProvider(name = "timeFrameArgsProvider")
	public Object[][] getTimeFrameArgs() {
		return TIMEFRAME_ARGS;
	}

	/**
	 *
	 * @throws NoSuchFieldException
	 */
	@BeforeClass
	public void init() throws NoSuchFieldException {

		this.kindOf =
			TimeFrameValidator.class.getDeclaredField("kindOfTimeFrame");

		this.kindOf.setAccessible(true);

		this.expander = TimeFrameExpander.createTimeFrameExpander();

	}

	/**
	 *
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 */
	@Test(dataProvider = "timeFrameArgsProvider")
	public void X_010_Test(String arg, TimeFrameValidator.KindOfTimeFrame kindOf) throws IllegalAccessException {

		TimeFrameValidator validator = new TimeFrameValidator();

		this.kindOf.set(validator, kindOf);

		TimeFrame tf = expander.expand(arg, validator);

		String from = DateTimeUtils.calToString(tf.getFrom());
		String to = DateTimeUtils.calToString(tf.getTo());

		switch (kindOf) {
			case YY:
				Assert.assertEquals(from, "2011-01-01");
				Assert.assertEquals(to, "2011-12-31");
				break;
			case YYMM:
				Assert.assertEquals(from, "2011-07-01");
				Assert.assertEquals(to, "2011-07-31");
				break;
			case YYMM_YYMM:
				Assert.assertEquals(from, "2011-01-01");
				Assert.assertEquals(to, "2012-01-31");
				break;
		}

	}

}
