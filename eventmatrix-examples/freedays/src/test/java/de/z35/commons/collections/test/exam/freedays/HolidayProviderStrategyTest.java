package de.z35.commons.collections.test.exam.freedays;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertEquals;


import de.z35.commons.collections.exam.freedays.DateTimeUtils;
import de.z35.commons.collections.exam.freedays.HolidayProviderStrategyMoveable;

public class HolidayProviderStrategyTest {

	
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

		HolidayProviderStrategyMoveable x = new HolidayProviderStrategyMoveable();
		assertNotNull(x);
	}

	/**
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

		HolidayProviderStrategyMoveable x = new HolidayProviderStrategyMoveable();

		x.setParams(year, "M5.5.2");
		
		Method specifyStrategy =
			HolidayProviderStrategyMoveable.class.getDeclaredMethod("transformTemplate");
		specifyStrategy.setAccessible(true);

		String actual = (String) specifyStrategy.invoke(x);
		
		String expected = String.format("%d-" + dateTemplate, year); 
		
		assertEquals(actual, expected);
		
		System.out.println(actual);
		
	}
	
	/**
	 * Test 'handleLastOccurence' with
	 * May 30, 2011 (monday): Memorial Day (observed) [last monday in May] as
	 * "M5.L.2"
	 * 
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	//@Test
	public void X_030_Test() throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {

		HolidayProviderStrategyMoveable x = 
			new HolidayProviderStrategyMoveable();
		
		//x.setParams(2011, "M5.5.2");
		x.setParams(2011, "M11.4.5");

		Method handle =
			HolidayProviderStrategyMoveable.class.getDeclaredMethod("handleLastOccurence");
		
		handle.setAccessible(true);

		Calendar cal = (Calendar) handle.invoke(x);
		
		System.out.println(DateTimeUtils.calToString(cal));

	}


}
