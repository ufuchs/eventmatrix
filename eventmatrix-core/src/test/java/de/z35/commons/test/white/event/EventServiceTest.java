package de.z35.commons.test.white.event;

import de.z35.commons.event.Event;
import de.z35.commons.event.EventService;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import de.z35.commons.event.Utils;
import de.z35.commons.test.white.event.Provider.EventProvider;
import de.z35.commons.test.white.event.impl.CriteriaByClassifier;
import de.z35.commons.test.white.event.impl.CriteriaByDateFromTo;
import de.z35.commons.test.white.event.impl.ProviderEasterDate;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Vector;

public class EventServiceTest {

	/**
	 *
	 */
	@Test
	public void X_010_Test() {
		EventService es = new EventService();
		assertNotNull(es);
	}

	/**
	 *
	 * @throws ParseException
	 */
	@Test
	public void X_020_Test() throws ParseException {
		Vector<Event> events = EventProvider.getSingleDateAsVector();
		assertNotNull(events);
	}

	/**
	 *
	 * @throws ParseException
	 */
	@Test
	public void X_030_Test() throws ParseException {

		Vector<Event> events = EventProvider.getSingleDateAsVector();

		EventService es = new EventService();

		es.setEvents(events);

        assertNotNull(es.getEvents());
	}

    /**
     *
     * @throws ParseException
     */
	@Test
	public void X_040_Test() throws ParseException {

		EventService es = new EventService();

		es.setEvents(EventProvider.getSingleDateAsVector());

        Vector<Event> actual = es.getEvents(new CriteriaByClassifier(1));

        assertEquals(actual.size(), 4);

	}

    /**
     *
     * @throws ParseException
     */
	@Test
	public void X_050_Test() throws ParseException {

		EventService es = new EventService();

		es.setEvents(EventProvider.getSingleDateAsVector());

        Calendar from = Utils.dateToCalendar("2011-06-04");
        Calendar to = Utils.dateToCalendar("2011-06-06");

        Vector<Event> actual = es.getEvents(new CriteriaByDateFromTo(from, to));

        assertEquals(actual.size(), 3);

	}

    /**
     *
     * @throws ParseException
     */
	@Test
	public void X_060_Test() throws ParseException {

		EventService es = new EventService();

		es.setEvents(EventProvider.getSingleDateAsVector());

        Calendar from = Utils.dateToCalendar("2011-06-04");
        Calendar to = Utils.dateToCalendar("2011-06-04");

        Vector<Event> actual = es.getEvents(new CriteriaByDateFromTo(from, to));

        assertEquals(actual.size(), 1);

	}

	@Test
	public void X_070_Test() throws Exception {

		ProviderEasterDate easterDate = new ProviderEasterDate();

		Calendar year = Utils.dateToCalendar("2011-01-01");

		Vector<Event> cycleDays = easterDate.getEvents(year);
		
		System.out.println(cycleDays.toString());

	}


}

