package cn.tortoise.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class DateHelper {
    private static final String FORMAT = "yyyy-MM-dd HH:mm:ss";


    public static Date parseDate(String dateStr){
        try {
            return new SimpleDateFormat(FORMAT).parse(dateStr);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return Calendar.getInstance().getTime();
    }

    public static Date parseDate(String format, String dateStr){
        try {
            return new SimpleDateFormat(format).parse(dateStr);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return new Date();
    }
}
