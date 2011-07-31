/*
 * Copyright (c) 2011. Uli Fuchs <ufuchs@gmx.com>
 * Released under the terms of the GNU GPL v2.0.
 */

package de.z35.cli.test;

import de.z35.frugal.cli.exam.freedays.*;
import de.z35.frugal.collections.exam.freedays.HolidayProviderStrategyMovableDate;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

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
			{"01.2011-07.2011", TimeFrameValidator.KindOfTimeFrame.YYMM_YYMM}

	};

	private Field kindOf;

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

	}


	/**
	 *
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 */
	@Test(dataProvider = "timeFrameArgsProvider")
	public void X_010_Test(String arg, TimeFrameValidator.KindOfTimeFrame kindOf) throws NoSuchFieldException, IllegalAccessException {

		TimeFrameValidator validator = new TimeFrameValidator();

		TimeFrameExpander expander = new TimeFrameExpander();

		expander.setExpanderRule(new ExpanderRulePureYear());
		expander.setExpanderRule(new ExpanderRulePeriodeOfMonths());
		expander.setExpanderRule(new ExpanderRuleMonthOfYear());

		this.kindOf.set(validator, kindOf);

		TimeFrame tf = expander.expand(arg, validator);

		Assert.assertNotNull(tf);

	}

}
