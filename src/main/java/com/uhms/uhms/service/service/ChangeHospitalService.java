package com.uhms.uhms.service.service;



import com.uhms.uhms.entity.ChangeHospitalEntity;

import java.util.List;

public interface ChangeHospitalService {
    List<ChangeHospitalEntity> findAll();
    void insert(ChangeHospitalEntity changeHospitalEntity);
    ChangeHospitalEntity getById(String id);
    void deleteById(String id);
}
