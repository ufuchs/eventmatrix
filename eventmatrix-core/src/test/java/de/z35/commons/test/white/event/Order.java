package de.z35.commons.test.white.event;

import java.util.Calendar;

public class Order {

	public static enum OrderState {
		order,
		confirmation,
		ship
	}

	OrderState state;
	Calendar date;

}
