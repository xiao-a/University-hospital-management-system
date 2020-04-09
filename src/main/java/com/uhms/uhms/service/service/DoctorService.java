package com.uhms.uhms.service.service;

import com.uhms.uhms.entity.DoctorEntity;

public interface DoctorService {
    int login(String username,String password);
    void insert(DoctorEntity doctorEntity);
}
