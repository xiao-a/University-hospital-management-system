package com.uhms.uhms.dao.daoimpl;

import com.uhms.uhms.dao.dao.PatientDao;
import com.uhms.uhms.entity.PatientEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PatientDaoImpl implements PatientDao {


    @Override
    public void insert(PatientEntity patientEntity) {

    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public PatientEntity getById(String id) {
        return null;
    }

    @Override
    public List<PatientEntity> getAll() {
        return null;
    }

    @Override
    public void update(String id, PatientEntity patientEntity) {

    }
}
