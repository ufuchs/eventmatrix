package de.z35.commons.collections.exam.freedays;

/**
 * Created by IntelliJ IDEA.
 * User: ufuchs
 * Date: 14/07/11
 * Time: 21:21
 * To change this template use File | Settings | File Templates.
 */
public interface HolidayProviderStrategy {
	void setParams(int year, String dateTemplate);
    String transformTemplate();
}
