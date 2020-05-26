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

    @Query(value = "select * from t_patient_case where patient_id= ?1" ,nativeQuery = true)
    List<PatientCaseEntity> getPatientCaseEntitiesByPatientId(String patientId);
    @Query(value = "select * from t_patient_case e  where (e.patient_case_id like CONCAT('%',?1,'%')  or ?1 is null) and (e.patient_id like CONCAT('%',?2,'%')  or ?2 is null) and (e.patient_name like CONCAT('%',?3,'%')  or ?3 is null)" ,nativeQuery = true )
    List<PatientCaseEntity> vague_find(String patientCaseId,String patientId ,String patientName);
}
