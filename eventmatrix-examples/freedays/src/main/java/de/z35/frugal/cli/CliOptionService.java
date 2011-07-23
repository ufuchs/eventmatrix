/*
 * Copyright (c) 2011. Uli Fuchs <ufuchs@gmx.com>
 * All rights reserved.
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

	CommandLineParser parser = new PosixParser();

	public String[] args;

	Options options;


	public CliOptionService withArgs(String[] args) {
		this.args = args;
		return  this;
	}

	public CliOptionService withOptions(Options options) {
		this.options = options;
		return this;
	}


	public void parse() throws ParseException {
		CommandLine cmd = parser.parse( options, args);

	}

}
