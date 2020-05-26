package com.uhms.uhms.dao.dao;

import com.uhms.uhms.entity.PatientEntity;

import java.util.List;

public interface PatientDao {
    void insert(PatientEntity patientEntity);
    void deleteById(String id);
    PatientEntity getById(String id);
    List<PatientEntity> getAll();
    void update(PatientEntity patientEntity);

    String login(String username,String password);
    List<PatientEntity> vague_find(String patientId, String name , String phoneNumber);
}
