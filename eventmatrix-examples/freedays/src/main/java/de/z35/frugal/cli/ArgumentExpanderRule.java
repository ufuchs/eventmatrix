/*
 * Copyright (c) 2011. Uli Fuchs <ufuchs@gmx.com>
 * Released under the terms of the GNU GPL v2.0.
 */

package de.z35.frugal.cli;

/**
 * Created by IntelliJ IDEA.
 * User: ufuchs
 * Date: 30/07/11
 * Time: 20:32
 * To change this template use File | Settings | File Templates.
 */
public interface ArgumentExpanderRule<T> {

	String getRuleName();

	T expand(String argument);

}
