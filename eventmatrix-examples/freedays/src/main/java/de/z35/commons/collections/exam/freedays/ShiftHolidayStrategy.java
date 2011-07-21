/*
 * Copyright (c) 2011 Uli Fuchs <ufuchs@gmx.com>
 * Released under the terms of the GNU GPL v2.0.
 */

package de.z35.commons.collections.exam.freedays;

/**
 * Created by IntelliJ IDEA.
 * User: ufuchs
 * Date: 21/07/11
 * Time: 21:58
 * To change this template use File | Settings | File Templates.
 */
public interface ShiftHolidayStrategy {

	Holiday shiftHoliday(Holiday origin);
	
}
