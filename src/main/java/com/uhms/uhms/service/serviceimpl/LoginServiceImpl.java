package com.uhms.uhms.service.serviceimpl;

import com.uhms.uhms.dao.dao.AdminDao;
import com.uhms.uhms.dao.dao.DoctorDao;
import com.uhms.uhms.dao.dao.PatientDao;
import com.uhms.uhms.enums.IdentifyEnum;
import com.uhms.uhms.service.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private PatientDao patientDao;
    @Autowired
    private DoctorDao doctorDao;
    @Autowired
    private AdminDao adminDao;
    String id;
    @Override
    public String Login(String username, String password,String identity) {
        if(IdentifyEnum.PATIENT.getType().equals(identity)){
            id = patientDao.login(username, password);
            return id;
        }else if(IdentifyEnum.DOCTOR.getType().equals(identity)){
            id=doctorDao.login(username,password);
            return id;
        }else if(IdentifyEnum.ADMIN.getType().equals(identity)){
            id=adminDao.login(username,password);
            return id;
        }else {
            return null;
        }
    }
}
