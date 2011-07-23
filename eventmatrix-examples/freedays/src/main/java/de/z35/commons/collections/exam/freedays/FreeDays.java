/*
 * Copyright (c) 2011 Uli Fuchs <ufuchs@gmx.com>
 * Released under the terms of the GNU GPL v2.0.
 */

package de.z35.commons.collections.exam.freedays;

public class FreeDays {

	/**
	 * command line options
	 */
	private static Object[][] FREEDAY_CLI_OPTIONS = new Object[][] {
		
		{ "p", "public", false, "lists the public holidays in your country" },
		{ "w", "weekend", false, "lists the weekends" },

	};

	 enum FreeDayOptions {
		PUBLIC_HOLIDAY,
		WEEKEND
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {

		OptionProvider op = new OptionProvider();
		op.populateOptions(FREEDAY_CLI_OPTIONS);
		
		System.out.print("test");
		
	}

}
