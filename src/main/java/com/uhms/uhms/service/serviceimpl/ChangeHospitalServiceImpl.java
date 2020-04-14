package com.uhms.uhms.service.serviceimpl;

import com.uhms.uhms.dao.dao.ChangeHospitalDao;
import com.uhms.uhms.dao.dao.PatientDao;
import com.uhms.uhms.dto.PatientDto;
import com.uhms.uhms.entity.ChangeHospitalEntity;
import com.uhms.uhms.entity.PatientEntity;
import com.uhms.uhms.service.service.ChangeHospitalService;
import com.uhms.uhms.service.service.PatientService;
import com.uhms.uhms.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChangeHospitalServiceImpl implements ChangeHospitalService {

    @Autowired
    private ChangeHospitalDao changeHospitalDao;


    @Override
    public List<ChangeHospitalEntity> findAll() {
        return changeHospitalDao.getAll();
    }

    @Override
    public void insert(ChangeHospitalEntity changeHospitalEntity) {
        changeHospitalDao.insert(changeHospitalEntity);
    }

    @Override
    public ChangeHospitalEntity getById(String id) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }
}
