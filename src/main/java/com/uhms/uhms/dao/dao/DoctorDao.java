package com.uhms.uhms.dao.dao;

import com.uhms.uhms.entity.DoctorEntity;

import java.util.List;

public interface DoctorDao {
    void insert(DoctorEntity doctorEntity);
    void deleteById(String id);
    DoctorEntity getById(String id);
    List<DoctorEntity> getAll();
    void update(String id, DoctorEntity doctorEntity);
}
