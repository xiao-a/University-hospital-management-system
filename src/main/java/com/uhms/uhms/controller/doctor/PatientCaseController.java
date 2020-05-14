package com.uhms.uhms.controller.doctor;

import com.uhms.uhms.dto.DoctorDto;
import com.uhms.uhms.dto.PatientCaseDto;
import com.uhms.uhms.entity.AdminEntity;
import com.uhms.uhms.entity.PatientCaseEntity;
import com.uhms.uhms.service.service.doctor.PatientCaseService;
import com.uhms.uhms.service.service.doctor.DoctorService;
import com.uhms.uhms.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PatientCaseController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private PatientCaseService patientCaseService;

    @RequestMapping("/login/doctor_select_patient_case/{doctorId}")
    public String doctorSelectPatientCase1(@PathVariable("doctorId")String doctorId,Model model){
        DoctorDto doctorDto = doctorService.getById(doctorId);
        List<PatientCaseEntity> patientCaseEntities = patientCaseService.getPatientCaseEntitiesByDivision(doctorDto.getDivision());
        LogUtils.info("Division:"+doctorDto.getDivision());
        LogUtils.info("patientCaseEntities"+patientCaseEntities);
        model.addAttribute("doctor",doctorDto);
        model.addAttribute("patientCaseList",patientCaseEntities);
        return "doctor/patientCaseSelect";
    }
    @RequestMapping("/main/doctor_select_patient_case/{doctorId}")
    public String doctorSelectPatientCase2(@PathVariable("doctorId")String doctorId,Model model){
        DoctorDto doctorDto = doctorService.getById(doctorId);
        List<PatientCaseEntity> patientCaseEntities = patientCaseService.getPatientCaseEntitiesByDivision(doctorDto.getDivision());
        LogUtils.info("Division:"+doctorDto.getDivision());
        LogUtils.info("patientCaseEntities"+patientCaseEntities);
        model.addAttribute("doctor",doctorDto);
        model.addAttribute("patientCaseList",patientCaseEntities);
        return "doctor/patientCaseSelect";
    }
    @RequestMapping("/doctor_select_patient_case/{doctorId}")
    public String doctorSelectPatientCase3(@PathVariable("doctorId")String doctorId,Model model){
        DoctorDto doctorDto = doctorService.getById(doctorId);
        List<PatientCaseEntity> patientCaseEntities = patientCaseService.getPatientCaseEntitiesByDivision(doctorDto.getDivision());
        LogUtils.info("Division:"+doctorDto.getDivision());
        LogUtils.info("patientCaseEntities"+patientCaseEntities);
        model.addAttribute("doctor",doctorDto);
        model.addAttribute("patientCaseList",patientCaseEntities);
        return "doctor/patientCaseSelect";
    }

    @RequestMapping(value = "/doctor_select_patient_case_detail/{doctorId}/{patientCaseId}" ,method = RequestMethod.GET)
    public String adminSelectDetailPatient(@PathVariable("patientCaseId")String patientCaseId,@PathVariable("doctorId")String doctorId,Model model){
        PatientCaseEntity patientCaseEntity = patientCaseService.getById(patientCaseId);
        DoctorDto doctorDto = doctorService.getById(doctorId);
        model.addAttribute("doctor",doctorDto);
        model.addAttribute("patientCase",patientCaseEntity);
        return "doctor/patientCaseDetailSelect";
    }

    @RequestMapping(value = "/doctor_update_patient_case/{doctorId}/{patientCaseId}",method = RequestMethod.GET)
    public String adminUpdateDoctor(@PathVariable("patientCaseId")String patientCaseId,@PathVariable("doctorId")String doctorId,Model model){
        PatientCaseEntity patientCaseEntity = patientCaseService.getById(patientCaseId);
        DoctorDto doctorDto = doctorService.getById(doctorId);
        model.addAttribute("doctor",doctorDto);
        model.addAttribute("patientCase",patientCaseEntity);
        return "doctor/patientCaseUpdate";
    }

    @RequestMapping(value = "/doctor_patient_case_update_submission" ,method = RequestMethod.POST)
    public String doctorUpdateSubmission(PatientCaseDto patientCaseDto, Model model, HttpServletRequest request) {
        patientCaseService.update(patientCaseDto);
        PatientCaseEntity caseEntity = patientCaseService.getById(patientCaseDto.getPatientCaseId());
        model.addAttribute("doctor",doctorService.getById(patientCaseDto.getDoctorId()));
        model.addAttribute("patientCase",caseEntity);
        return "doctor/patientCaseUpdate";
    }
    @RequestMapping(value = "/doctor_delete_patient/{doctorId}/{patientCaseId}",method = RequestMethod.GET)
    public String deletePatient(@PathVariable("patientCaseId")String patientCaseId,@PathVariable("doctorId")String doctorId,Model model){
        patientCaseService.deleteById(patientCaseId);
        DoctorDto doctorDto = doctorService.getById(doctorId);
        List<PatientCaseEntity> patientCaseEntities = patientCaseService.getPatientCaseEntitiesByDivision(doctorDto.getDivision());
        model.addAttribute("doctor",doctorDto);
        model.addAttribute("patientCaseList",patientCaseEntities);
        return "doctor/patientCaseSelect";
    }
    @RequestMapping(value = "/doctor_insert_patien_case/{doctorId}" ,method = RequestMethod.GET)
    public String insertDoctor(@PathVariable("doctorId")String doctorId,Model model){
        PatientCaseEntity caseEntity = patientCaseService.getById(doctorId);
        model.addAttribute("patientCase",caseEntity);
        return "doctor/patientCaseInsert";
    }
    @RequestMapping(value = "/doctor_insert_patient_case_submission" ,method = RequestMethod.POST)
    public String insertDoctorSubmission(PatientCaseDto patientCaseDto, Model model){
        patientCaseService.insert(patientCaseDto);
        DoctorDto doctorDto = doctorService.getById(patientCaseDto.getDoctorId());
        List<PatientCaseEntity> patientCaseEntities = patientCaseService.getPatientCaseEntitiesByDivision(doctorDto.getDivision());
        model.addAttribute("doctor",doctorDto);
        model.addAttribute("patientCaseList",patientCaseEntities);
        return "doctor/patientCaseSelect";
    }
}
