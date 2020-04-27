package com.uhms.uhms.repository;

import com.uhms.uhms.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity,String> {
    @Query(value = "select admin_id from t_admin where username= ?1 and password=?2 " ,nativeQuery = true)
    String login(String username, String password);
}
