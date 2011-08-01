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
public class ArgumentProvider<T> {

	// /////////////////////////////////////////////////////////////////////////
	// fields
	// /////////////////////////////////////////////////////////////////////////

	private T apiArgument;

	private ArgumentValidator validator;

	private ArgumentExpander<T> expander;

	// /////////////////////////////////////////////////////////////////////////
	// ctor
	// /////////////////////////////////////////////////////////////////////////

	/**
	 *
	 */
	public ArgumentProvider() {}

	// /////////////////////////////////////////////////////////////////////////
	// setters
	// /////////////////////////////////////////////////////////////////////////

	public T getApiArgument() {
		return apiArgument;
	}

	/**
	 *
	 * @param validator
	 */
	public void setValidator(ArgumentValidator validator) {
		this.validator = validator;
	}

	/**
	 *
	 * @param expander
	 */
	public void setExpander(ArgumentExpander<T> expander) {
		this.expander = expander;
	}

	// /////////////////////////////////////////////////////////////////////////
	// production
	// /////////////////////////////////////////////////////////////////////////

	/**
	 * Provides an API compatible argument.
	 *
	 * @param argument Raw argument from the commandline
	 * @throws IllegalArgumentException
	 */
	public void process(String argument) throws IllegalArgumentException {

		if (argument == null) {
			throw new IllegalArgumentException("argument can't be null.");
		}

		if ("".equals(argument)) {
			throw new IllegalArgumentException("argument can't be empty.");
		}

		if (this.validator != null) {
			this.validator.validate((argument));
		}

		if (this.expander != null) {
			this.apiArgument = this.expander.expand(argument, this.validator);
		}

	}

}
