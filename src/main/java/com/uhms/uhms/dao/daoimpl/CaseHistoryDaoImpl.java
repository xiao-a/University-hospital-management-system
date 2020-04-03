package com.uhms.uhms.dao.daoimpl;

import com.uhms.uhms.dao.dao.CaseHistoryDao;
import com.uhms.uhms.entity.CaseHistoryEntity;
import com.uhms.uhms.repository.CaseHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CaseHistoryDaoImpl implements CaseHistoryDao {
    @Autowired
    private CaseHistoryRepository caseHistoryRepository;
    @Override
    public void insert(CaseHistoryEntity caseHistoryEntity) {
        caseHistoryRepository.save(caseHistoryEntity);
    }

    @Override
    public void deleteById(String id) {
        caseHistoryRepository.deleteById(id);
    }

    @Override
    public CaseHistoryEntity getById(String id) {
        return caseHistoryRepository.getOne(id);
    }

    @Override
    public List<CaseHistoryEntity> getAll() {
        return caseHistoryRepository.findAll();
    }

    @Override
    public void update(String id, CaseHistoryEntity caseHistoryEntity) {
        CaseHistoryEntity entity = getById(id);
        entity.setIllnessDescription(caseHistoryEntity.getIllnessDescription());
        entity.setBedUseId(caseHistoryEntity.getBedUseId());
        entity.setDoctorId(caseHistoryEntity.getDoctorId());
        entity.setDiagnosis(caseHistoryEntity.getDiagnosis());
    }
}
