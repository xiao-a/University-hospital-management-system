package com.uhms.uhms.utils;

import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneUtils {
    /**
     * 验证手机号是否合法
     *  * @return
     */
    public static boolean isMobileNumber(String number) {
        if (StringUtils.isEmpty(number)) {
            return false;
        }
        if (11 != number.length()) {
            return false;
        }
        /**
         * 移动号段正则表达式
         */
        String pat1 = "^((13[4-9])|(147)|(15[0-2,7-9])|(178)|(18[2-4,7-8]))\\d{8}|(1705)\\d{7}$";
        /**
         * 联通号段正则表达式
         */
        String pat2 = "^((13[0-2])|(145)|(15[5-6])|(176)|(18[5,6]))\\d{8}|(1709)\\d{7}$";
        /**
         * 电信号段正则表达式
         */
        String pat3 = "^((133)|(153)|(177)|(18[0,1,9])|(149))\\d{8}$";
        /**
         * 虚拟运营商正则表达式
         */
        String pat4 = "^((170))\\d{8}|(1718)|(1719)\\d{7}$";

        Pattern pattern1 = Pattern.compile(pat1);
        Matcher match1 = pattern1.matcher(number);
        boolean isMatch1 = match1.matches();
        if (isMatch1) {
            return true;
        }
        Pattern pattern2 = Pattern.compile(pat2);
        Matcher match2 = pattern2.matcher(number);
        boolean isMatch2 = match2.matches();
        if (isMatch2) {
            return true;
        }
        Pattern pattern3 = Pattern.compile(pat3);
        Matcher match3 = pattern3.matcher(number);
        boolean isMatch3 = match3.matches();
        if (isMatch3) {
            return true;
        }
        Pattern pattern4 = Pattern.compile(pat4);
        Matcher match4 = pattern4.matcher(number);
        boolean isMatch4 = match4.matches();
        if (isMatch4) {
            return true;
        }
        return false;
    }
}
