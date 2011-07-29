/*
 * Copyright (c) 2011. Uli Fuchs <ufuchs@gmx.com>
 * Released under the terms of the GNU GPL v2.0.
 */

package de.z35.frugal.cli;

import org.apache.commons.cli.*;

/**
 * Created by IntelliJ IDEA.
 * User: ufuchs
 * Date: 23/07/11
 * Time: 21:01
 * To change this template use File | Settings | File Templates.
 */
public class CliOptionService {

	private String[] args;

	private Options options;

	private CommandLine cmd;

	/**
	 *
	 * @param args
	 * @return
	 */
	public CliOptionService withArgs(String[] args) {
		this.args = args;
		return  this;
	}

	/**
	 *
	 * @param descriptor
	 * @return
	 */
	public CliOptionService withOptions(Object[][] descriptor) {

		this.options = this.populateOptions(descriptor);
		return this;

	}

	/**
	 *
	 * @param descriptor
	 */
	private Options populateOptions(Object[][] descriptor) {

		OptionProvider op = new OptionProvider();
		op.populateOptions(descriptor);

		return op.getOptions();

	}

	/**
	 *
	 * @throws ParseException
	 */
	public void parse() throws ParseException {

		CommandLineParser parser = new PosixParser();

		this.cmd = parser.parse(this.options, this.args);

	}

}
