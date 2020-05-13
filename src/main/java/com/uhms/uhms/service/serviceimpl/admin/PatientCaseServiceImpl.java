package com.uhms.uhms.service.serviceimpl.admin;

import com.uhms.uhms.dao.dao.AdminDao;
import com.uhms.uhms.dao.dao.PatientCaseDao;
import com.uhms.uhms.dto.AdminDto;
import com.uhms.uhms.entity.AdminEntity;
import com.uhms.uhms.entity.PatientCaseEntity;
import com.uhms.uhms.enums.DataStatusEnum;
import com.uhms.uhms.enums.SexEnum;
import com.uhms.uhms.service.service.admin.AdminService;
import com.uhms.uhms.service.service.admin.PatientCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientCaseServiceImpl implements PatientCaseService {
    @Autowired
    private PatientCaseDao patientCaseDao;
    @Override
    public void insert(PatientCaseEntity patientCaseEntity) {
        patientCaseDao.insert(patientCaseEntity);
    }

    @Override
    public void deleteById(String id) {
        patientCaseDao.deleteById(id);
    }

    @Override
    public PatientCaseEntity getById(String id) {
        return patientCaseDao.getById(id);
    }

    @Override
    public List<PatientCaseEntity> getAll() {
        return patientCaseDao.getAll();
    }

    @Override
    public void update(PatientCaseEntity patientCaseEntity) {
        patientCaseDao.update(patientCaseEntity);
    }
}
