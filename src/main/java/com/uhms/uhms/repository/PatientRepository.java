package com.uhms.uhms.repository;

import com.uhms.uhms.entity.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<AppointmentEntity,String> {
}
