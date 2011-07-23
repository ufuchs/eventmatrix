/*
 * Copyright (c) 2011. Uli Fuchs <ufuchs@gmx.com>
 * Released under the terms of the GNU GPL v2.0.
 */

package de.z35.frugal.cli;

/**
 * Created by IntelliJ IDEA.
 * User: ufuchs
 * Date: 23/07/11
 * Time: 20:10
 * To change this template use File | Settings | File Templates.
 *
 * @see http://stackoverflow.com/questions/1173290/using-java-generics-with-enums
 */
public abstract class CliOption<T extends Enum<T>> {

	private T option;

	private String param;

	public void setParam(String param) {
		this.param = param;
	}

	public String getParam() {
		return this.param;
	}

	public void setOption(T option) {
		this.option = option;
	}

	public T getOption() {
		return  this.option;
	}



}
