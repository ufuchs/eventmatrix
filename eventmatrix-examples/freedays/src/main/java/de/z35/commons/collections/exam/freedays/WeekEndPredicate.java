/*
 * Copyright (c) 2011 Uli Fuchs <ufuchs@gmx.com>
 * Released under the terms of the GNU GPL v2.0.
 */

package de.z35.commons.collections.exam.freedays;

import de.z35.commons.collections.Predicate;

/**
 * 
 * @author ufuchs
 *
 */
public class WeekEndPredicate implements Predicate<Holiday>
{

	@Override
	public boolean evaluate(Holiday t) {

		return t.isOnWeekEnd();
	}

}
