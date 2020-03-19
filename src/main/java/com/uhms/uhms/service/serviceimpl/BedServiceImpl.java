package com.uhms.uhms.service.serviceimpl;

import com.uhms.uhms.dao.dao.BedDao;
import com.uhms.uhms.entity.BedEntity;
import com.uhms.uhms.repository.BedRepository;
import com.uhms.uhms.service.service.BedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class BedServiceImpl implements BedService {
    @Autowired
    private BedDao bedDao;
    public void insert(BedEntity bedEntity){
        bedDao.insert(bedEntity);
    }
}
