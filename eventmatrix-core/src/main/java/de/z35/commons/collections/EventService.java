/*
 * Copyright (c) 2011 Uli Fuchs <ufuchs@gmx.com>
 * Released under the terms of the GNU GPL v2.0.
 */

package de.z35.commons.collections;

import java.util.Iterator;
import java.util.Vector;

public class EventService<T> extends Vector<T>{

	// /////////////////////////////////////////////////////////////////////////
	// fields
	// /////////////////////////////////////////////////////////////////////////

	/**
	 * 
	 */
	private static final long serialVersionUID = -1972616780362106046L;
	
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
	public synchronized Vector<T> selectAll(Predicate<T> c) {

		Vector<T> result = new Vector<T>();

		for (int i = 0; i < super.elementData.length; i++){
			T t = (T)super.elementData[i];
			if (c.evaluate(t)) {
				result.add(t);
			}
			
		}
			
		
		
//		for (T t : (T) super.elementData) {
//
//			if (c.match(t)) {
//				result.add(t);
//			}
//
//		}

		return result;

	}

	/**
	 *
	 * @param elements
	 * @param c
	 */
	public static synchronized <T> void shrink(Vector<T> elements, Predicate<T> c) {

		Iterator<T> it = elements.iterator();

		while (it.hasNext()) {

			T t = it.next();

			if (c.evaluate(t)) {
				it.remove();
			}

		}

	}
	
	
}
