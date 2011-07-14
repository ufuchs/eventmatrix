package de.z35.commons.collections.exam.freedays;

/**
 * Created by IntelliJ IDEA.
 * User: ufuchs
 * Date: 14/07/11
 * Time: 21:21
 * To change this template use File | Settings | File Templates.
 */
public interface FixedHolidayProviderStrategy {
    String transformTemplate(int year, String dateTemplate);
}
