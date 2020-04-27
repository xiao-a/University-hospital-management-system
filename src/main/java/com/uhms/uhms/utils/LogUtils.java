package com.uhms.uhms.utils;

import com.uhms.uhms.enums.LogGradeEnum;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LogUtils {
    /** 默认可以打印 */
    private static boolean enable = true;
    /** 默认打印所有级别日志 */
    private static LogGradeEnum minLevel = LogGradeEnum.ALL;
    /** 日期显示格式 */
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");

    /**
     * <pre>
     * 设置是否开启打印
     * </pre>
     *
     * @author ygr
     * @date 2018年4月9日 上午9:54:46
     * @param enable
     */
    public static void setEnable(boolean enable) {
        LogUtils.enable = enable;
    }
    /**
     * <pre>
     * 设置日志打印级别
     * </pre>
     *
     * @author ygr
     * @date 2018年4月9日 上午9:42:09
     * @param level
     */
    public static void setLogLevel(LogGradeEnum level) {
        LogUtils.minLevel = level;
    }

    /**
     * <pre>
     * 打印消息级别日志
     * </pre>
     *
     * @author ygr
     * @date 2018年4月9日 上午9:42:59
     * @param msg
     *            待打印消息
     */
    public static void info(String msg) {
        finalPrint(LogGradeEnum.INFO, msg);
    }

    /**
     * <pre>
     * 打印警告级别日志
     * </pre>
     *
     * @author ygr
     * @date 2018年4月9日 上午9:42:59
     * @param msg
     *            待打印消息
     */
    public static void warn(String msg) {
        finalPrint(LogGradeEnum.WARN, msg);
    }

    /**
     * <pre>
     * 打印错误级别日志
     * </pre>
     *
     * @author ygr
     * @date 2018年4月9日 上午9:42:59
     * @param msg
     *            待打印消息
     */
    public static void error(String msg) {
        finalPrint(LogGradeEnum.ERROR, msg);
    }

    /**
     * <pre>
     * 最终打印日志
     * </pre>
     *
     * @author ygr
     * @date 2018年4月9日 上午9:50:21
     * @param logLevel
     *            日志级别
     * @param msg
     *            待打印消息
     */
    private static void finalPrint(LogGradeEnum logLevel, String msg) {
        if (!enable) {
            return;
        }
        if (logLevel.isAllow(minLevel)) {
            System.out.printf("%s %s %s\n", formatCurrentTime(), logLevel.getName(), msg);
        }
    }

    /**
     * <pre>
     * 获取当前时间
     * </pre>
     *
     * @author ygr
     * @date 2018年4月9日 上午9:49:00
     * @return
     */
    private static String formatCurrentTime() {
        return sdf.format(new Date());
    }

    /**


     LogUtils.info("这是info消息");
     LogUtils.warn("这是warn消息");
     LogUtils.error("这是error消息");
     LogUtils.setEnable(false);
     LogUtils.info("这是info消息");
     LogUtils.setEnable(true);
     Thread.sleep(1000);
     LogUtils.setLogLevel(LogLevel.WARN);
     LogUtils.info("这是info消息");
     LogUtils.warn("这是warn消息");
     LogUtils.error("这是error消息");

     https://www.imooc.com/article/25275?block_id=tuijian_wz

     */
}
