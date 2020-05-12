package com.uhms.uhms.test;

import com.uhms.uhms.UhmsApplication;
import com.uhms.uhms.dao.dao.*;
import com.uhms.uhms.entity.*;
import com.uhms.uhms.enums.DayWeekEnum;
import com.uhms.uhms.enums.DivisionTypeEnum;
import com.uhms.uhms.enums.SexEnum;
import com.uhms.uhms.utils.DateUtils;
import com.uhms.uhms.utils.IdUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= UhmsApplication.class)
public class InitDataTest {
    @Autowired
    private DoctorDao doctorDao;
    DoctorEntity doctorEntity=new DoctorEntity();
    @Autowired
    private PatientDao patientDao;
    PatientEntity patientEntity=new PatientEntity();
    @Autowired
    private ChangeHospitalDao changeHospitalDao;
    ChangeHospitalEntity changeHospitalEntity=new ChangeHospitalEntity();
    @Autowired
    private WatchListDao watchListDao;
    WatchListEntity watchListEntity=new WatchListEntity();
    @Autowired
    private AdminDao adminDao;
    AdminEntity adminEntity=new AdminEntity();
    @Autowired
    private NewsDao newsDao;
    NewsEntity newsEntity=new NewsEntity();
    /**
     * 创建10条医生信息
     */
    @Test
    public void createDoctor()
    {
        for(int i=0;i<=2;i++){
            doctorEntity.setName("内科-张三-"+i);
            doctorEntity.setSex(SexEnum.MAN.getType());
            doctorEntity.setDivision(DivisionTypeEnum.getTypeByName("内科"));
            doctorEntity.setAge(20+i);
            doctorEntity.setStartWorkDate(DateUtils.getCurrentDate());
            doctorEntity.setPhoneNumber(i+"**********");
            doctorEntity.setUsername("nk"+i);
            doctorEntity.setPassword("nk"+i);
            doctorEntity.setEmail(i+"10086@qq.com");
            doctorEntity.setAddress("内科"+i+"号");
            doctorDao.insert(doctorEntity);
        }
        for(int i=0;i<=2;i++){
            doctorEntity.setName("外科-张三-"+i);
            doctorEntity.setSex(SexEnum.MAN.getType());
            doctorEntity.setDivision(DivisionTypeEnum.getTypeByName("外科"));
            doctorEntity.setAge(20+i);
            doctorEntity.setStartWorkDate(DateUtils.getCurrentDate());
            doctorEntity.setPhoneNumber(i+"**********");
            doctorEntity.setUsername("wk"+i);
            doctorEntity.setPassword("wk"+i);
            doctorEntity.setEmail(i+"10086@qq.com");
            doctorEntity.setAddress("外科"+i+"号");
            doctorDao.insert(doctorEntity);
        }
        for(int i=0;i<=2;i++){
            doctorEntity.setName("妇科-张三-"+i);
            doctorEntity.setSex(SexEnum.MAN.getType());
            doctorEntity.setDivision(DivisionTypeEnum.getTypeByName("妇科"));
            doctorEntity.setAge(20+i);
            doctorEntity.setStartWorkDate(DateUtils.getCurrentDate());
            doctorEntity.setPhoneNumber(i+"**********");
            doctorEntity.setUsername("fk"+i);
            doctorEntity.setPassword("fk"+i);
            doctorEntity.setEmail(i+"10086@qq.com");
            doctorEntity.setAddress("妇科"+i+"号");
            doctorDao.insert(doctorEntity);
        }
        for(int i=0;i<=2;i++){
            doctorEntity.setName("骨科-张三-"+i);
            doctorEntity.setSex(SexEnum.MAN.getType());
            doctorEntity.setDivision(DivisionTypeEnum.getTypeByName("骨科"));
            doctorEntity.setAge(20+i);
            doctorEntity.setStartWorkDate(DateUtils.getCurrentDate());
            doctorEntity.setPhoneNumber(i+"**********");
            doctorEntity.setUsername("gk"+i);
            doctorEntity.setPassword("gk"+i);
            doctorEntity.setEmail(i+"10086@qq.com");
            doctorEntity.setAddress("骨科"+i+"号");
            doctorDao.insert(doctorEntity);
        }
        for(int i=0;i<=2;i++){
            doctorEntity.setName("五官科-张三-"+i);
            doctorEntity.setSex(SexEnum.MAN.getType());
            doctorEntity.setDivision(DivisionTypeEnum.getTypeByName("五官科"));
            doctorEntity.setAge(20+i);
            doctorEntity.setStartWorkDate(DateUtils.getCurrentDate());
            doctorEntity.setPhoneNumber(i+"**********");
            doctorEntity.setUsername("wgk"+i);
            doctorEntity.setPassword("wgk"+i);
            doctorEntity.setEmail(i+"10086@qq.com");
            doctorEntity.setAddress("五官科"+i+"号");
            doctorDao.insert(doctorEntity);
        }
        for(int i=0;i<=2;i++){
            doctorEntity.setName("皮肤科-张三-"+i);
            doctorEntity.setSex(SexEnum.MAN.getType());
            doctorEntity.setDivision(DivisionTypeEnum.getTypeByName("皮肤科"));
            doctorEntity.setAge(20+i);
            doctorEntity.setStartWorkDate(DateUtils.getCurrentDate());
            doctorEntity.setPhoneNumber(i+"**********");
            doctorEntity.setUsername("pfk"+i);
            doctorEntity.setPassword("pfk"+i);
            doctorEntity.setEmail(i+"10086@qq.com");
            doctorEntity.setAddress("皮肤科"+i+"号");
            doctorDao.insert(doctorEntity);
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
            patientEntity.setUsername("patient"+i);
            patientEntity.setPassword("patient"+i);
            patientEntity.setPhoneNumber("10086****"+i);
            patientEntity.setAddress("###########"+i);
            patientDao.insert(patientEntity);
        }
    }

