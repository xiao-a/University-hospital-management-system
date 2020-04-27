package com.uhms.uhms.dao.dao;

import com.uhms.uhms.entity.AdminEntity;

import java.util.List;

public interface AdminDao {
    void insert(AdminEntity adminEntity);
    void deleteById(String id);
    AdminEntity getById(String id);
    List<AdminEntity> getAll();
    void update(AdminEntity adminEntity);

    String login(String username, String password);
}
