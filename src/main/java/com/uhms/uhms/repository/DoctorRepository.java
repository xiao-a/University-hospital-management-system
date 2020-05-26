package com.uhms.uhms.repository;

import com.uhms.uhms.entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity,String> {
    @Query(value = "select doctor_id from t_doctor where username= ?1 and password=?2 " ,nativeQuery = true)
    String login(String username,String password);
//    @Modifying
//    @Query(value = "update from t_doctor set where username= ?1 and password=?2 " ,nativeQuery = true)
//    void updateById(String id);
    @Query(value = "select * from t_doctor where division=?1",nativeQuery = true)
    List<DoctorEntity> selectByDivision(String division);
    @Query(value = "select * from t_doctor e  where (e.doctor_id like CONCAT('%',?1,'%')  or ?1 is null) and (e.division like CONCAT('%',?2,'%')  or ?2 is null) and (e.name like CONCAT('%',?3,'%')  or ?3 is null)" ,nativeQuery = true )
    List<DoctorEntity> vague_find(String doctorId,String division ,String name);
}
