/*
 * Copyright (c) 2011. Uli Fuchs <ufuchs@gmx.com>
 * Released under the terms of the GNU GPL v2.0.
 */

package de.z35.cli.test;

import de.z35.frugal.cli.ArgumentProvider;
import de.z35.frugal.cli.TimeFrame;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by IntelliJ IDEA.
 * User: ufuchs
 * Date: 29/07/11
 * Time: 21:00
 * To change this template use File | Settings | File Templates.
 */
public class ArgumentProviderTest {

	/**
	 *
	 */
	@Test
	public void X_010_Test() {

		ArgumentProvider provider = new ArgumentProvider();
		Assert.assertNotNull(provider);

	}

	/**
	 *
	 */
	@Test
	public void X_020_Test() {

		ArgumentProvider<TimeFrame> provider = new ArgumentProvider<TimeFrame>();
		Assert.assertNotNull(provider);

	}

	/**
	 *
	 */
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void X_030_Test() {

		ArgumentProvider provider = new ArgumentProvider();

		provider.setValidator(null);

		provider.process(null);

	}

}
