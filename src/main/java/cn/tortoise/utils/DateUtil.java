package cn.tortoise.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class DateUtil {
    private static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String DATE_FORMAT = "yyyy-MM-dd";

    public static Date parseDate(String str) throws ParseException {
        return parseDate(DATE_FORMAT, str);
    }

    public static Date parseDatetime(String dateStr){
        try {
            return parseDate(DATETIME_FORMAT, dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }

    public static Date parseDate(String format, String dateStr) throws ParseException {

        return new SimpleDateFormat(format).parse(dateStr);

    }


    public static String toString(Date date){
        return new SimpleDateFormat(DATETIME_FORMAT).format(date);
    }
}
