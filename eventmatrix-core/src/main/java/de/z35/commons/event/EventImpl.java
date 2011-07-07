package de.z35.commons.event;

/*
 * %W% %E%
 *
 * Copyright (c) 2011 Uli Fuchs <ufuchs@gmx.com>
 * All rights reserved.
 * Released under the terms of the GNU GPL v2.0.
 */

import java.util.Calendar;


public class EventImpl implements Event {

	/**
	 * 
	 * @param classifier
	 * @param dateAt
	 * @return
	 */
	public static Event createEvent(Integer classifier, Calendar dateAt) {
		
		Event e= new EventImpl();
		
		e.setClassifier(classifier);
		e.setDateAt(dateAt);
		
		return e;
				
	}

	private Integer classifier;
	private Calendar dateAt;

	/* (non-Javadoc)
	 * @see de.z35.commons.event.Event#getClassifier()
	 */
	public Integer getClassifier() {
		return this.classifier;
	}

	/* (non-Javadoc)
	 * @see de.z35.commons.event.Event#setClassifier(java.lang.Integer)
	 */
	public void setClassifier(Integer id) {
		this.classifier = id;
	}

	/* (non-Javadoc)
	 * @see de.z35.commons.event.Event#getDateAt()
	 */
	public Calendar getDateAt() {
		return this.dateAt;
	}

	/* (non-Javadoc)
	 * @see de.z35.commons.event.Event#setDateAt(java.util.Calendar)
	 */
	public void setDateAt(Calendar dateAt) {
		this.dateAt = dateAt;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("classifier : ").append(classifier).append(" | ");
		sb.append("dateAt : ")
			.append(dateAt.get(Calendar.YEAR))
			.append("-")			
			.append(dateAt.get(Calendar.MONTH) + 1)
			.append("-")
			.append(dateAt.get(Calendar.DATE))
			.append("\n");
		
		
		return sb.toString();
	}

}