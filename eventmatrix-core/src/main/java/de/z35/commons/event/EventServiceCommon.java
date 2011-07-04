package de.z35.commons.event;

import java.util.Calendar;
import java.util.Vector;

public class EventServiceCommon extends EventService {
	
	@Override
	protected void check(final Calendar at,	final Calendar until) {

		super.check(at, until);
		
		assert super.events != null;
		
	}
	
	@Override
	public Vector<Event> getEvents(final Integer classifier, final Calendar at,	final Calendar until) {

		this.check(at, until);
		
		Vector<Event> result = new Vector<Event>();
		
		for (Event e : super.events) {
			
			if (!e.getClassifier().equals(classifier)) {
				continue;
			}	
				
			boolean hit = isMatchingEvent(e, at, until);
			
			if (hit) {
				result.add(e);
			}
			
		}
		
		return result;
		
	}

	@Override
	public Vector<Event> getEvents(final Calendar at, final Calendar until) {
		
		this.check(at, until);
		
		Vector<Event> result = new Vector<Event>();
		
		for (Event e : super.events) {
				
			boolean hit = isMatchingEvent(e, at, until);
			
			if (hit) {
				result.add(e);
			}
			
		}
		
		return result;
	}

	/**
	 * 
	 * @param e
	 * @param at
	 * @param until
	 * @return
	 */
	private boolean isMatchingEvent(final Event e, final Calendar at, final Calendar until) {

		boolean hit = e.getDateAt().compareTo(at) >= 0;
		
		if (until != null) {
			
			hit &= e.getDateUntil().compareTo(until) <= 0;
			
		}
		
		return hit;
		
	}
	
}
