package com.uhms.uhms.service.service.admin;

import com.uhms.uhms.entity.PatientCaseEntity;

import java.util.List;

public interface PatientCaseService {
    void insert(PatientCaseEntity patientCaseEntity);
    void deleteById(String id);
    PatientCaseEntity getById(String id);
    List<PatientCaseEntity> getAll();
    void update(PatientCaseEntity patientCaseEntity);
}
