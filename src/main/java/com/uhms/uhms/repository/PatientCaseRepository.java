package com.uhms.uhms.repository;

import com.uhms.uhms.entity.PatientCaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PatientCaseRepository extends JpaRepository<PatientCaseEntity,String> {
    @Query(value = "select * from t_patient_case where division= ?1" ,nativeQuery = true)
    List<PatientCaseEntity> getPatientCaseEntitiesByDivision(String division);
}
