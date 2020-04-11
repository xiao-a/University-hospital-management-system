package com.uhms.uhms.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

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

}