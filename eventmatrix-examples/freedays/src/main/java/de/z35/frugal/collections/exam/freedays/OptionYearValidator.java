/*
 * Copyright (c) 2011. Uli Fuchs <ufuchs@gmx.com>
 * Released under the terms of the GNU GPL v2.0.
 */

package de.z35.frugal.collections.exam.freedays;

/**
 * Many thanks to Jan Goyvaerts for his inspirations. See contributors.
 *
 * Created by IntelliJ IDEA.
 * User: ufuchs
 * Date: 27/07/11
 * Time: 22:52
 * To change this template use File | Settings | File Templates.
 */
public class OptionYearValidator {

	private String[] fromTo;

	/**
	 *
	 * @return
	 */
	private int validateFormal(String yearOption) {

		int errPos = 0;

		this.fromTo = yearOption.split("-");

		for (int i = 0; i < this.fromTo.length; i++) {

			// should match '10.2011'
			if (!fromTo[i].matches("^(\\d{1}|\\d{2})[. /.]\\d{4}")) {
				errPos = i + 1;
			}

		}

		return errPos;

	}

	/**
	 *
	 * @return
	 */
	private int validatePedantic(String yearOption) {

		int errPos = 0;

		for (int i = 0; i < this.fromTo.length; i++) {

			// should match for
			// - 1.2011
			// - 01.2011
			// - 10.2010
			if (!this.fromTo[i].matches("^([1-9]|0[1-9]|1[012])[. /.](19|20)\\d\\d$")) {
				errPos = i + 1;
			}

		}

		return errPos;

	}

	/**
	 *
	 * @param yearOption
	 * @return
	 */
	public int validate(String yearOption) {

		this.fromTo = yearOption.split("-");

		int errPos = this.validateFormal(yearOption);
		checkErr(errPos);

		errPos = validatePedantic(yearOption);
		checkErr(errPos);
		// check 'year' option

		return 0;

	}

	private void checkErr(int errPos) {
		// check 'year' option
		if (errPos != 0) {

			String date;
			String pattern;

			if (errPos == 1) {
				date = "first";
				pattern = "%s-xx.xxxx";
			} else {
				date = "second";
				pattern = "xx.xxxx-%s";
			}

			String format = String.format("error in option \'--year\' at %s date position \'%s\'", date, pattern);

			String msg = String.format(format, this.fromTo[errPos-1]);

			throw new IllegalArgumentException(msg);
		}
	}


}
