package com.uhms.uhms.test;

import com.uhms.uhms.UhmsApplication;
import com.uhms.uhms.dao.dao.BedDao;
import com.uhms.uhms.entity.BedEntity;
import com.uhms.uhms.enums.BedStatusEnum;
import com.uhms.uhms.repository.BedRepository;
import com.uhms.uhms.service.service.BedService;
import com.uhms.uhms.utils.IdUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= UhmsApplication.class)
public class FristTest {

    @Autowired
    private BedService bedRepository;
    @Test
    public  void test()
    {
        BedEntity bed=new BedEntity();
        bed.setId(IdUtils.createID("bed"));
        bed.setDivision("内科");
        bed.setStatus(BedStatusEnum.IDLE.getType());
        bedRepository.insert(bed);
    }

}
