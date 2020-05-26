package com.uhms.uhms.service.serviceimpl.doctor;

import com.uhms.uhms.dao.dao.AppointmentDao;
import com.uhms.uhms.dao.dao.DoctorDao;
import com.uhms.uhms.dao.dao.PatientCaseDao;
import com.uhms.uhms.dao.dao.PatientDao;
import com.uhms.uhms.dto.PatientCaseDto;
import com.uhms.uhms.entity.AppointmentEntity;
import com.uhms.uhms.entity.DoctorEntity;
import com.uhms.uhms.entity.PatientCaseEntity;
import com.uhms.uhms.entity.PatientEntity;
import com.uhms.uhms.enums.AppointmentStatusEnum;
import com.uhms.uhms.enums.DivisionTypeEnum;
import com.uhms.uhms.service.service.doctor.PatientCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientCaseServiceImpl implements PatientCaseService {
    @Autowired
    private PatientCaseDao patientCaseDao;
    @Autowired
    private DoctorDao doctorDao;
    @Autowired
    private AppointmentDao appointmentDao;
    @Autowired
    private PatientDao patientDao;
    @Override
    public void insert(PatientCaseDto patientCaseDto) {
        DoctorEntity doctorEntity = doctorDao.getById(patientCaseDto.getDoctorId());
        AppointmentEntity appointmentEntity = appointmentDao.getById(patientCaseDto.getAppointmentId());

        appointmentEntity.setAppointmentStatus(AppointmentStatusEnum.COMPLETE.getType());
        appointmentDao.update(patientCaseDto.getAppointmentId(),appointmentEntity);
        PatientCaseEntity patientCaseEntity=new PatientCaseEntity();
        patientCaseEntity.setFee(patientCaseDto.getFee());
        patientCaseEntity.setDiagnosisResult(patientCaseDto.getDiagnosisResult());
        patientCaseEntity.setExamineResult(patientCaseDto.getExamineResult());
        patientCaseEntity.setHandlingSuggestion(patientCaseDto.getHandlingSuggestion());
        patientCaseEntity.setPatientCaseContext(patientCaseDto.getPatientCaseContext());
        patientCaseEntity.setDivision(doctorEntity.getDivision());
        patientCaseEntity.setPatientName(appointmentEntity.getPatientName());
        patientCaseEntity.setPatientId(appointmentEntity.getPatientId());
        patientCaseEntity.setAppointmentId(patientCaseDto.getAppointmentId());
        patientCaseEntity.setDoctorId(doctorEntity.getDoctorId());
        patientCaseEntity.setDoctorName(doctorEntity.getName());
        patientCaseDao.insert(patientCaseEntity);
    }

    @Override
    public void insert_s(PatientCaseDto patientCaseDto) {
        DoctorEntity doctorEntity = doctorDao.getById(patientCaseDto.getDoctorId());
        String patientId = patientCaseDto.getPatientId();
        PatientEntity patientEntity = patientDao.getById(patientId);
        PatientCaseEntity patientCaseEntity=new PatientCaseEntity();
        patientCaseEntity.setFee(patientCaseDto.getFee());
        patientCaseEntity.setDiagnosisResult(patientCaseDto.getDiagnosisResult());
        patientCaseEntity.setExamineResult(patientCaseDto.getExamineResult());
        patientCaseEntity.setHandlingSuggestion(patientCaseDto.getHandlingSuggestion());
        patientCaseEntity.setPatientCaseContext(patientCaseDto.getPatientCaseContext());
        patientCaseEntity.setDivision(doctorEntity.getDivision());
        patientCaseEntity.setPatientName(patientEntity.getName());
        patientCaseEntity.setPatientId(patientEntity.getPatientId());
        patientCaseEntity.setAppointmentId(patientCaseDto.getAppointmentId());
        patientCaseEntity.setDoctorId(doctorEntity.getDoctorId());
        patientCaseEntity.setDoctorName(doctorEntity.getName());
        patientCaseDao.insert(patientCaseEntity);
    }

    @Override
    public void deleteById(String id) {
        patientCaseDao.deleteById(id);
    }

    @Override
    public PatientCaseEntity getById(String id) {
        PatientCaseEntity patientCaseEntity = patientCaseDao.getById(id);
        patientCaseEntity.setDivision(DivisionTypeEnum.getNameByType(patientCaseEntity.getDivision()));
        return patientCaseEntity;
    }

    @Override
    public List<PatientCaseEntity> getAll() {
        return patientCaseDao.getAll();
    }

    @Override
    public void update(PatientCaseDto patientCaseDto) {
        PatientCaseEntity entity = patientCaseDao.getById(patientCaseDto.getPatientCaseId());
        entity.setPatientCaseContext(patientCaseDto.getPatientCaseContext());
        entity.setHandlingSuggestion(patientCaseDto.getHandlingSuggestion());
        entity.setExamineResult(patientCaseDto.getExamineResult());
        entity.setDiagnosisResult(patientCaseDto.getDiagnosisResult());
        entity.setFee(patientCaseDto.getFee());
        patientCaseDao.update(entity);
    }

    @Override
    public List<PatientCaseEntity> getPatientCaseEntitiesByDivision(String division) {
        String division_= DivisionTypeEnum.getTypeByName(division);
        return patientCaseDao.getPatientCaseEntitiesByDivision(division_);
    }
}
