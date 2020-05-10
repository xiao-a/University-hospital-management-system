package com.uhms.uhms.service.serviceimpl.admin;

import com.uhms.uhms.dao.dao.AdminDao;
import com.uhms.uhms.dto.AdminDto;
import com.uhms.uhms.entity.AdminEntity;
import com.uhms.uhms.enums.DataStatusEnum;
import com.uhms.uhms.enums.SexEnum;
import com.uhms.uhms.service.service.admin.AdminService;
import com.uhms.uhms.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao AdminDao;
    @Override
    public List<AdminEntity> findAll() {
        return AdminDao.getAll();
    }

    @Override
    public void insert(AdminDto AdminDto) {
        AdminEntity AdminEntity=new AdminEntity();
        AdminEntity.setName(AdminDto.getName());
        AdminEntity.setSex(AdminDto.getSex());
        AdminEntity.setAge(AdminDto.getAge());
        AdminEntity.setUsername(AdminDto.getName());
        AdminEntity.setAddress(AdminDto.getAddress());
        AdminEntity.setPhoneNumber(AdminDto.getPhoneNumber());
        AdminEntity.setStatus(DataStatusEnum.VALID.getType());
        AdminDao.insert(AdminEntity);
    }
    @Override
    public AdminEntity getById(String id) {
        AdminEntity adminEntity = AdminDao.getById(id);
        adminEntity.setSex(SexEnum.getNameByType(adminEntity.getSex()));
        return adminEntity;
    }

    @Override
    public void deleteById(String id) {
        AdminDao.deleteById(id);
    }

    @Override
    public void updateJpa(AdminEntity adminEntity) {
        AdminDao.update(adminEntity);
    }


}
