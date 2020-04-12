package com.uhms.uhms.controller;

import com.uhms.uhms.dto.DoctorDto;
import com.uhms.uhms.entity.PatientEntity;
import com.uhms.uhms.service.service.DoctorService;
import com.uhms.uhms.service.service.PatientService;
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
    public String selectPatient(@PathVariable("doctorId")String doctorId,Model model){
        DoctorDto doctorDto = doctorService.getById(doctorId);
        List<PatientEntity> patientList = patientService.findAll();
        model.addAttribute("doctor",doctorDto);
        model.addAttribute("patientList",patientList);
        return "/patientSelect";
    }
    @RequestMapping(value = "/select_patient_detail/{doctorId}/{patientId}" ,method = RequestMethod.GET)
    public String selectDetailPatient(@PathVariable("doctorId")String doctorId,@PathVariable("patientId")String patientId,Model model){
        DoctorDto doctorDto = doctorService.getById(doctorId);
        PatientEntity patient = patientService.getById(patientId);
        System.out.println(patient);
        model.addAttribute("doctor",doctorDto);
        model.addAttribute("patient",patient);
        return "/patientDetailSelect";
    }
    @RequestMapping(value = "/update_patient/{doctorId}/{patientId}",method = RequestMethod.GET)
    public String updatePatient(@PathVariable("doctorId")String doctorId,@PathVariable("patientId")String patientId,Model model){
        DoctorDto doctorDto = doctorService.getById(doctorId);
        PatientEntity patient = patientService.getById(patientId);
        System.out.println(patient);
        model.addAttribute("doctor",doctorDto);
        model.addAttribute("patient",patient);
        return "/patientUpdate";
    }
    @RequestMapping(value = "/delete_patient/{doctorId}/{patientId}",method = RequestMethod.GET)
    public String deletePatient(@PathVariable("doctorId")String doctorId,@PathVariable("patientId")String patientId,Model model){
        patientService.deleteById(patientId);
        DoctorDto doctorDto = doctorService.getById(doctorId);
        List<PatientEntity> patientList = patientService.findAll();
        model.addAttribute("doctor",doctorDto);
        model.addAttribute("patientList",patientList);
        return "/patientSelect";
    }

}
