/*
 * Copyright (c) 2011. Uli Fuchs <ufuchs@gmx.com>
 * Released under the terms of the GNU GPL v2.0.
 */

package de.z35.frugal.cli;

/**
 *
 * Created by IntelliJ IDEA.
 * User: ufuchs
 * Date: 29/07/11
 * Time: 21:44
 * To change this template use File | Settings | File Templates.
 */
public interface ArgumentExpander<T> {

	/**
	 * Expands a given argument by the use of so called <code>expanding rules</code>
	 * into an API compatible argument .
	 *
	 * </br>Example:
	 * </br>Commandline option with given argument is '--year 2011'
	 * </br>But the expected value inside the API is a from - to date.
	 * </br>So there must implement a rule, which converts a pure year into a
	 * 'from' date and into a 'to' date.
	 *
	 * @param argument
	 * @return
	 */
	T expand(String argument, ArgumentValidator validator);

}
