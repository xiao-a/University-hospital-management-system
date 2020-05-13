package com.uhms.uhms.schedule;

import com.uhms.uhms.utils.LogUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Scheduler{
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    //每隔2秒执行一次
    @Scheduled(fixedRate = 2000)
    public void testTasks01() {
        LogUtils.info("每隔2秒执行一次:"+dateFormat.format(new Date()));
    }

//    //每天3：05执行
//    @Scheduled(cron = "0 05 03 ? * *")
//    public void testTasks02() {
//        System.out.println("定时任务执行时间：" + dateFormat.format(new Date()));
//    }


}
