package com.uhms.uhms.service.serviceimpl;

import com.uhms.uhms.dao.dao.DoctorDao;
import com.uhms.uhms.dto.DoctorDto;
import com.uhms.uhms.entity.BedEntity;
import com.uhms.uhms.entity.DoctorEntity;
import com.uhms.uhms.enums.SexEnum;
import com.uhms.uhms.service.service.BedService;
import com.uhms.uhms.service.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorDao doctorDao;
    DoctorDto doctorDto=new DoctorDto();
    DoctorEntity doctorEntity=new DoctorEntity();
    @Override
    public DoctorEntity login(String username, String password){
        return doctorDao.login(username, password);
    }

    @Override
    public void insert(DoctorEntity doctorEntity) {
        doctorDao.insert(doctorEntity);
    }

    @Override
    public DoctorDto getById(String id) {
        DoctorEntity entity = doctorDao.getById(id);
        doctorDto.setDoctorId(entity.getDoctorId());
        doctorDto.setName(entity.getName());
        doctorDto.setSex(SexEnum.getNameByType(entity.getSex()));
        doctorDto.setDivision(entity.getDivision());
        doctorDto.setAge(entity.getAge());
        doctorDto.setStartWorkDateStr(entity.getStartWorkDate()+"");
        doctorDto.setPhoneNumber(entity.getPhoneNumber());
        doctorDto.setUsername(entity.getUsername());
        doctorDto.setPassword(entity.getPassword());
        doctorDto.setEmail(entity.getEmail());
        return doctorDto;
    }

    @Override
    public void updateJpa(DoctorDto doctorDto) {
        doctorEntity=doctorDao.getById(doctorDto.getDoctorId());
        doctorEntity.setName(doctorDto.getName());
        doctorEntity.setSex(SexEnum.getTypeByName(doctorDto.getSex()));
        doctorEntity.setDivision(doctorDto.getDivision());
        doctorEntity.setAge(doctorDto.getAge());
//        doctorEntity.setStartWorkDate(doctorDto.getStartWorkDateStr());
        doctorEntity.setPhoneNumber(doctorDto.getPhoneNumber());
        doctorEntity.setUsername(doctorDto.getUsername());
        doctorEntity.setPassword(doctorDto.getPassword());
        doctorEntity.setEmail(doctorDto.getEmail());
        doctorDao.updateJpa(doctorEntity);
    }
}
