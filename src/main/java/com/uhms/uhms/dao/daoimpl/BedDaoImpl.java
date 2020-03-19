package com.uhms.uhms.dao.daoimpl;

import com.uhms.uhms.dao.dao.BedDao;
import com.uhms.uhms.entity.BedEntity;
import com.uhms.uhms.repository.BedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BedDaoImpl implements BedDao {
    @Autowired
    private BedRepository bedRepository;
    public void insert(BedEntity bedEntity){
        bedRepository.save(bedEntity);
    }
}
