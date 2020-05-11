package com.uhms.uhms.service.serviceimpl.doctor;


import com.uhms.uhms.dao.dao.AppointmentDao;
import com.uhms.uhms.entity.AppointmentEntity;
import com.uhms.uhms.enums.AppointmentStatusEnum;
import com.uhms.uhms.service.service.doctor.AppointmentDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentDoctorServiceImpl implements AppointmentDoctorService {
    @Autowired
    private AppointmentDao appointmentDao;
    @Override
    public List<AppointmentEntity> getAllByDoctorId(String doctorId) {
        List<AppointmentEntity> appointmentEntityList = appointmentDao.getAllByDoctorId(doctorId);
        List<AppointmentEntity> appointmentEntities=new ArrayList<>();
        for (int i=0;i<appointmentEntityList.size();i++){
            appointmentEntityList.get(i).setAppointmentStatus(AppointmentStatusEnum.getNameByType(appointmentEntityList.get(i).getAppointmentStatus()));
            appointmentEntities.add(appointmentEntityList.get(i));
        }
        return appointmentEntities;
    }

    @Override
    public AppointmentEntity changeAppointment(String appointmentId) {
        AppointmentEntity appointmentEntity = appointmentDao.getById(appointmentId);
        appointmentEntity.setAppointmentStatus(AppointmentStatusEnum.CONFIRMED.getType());
        appointmentDao.changeAppointmentStatus(appointmentEntity);
        return appointmentEntity;
    }
}
