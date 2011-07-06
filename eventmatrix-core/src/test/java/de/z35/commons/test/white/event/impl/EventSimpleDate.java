package de.z35.commons.test.white.event.impl;

/*
 * %W% %E%
 *
 * Copyright (c) 2011 Uli Fuchs <ufuchs@gmx.com>
 * All rights reserved.
 * Released under the terms of the GNU GPL v2.0.
 */

import java.util.Calendar;

import de.z35.commons.event.Event;

public class EventSimpleDate implements Event {

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

}
