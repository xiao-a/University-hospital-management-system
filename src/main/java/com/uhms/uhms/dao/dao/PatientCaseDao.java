package com.uhms.uhms.dao.dao;

import com.uhms.uhms.entity.PatientCaseEntity;

import java.util.List;

public interface PatientCaseDao {
    void insert(PatientCaseEntity patientCaseEntity);
    void deleteById(String id);
    PatientCaseEntity getById(String id);
    List<PatientCaseEntity> getAll();
    void update(PatientCaseEntity patientCaseEntity);
    List<PatientCaseEntity> getPatientCaseEntitiesByDivision(String division);
    List<PatientCaseEntity> getPatientCaseEntitiesByPatientId(String patientId);
}
