package com.uhms.uhms.dao.dao;

import com.uhms.uhms.entity.ChangeHospitalEntity;

import java.util.List;

public interface ChangeHospitalDao {
    void insert(ChangeHospitalEntity changeHospitalEntity);
    void deleteById(String id);
    ChangeHospitalEntity getById(String id);
    List<ChangeHospitalEntity> getAll();
    void update(String id, ChangeHospitalEntity changeHospitalEntity);
}
