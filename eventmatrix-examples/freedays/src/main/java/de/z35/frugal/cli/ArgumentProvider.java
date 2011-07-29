/*
 * Copyright (c) 2011. Uli Fuchs <ufuchs@gmx.com>
 * Released under the terms of the GNU GPL v2.0.
 */

package de.z35.frugal.cli;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: ufuchs
 * Date: 29/07/11
 * Time: 20:25
 * To change this template use File | Settings | File Templates.
 */
public class ArgumentProvider {

	// /////////////////////////////////////////////////////////////////////////
	// fields
	// /////////////////////////////////////////////////////////////////////////

	private HashMap<String, String> params = new HashMap<String, String>();

	private ArgumentValidator validator;

	// /////////////////////////////////////////////////////////////////////////
	// ctor
	// /////////////////////////////////////////////////////////////////////////

	/**
	 *
	 * @param validator
	 */
	public ArgumentProvider(ArgumentValidator validator) {
		this.validator = validator;
	}

	/**
	 *
	 */
	public ArgumentProvider() {}

	// /////////////////////////////////////////////////////////////////////////
	// production
	// /////////////////////////////////////////////////////////////////////////

	/**
	 *
	 * @param argument
	 * @throws IllegalArgumentException
	 */
	public void process(String argument) throws IllegalArgumentException {

		if (this.validator != null) {
			this.validator.validate((argument));
		}

	}

}
