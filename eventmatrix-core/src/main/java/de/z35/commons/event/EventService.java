package de.z35.commons.event;

import java.util.Iterator;
import java.util.Vector;

public class EventService<T> {

	// /////////////////////////////////////////////////////////////////////////
	// fields
	// /////////////////////////////////////////////////////////////////////////

	protected Vector<T> elements;

	// /////////////////////////////////////////////////////////////////////////
	// ctor
	// /////////////////////////////////////////////////////////////////////////

	/**
	 *
	 */
	public EventService() {}

	/**
	 *
	 */
	public EventService(final Vector<T> elements) {
		this.elements = elements;
	}

	// /////////////////////////////////////////////////////////////////////////
	// properties
	// /////////////////////////////////////////////////////////////////////////

	/**
	 *
	 * @return
	 */
	public Vector<T> getElements() {
		return this.elements;
	}

	/**
	 *
	 * @param elements
	 */
	public void setElements(Vector<T> elements) {
		this.elements = elements;
	}
	
	/**
	 *
	 * @param c
	 * @return
	 */
	public Vector<T> selectAll(Criteria<T> c) {

		Vector<T> result = new Vector<T>();

		for (T t : this.elements) {

			if (c.match(t)) {
				result.add(t);
			}

		}

		return result;

	}

	/**
	 *
	 * @param elements
	 * @param c
	 */
	public static <T> void shrink(Vector<T> elements, Criteria<T> c) {

		Iterator<T> it = elements.iterator();

		while (it.hasNext()) {

			T t = it.next();

			if (c.match(t)) {
				it.remove();
			}

		}

	}
	
	
}
