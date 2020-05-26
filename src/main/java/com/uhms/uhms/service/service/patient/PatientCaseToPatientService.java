package com.uhms.uhms.service.service.patient;

import com.uhms.uhms.dto.AppointmentHistoryDto;
import com.uhms.uhms.entity.AppointmentEntity;
import com.uhms.uhms.entity.PatientCaseEntity;

import java.util.List;

public interface PatientCaseToPatientService {
    List<PatientCaseEntity> getPatientCaseEntitiesByPatientId(String patientId);
}
