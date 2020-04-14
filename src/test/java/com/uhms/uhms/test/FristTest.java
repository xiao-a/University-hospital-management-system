package com.uhms.uhms.test;

import com.uhms.uhms.UhmsApplication;
import com.uhms.uhms.dao.dao.BedDao;
import com.uhms.uhms.entity.BedEntity;
import com.uhms.uhms.enums.BedStatusEnum;
import com.uhms.uhms.repository.BedRepository;
import com.uhms.uhms.service.service.BedService;
import com.uhms.uhms.service.service.ChangeHospitalService;
import com.uhms.uhms.utils.IdUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Table;


@RunWith(SpringRunner.class)
@SpringBootTest(classes= UhmsApplication.class)
public class FristTest {

    @Autowired
    private BedDao bedDao;
    @Autowired
    private ChangeHospitalService changeHospitalService;

    Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    /**
     * 插入
     */
    @Test
    public  void testInset() {
        for(int i=0;i<10;i++) {
            BedEntity bed = new BedEntity();
            bed.setDivision("内科");
            bed.setUseStatus(BedStatusEnum.IDLE.getType());
            bedDao.insert(bed);
        }

    }

    /**
     *  查询
     */
    @Test
    public void testDelete() {
        logger.info(bedDao.getById("158462633134428697002-bed"));
        logger.info(bedDao.getAll());
    }

    @Test
    public void testUpdate() {
        BedEntity entity = bedDao.getById("158588395023721143559_bed");
        entity.setUseStatus(BedStatusEnum.IN_USE.getType());
        bedDao.update("158588395023721143559_bed",entity);
        logger.info(bedDao.getById("158588395023721143559_bed"));
    }


    @Test
    public void testChangeHospitalGetList(){
        System.out.println(changeHospitalService.findAll());
    }

}
