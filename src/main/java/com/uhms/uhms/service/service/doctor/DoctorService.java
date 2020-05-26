package com.uhms.uhms.service.service.doctor;

import com.uhms.uhms.dto.DoctorDto;
import com.uhms.uhms.entity.DoctorEntity;

import java.util.List;

public interface DoctorService {
    void insert(DoctorEntity doctorEntity);
    void insert(DoctorDto doctorDto);
    DoctorDto getById(String id);
    void updateJpa(DoctorDto doctorDto);
    List<DoctorDto> getAll();
    void deleteById(String doctorId);
    List<DoctorDto> vague_find(String doctorId,String division ,String name);
}
