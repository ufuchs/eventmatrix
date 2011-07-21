/*
 * Copyright (c) 2011. Uli Fuchs <ufuchs@gmx.com>
 * All rights reserved.
 * Released under the terms of the GNU GPL v2.0.
 */

package de.z35.commons.collections.test.exam.freedays;

import de.z35.commons.collections.exam.freedays.HolidayProvider;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

/**
 * Created by IntelliJ IDEA.
 * User: ufuchs
 * Date: 18/07/11
 * Time: 18:23
 * To change this template use File | Settings | File Templates.
 */
public class HolidayProviderTest {


    public static Object[][] HOLIDAYS_2011_en_US = new Object[][] {

            {"2011-01-01", "01-01", "New Year's Day"},
            {"2011-01-17", "M1.3.2", "Martin Luther King Day"},
            {"2011-02-21", "M2.3.2", "Presidents Day"},
            {"2011-05-30", "M5.5.2", "Memorial Day"},
            {"2011-07-04", "07-04", "Independence Day"},
            {"2011-09-05", "M9.1.2", "Labor Day"},
            {"2011-10-10", "M10.2.2", "Columbus Day"},
            {"2011-11-11", "11-11", "Veterans' Day"},
            {"2011-11-24", "M11.4.5", "Thanksgiving Day"},
            {"2011-12-25", "12-25", "Christmas Day"}

    };

    @DataProvider(name = "holidays_2011_en_US_Provider")
    public Object[][] holidays_2011_en_US_Provider() {
        return HOLIDAYS_2011_en_US;
    }

    /**
     * 
     */
    @Test
    public void X_010_Test() {

        HolidayProvider itsFHP = new HolidayProvider(null);
        assertNotNull(itsFHP);

    }

    /**
     * 
     * @param expected
     * @param dateTemplate
     * @param name
     * @throws SecurityException
     * @throws NoSuchMethodException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    @Test(dataProvider = "holidays_2011_en_US_Provider")
    public void X_020_Test(String expected, String dateTemplate, String name) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {

    	int year = 2011;

        HolidayProvider provider = new HolidayProvider(null);

		Method getDate =
			HolidayProvider.class.getDeclaredMethod("getDate", int.class, String.class);

		getDate.setAccessible(true);

		String actual = (String) getDate.invoke(provider, year, dateTemplate);

		assertEquals(actual, expected);

    }

}
