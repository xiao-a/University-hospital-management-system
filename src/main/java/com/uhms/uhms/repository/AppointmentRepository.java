package com.uhms.uhms.repository;

import com.uhms.uhms.entity.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<AppointmentEntity,String> {
    @Query(value = "select * from t_appointment where patient_id=?1" ,nativeQuery = true)
    List<AppointmentEntity> getAppointmentEntityByPatientId(String patientId);
    @Query(value = "select * from t_appointment where doctor_id=?1" ,nativeQuery = true)
    List<AppointmentEntity> getAppointmentEntityByDoctorId(String doctorId);
}
