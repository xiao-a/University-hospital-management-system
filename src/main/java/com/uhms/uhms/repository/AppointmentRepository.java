package com.uhms.uhms.repository;

import com.uhms.uhms.entity.AppointmentEntity;
import com.uhms.uhms.entity.BedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AppointmentRepository extends JpaRepository<AppointmentEntity,String> {
}
