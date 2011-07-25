/*
 * Copyright (c) 2011. Uli Fuchs <ufuchs@gmx.com>
 * Released under the terms of the GNU GPL v2.0.
 */

package de.z35.frugal.collections.exam.freedays;

import java.text.DateFormat;
import java.util.Date;
import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * User: ufuchs
 * Date: 25/07/11
 * Time: 20:13
 * To change this template use File | Settings | File Templates.
 */
public class FreeDaysMvc {


	private int maxNameLen;

	private int maxDateLen;

	private int dateStyle;

	/**
	 *
	 * @param dateStyle
	 */
	public FreeDaysMvc(int dateStyle) {
		this.dateStyle = dateStyle;
	}

	/**
	 *
	 * @return
	 */
	public int getMaxNameLen() {
		return maxNameLen;
	}

	/**
	 *
	 * @param holidays
	 * @return
	 */
	public void calcDimensions(Vector<Holiday> holidays) {

		maxNameLen = 0;
		maxDateLen = 0;

		for (Holiday holiday : holidays) {

			int nameLen = holiday.getName().length();

			if (nameLen > maxNameLen) {
				maxNameLen = nameLen;
			}

			Date date = holiday.getDate().getTime();

			int dateLen = DateFormat.getDateInstance(this.dateStyle).format(date).length();

			if (dateLen > maxDateLen) {
				maxDateLen = dateLen;
			}

		}



	}

	/**
	 *
	 * @param date
	 * @return
	 */
	public String formatDate(Date date) {

		String result = DateFormat.getDateInstance(this.dateStyle).format(date);

		String format = String.format("%%%ds", -maxDateLen);

		return String.format(format, result);
	}

}
