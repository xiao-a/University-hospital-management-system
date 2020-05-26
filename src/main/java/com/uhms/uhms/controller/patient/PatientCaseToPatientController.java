package com.uhms.uhms.controller.patient;

import com.uhms.uhms.dto.AppointmentHistoryDto;
import com.uhms.uhms.entity.PatientCaseEntity;
import com.uhms.uhms.entity.PatientEntity;
import com.uhms.uhms.service.service.doctor.PatientCaseService;
import com.uhms.uhms.service.service.patient.AppointmentService;
import com.uhms.uhms.service.service.patient.PatientCaseToPatientService;
import com.uhms.uhms.service.service.patient.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class PatientCaseToPatientController {
    @Autowired
    PatientService patientService;
    @Autowired
    PatientCaseToPatientService patientCaseToPatientService;
    @Autowired
    PatientCaseService patientCaseService;
    @RequestMapping(value = "/patient_case/{patientId}" ,method = RequestMethod.GET)
    public String patientCaseSelectById(@PathVariable("patientId")String patientId,Model model){
        PatientEntity patientEntity = patientService.getById(patientId);
        List<PatientCaseEntity> patientCaseEntities = patientCaseToPatientService.getPatientCaseEntitiesByPatientId(patientId);
        model.addAttribute("patientCaseList",patientCaseEntities);
        model.addAttribute("patient",patientEntity);
        return "patient/patientCase";
    }


    @RequestMapping(value = "/patient_case_detail/{patientId}/{patientCaseId}" ,method = RequestMethod.GET)
    public String patientCaseDetailSelectById(@PathVariable("patientId")String patientId,@PathVariable("patientCaseId")String patientCaseId,Model model){
        PatientEntity patientEntity = patientService.getById(patientId);
        PatientCaseEntity patientCaseEntity = patientCaseService.getById(patientCaseId);
        model.addAttribute("patientCase",patientCaseEntity);
        model.addAttribute("patient",patientEntity);
        return "patient/patientCaseDetail";
    }


}
