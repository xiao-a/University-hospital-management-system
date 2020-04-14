package com.uhms.uhms.test;

import com.uhms.uhms.UhmsApplication;
import com.uhms.uhms.dto.DoctorDto;
import com.uhms.uhms.dto.PatientDto;
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
    DoctorDto doctorDto=new DoctorDto();
    @Autowired
    private PatientService patientService;
    PatientDto patientDto=new PatientDto();
    /**
     * 创建10条医生信息
     */
    @Test
    public void createDoctor()
    {
//        for(int i=0;i<=9;i++){
//            doctorDto.setName("张三"+i);
//            doctorDto.setSex(SexEnum.MAN.getType());
//            doctorDto.setDivision("骨科");
//            doctorDto.setAge(20+i);
//            doctorDto.setStartWorkDate(DateUtils.getCurrentDate());
//            doctorDto.setPhoneNumber(i+"**********");
//            doctorDto.setUsername(i+"123");
//            doctorDto.setPassword(i+"123");
//            doctorDto.setEmail(i+"10086@qq.com");
//            doctorService.insert(doctorDto);
//        }
    }
    /**
     * 创建10条病人信息
     */
    @Test
    public void createPatient()
    {
//        for(int i=0;i<=9;i++){
//            patientEntity.setName("李四"+i);
//            patientEntity.setSex(SexEnum.WOMAN.getType());
//            patientEntity.setAge(20+i);
//            patientEntity.setUsername(i+"123");
//            patientEntity.setPassword(i+"123");
//            patientEntity.setPhoneNumber("10086****"+i);
//            patientEntity.setAddress("###########"+i);
//            patientService.insert(patientEntity);
//        }
    }

}
