package com.uhms.uhms.dao.dao;

import com.uhms.uhms.entity.PatientEntity;

import java.util.List;

public interface PatientDao {
    void insert(PatientEntity patientEntity);
    void deleteById(String id);
    PatientEntity getById(String id);
    List<PatientEntity> getAll();
    void update(String id, PatientEntity patientEntity);
}
