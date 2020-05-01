package com.uhms.uhms.dao.daoimpl;
import com.uhms.uhms.dao.dao.AppointmentDao;
import com.uhms.uhms.entity.AppointmentEntity;
import com.uhms.uhms.enums.AppointmentStatusEnum;
import com.uhms.uhms.enums.DataStatusEnum;
import com.uhms.uhms.repository.AppointmentRepository;
import com.uhms.uhms.utils.DateUtils;
import com.uhms.uhms.utils.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class AppointmentDaoImpl  implements AppointmentDao {

    @Autowired
    private AppointmentRepository appointmentRepository;
    @Override
    public void insert(AppointmentEntity appointmentEntity) {
        appointmentEntity.setAppointmentId(IdUtils.createID("appointment"));
        appointmentEntity.setCreateDate(DateUtils.getCurrentDate());
        appointmentEntity.setUpdateDate(DateUtils.getCurrentDate());
        appointmentEntity.setStatus(DataStatusEnum.VALID.getType());
        appointmentEntity.setAppointmentStatus(AppointmentStatusEnum.CONFIRMED.getType());
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
    public List<AppointmentEntity> getAllByPatientId(String patientId) {
        return appointmentRepository.getAppointmentEntityByPatientId(patientId);
    }

    @Override
    public void update(String id, AppointmentEntity appointmentEntity) {
//        AppointmentEntity entity = appointmentRepository.getOne(id);
        appointmentRepository.save(appointmentEntity);
    }
}
