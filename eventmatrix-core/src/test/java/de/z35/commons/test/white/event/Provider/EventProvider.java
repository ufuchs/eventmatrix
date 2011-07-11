package de.z35.commons.test.white.event.Provider;

import java.text.ParseException;
import java.util.Vector;

import org.testng.annotations.DataProvider;

import de.z35.commons.test.white.event.Event;
import de.z35.commons.test.white.event.EventImpl;
import de.z35.commons.test.white.event.Utils;

public class EventProvider {

	private static Object[][] SINGLE_DATE = new Object[][] {

		{1, "2011-06-01"},
		{2, "2011-06-02"},
		{1, "2011-06-03"},
		{2, "2011-06-04"},
		{1, "2011-06-05"},
		{2, "2011-06-06"},
		{1, "2011-06-07"},
		{2, "2011-06-08"},

	};

	/**
	 *
	 * @return
	 */
	@DataProvider(name = "singleDate")
	public static Object[][] getSingleDate() {
		return SINGLE_DATE;
	}

	/**
	 *
	 * @return
	 * @throws ParseException
	 */
	public static Vector<Event> getSingleDateAsVector() {

		Vector<Event> result = new Vector<Event>();

		for (Object[] event : SINGLE_DATE) {

			Event e = EventImpl.createEvent((Integer) event[0],
                    null, Utils.dateToCalendar((String) event[1]));

			result.add(e);

		}

		return result;
	}

}
