package com.uhms.uhms.dao.dao;

import com.uhms.uhms.entity.AppointmentEntity;
import com.uhms.uhms.entity.BedEntity;

import java.util.List;

public interface AppointmentDao {
    void insert(AppointmentEntity appointmentEntity);
    void deleteById(String id);
    AppointmentEntity getById(String id);
    List<AppointmentEntity> getAll();
    void update(String id, AppointmentEntity appointmentEntity);
}
