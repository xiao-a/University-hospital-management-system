package com.uhms.uhms.dao.dao;

import com.uhms.uhms.entity.AppointmentEntity;

import java.util.Date;
import java.util.List;

public interface AppointmentDao {
    void insert(AppointmentEntity appointmentEntity);
    void deleteById(String id);
    AppointmentEntity getById(String id);
    List<AppointmentEntity> getAll();
    List<AppointmentEntity> getAllByPatientId(String patientId);
    List<AppointmentEntity> getAllByDoctorId(String doctorId);
    void update(String id, AppointmentEntity appointmentEntity);
    void changeAppointmentStatus(AppointmentEntity appointmentId);
    List<AppointmentEntity> getAppointmentEntityByAppointmentDate(String  appointmentStatus);
}
