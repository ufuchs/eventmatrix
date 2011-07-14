package de.z35.commons.collections.test.exam.freedays;

import java.util.Vector;

import org.testng.annotations.Test;
import static org.testng.Assert.assertNotNull;

import de.z35.commons.collections.CollectionUtils;
import de.z35.commons.collections.Predicate;
import de.z35.commons.collections.exam.freedays.FixedHolidayProvider;
import de.z35.commons.collections.exam.freedays.Holiday;
import de.z35.commons.collections.exam.freedays.WeekEndPredicate;

public class FixedHolidayProviderTest {

	@Test
	public void X_010_Test() {

		FixedHolidayProvider itsFHP = new FixedHolidayProvider();
		assertNotNull(itsFHP);

	}

	@Test
	public void X_020_Test() {

		FixedHolidayProvider itsFHP = new FixedHolidayProvider();

		Vector<Holiday> holidays = itsFHP.getFixedHolidays(FixedHolidayProvider.fixedHolidays_de_DE, 2011);

		System.out.print(holidays.toString());
		System.out.println();

	}

	@Test
	public void X_030_Test() {

		FixedHolidayProvider itsFHP = new FixedHolidayProvider();

		Vector<Holiday> holidays = itsFHP.getFixedHolidays(FixedHolidayProvider.fixedHolidays_de_DE, 2011);

		Predicate<Holiday> p = new WeekEndPredicate();

		Vector<Holiday> holidaysWithOutWeekEnds = new Vector<Holiday>(CollectionUtils.selectRejected(holidays, p));

		System.out.print(holidaysWithOutWeekEnds.toString());
		System.out.println();

	}

}
