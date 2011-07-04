/*
 * %W% %E%
 *
 * Copyright (c) 2011 Uli Fuchs <ufuchs@gmx.com>
 * All rights reserved.
 * Released under the terms of the GNU GPL v2.0.
 */

package de.z35.commons.event;

import java.util.Calendar;
import java.util.Iterator;
import java.util.Vector;

public abstract class EventService {

	private int state;

	protected Vector<Event> events;

	/**
	 *
	 */
	public EventService() {}

	/**
	 *
	 */
	public EventService(Vector<Event> events) {
		this.events = events;
	}

	/**
	 *
	 */
	public void setState(int state, boolean enable) {

		if (enable) {
			this.state = this.state | state;
		} else {
			this.state = this.state & ~state;
		}

	}

	/**
	 *
	 */
	public boolean getState(int state) {
		return (this.state & state) == state;
	}

	/**
	 *
	 * @param at
	 * @param until
	 */
	protected void check(final Calendar at, final Calendar until) {

		assert at != null : "date 'at' can't be null";

		if (until == null) {
			return;
		}
		
		assert until.compareTo(at) <= 0: "date 'until' is lesser than date 'until'";

	}

	/**
	 *
	 * @return
	 */
	public Vector<Event> getEvents() {
		return this.events;
	}

	/**
	 * Gets a vector of inheritors of EventAbstract, which matches the params
	 *
	 * @param classifier Represents a kind of identifier for the content.
	 * @param from Date starting from.
	 * @param to Date until to.
	 * @return Inheritors of EventAbstract, which matches the criterias
	 *         <code>classifier</code>, <code>from</code> and <code>to</code>
	 */
	public abstract Vector<Event> getEvents(
			final Integer classifier, final Calendar at, Calendar until);

	/**
	 * Contract: </br>Drop all <code>EventAbstract</code> in the vector, which
	 * field <code>date</code> don't be located inside of <code>at</code> and
	 * <code>until</code>
	 *
	 * @param crossOuts
	 * @param from
	 * @param to
	 */
	public abstract Vector<Event> getEvents(final Calendar at,
			final Calendar until);

    /**
     *
     * @param at
     * @return
     */
    public boolean isWeekEnd(final Calendar at) {

        assert at != null : "'date' can't be null";

        int dayOfWeek = at.get(Calendar.DAY_OF_WEEK);

        return (dayOfWeek == Calendar.SATURDAY) || (dayOfWeek == Calendar.SUNDAY);

    }

    /**
     * 
     * @param eventMatrix
     * @param at
     * @param until
     */
	public void trimEvents(Vector<Event> eventMatrix, final Calendar at, final Calendar until) {

		check(at, until);
		
		// remove all days until 'to' date
		Iterator<? extends Event> it = eventMatrix.iterator();
		
		while (it.hasNext()) {

			Event event = it.next();

			if (event.getDateAt().before(at)) {
				it.remove();
			}
		}

		// remove all days starting by 'from' date until end of vector
		it = eventMatrix.iterator();
		while (it.hasNext()) {

			Event event = it.next();

			if (event.getDateAt().after(until)) {
				it.remove();
			}
		}

	}

}
