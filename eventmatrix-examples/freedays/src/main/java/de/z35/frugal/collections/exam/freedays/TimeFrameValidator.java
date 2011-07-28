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
 *
 * design issues:
 * MMXI-07-28 z35	if someday a validation against DD.MM.YYYY is necessary
 * 					please introduce a strategy pattern.
 */
public class TimeFrameValidator {

	public enum KindOfTimeFrame {
		NOTHING,
		YY,
		YYMM,
		YYMM_YYMM
	}

	private static String YEAR_ONLY = "^(\\d{4})$";

	private static String FORMAL_MMYY = "^(\\d{1}|\\d{2})[. /.]\\d{4}$";

	private static String PEDANTIC_MMYY = "^([1-9]|0[1-9]|1[012])[. /.](19|20)\\d\\d$";

	private String[] fromTo;

	private KindOfTimeFrame kindOfTimeFrame = KindOfTimeFrame.NOTHING;

	/**
	 *
	 * @return
	 */
	public String[] getFromTo() {
		return this.fromTo;
	}

	/**
	 *
	 * @return
	 */
	public KindOfTimeFrame getKindOfTimeFrame() {
		return this.kindOfTimeFrame;
	}


	/**
	 *
	 * @param timeFrame
	 * @param pattern
	 * @return
	 */
	private int doValidate(String timeFrame, String pattern) {

		int errPos = 0;

		for (int i = 0; i < this.fromTo.length; i++) {

			// should match '10.2011'
			if (!fromTo[i].matches(pattern)) {
				errPos = i + 1;
			}

		}

		return errPos;

	}

	/**
	 *
	 * @param timeFrame
	 * @return
	 */
	public int validate(String timeFrame) {

		int argLen = timeFrame.length();

		if (argLen < 4) {

			String msg = String.format("argument \'%s\' to short.");
			throw new IllegalArgumentException(msg);

		}

		if (argLen == 4) {

			if (timeFrame.matches(YEAR_ONLY)) {
				this.kindOfTimeFrame = KindOfTimeFrame.YY;
				return 0;
			} else {
			  	throw new IllegalArgumentException();
			}

		}

		this.fromTo = timeFrame.split("-");

		// pure assumption
		// if an error has occurred 'kindOfTimeFrame' falls back to KindOfTimeFrame.NOTHING
		switch (this.fromTo.length) {
			case 1 :
				this.kindOfTimeFrame = KindOfTimeFrame.YYMM;
				break;
			case 2 :
				this.kindOfTimeFrame = KindOfTimeFrame.YYMM_YYMM;
				break;
		}

		int errPos = this.doValidate(timeFrame, FORMAL_MMYY);
		checkErr(errPos);

		errPos = this.doValidate(timeFrame, PEDANTIC_MMYY);
		checkErr(errPos);
		// check 'year' option

		return 0;

	}

	/**
	 *
	 * @param errPos
	 */
	private void checkErr(int errPos) {

		if (errPos != 0) {

			this.kindOfTimeFrame = KindOfTimeFrame.NOTHING;

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
