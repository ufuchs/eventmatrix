package de.z35.commons.test.white.event;

import de.z35.commons.event.EventService;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import de.z35.commons.test.white.event.Provider.EventProvider;
import de.z35.commons.test.white.event.Provider.ProviderEasterTide;
import de.z35.commons.test.white.event.impl.CriteriaByClassifier;
import de.z35.commons.test.white.event.impl.CriteriaByDateFromTo;
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
		EventService<Event> es = new EventService<Event>();
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

		EventService<Event> es = new EventService<Event>();

		es.setElements(events);

        assertNotNull(es.getElements());
	}

    /**
     *
     * @throws ParseException
     */
	@Test
	public void X_040_Test() throws ParseException {

		EventService<Event> es = new EventService<Event>();

		es.setElements(EventProvider.getSingleDateAsVector());

        Vector<Event> actual = es.selectAll(new CriteriaByClassifier(1));

        assertEquals(actual.size(), 4);

	}

    /**
     *
     * @throws ParseException
     */
	@Test
	public void X_050_Test() {

		EventService<Event> es = new EventService<Event>();

		es.setElements(EventProvider.getSingleDateAsVector());

        Calendar from = Utils.dateToCalendar("2011-06-04");
        Calendar to = Utils.dateToCalendar("2011-06-06");

        Vector<Event> actual = es.selectAll(new CriteriaByDateFromTo(from, to));

        assertEquals(actual.size(), 3);

	}

    /**
     *
     * @throws ParseException
     */
	@Test
	public void X_060_Test() throws ParseException {

		EventService<Event> es = new EventService<Event>();

		es.setElements(EventProvider.getSingleDateAsVector());

        Calendar from = Utils.dateToCalendar("2011-06-04");
        Calendar to = Utils.dateToCalendar("2011-06-04");

        Vector<Event> actual = es.selectAll(new CriteriaByDateFromTo(from, to));

        assertEquals(actual.size(), 1);

	}

	@Test
	public void X_070_Test() throws Exception {

		ProviderEasterTide easterDate = new ProviderEasterTide();

		Calendar year = Utils.dateToCalendar("2011-01-01");

		Vector<Event> cycleDays = easterDate.getEasterTide(year);
		
		System.out.println(cycleDays.toString());

	}


}

