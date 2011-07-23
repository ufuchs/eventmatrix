/*
 * Copyright (c) 2011. Uli Fuchs <ufuchs@gmx.com>
 * All rights reserved.
 * Released under the terms of the GNU GPL v2.0.
 */

package de.z35.frugal.cli;

/**
 * Created by IntelliJ IDEA.
 * User: ufuchs
 * Date: 23/07/11
 * Time: 20:10
 * To change this template use File | Settings | File Templates.
 */
public interface CliOption<T extends Enum<T>> {

	void setParam(String param);
	String getParam();

	void setOption(T t);
	T getOption();

}
