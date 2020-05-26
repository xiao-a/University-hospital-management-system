package com.uhms.uhms.schedule;

import com.uhms.uhms.entity.AppointmentEntity;
import com.uhms.uhms.enums.AppointmentStatusEnum;
import com.uhms.uhms.service.service.patient.AppointmentService;
import com.uhms.uhms.utils.DateUtils;
import com.uhms.uhms.utils.LogUtils;
import com.uhms.uhms.utils.SMSUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class Scheduler{
    @Autowired
    private AppointmentService appointmentService;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

//    //每隔2秒执行一次
//    @Scheduled(fixedRate = 2000)
//    public void testTasks01() {
//        LogUtils.info("每隔2秒执行一次:"+dateFormat.format(new Date()));
//    }

//    //每天3：05执行
//    @Scheduled(cron = "0 05 03 ? * *")
//    public void testTasks02() {
//        System.out.println("定时任务执行时间：" + dateFormat.format(new Date()));
//    }

    //每天早上8点执行提醒预约功能
    @Scheduled(cron="0 0 8 * * ?")
    public void appointment() {
        List<AppointmentEntity> appointmentEntityByAppointmentDate = appointmentService.getAppointmentEntityByAppointmentDate(AppointmentStatusEnum.CONFIRMED.getType());
        Long startTime = DateUtils.getStartTime();
        Long endTime = DateUtils.getEndTime();
        for(int i=0;i<appointmentEntityByAppointmentDate.size();i++){
            long time = appointmentEntityByAppointmentDate.get(i).getAppointmentDate().getTime()-86399999;
//            LogUtils.info("startTime:"+startTime);
//            LogUtils.info("endTime:"+endTime);
//            LogUtils.info("dateTime:"+appointmentEntityByAppointmentDate.get(i).getAppointmentDate());
//            LogUtils.info("time:"+time);
//            LogUtils.info("cha:"+(endTime-startTime));
            if(time>startTime&&time<endTime){
                LogUtils.info("恭喜你获得的被提醒的权利！");
            }
        }
    }


}
