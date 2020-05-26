package com.uhms.uhms.dao.dao;

import com.uhms.uhms.entity.DoctorEntity;

import java.util.List;

public interface DoctorDao {
    void insert(DoctorEntity doctorEntity);
    void deleteById(String id);
    DoctorEntity getById(String id);
    List<DoctorEntity> getAll();
    void updateJpa(DoctorEntity doctorEntity);
    void update(String id, DoctorEntity doctorEntity);

    String login(String username,String password);
    List<DoctorEntity> selectByDivision(String division);
    List<DoctorEntity> vague_find(String doctorId,String division ,String name);
}
