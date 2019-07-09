package com.academik.minitse.utils;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author esvux
 */
public class DateUtils {

    public static Date truncateDate(Date date) {
        Calendar cal = Calendar.getInstance(); // locale-specific
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 12);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

}
