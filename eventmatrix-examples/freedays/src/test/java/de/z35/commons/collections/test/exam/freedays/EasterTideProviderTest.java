package de.z35.commons.collections.test.exam.freedays;

import static org.testng.Assert.assertNotNull;

import java.util.Calendar;
import java.util.Vector;

import org.testng.annotations.Test;

import de.z35.commons.collections.CollectionUtils;
import de.z35.commons.collections.Predicate;
import de.z35.commons.collections.exam.freedays.EasterTideProvider;
import de.z35.commons.collections.exam.freedays.EasterTideProvider.DayOfTide;
import de.z35.commons.collections.exam.freedays.EasterTideTransformer;
import de.z35.commons.collections.exam.freedays.Holiday;
import de.z35.commons.collections.exam.freedays.DateTimeUtils;
import de.z35.commons.collections.exam.freedays.WeekEndPredicate;

public class EasterTideProviderTest {

	@Test
	public void X_010_Test() {
		EasterTideProvider itsETP = new EasterTideProvider();
		assertNotNull(itsETP);
	}

	@Test
	public void X_020_Test() {

		EasterTideProvider itsETP = new EasterTideProvider();

		Calendar year = DateTimeUtils.dateToCalendar("2011-01-01");

		Vector<DayOfTide> easterTide = itsETP.getEasterTide(year);

		assertNotNull(easterTide);

		System.out.print(easterTide.toString());
		System.out.println();

	}

	/**
	 * Transforms the days of 'eastertide' into 'holidays'
	 */
	@Test
	public void X_030_Test() {

		EasterTideProvider itsETP = new EasterTideProvider();

		Calendar year = DateTimeUtils.dateToCalendar("2011-01-01");

		Vector<DayOfTide> easterTide = itsETP.getEasterTide(year);

		EasterTideTransformer t = new EasterTideTransformer();

		Vector<Holiday> holidays = new Vector<Holiday>(CollectionUtils.transform(easterTide, t));

		System.out.print(holidays.toString());
		System.out.println();

	}

	@Test
	public void X_040_Test() {

		EasterTideProvider itsETP = new EasterTideProvider();

		Calendar year = DateTimeUtils.dateToCalendar("2011-01-01");

		Vector<DayOfTide> easterTide = itsETP.getEasterTide(year);

		EasterTideTransformer t = new EasterTideTransformer();

		Vector<Holiday> holidays = new Vector<Holiday>(CollectionUtils.transform(easterTide, t));

		Predicate<Holiday> p = new WeekEndPredicate();

		Vector<Holiday> holidaysWithOutWeekEnds = new Vector<Holiday>(CollectionUtils.selectRejected(holidays, p));

		System.out.print(holidaysWithOutWeekEnds.toString());
		System.out.println();

	}



}
