package com.uhms.uhms.dao.daoimpl;


import com.uhms.uhms.dao.dao.PatientCaseDao;
import com.uhms.uhms.entity.PatientCaseEntity;
import com.uhms.uhms.enums.DataStatusEnum;
import com.uhms.uhms.repository.PatientCaseRepository;
import com.uhms.uhms.utils.DateUtils;
import com.uhms.uhms.utils.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PatientCaseDaoImpl implements PatientCaseDao {

    @Autowired
    private PatientCaseRepository patientCaseRepository;
    @Override
    public void insert(PatientCaseEntity patientCaseEntity) {
        patientCaseEntity.setPatientCaseId(IdUtils.createID("patientCase"));
        patientCaseEntity.setCreateDate(DateUtils.getCurrentDate());
        patientCaseEntity.setUpdateDate( DateUtils.getCurrentDate());
        patientCaseEntity.setStatus(DataStatusEnum.VALID.getType());
        patientCaseRepository.save(patientCaseEntity);
    }

    @Override
    public void deleteById(String id) {
        patientCaseRepository.deleteById(id);
    }

    @Override
    public PatientCaseEntity getById(String id) {
        return patientCaseRepository.getOne(id);
    }

    @Override
    public List<PatientCaseEntity> getAll() {
        return patientCaseRepository.findAll();
    }

    @Override
    public void update(PatientCaseEntity patientCaseEntity) {
        patientCaseEntity.setUpdateDate(DateUtils.getCurrentDate());
        patientCaseRepository.save(patientCaseEntity);
    }

    @Override
    public List<PatientCaseEntity> getPatientCaseEntitiesByDivision(String division) {
        return patientCaseRepository.getPatientCaseEntitiesByDivision(division);
    }

    @Override
    public List<PatientCaseEntity> getPatientCaseEntitiesByPatientId(String patientId) {
        return patientCaseRepository.getPatientCaseEntitiesByPatientId(patientId);
    }
}
