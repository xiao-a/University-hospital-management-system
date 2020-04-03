package com.uhms.uhms.dao.daoimpl;
import com.uhms.uhms.dao.dao.AppointmentDao;
import com.uhms.uhms.entity.AppointmentEntity;
import com.uhms.uhms.repository.AppointmentRepository;
import com.uhms.uhms.utils.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;



public class AppointmentDaoImpl  implements AppointmentDao {

    @Autowired
    private AppointmentRepository appointmentRepository;
    @Override
    public void insert(AppointmentEntity appointmentEntity) {
        appointmentEntity.setDoctorId(IdUtils.createID("appointment"));
        appointmentRepository.save(appointmentEntity);
    }

    @Override
    public void deleteById(String id) {
        appointmentRepository.deleteById(id);
    }

    @Override
    public AppointmentEntity getById(String id) {
        return appointmentRepository.getOne(id);
    }

    @Override
    public List<AppointmentEntity> getAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public void update(String id, AppointmentEntity appointmentEntity) {
//        AppointmentEntity entity = appointmentRepository.getOne(id);
        appointmentRepository.save(appointmentEntity);
    }
}
