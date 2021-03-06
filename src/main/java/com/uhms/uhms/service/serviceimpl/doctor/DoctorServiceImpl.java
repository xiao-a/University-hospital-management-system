package com.uhms.uhms.service.serviceimpl.doctor;

import com.uhms.uhms.dao.dao.DoctorDao;
import com.uhms.uhms.dto.DoctorDto;
import com.uhms.uhms.entity.DoctorEntity;
import com.uhms.uhms.enums.DivisionTypeEnum;
import com.uhms.uhms.enums.SexEnum;
import com.uhms.uhms.service.service.doctor.DoctorService;
import com.uhms.uhms.utils.EmptyUtils;
import com.uhms.uhms.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorDao doctorDao;
    DoctorDto doctorDto=new DoctorDto();
    DoctorEntity doctorEntity=new DoctorEntity();
    @Override
    public void insert(DoctorEntity doctorEntity) {
        doctorDao.insert(doctorEntity);
    }

    @Override
    public void insert(DoctorDto doctorDto) {
        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setAddress(doctorDto.getAddress());
        doctorEntity.setDivision(doctorDto.getDivision());
        doctorEntity.setEmail(doctorDto.getEmail());
        doctorEntity.setAge(doctorDto.getAge());
        doctorEntity.setUsername(doctorDto.getUsername());
        doctorEntity.setPassword(doctorDto.getPassword());
        doctorEntity.setPhoneNumber(doctorDto.getPhoneNumber());
        doctorEntity.setName(doctorDto.getName());
        doctorEntity.setSex(doctorDto.getSex());
        doctorEntity.setHeadUrl(doctorDto.getHeadUrl());
        doctorDao.insert(doctorEntity);
    }

    @Override
    public DoctorDto getById(String id) {
        DoctorEntity entity = doctorDao.getById(id);
        doctorDto.setDoctorId(entity.getDoctorId());
        doctorDto.setName(entity.getName());
        doctorDto.setSex(SexEnum.getNameByType(entity.getSex()));
        doctorDto.setDivision(DivisionTypeEnum.getNameByType(entity.getDivision()));
        doctorDto.setAge(entity.getAge());
        doctorDto.setStartWorkDateStr(entity.getStartWorkDate()+"");
        doctorDto.setPhoneNumber(entity.getPhoneNumber());
        doctorDto.setUsername(entity.getUsername());
        doctorDto.setPassword(entity.getPassword());
        doctorDto.setEmail(entity.getEmail());
        doctorDto.setAddress(entity.getAddress());
        doctorDto.setHeadUrl(entity.getHeadUrl());
        return doctorDto;
    }

    @Override
    public void updateJpa(DoctorDto doctorDto) {
        doctorEntity=doctorDao.getById(doctorDto.getDoctorId());
        doctorEntity.setName(doctorDto.getName());
        if (EmptyUtils.isNotEmpty(doctorDto.getSex()))
        {
            doctorEntity.setSex(doctorDto.getSex());
            LogUtils.info("sex1:"+doctorDto.getSex());
        }
        LogUtils.info("sex2:"+doctorEntity.getSex());
        if (EmptyUtils.isNotEmpty(doctorDto.getDivision()))
        {
            doctorEntity.setDivision(doctorDto.getDivision());
        }
        doctorEntity.setAge(doctorDto.getAge());
//        doctorEntity.setStartWorkDate(doctorDto.getStartWorkDateStr());
        doctorEntity.setPhoneNumber(doctorDto.getPhoneNumber());
        doctorEntity.setUsername(doctorDto.getUsername());
        doctorEntity.setPassword(doctorDto.getPassword());
        doctorEntity.setEmail(doctorDto.getEmail());
        doctorEntity.setAddress(doctorDto.getAddress());
        if(EmptyUtils.isEmpty(doctorDto.getHeadUrl())) {

        }else{
            doctorEntity.setHeadUrl(doctorDto.getHeadUrl());
        }
        doctorDao.updateJpa(doctorEntity);
    }

    @Override
    public List<DoctorDto> getAll() {
        List<DoctorEntity> doctorEntityList = doctorDao.getAll();
        List<DoctorDto> doctorDtoList=new ArrayList<>();
        for(int i=0;i<doctorEntityList.size();i++){
            DoctorDto doctorDto=new DoctorDto();
            doctorDto.setDoctorId(doctorEntityList.get(i).getDoctorId());
            doctorDto.setName(doctorEntityList.get(i).getName());
            doctorDto.setAge(doctorEntityList.get(i).getAge());
            doctorDto.setDivision(DivisionTypeEnum.getNameByType(doctorEntityList.get(i).getDivision()));
            doctorDto.setSex(SexEnum.getNameByType(doctorEntityList.get(i).getSex()));
            doctorDto.setPhoneNumber(doctorEntityList.get(i).getPhoneNumber());
            doctorDto.setEmail(doctorEntityList.get(i).getEmail());
            doctorDto.setUsername(doctorEntityList.get(i).getUsername());
            doctorDto.setPassword(doctorEntityList.get(i).getPassword());
            doctorDtoList.add(doctorDto);
        }
        return doctorDtoList;
    }

    @Override
    public void deleteById(String doctorId) {
        doctorDao.deleteById(doctorId);
    }

    @Override
    public List<DoctorDto> vague_find(String doctorId, String division, String name) {
        List<DoctorEntity> doctorEntityList = doctorDao.vague_find(doctorId, division, name);
        List<DoctorDto> doctorDtoList=new ArrayList<>();
        for(int i=0;i<doctorEntityList.size();i++){
            DoctorDto doctorDto=new DoctorDto();
            doctorDto.setDoctorId(doctorEntityList.get(i).getDoctorId());
            doctorDto.setName(doctorEntityList.get(i).getName());
            doctorDto.setAge(doctorEntityList.get(i).getAge());
            doctorDto.setDivision(DivisionTypeEnum.getNameByType(doctorEntityList.get(i).getDivision()));
            doctorDto.setSex(SexEnum.getNameByType(doctorEntityList.get(i).getSex()));
            doctorDto.setPhoneNumber(doctorEntityList.get(i).getPhoneNumber());
            doctorDto.setEmail(doctorEntityList.get(i).getEmail());
            doctorDto.setUsername(doctorEntityList.get(i).getUsername());
            doctorDto.setPassword(doctorEntityList.get(i).getPassword());
            doctorDtoList.add(doctorDto);
        }
        return doctorDtoList;
    }
}
