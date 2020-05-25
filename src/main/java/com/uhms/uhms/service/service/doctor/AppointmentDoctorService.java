package com.uhms.uhms.service.service.doctor;

import com.uhms.uhms.dto.AppointmentHistoryDto;
import com.uhms.uhms.entity.AppointmentEntity;

import java.util.List;

public interface AppointmentDoctorService {
    List<AppointmentEntity> getAllByDoctorId(String doctorId);
    AppointmentEntity changeAppointment(String appointmentId);
    AppointmentEntity getById(String appointmentId);
}
