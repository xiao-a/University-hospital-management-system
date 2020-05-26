package com.uhms.uhms.repository;

import com.uhms.uhms.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity,String> {
    @Query(value = "select patient_id from t_patient where username= ?1 and password=?2 " ,nativeQuery = true)
    String login(String username, String password);

    @Query(value = "select * from t_patient e  where (e.patient_id like CONCAT('%',?1,'%')  or ?1 is null) and (e.name like CONCAT('%',?2,'%')  or ?2 is null) and (e.phone_number like CONCAT('%',?3,'%')  or ?3 is null)" ,nativeQuery = true )
    List<PatientEntity> vague_find(String patientId, String name , String phoneNumber);
}
