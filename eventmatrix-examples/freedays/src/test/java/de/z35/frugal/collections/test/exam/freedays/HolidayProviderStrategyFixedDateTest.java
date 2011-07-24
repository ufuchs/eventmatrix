package de.z35.frugal.collections.test.exam.freedays;

import java.util.Vector;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import de.z35.frugal.collections.CollectionUtils;
import de.z35.frugal.collections.Predicate;
import de.z35.frugal.collections.exam.freedays.*;

public class HolidayProviderStrategyFixedDateTest {

    private static Object[][] FIXEDHOLIDAYS_en_US = new Object[][] {

    	// January 1, 2011 (saturday): New Year's Day [Jan. 1 every year]
    	{"01-01"},
        // July 4, 2011 (monday): Independence Day [July 4th every year]
        {"07-04"},

        // November 11, 2011 (friday): Veterans' Day [Nov. 11 every year]
        {"11-11"},

        // December 25, 2011 (sunday): Christmas Day [Dec. 25 every year]
        {"12-25"},

    };

    /**
     *
     * @return
     */
    @DataProvider(name = "fixedHoliDay_en_US_Provider")
    public Object[][] fixedHoliDay_en_US_Provider() {
        return FIXEDHOLIDAYS_en_US;
    }

	@Test
	public void X_010_Test() {

        HolidayProviderStrategyFixedDate strategy = new HolidayProviderStrategyFixedDate();
        assertNotNull(strategy);

	}

	@Test(dataProvider = "fixedHoliDay_en_US_Provider")
	public void X_020_Test(String dateTemplate) {

        HolidayProviderStrategyFixedDate strategy = new HolidayProviderStrategyFixedDate();

        int year = 2011;

        strategy.setParams(year, dateTemplate);

        String actual = strategy.transformTemplate();

        String expected = String.format("%d-" + dateTemplate, year);

        assertEquals(actual, expected);

	}

}
