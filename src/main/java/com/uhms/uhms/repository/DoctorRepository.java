package com.uhms.uhms.repository;

import com.uhms.uhms.entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity,String> {

    @Query(value = "select COUNT(*) from t_doctor where username= ?1 and password=?2 " ,nativeQuery = true)
    int login(String username,String password);
}
