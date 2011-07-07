/*
 * %W% %E%
 *
 * Copyright (c) 2011 Uli Fuchs <ufuchs@gmx.com>
 * All rights reserved.
 * Released under the terms of the GNU GPL v2.0.
 */

package de.z35.commons.event;

import java.util.Iterator;
import java.util.Vector;

public class EventService {

	// /////////////////////////////////////////////////////////////////////////
	// fields
	// /////////////////////////////////////////////////////////////////////////

	protected Vector<Event> events;

	// /////////////////////////////////////////////////////////////////////////
	// ctor
	// /////////////////////////////////////////////////////////////////////////

	/**
	 *
	 */
	public EventService() {}

	/**
	 *
	 */
	public EventService(final Vector<Event> events) {
		this.events = events;
	}

	// /////////////////////////////////////////////////////////////////////////
	// properties
	// /////////////////////////////////////////////////////////////////////////

	/**
	 *
	 * @return
	 */
	public Vector<Event> getEvents() {
		return this.events;
	}

	/**
	 *
	 * @param criteria
	 * @return
	 */
	public Vector<Event> getEvents(final Criteria criteria) {

		Vector<Event> result = new Vector<Event>();

		for (Event e : this.events) {

			if (criteria.match(e)) {
				result.add(e);
			}

		}

		return result;

	}

	/**
	 *
	 * @param events
	 */
	public void setEvents(final Vector<Event> events) {
		this.events = events;
	}


	/**
	 *
	 * @param events
	 * @param criteria
	 */
	public void trimEvents(final Vector<Event> events, final Criteria criteria) {

		Iterator<Event> it = events.iterator();

		while (it.hasNext()) {

			Event e = it.next();

			if (criteria.match(e)) {
				it.remove();
			}

		}

	}

}
