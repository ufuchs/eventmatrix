/*
 * Copyright (c) 2011 Uli Fuchs <ufuchs@gmx.com>
 * Released under the terms of the GNU GPL v2.0.
 */

package de.z35.commons.collections.exam.freedays;

public class FreeDays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		OptionProvider op = new OptionProvider();
		op.populateOptions(FreeDayCliOption.OPTIONS_DESC);


		
		System.out.print("test");
		
	}

}
