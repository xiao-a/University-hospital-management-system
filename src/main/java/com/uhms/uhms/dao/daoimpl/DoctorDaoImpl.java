package com.uhms.uhms.dao.daoimpl;

import com.uhms.uhms.dao.dao.DoctorDao;
import com.uhms.uhms.entity.DoctorEntity;
import com.uhms.uhms.enums.DataStatusEnum;
import com.uhms.uhms.repository.DoctorRepository;
import com.uhms.uhms.utils.DateUtils;
import com.uhms.uhms.utils.IdUtils;
import com.uhms.uhms.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class DoctorDaoImpl implements DoctorDao {

    @Autowired
    private DoctorRepository doctorRepository;
    @Override
    public void insert(DoctorEntity doctorEntity) {
        doctorEntity.setDoctorId(IdUtils.createID("doctor"));
        doctorEntity.setCreateDate(DateUtils.getCurrentDate());
        doctorEntity.setUpdateDate( DateUtils.getCurrentDate());
        doctorEntity.setStartWorkDate(DateUtils.getCurrentDate());
        doctorEntity.setStatus(DataStatusEnum.VALID.getType());
        doctorRepository.save(doctorEntity);
    }

    @Override
    public void deleteById(String id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public DoctorEntity getById(String id) {
        return doctorRepository.getOne(id);
    }

    @Override
    public List<DoctorEntity> getAll() {
        return doctorRepository.findAll();
    }

    @Override
    public void updateJpa(DoctorEntity doctorEntity) {
        doctorEntity.setUpdateDate(DateUtils.getCurrentDate());
        LogUtils.info("sex:"+doctorEntity.getSex());
        doctorRepository.save(doctorEntity);
    }

    @Override
    public void update(String id, DoctorEntity doctorEntity) {
        doctorEntity.setUpdateDate(DateUtils.getCurrentDate());
    }

    @Override
    public String login(String username, String password) {
        return doctorRepository.login(username,password);
    }

    @Override
    public List<DoctorEntity> selectByDivision(String division) {
        return doctorRepository.selectByDivision(division);
    }

    @Override
    public List<DoctorEntity> vague_find(String doctorId, String division, String name) {
        return doctorRepository.vague_find(doctorId,division,name);
    }
}
