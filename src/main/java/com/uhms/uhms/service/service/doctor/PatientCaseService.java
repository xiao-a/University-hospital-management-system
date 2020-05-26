package com.uhms.uhms.service.service.doctor;

import com.uhms.uhms.dto.PatientCaseDto;
import com.uhms.uhms.entity.PatientCaseEntity;

import java.util.List;

public interface PatientCaseService {
    void insert(PatientCaseDto patientCaseDto);
    void insert_s(PatientCaseDto patientCaseDto);
    void deleteById(String id);
    PatientCaseEntity getById(String id);
    List<PatientCaseEntity> getAll();
    void update(PatientCaseDto patientCaseDto);
    List<PatientCaseEntity> getPatientCaseEntitiesByDivision(String division);
}
