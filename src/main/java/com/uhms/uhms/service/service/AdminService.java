package com.uhms.uhms.service.service;

import com.uhms.uhms.dto.AdminDto;
import com.uhms.uhms.entity.AdminEntity;

import java.util.List;

public interface AdminService {
    List<AdminEntity> findAll();
    void insert(AdminDto AdminDto);
    AdminEntity getById(String id);
    void deleteById(String id);
    void updateJpa(AdminDto AdminDto);
}
