/*
 * Copyright (c) 2011. Uli Fuchs <ufuchs@gmx.com>
 * Released under the terms of the GNU GPL v2.0.
 */


package de.z35.commons.test.white.event.impl;

import java.util.Calendar;

import de.z35.commons.collections.Predicate;
import de.z35.commons.test.white.event.Order;

public class PredicateByOrderStatus implements Predicate<Order> {

	private Calendar from;
	private Calendar to;


    /**
     * Be aware! There is no protection against malformed arguments.
     *
     * @param from
     * @param to
     */
    public PredicateByOrderStatus(Calendar from, Calendar to) {
        this.from = from;
        this.to = to;

    }

    /**
     *
     * @param e
     * @return
     */
	public boolean evaluate(Order o) {

		return false;

	}

}
