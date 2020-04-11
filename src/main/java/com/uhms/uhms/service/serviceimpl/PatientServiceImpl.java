package com.uhms.uhms.service.serviceimpl;

import com.uhms.uhms.dao.dao.PatientDao;
import com.uhms.uhms.dto.PatientDto;
import com.uhms.uhms.entity.BedEntity;
import com.uhms.uhms.entity.PatientEntity;
import com.uhms.uhms.service.service.BedService;
import com.uhms.uhms.service.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientDao patientDao;
    @Override
    public List<PatientEntity> findAll() {
        return patientDao.getAll();
    }

    @Override
    public void insert(PatientEntity patientEntity) {
        patientDao.insert(patientEntity);
    }

    @Override
    public PatientEntity getById(String id) {
        return patientDao.getById(id);
    }
}
