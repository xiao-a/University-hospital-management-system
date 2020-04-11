package com.uhms.uhms.dao.daoimpl;

import com.uhms.uhms.dao.dao.DoctorDao;
import com.uhms.uhms.entity.DoctorEntity;
import com.uhms.uhms.enums.DataStatusEnum;
import com.uhms.uhms.repository.DoctorRepository;
import com.uhms.uhms.utils.DateUtils;
import com.uhms.uhms.utils.IdUtils;
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
        doctorRepository.save(doctorEntity);
    }

    @Override
    public void update(String id, DoctorEntity doctorEntity) {

    }

    @Override
    public DoctorEntity login(String username, String password) {
        return doctorRepository.login(username,password);
    }
}
