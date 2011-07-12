package de.z35.commons.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

/*
 * This IS and WILL NOT BE any substitute against the famous apache.commons.collections - framework
 * Only a lightweight implementation for a special purpose inspired from. 
 */
public class Utils {

	/**
	 * Selects all elements from input collection which match the given predicate into an output collection.
	 * @param <T>
	 * @param c
	 * @param p
	 * @param reject
	 * @return
	 * @see http://commons.apache.org/collections/apidocs/org/apache/commons/collections/CollectionUtils.html#select(java.util.Collection, org.apache.commons.collections.Predicate)
	 */
	public static synchronized <T> Collection<T> select(Collection<T> c, Predicate<T> p) {

		Collection<T> result = new Vector<T>();
		
		Iterator<T> it = c.iterator();

		while (it.hasNext()) {

			T e = it.next();

			if (p.evaluate(e)) {
				result.add(e);
			}

		}
		
		return result;
		
	}

	/**
	 * Selects all elements from inputCollection which don't match the given predicate into an output collection.
	 * @param <T>
	 * @param c
	 * @param p
	 * @see http://commons.apache.org/collections/apidocs/org/apache/commons/collections/CollectionUtils.html
	 */
	public static synchronized <T> Collection<T> selectRejected(Collection<T> c, Predicate<T> p) {

		Collection<T> result = new Vector<T>();
		
		Iterator<T> it = c.iterator();

		while (it.hasNext()) {

			T e = it.next();

			if (!p.evaluate(e)) {
				result.add(e);
			}

		}
		
		return result;
		
	}
	
}
