package com.uhms.uhms.dao.daoimpl;

import com.uhms.uhms.dao.dao.PatientDao;
import com.uhms.uhms.entity.PatientEntity;
import com.uhms.uhms.enums.DataStatusEnum;
import com.uhms.uhms.repository.PatientRepository;
import com.uhms.uhms.utils.DateUtils;
import com.uhms.uhms.utils.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PatientDaoImpl implements PatientDao {
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void insert(PatientEntity patientEntity) {
        patientEntity.setPatientId(IdUtils.createID("patient"));
        patientEntity.setCreateDate(DateUtils.getCurrentDate());
        patientEntity.setUpdateDate( DateUtils.getCurrentDate());
        patientEntity.setStatus(DataStatusEnum.VALID.getType());
        patientRepository.save(patientEntity);
    }

    @Override
    public void deleteById(String id) {
        patientRepository.deleteById(id);
    }

    @Override
    public PatientEntity getById(String id) {
        return patientRepository.getOne(id);
    }

    @Override
    public List<PatientEntity> getAll() {
        return patientRepository.findAll();
    }

    @Override
    public void update(PatientEntity patientEntity) {
        patientRepository.save(patientEntity);
    }

}
