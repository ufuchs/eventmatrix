package de.z35.commons.collections.test.exam.freedays;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertEquals;

import de.z35.commons.collections.exam.freedays.HolidayProviderStrategyMovableDate;

/**
 * 
 * @author ufuchs
 *
 */
public class HolidayProviderStrategyMovableDateTest {

	private static Object[][] MEMORIAL_DAY = new Object[][] {

		{2001, "05-28"},
		{2002, "05-27"},
		{2003, "05-26"},
		{2004, "05-31"},
		{2005, "05-30"},
		{2006, "05-29"},
		{2007, "05-28"},
		{2008, "05-26"},
		{2009, "05-25"},
		{2010, "05-31"},

	};

	private static Object[][] THANKSGIVING_DAY = new Object[][] {

		{2001, "11-22"},
		{2002, "11-28"},
		{2003, "11-27"},
		{2004, "11-25"},
		{2005, "11-24"},
		{2006, "11-23"},
		{2007, "11-22"},
		{2008, "11-27"},
		{2009, "11-26"},
		{2010, "11-25"},

	};

	/**
	 *
	 * @return
	 */
	@DataProvider(name = "memorialDayProvider")
	public Object[][] memorialDayProvider() {
		return MEMORIAL_DAY;
	}

	/**
	 *
	 * @return
	 */
	@DataProvider(name = "thanksGivingDayProvider")
	public Object[][] thanksGivingDayProvider() {
		return THANKSGIVING_DAY;
	}


	@Test
	public void X_010_Test() {

		HolidayProviderStrategyMovableDate x = new HolidayProviderStrategyMovableDate();
		assertNotNull(x);
	}

	/**
     * Test 'transformTemplate' with
     * Memorial Day (observed) [last monday in May] as
     * "M5.5.2"
	 *
	 * @param year
	 * @param dateTemplate
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@Test(dataProvider = "memorialDayProvider")
	public void X_020_Test(int year, String dateTemplate) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {

		HolidayProviderStrategyMovableDate strategy = new HolidayProviderStrategyMovableDate();

		strategy.setParams(year, "M5.5.2");

		// 2001-JUL-20 'transformTemplate' is now public.
		Method specifyStrategy =
			HolidayProviderStrategyMovableDate.class.getDeclaredMethod("transformTemplate");

		specifyStrategy.setAccessible(true);

		String actual = (String) specifyStrategy.invoke(strategy);

		String expected = String.format("%d-" + dateTemplate, year);

		assertEquals(actual, expected);

	}

	/**
     * Test 'transformTemplate' with
     * Thanksgiving Day [4th thursday in Nov]
     * "M11.4.5"
	 *
	 * @param year
	 * @param dateTemplate
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@Test(dataProvider = "thanksGivingDayProvider")
	public void X_030_Test(int year, String dateTemplate) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {

		HolidayProviderStrategyMovableDate strategy = new HolidayProviderStrategyMovableDate();

		strategy.setParams(year, "M11.4.5");

		// 2001-JUL-20 'transformTemplate' is now public.
		Method specifyStrategy =
			HolidayProviderStrategyMovableDate.class.getDeclaredMethod("transformTemplate");

		specifyStrategy.setAccessible(true);

		String actual = (String) specifyStrategy.invoke(strategy);

		String expected = String.format("%d-" + dateTemplate, year);

		assertEquals(actual, expected);

	}

}
