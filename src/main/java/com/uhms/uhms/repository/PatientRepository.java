package com.uhms.uhms.repository;

import com.uhms.uhms.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity,String> {
    @Query(value = "select patient_id from t_patient where username= ?1 and password=?2 " ,nativeQuery = true)
    String login(String username, String password);
}
