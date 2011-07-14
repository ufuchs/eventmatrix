package de.z35.commons.collections.exam.freedays;

import de.z35.commons.collections.Predicate;

public class WeekEndPredicate implements Predicate<Holiday>
{

	@Override
	public boolean evaluate(Holiday t) {

		return t.isOnWeekEnd();
	}

}
