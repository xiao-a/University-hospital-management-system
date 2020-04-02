package com.uhms.uhms.dao.daoimpl;

import com.uhms.uhms.dao.dao.AppointmentDao;
import com.uhms.uhms.entity.AppointmentEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppointmentDaoImpl implements AppointmentDao {
    @Override
    public void insert(AppointmentEntity appointmentEntity) {

    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public AppointmentEntity getById(String id) {
        return null;
    }

    @Override
    public List<AppointmentEntity> getAll() {
        return null;
    }

    @Override
    public void update(String id, AppointmentEntity appointmentEntity) {

    }
}
