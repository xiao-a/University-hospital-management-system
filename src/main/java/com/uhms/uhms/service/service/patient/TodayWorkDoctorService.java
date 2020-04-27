package com.uhms.uhms.service.service.patient;

import com.uhms.uhms.dto.PatientDto;
import com.uhms.uhms.entity.DoctorEntity;
import com.uhms.uhms.entity.PatientEntity;

import java.util.List;

public interface TodayWorkDoctorService {
    List<DoctorEntity> getDayWordDoctor();
}
