package com.uhms.uhms.dao.daoimpl;

import com.uhms.uhms.dao.dao.AdminDao;
import com.uhms.uhms.entity.AdminEntity;
import com.uhms.uhms.enums.DataStatusEnum;
import com.uhms.uhms.repository.AdminRepository;
import com.uhms.uhms.utils.DateUtils;
import com.uhms.uhms.utils.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdminDaoImpl implements AdminDao {
    @Autowired
    private AdminRepository AdminRepository;

    @Override
    public void insert(AdminEntity AdminEntity) {
        AdminEntity.setAdminId(IdUtils.createID("admin"));
        AdminEntity.setCreateDate(DateUtils.getCurrentDate());
        AdminEntity.setUpdateDate( DateUtils.getCurrentDate());
        AdminEntity.setStatus(DataStatusEnum.VALID.getType());
        AdminRepository.save(AdminEntity);
    }

    @Override
    public void deleteById(String id) {
        AdminRepository.deleteById(id);
    }

    @Override
    public AdminEntity getById(String id) {
        return AdminRepository.getOne(id);
    }

    @Override
    public List<AdminEntity> getAll() {
        return AdminRepository.findAll();
    }

    @Override
    public void update(AdminEntity adminEntity) {
        AdminEntity AdminEntity = getById(adminEntity.getAdminId());
        AdminEntity.setName(adminEntity.getName());
        AdminEntity.setSex(adminEntity.getSex());
        AdminEntity.setAge(adminEntity.getAge());
        AdminEntity.setUsername(adminEntity.getUsername());
        AdminEntity.setAddress(adminEntity.getAddress());
        AdminEntity.setPhoneNumber(adminEntity.getPhoneNumber());
        AdminEntity.setUpdateDate(DateUtils.getCurrentDate());
        AdminRepository.save(AdminEntity);
    }

    @Override
    public String login(String username, String password) {
        return AdminRepository.login(username,password);
    }

}