    /**
     * 创建10条管理员信息
     */
    @Test
    public void createAdmin()
    {
        for(int i=0;i<=9;i++){
            adminEntity.setName("王五"+i);
            adminEntity.setSex(SexEnum.WOMAN.getType());
            adminEntity.setAge(20+i);
            adminEntity.setUsername("admin"+i);
            adminEntity.setPassword("admin"+i);
            adminEntity.setPhoneNumber("10086****"+i);
            adminEntity.setAddress("###########"+i);
            adminDao.insert(adminEntity);
        }
    }


    /**
     * 创建10条病人信息
     */
    @Test
    public void createChangeHospital()
    {
        for(int i=0;i<=9;i++){
            changeHospitalEntity.setDoctorId(IdUtils.createID("doctor"));
            changeHospitalEntity.setPatientId(IdUtils.createID("patient"));
            changeHospitalEntity.setChangeHospitalDate(DateUtils.getCurrentDate());
            changeHospitalEntity.setChangeHospitalName("河南省第"+i+1+"甲医院");
            changeHospitalDao.insert(changeHospitalEntity);
        }
    }

    /**
     * 创建值班表
     */
    @Test
    public void createWatchList()
    {
        List<DoctorEntity> physician = doctorDao.selectByDivision("physician");
        List<DoctorEntity> surgery = doctorDao.selectByDivision("surgery");
        List<DoctorEntity> gynecology = doctorDao.selectByDivision("gynecology");
        List<DoctorEntity> orthopedics = doctorDao.selectByDivision("orthopedics");
        List<DoctorEntity> ophthalmology = doctorDao.selectByDivision("ophthalmology");
        List<DoctorEntity> dermatology = doctorDao.selectByDivision("dermatology");
        //周一
        watchListEntity.setDayWeek(DayWeekEnum.getTypeByName("星期一"));
        watchListEntity.setNkDoctorId(physician.get(0).getDoctorId());
        watchListEntity.setWkDoctorId(surgery.get(0).getDoctorId());
        watchListEntity.setFkDoctorId(gynecology.get(0).getDoctorId());
        watchListEntity.setGkDoctorId(orthopedics.get(0).getDoctorId());
        watchListEntity.setWgkDoctorId(ophthalmology.get(0).getDoctorId());
        watchListEntity.setPfkDoctorId(dermatology.get(0).getDoctorId());
        watchListDao.insert(watchListEntity);
        //周二
        watchListEntity.setDayWeek(DayWeekEnum.getTypeByName("星期二"));
        watchListEntity.setNkDoctorId(physician.get(1).getDoctorId());
        watchListEntity.setWkDoctorId(surgery.get(1).getDoctorId());
        watchListEntity.setFkDoctorId(gynecology.get(1).getDoctorId());
        watchListEntity.setGkDoctorId(orthopedics.get(1).getDoctorId());
        watchListEntity.setWgkDoctorId(ophthalmology.get(1).getDoctorId());
        watchListEntity.setPfkDoctorId(dermatology.get(1).getDoctorId());
        watchListDao.insert(watchListEntity);
        //周三
        watchListEntity.setDayWeek(DayWeekEnum.getTypeByName("星期三"));
        watchListEntity.setNkDoctorId(physician.get(2).getDoctorId());
        watchListEntity.setWkDoctorId(surgery.get(2).getDoctorId());
        watchListEntity.setFkDoctorId(gynecology.get(2).getDoctorId());
        watchListEntity.setGkDoctorId(orthopedics.get(2).getDoctorId());
        watchListEntity.setWgkDoctorId(ophthalmology.get(2).getDoctorId());
        watchListEntity.setPfkDoctorId(dermatology.get(2).getDoctorId());
        watchListDao.insert(watchListEntity);
        //周四
        watchListEntity.setDayWeek(DayWeekEnum.getTypeByName("星期四"));
        watchListEntity.setNkDoctorId(physician.get(0).getDoctorId());
        watchListEntity.setWkDoctorId(surgery.get(0).getDoctorId());
        watchListEntity.setFkDoctorId(gynecology.get(0).getDoctorId());
        watchListEntity.setGkDoctorId(orthopedics.get(0).getDoctorId());
        watchListEntity.setWgkDoctorId(ophthalmology.get(0).getDoctorId());
        watchListEntity.setPfkDoctorId(dermatology.get(0).getDoctorId());
        watchListDao.insert(watchListEntity);
        //周五
        watchListEntity.setDayWeek(DayWeekEnum.getTypeByName("星期五"));
        watchListEntity.setNkDoctorId(physician.get(1).getDoctorId());
        watchListEntity.setWkDoctorId(surgery.get(1).getDoctorId());
        watchListEntity.setFkDoctorId(gynecology.get(1).getDoctorId());
        watchListEntity.setGkDoctorId(orthopedics.get(1).getDoctorId());
        watchListEntity.setWgkDoctorId(ophthalmology.get(1).getDoctorId());
        watchListEntity.setPfkDoctorId(dermatology.get(1).getDoctorId());
        watchListDao.insert(watchListEntity);
        //周六
        watchListEntity.setDayWeek(DayWeekEnum.getTypeByName("星期六"));
        watchListEntity.setNkDoctorId(physician.get(2).getDoctorId());
        watchListEntity.setWkDoctorId(surgery.get(2).getDoctorId());
        watchListEntity.setFkDoctorId(gynecology.get(2).getDoctorId());
        watchListEntity.setGkDoctorId(orthopedics.get(2).getDoctorId());
        watchListEntity.setWgkDoctorId(ophthalmology.get(2).getDoctorId());
        watchListEntity.setPfkDoctorId(dermatology.get(2).getDoctorId());
        watchListDao.insert(watchListEntity);
        //周日
        watchListEntity.setDayWeek(DayWeekEnum.getTypeByName("星期日"));
        watchListEntity.setNkDoctorId(physician.get(0).getDoctorId());
        watchListEntity.setWkDoctorId(surgery.get(0).getDoctorId());
        watchListEntity.setFkDoctorId(gynecology.get(0).getDoctorId());
        watchListEntity.setGkDoctorId(orthopedics.get(0).getDoctorId());
        watchListEntity.setWgkDoctorId(ophthalmology.get(0).getDoctorId());
        watchListEntity.setPfkDoctorId(dermatology.get(0).getDoctorId());
        watchListDao.insert(watchListEntity);
    }


    /**
     * 创建4条新闻信息
     */
    @Test
    public void createNews()
    {
        for(int i=0;i<=3;i++){
            newsEntity.setNewsImg("/file/20160821230024_MyCYK.thumb.700_0.jpeg");
            newsEntity.setNewsText("JJJJJJJJJJJ>"+i+"<KKKKKKKKKKK");
            newsEntity.setNewsTitle("Title>"+i+"<Title");
            newsDao.insert(newsEntity);
        }
    }



}
