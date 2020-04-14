package com.uhms.uhms.service.serviceimpl;

import com.uhms.uhms.dao.dao.PatientDao;
import com.uhms.uhms.dto.PatientDto;
import com.uhms.uhms.entity.BedEntity;
import com.uhms.uhms.entity.PatientEntity;
import com.uhms.uhms.enums.DataStatusEnum;
import com.uhms.uhms.service.service.BedService;
import com.uhms.uhms.service.service.PatientService;
import com.uhms.uhms.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientDao patientDao;
    @Override
    public List<PatientEntity> findAll() {
        return patientDao.getAll();
    }

    @Override
    public void insert(PatientDto patientDto) {
        PatientEntity patientEntity=new PatientEntity();
        patientEntity.setName(patientDto.getName());
        patientEntity.setSex(patientDto.getSex());
        patientEntity.setAge(patientDto.getAge());
        patientEntity.setUsername(patientDto.getName());
        patientEntity.setAddress(patientDto.getAddress());
        patientEntity.setPhoneNumber(patientDto.getPhoneNumber());
        patientEntity.setStatus(DataStatusEnum.VALID.getType());
        patientDao.insert(patientEntity);
    }
    @Override
    public PatientEntity getById(String id) {
        return patientDao.getById(id);
    }

    @Override
    public void deleteById(String id) {
        patientDao.deleteById(id);
    }

    @Override
    public void updateJpa(PatientDto patientDto) {
        PatientEntity patientEntity = getById(patientDto.getPatientId());
        patientEntity.setName(patientDto.getName());
        patientEntity.setSex(patientDto.getSex());
        patientEntity.setAge(patientDto.getAge());
        patientEntity.setUsername(patientDto.getName());
        patientEntity.setAddress(patientDto.getAddress());
        patientEntity.setPhoneNumber(patientDto.getPhoneNumber());
        patientEntity.setUpdateDate(DateUtils.getCurrentDate());
        patientDao.update(patientEntity);
    }


}
