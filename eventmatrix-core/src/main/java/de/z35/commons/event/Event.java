/*
 * %W% %E%
 *
 * Copyright (c) 2011 Uli Fuchs <ufuchs@gmx.com>
 * All rights reserved.
 * Released under the terms of the GNU GPL v2.0.
 */

package de.z35.commons.event;

import java.util.Calendar;

public interface Event {

	Integer getClassifier();

	void setClassifier(final Integer id);

	Calendar getDateAt();

	void setDateAt(final Calendar dateAt);

}