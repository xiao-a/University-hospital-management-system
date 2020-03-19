package com.uhms.uhms.dao.daoimpl;


import com.uhms.uhms.dao.dao.BedUseDao;
import com.uhms.uhms.entity.BedUseEntity;
import com.uhms.uhms.repository.BedUseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class BedUseDaoImpl implements BedUseDao {
    @Autowired
    private BedUseRepository bedUseRepository;
    public void insert(BedUseEntity bedEntity){
        bedUseRepository.save(bedEntity);
    }
}
