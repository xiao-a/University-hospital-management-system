package com.uhms.uhms.test;

import com.uhms.uhms.UhmsApplication;
import com.uhms.uhms.dao.dao.DoctorDao;
import com.uhms.uhms.entity.AppointmentEntity;
import com.uhms.uhms.entity.DoctorEntity;
import com.uhms.uhms.enums.AppointmentStatusEnum;
import com.uhms.uhms.service.service.patient.AppointmentService;
import com.uhms.uhms.utils.DateUtils;
import com.uhms.uhms.utils.LogUtils;
import com.uhms.uhms.utils.SMSUtils;
import com.zhenzi.sms.ZhenziSmsClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= UhmsApplication.class)
public class FunctionTest {
    @Autowired
    AppointmentService appointmentService;
    @Autowired
    private DoctorDao doctorDao;
    @Test
    public void time(){
        String weekOfDate = DateUtils.getWeekOfDate();
        System.out.println(weekOfDate);
    }
    @Test
    public void selectByDivisionTest(){
        List<DoctorEntity> physician = doctorDao.selectByDivision("physician");
        System.out.println(physician);
    }

    @Test
    public void sendSMSTest(){
//        SMSUtils.sendMessage("15236561632","您的验证码为4534，有效时间为5分钟！");

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
        LogUtils.info("appointmentEntityByAppointmentDate:"+appointmentEntityByAppointmentDate);
    }


}
