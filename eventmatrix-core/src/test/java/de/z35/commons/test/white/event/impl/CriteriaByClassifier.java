/*
 * Copyright (c) 2011. Uli Fuchs <ufuchs@gmx.com>
 * Released under the terms of the GNU GPL v2.0.
 */

package de.z35.commons.test.white.event.impl;

import de.z35.commons.event.Criteria;
import de.z35.commons.test.white.event.Event;

/**
 * Created by IntelliJ IDEA.
 * User: ufuchs
 * Date: 06/07/11
 * Time: 20:20
 * To change this template use File | Settings | File Templates.
 */
public class CriteriaByClassifier implements Criteria<Event> {

    private Integer classifier;

    /**
     *
     * @param classifier
     */
    public CriteriaByClassifier(Integer classifier) {

        assert classifier != null : "'classifier' can't be null.";
        this.classifier = classifier;

    }

    /**
     * Compares a given <code>classifier</code> against the field <code>classifier</code> of the <code>Event</code> instance.
     * Be aware! There is no protection against malformed arguments.
     *
     *
     * @param e
     * @return
     */
    public boolean match(Event e) {

        return e.getClassifier().compareTo(this.classifier) != 0;

    }

}
