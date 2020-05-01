package com.uhms.uhms.service.service.patient;

import com.uhms.uhms.dto.AppointmentHistoryDto;
import com.uhms.uhms.entity.AppointmentEntity;
import com.uhms.uhms.entity.DoctorEntity;

import java.util.List;

public interface AppointmentService {
    void appointmentSubmit(String appointmentJson);
    List<AppointmentHistoryDto> getAllByPatientId(String patientId);}
