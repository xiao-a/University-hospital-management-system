package com.uhms.uhms.dao.daoimpl;

import com.uhms.uhms.dao.dao.DoctorDao;
import com.uhms.uhms.entity.DoctorEntity;
import com.uhms.uhms.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DoctorDaoImpl implements DoctorDao {

    @Autowired
    private DoctorRepository doctorRepository;
    @Override
    public void insert(DoctorEntity doctorEntity) {

    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public DoctorEntity getById(String id) {
        return null;
    }

    @Override
    public List<DoctorEntity> getAll() {
        return null;
    }

    @Override
    public void update(String id, DoctorEntity doctorEntity) {

    }

    @Override
    public int login(String username, String password) {
        return doctorRepository.login(username,password);
    }
}
