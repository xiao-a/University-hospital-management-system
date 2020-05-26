package com.uhms.uhms.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;

/**
 * 日期常用方法
 *
 * @author
 *
 */
public class DateUtils {
    /**
     * 获取当前时间
     *
     */
    public static  Date getCurrentDate() {
        return new Date();// new Date()为获取当前系统时间
    }
    /**
     * 显示当前时间的年月日
     */
    public static String  showYearMonthDayStr(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);

    }
    /**
     * 将string类型的时间转换成date类型
     */
    public static Date StringToDate(String date){
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String str = " 00:00:00";
        Date parse = null;
        try {
            parse = sim.parse(date + str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }

    /**
     * 获取今天日期是星期几<br>
     *
     * @return 当前日期是星期几
     */
    public static String getWeekOfDate() {
        String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
        Calendar cal = Calendar.getInstance();
        cal.setTime(getCurrentDate());
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }
    /**
     * 获取今天日期是星期几<br>
     *
     * @return 传入一个日期是获取那天是星期几
     */
    public static String getWeekOfDateX(Date date) {
        String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }
    /**
     * 将Date类型转成String
     */
    public static String DateToString(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }

    public static String DateToStrHH(Date date) {
        return DateToString(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static String DateToStr(Date date) {
        return DateToString(date, "yyyy-MM-dd");
    }

    /**
     * 获取当天的开始时间 单位：毫秒
     * @return
     */
    public static Long getStartTime(){
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime().getTime();
    }


    /**
     * 获取当天的结束时间 单位：毫秒
     * @return
     */
    public static Long getEndTime(){
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime().getTime();
    }

}