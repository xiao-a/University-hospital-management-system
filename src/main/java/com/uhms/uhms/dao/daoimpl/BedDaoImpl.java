package com.uhms.uhms.dao.daoimpl;

import com.uhms.uhms.dao.dao.BedDao;
import com.uhms.uhms.entity.BedEntity;
import com.uhms.uhms.repository.BedRepository;
import com.uhms.uhms.utils.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class BedDaoImpl implements BedDao {


    @Autowired
    private BedRepository bedRepository;
    @Override
    public void insert(BedEntity bedEntity) {
        bedEntity.setId(IdUtils.createID("bed"));
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
    public void update(String id, BedEntity bedEntity) {
        BedEntity entity = getById(id);
        entity.setStatus(bedEntity.getStatus());
        entity.setDivision(bedEntity.getDivision());
        bedRepository.save(bedEntity);
    }
}
