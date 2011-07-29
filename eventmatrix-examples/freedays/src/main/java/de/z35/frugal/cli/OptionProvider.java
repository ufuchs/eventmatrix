/*
 * Copyright (c) 2011. Uli Fuchs <ufuchs@gmx.com>
 * Released under the terms of the GNU GPL v2.0.
 */

package de.z35.frugal.cli;

import org.apache.commons.cli.Options;

public class OptionProvider {

	static int O_OPT = 0;
	static int O_LONGOPT = 1;
	static int O_HASARG = 2;
	static int O_DESC = 3;

	protected Options options = new Options();

	/**
	 *
	 * @return
	 */
	public Options getOptions() {
		return this.options;
	}

	/**
	 * @param optionsDescs
	 */
	public void populateOptions(Object[][] optionsDescs) {

		for (Object[] optionDesc : optionsDescs) {

			String opt = (String) optionDesc[O_OPT];
			String longOpt = (String) optionDesc[O_LONGOPT];
			boolean hasArg = (Boolean) optionDesc[O_HASARG];
			String desc = (String) optionDesc[O_DESC];

			if ("".equals(longOpt)) {
				options.addOption(opt, hasArg, desc);
			} else {
				options.addOption(opt, longOpt, hasArg, desc);
			}

		}

	}

	/**
	 * Add more complex options which couldn't be handled by standard manner
	 */
	private void addExtraOptions() {

	}
}