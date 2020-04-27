package com.uhms.uhms.test;

import com.uhms.uhms.UhmsApplication;
import com.uhms.uhms.dao.dao.DoctorDao;
import com.uhms.uhms.entity.DoctorEntity;
import com.uhms.uhms.utils.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= UhmsApplication.class)
public class FunctionTest {
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


}
