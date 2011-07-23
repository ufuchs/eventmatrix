/*
 * Copyright (c) 2011. Uli Fuchs <ufuchs@gmx.com>
 * All rights reserved.
 * Released under the terms of the GNU GPL v2.0.
 */

package de.z35.commons.collections.exam.freedays;

import de.z35.frugal.cli.CliOption;

/**
 * Created by IntelliJ IDEA.
 * User: ufuchs
 * Date: 23/07/11
 * Time: 20:24
 * To change this template use File | Settings | File Templates.
 */
public class FreeDayCliOption extends CliOption<FreeDayCliOption.Options>{

	/**
	 * command line options
	 */
	public static Object[][] OPTIONS_DESC = new Object[][] {

		{ "p", "public", false, "lists the public holidays in your country" },
		{ "w", "weekend", false, "lists the weekends" },

	};

	public enum Options {
	   PUBLIC_HOLIDAY,
	   WEEKEND
   	}

	public Options transform(String o) {

		return null;


	}

}
