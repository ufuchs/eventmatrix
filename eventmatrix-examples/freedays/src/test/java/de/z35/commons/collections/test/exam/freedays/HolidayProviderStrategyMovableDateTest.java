package de.z35.commons.collections.test.exam.freedays;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertEquals;


import de.z35.commons.collections.exam.freedays.DateTimeUtils;
import de.z35.commons.collections.exam.freedays.HolidayProviderStrategyMovableDate;

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
	
	/**
	 * 
	 * @return
	 */
	@DataProvider(name = "memorialDayProvider")
	public Object[][] memorialDayProvider() {
		return MEMORIAL_DAY;
	}

	@Test
	public void X_010_Test() {

		HolidayProviderStrategyMovableDate x = new HolidayProviderStrategyMovableDate();
		assertNotNull(x);
	}

	/**
     * Test 'handleLastOccurence' with
     * May 30, 2011 (monday): Memorial Day (observed) [last monday in May] as
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
		
		Method specifyStrategy =
			HolidayProviderStrategyMovableDate.class.getDeclaredMethod("transformTemplate");

		specifyStrategy.setAccessible(true);

		String actual = (String) specifyStrategy.invoke(strategy);
		
		String expected = String.format("%d-" + dateTemplate, year); 
		
		assertEquals(actual, expected);

	}

}
