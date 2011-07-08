/*
 * Copyright (c) 2011 Uli Fuchs <ufuchs@gmx.com>
 * Released under the terms of the GNU GPL v2.0.
 */

package de.z35.commons.event;

import java.util.Calendar;

public class EventNull implements Event {

	@Override
	public Integer getClassifier() {
		return 0;
	}

	@Override
	public void setClassifier(Integer id) {}

	@Override
	public Calendar getDateAt() {
		return Calendar.getInstance();
	}

	@Override
	public void setDateAt(Calendar dateAt) {}

	
	public boolean isNull() {
		return true;
	}
	
}
