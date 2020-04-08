package com.uhms.uhms.service.serviceimpl;

import com.uhms.uhms.dao.dao.DoctorDao;
import com.uhms.uhms.entity.BedEntity;
import com.uhms.uhms.service.service.BedService;
import com.uhms.uhms.service.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorDao doctorDao;
    @Override
    public int login(String username, String password){
        return doctorDao.login(username, password);
    }
}
