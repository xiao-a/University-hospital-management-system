package com.uhms.uhms.test;

import com.uhms.uhms.UhmsApplication;
import com.uhms.uhms.dao.dao.BedDao;
import com.uhms.uhms.entity.BedEntity;
import com.uhms.uhms.enums.BedStatusEnum;
import com.uhms.uhms.repository.BedRepository;
import com.uhms.uhms.service.service.BedService;
import com.uhms.uhms.utils.IdUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes= UhmsApplication.class)
public class FristTest {

    @Autowired
    private BedDao bedRepository;
    Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Test
    public  void test()
    {
        //插入
//        for(int i=0;i<10;i++) {
//            BedEntity bed = new BedEntity();
//            bed.setId(IdUtils.createID("bed"));
//            bed.setDivision("内科");
//            bed.setStatus(BedStatusEnum.IDLE.getType());
//            bedRepository.insert(bed);
//        }
        //删除
//        bedRepository.deleteById("158462633153930061598-bed");

        //查询
//        logger.info(bedRepository.getById("158462633134428697002-bed"));
//        logger.info(bedRepository.getAll());
//        修改
        BedEntity bedEntity =new BedEntity();
        bedEntity.setId("158462633153120787271-bed");
        bedEntity.setDivision("jinshen科");
        bedRepository.update(bedEntity);
        logger.info(bedRepository.getById("158462633150859610598-bed"));




    }

}
