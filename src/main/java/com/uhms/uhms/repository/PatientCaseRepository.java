package com.uhms.uhms.repository;

import com.uhms.uhms.entity.HospitalInfoEntity;
import com.uhms.uhms.entity.PatientCaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientCaseRepository extends JpaRepository<PatientCaseEntity,String> {
}
