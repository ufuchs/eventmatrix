package de.z35.commons.event;

/*
 * %W% %E%
 *
 * Copyright (c) 2011 Uli Fuchs <ufuchs@gmx.com>
 * All rights reserved.
 * Released under the terms of the GNU GPL v2.0.
 */

import java.util.Calendar;

public class Event {

	private Integer classifier;
	private Calendar dateAt;
	private Calendar dateUntil;

	public Integer getClassifier() {
		return this.classifier;
	}

	public void setClassifier(Integer id) {
		this.classifier = id;
	}

	public Calendar getDateAt() {
		return this.dateAt;
	}

	public void setDateAt(Calendar dateAt) {
		this.dateAt = dateAt;
	}

	public Calendar getDateUntil() {
		return dateUntil;
	}

	public void setDateUntil(Calendar dateUntil) {
		this.dateUntil = dateUntil;
	}
	
	
}
