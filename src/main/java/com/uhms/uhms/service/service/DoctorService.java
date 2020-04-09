package com.uhms.uhms.service.service;

import com.uhms.uhms.entity.DoctorEntity;

public interface DoctorService {
    String login(String username,String password);
    void insert(DoctorEntity doctorEntity);
    DoctorEntity getById(String id);
}
