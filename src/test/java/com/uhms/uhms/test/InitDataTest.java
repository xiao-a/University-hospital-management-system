package com.uhms.uhms.test;

import com.uhms.uhms.UhmsApplication;
import com.uhms.uhms.entity.DoctorEntity;
import com.uhms.uhms.entity.PatientEntity;
import com.uhms.uhms.enums.SexEnum;
import com.uhms.uhms.service.service.DoctorService;
import com.uhms.uhms.service.service.PatientService;
import com.uhms.uhms.utils.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= UhmsApplication.class)
public class InitDataTest {
    @Autowired
    private DoctorService doctorService;
    DoctorEntity doctorEntity=new DoctorEntity();
    @Autowired
    private PatientService patientService;
    PatientEntity patientEntity=new PatientEntity();
    /**
     * 创建10条医生信息
     */
    @Test
    public void createDoctor()
    {
        for(int i=0;i<=9;i++){
            doctorEntity.setName("张三"+i);
            doctorEntity.setSex(SexEnum.MAN.getType());
            doctorEntity.setDivision("骨科");
            doctorEntity.setAge(20+i);
            doctorEntity.setStartWorkDate(DateUtils.getCurrentDate());
            doctorEntity.setPhoneNumber(i+"**********");
            doctorEntity.setUsername(i+"123");
            doctorEntity.setPassword(i+"123");
            doctorEntity.setEmail(i+"10086@qq.com");
            doctorService.insert(doctorEntity);
        }
    }
    /**
     * 创建10条病人信息
     */
    @Test
    public void createPatient()
    {
        for(int i=0;i<=9;i++){
            patientEntity.setName("李四"+i);
            patientEntity.setSex(SexEnum.WOMAN.getType());
            patientEntity.setAge(20+i);
            patientEntity.setUsername(i+"123");
            patientEntity.setPassword(i+"123");
            patientEntity.setPhoneNumber("10086****"+i);
            patientEntity.setAddress("###########"+i);
            patientService.insert(patientEntity);
        }
    }

}
