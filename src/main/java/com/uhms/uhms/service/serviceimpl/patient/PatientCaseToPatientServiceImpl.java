package com.uhms.uhms.service.serviceimpl.patient;

import com.uhms.uhms.dao.dao.PatientCaseDao;
import com.uhms.uhms.entity.PatientCaseEntity;
import com.uhms.uhms.service.service.patient.PatientCaseToPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientCaseToPatientServiceImpl implements PatientCaseToPatientService {

    @Autowired
    private PatientCaseDao patientCaseDao;
    @Override
    public List<PatientCaseEntity> getPatientCaseEntitiesByPatientId(String patientId) {
        return patientCaseDao.getPatientCaseEntitiesByPatientId(patientId);
    }
}
