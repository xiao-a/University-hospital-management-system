package com.uhms.uhms.service.service;

import com.uhms.uhms.dto.PatientDto;
import com.uhms.uhms.entity.PatientEntity;

import java.util.List;

public interface PatientService {
    List<PatientEntity> findAll();
    void insert(PatientDto patientDto);
    PatientEntity getById(String id);
    void deleteById(String id);
    void updateJpa(PatientDto patientDto);
}
