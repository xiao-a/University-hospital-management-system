package com.uhms.uhms.repository;

import com.uhms.uhms.entity.CaseHistoryEntity;
import com.uhms.uhms.entity.ChangeHospitalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChangeHospitalRepository extends JpaRepository<ChangeHospitalEntity,String> {
}
