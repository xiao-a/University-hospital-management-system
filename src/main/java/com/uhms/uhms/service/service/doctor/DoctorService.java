package com.uhms.uhms.service.service.doctor;

import com.uhms.uhms.dto.DoctorDto;
import com.uhms.uhms.entity.DoctorEntity;

import java.util.List;

public interface DoctorService {
    void insert(DoctorEntity doctorEntity);
    DoctorDto getById(String id);
    void updateJpa(DoctorDto doctorDto);
    List<DoctorDto> getAll();
}
