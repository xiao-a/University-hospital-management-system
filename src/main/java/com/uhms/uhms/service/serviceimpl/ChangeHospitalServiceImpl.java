package com.uhms.uhms.service.serviceimpl;

import com.uhms.uhms.dao.dao.ChangeHospitalDao;
import com.uhms.uhms.dto.ChangeHospitalDto;
import com.uhms.uhms.entity.ChangeHospitalEntity;
import com.uhms.uhms.service.service.ChangeHospitalService;
import com.uhms.uhms.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChangeHospitalServiceImpl implements ChangeHospitalService {
    private  ChangeHospitalEntity changeHospitalEntity=new ChangeHospitalEntity();

    @Autowired
    private ChangeHospitalDao changeHospitalDao;


    @Override
    public List<ChangeHospitalEntity> findAll() {
        return changeHospitalDao.getAll();
    }

    @Override
    public void insert(ChangeHospitalDto changeHospitalDto) {
        changeHospitalEntity.setDoctorId(changeHospitalDto.getDoctorId());
        changeHospitalEntity.setPatientId(changeHospitalDto.getPatientId());
        changeHospitalEntity.setChangeHospitalName(changeHospitalDto.getChangeHospitalName());
        changeHospitalEntity.setChangeHospitalDate(DateUtils.getCurrentDate());
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
