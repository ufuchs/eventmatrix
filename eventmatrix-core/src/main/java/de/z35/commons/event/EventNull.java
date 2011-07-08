/*
 * Copyright (c) 2011 Uli Fuchs <ufuchs@gmx.com>
 * Released under the terms of the GNU GPL v2.0.
 */

package de.z35.commons.event;

import java.util.Calendar;

public class EventNull implements Event {

	public Integer getClassifier() {
		return 0;
	}

	public void setClassifier(Integer id) {}

    public String getClassifierVerbally() {
        return "";
    }

    public void setClassifierVerbally(String desc) {}

	public Calendar getDateAt() {
		return Calendar.getInstance();
	}

	public void setDateAt(Calendar dateAt) {}

	public boolean isNull() {
		return true;
	}
	
}
