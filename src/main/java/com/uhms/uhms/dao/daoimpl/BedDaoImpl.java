package com.uhms.uhms.dao.daoimpl;

import com.uhms.uhms.dao.dao.BedDao;
import com.uhms.uhms.entity.BedEntity;
import com.uhms.uhms.repository.BedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BedDaoImpl implements BedDao {
    @Autowired
    private BedRepository bedRepository;

    /**
     * 插入病床信息
     * @param bedEntity
     */
    public void insert(BedEntity bedEntity){
        bedRepository.save(bedEntity);
    }

    @Override
    public void deleteById(String id) {
        bedRepository.deleteById(id);
    }

    @Override
    public BedEntity getById(String id) {
        return bedRepository.getOne(id);
    }

    @Override
    public List<BedEntity> getAll() {
        return bedRepository.findAll();
    }

    @Override
    public void update(BedEntity bedEntity) {
        bedRepository.save(bedEntity);
    }
}
