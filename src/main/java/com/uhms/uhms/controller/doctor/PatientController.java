package com.uhms.uhms.controller.doctor;

import com.uhms.uhms.dto.DoctorDto;
import com.uhms.uhms.entity.PatientEntity;
import com.uhms.uhms.service.service.doctor.DoctorService;
import com.uhms.uhms.service.service.patient.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class PatientController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private DoctorService doctorService;
    @RequestMapping("/select_patient/{doctorId}")
    public String doctorSelectPatient(@PathVariable("doctorId")String doctorId,Model model){
        DoctorDto doctorDto = doctorService.getById(doctorId);
        List<PatientEntity> patientList = patientService.findAll();
        model.addAttribute("doctor",doctorDto);
        model.addAttribute("patientList",patientList);
        model.addAttribute("msg",null);
        return "doctor/patientSelect";
    }
    @RequestMapping(value = "/select_patient_detail/{doctorId}/{patientId}" ,method = RequestMethod.GET)
    public String doctorSelectDetailPatient(@PathVariable("doctorId")String doctorId,@PathVariable("patientId")String patientId,Model model){
        DoctorDto doctorDto = doctorService.getById(doctorId);
        PatientEntity patient = patientService.getById(patientId);
        System.out.println(patient);
        model.addAttribute("doctor",doctorDto);
        model.addAttribute("patient",patient);
        return "doctor/patientDetailSelect";
    }
}
