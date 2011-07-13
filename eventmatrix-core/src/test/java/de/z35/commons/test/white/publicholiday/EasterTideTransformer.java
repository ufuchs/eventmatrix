package de.z35.commons.test.white.publicholiday;

import de.z35.commons.collections.Transformer;
import de.z35.commons.test.white.publicholiday.EasterTideProvider.DayOfTide;
import de.z35.commons.test.white.publicholiday.EasterTideProvider.EasterTide;

public class EasterTideTransformer implements Transformer<DayOfTide, Holiday> {
	
	/**
	 *
	 * @return
	 */
	private String nameOfDay(EasterTide dayOfTide) {

		String result = null;

		String[] parts = dayOfTide.name().split("_");

		for (String part : parts) {

			String capitalized = part.substring(0,1)
				+ part.substring(1).toLowerCase() + " ";

			if (result == null) {
				result = capitalized;
			} else {
				result += capitalized;
			}

		}

		return result.trim();
	}

	/**
	 * 
	 */
	@Override
	public Holiday transform(DayOfTide t) {
		
		return Holiday.createHoliday(t.getDate(), nameOfDay(t.getDayOfTide()));
		
	}

}
