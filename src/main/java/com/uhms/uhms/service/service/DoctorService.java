package com.uhms.uhms.service.service;

import com.uhms.uhms.dto.DoctorDto;
import com.uhms.uhms.entity.DoctorEntity;

public interface DoctorService {
    void insert(DoctorEntity doctorEntity);
    DoctorDto getById(String id);
    void updateJpa(DoctorDto doctorDto);
}
