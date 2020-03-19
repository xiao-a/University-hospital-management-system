package com.uhms.uhms.repository;

import com.uhms.uhms.entity.AppointmentEntity;
import com.uhms.uhms.entity.CaseHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseHistoryRepository extends JpaRepository<CaseHistoryEntity,String> {
}
