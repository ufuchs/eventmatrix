/*
 * Copyright (c) 2011. Uli Fuchs <ufuchs@gmx.com>
 * Released under the terms of the GNU GPL v2.0.
 */

package de.z35.frugal.cli.exam.freedays;

import de.z35.frugal.cli.ArgumentExpander;
import de.z35.frugal.cli.ArgumentExpanderRule;
import de.z35.frugal.cli.ArgumentValidator;

import java.util.Calendar;
import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: ufuchs
 * Date: 29/07/11
 * Time: 22:19
 * To change this template use File | Settings | File Templates.
 */
public class TimeFrameExpander implements ArgumentExpander<TimeFrame> {


	public static class ExpanderRuleMonthOfYear implements ArgumentExpanderRule<TimeFrame> {

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

	public static class ExpanderRulePeriodOfMonths implements ArgumentExpanderRule<TimeFrame> {

		/**
		 * In this case <code>getRuleName</code> provides the name of the
		 * corresponding enum field.
		 * @return
		 */
		@Override
		public String getRuleName() {
			return TimeFrameValidator.KindOfTimeFrame.YYMM_YYMM.name();
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

			String[] to = date.split("\\.");

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

			String[] from = date.split("\\.");

			int month = Integer.parseInt(from[0]);

			int year = Integer.parseInt(from[1]);

			tf.setFromFields(year, month, 1);

		}

	}

	public static class ExpanderRulePureYear implements ArgumentExpanderRule<TimeFrame> {

		@Override
		public String getRuleName() {
			return TimeFrameValidator.KindOfTimeFrame.YY.name();
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

		// /////////////////////////////////////////////////////////////////////////
		// fields
		// /////////////////////////////////////////////////////////////////////////

		private HashMap<TimeFrameValidator.KindOfTimeFrame, ArgumentExpanderRule<TimeFrame>> hm =
				new HashMap<TimeFrameValidator.KindOfTimeFrame, ArgumentExpanderRule<TimeFrame>>();

		// /////////////////////////////////////////////////////////////////////////
		// ctor
		// /////////////////////////////////////////////////////////////////////////

		private TimeFrameExpander() {
		}

		/**
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
		 * 2011
		 * 07.2011
		 * 01.2011-07.2011
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
