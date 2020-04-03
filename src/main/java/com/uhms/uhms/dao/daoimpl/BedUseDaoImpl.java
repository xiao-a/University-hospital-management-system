package com.uhms.uhms.dao.daoimpl;


import com.uhms.uhms.dao.dao.BedUseDao;
import com.uhms.uhms.entity.BedUseEntity;
import com.uhms.uhms.repository.BedUseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class BedUseDaoImpl implements BedUseDao {
    @Autowired
    private BedUseRepository bedUseRepository;
    public void insert(BedUseEntity bedEntity){
        bedUseRepository.save(bedEntity);
    }

    @Override
    public void deleteById(String id) {
        bedUseRepository.deleteById(id);
    }

    @Override
    public BedUseEntity getById(String id) {
        return bedUseRepository.getOne(id);
    }

    @Override
    public List<BedUseEntity> getAll() {
        return bedUseRepository.findAll();
    }

    @Override
    public void update(String id, BedUseEntity bedUseEntity) {
        BedUseEntity entity = getById(id);
        entity.setPatientId(bedUseEntity.getPatientId());
        entity.setStartDate(bedUseEntity.getStartDate());
        entity.setEndDate(bedUseEntity.getEndDate());
        bedUseRepository.save(entity);
    }
}
