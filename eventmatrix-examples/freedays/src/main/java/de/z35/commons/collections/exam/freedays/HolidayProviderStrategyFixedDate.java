/*
 * Copyright (c) 2011. Uli Fuchs <ufuchs@gmx.com>
 * All rights reserved.
 * Released under the terms of the GNU GPL v2.0.
 */

package de.z35.commons.collections.exam.freedays;

/**
 * Created by IntelliJ IDEA.
 * User: ufuchs
 * Date: 14/07/11
 * Time: 21:15
 * To change this template use File | Settings | File Templates.
 */
public class HolidayProviderStrategyFixedDate implements HolidayProviderStrategy {

	private int year; 
	private String dateTemplate;
	
    @Override
    public String transformTemplate() {

		String format = "%d-" + dateTemplate;

		return String.format(format, this.year);

    }

	@Override
	public void setParams(int year, String dateTemplate) {
		
		this.year = year;
		this.dateTemplate = dateTemplate;
				
	}

}
