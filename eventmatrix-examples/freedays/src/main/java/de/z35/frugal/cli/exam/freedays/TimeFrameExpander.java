/*
 * Copyright (c) 2011. Uli Fuchs <ufuchs@gmx.com>
 * Released under the terms of the GNU GPL v2.0.
 */

package de.z35.frugal.cli.exam.freedays;

import de.z35.frugal.cli.ArgumentExpander;
import de.z35.frugal.cli.ArgumentExpanderRule;
import de.z35.frugal.cli.ArgumentValidator;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: ufuchs
 * Date: 29/07/11
 * Time: 22:19
 * To change this template use File | Settings | File Templates.
 */
public class TimeFrameExpander implements ArgumentExpander<TimeFrame> {

	// /////////////////////////////////////////////////////////////////////////
	// fields
	// /////////////////////////////////////////////////////////////////////////

	private HashMap<TimeFrameValidator.KindOfTimeFrame, ArgumentExpanderRule<TimeFrame>> hm =
			new HashMap<TimeFrameValidator.KindOfTimeFrame, ArgumentExpanderRule<TimeFrame>>();

	private TimeFrameExpander() {
	}

	/**
	 *
	 * @return
	 */
	public static TimeFrameExpander createTimeFrameExpander() {

		TimeFrameExpander expander = new TimeFrameExpander();

		expander.setExpanderRule(new ExpanderRulePureYear());
		expander.setExpanderRule(new ExpanderRulePeriodOfMonths());
		expander.setExpanderRule(new ExpanderRuleMonthOfYear());

		return expander;

	}

	// /////////////////////////////////////////////////////////////////////////
	// setters
	// /////////////////////////////////////////////////////////////////////////

	/**
	 *
	 * @param rule
	 */
	public void setExpanderRule(ArgumentExpanderRule<TimeFrame> rule) {

		TimeFrameValidator.KindOfTimeFrame kindOf =
				Enum.valueOf(TimeFrameValidator.KindOfTimeFrame.class, rule.getRuleName());

		hm.put(kindOf, rule);

	}

	// /////////////////////////////////////////////////////////////////////////
	// production
	// /////////////////////////////////////////////////////////////////////////

	/**
	 * Expands an argument like
	 *   2011
	 *   07.2011
	 *   01.2011-07.2011
	 * into an API-usable time frame.
	 *
	 * @param argument
	 * @param validator
	 * @return
	 */
	@Override
	public TimeFrame expand(String argument, ArgumentValidator validator) {

		TimeFrameValidator timeFrameValidator = (TimeFrameValidator) validator;

		ArgumentExpanderRule<TimeFrame> rule =
				hm.get(timeFrameValidator.getKindOfTimeFrame());

		return rule.expand(argument);

	}

}
