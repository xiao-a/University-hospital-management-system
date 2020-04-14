package com.uhms.uhms.controller;

import com.uhms.uhms.dto.DoctorDto;
import com.uhms.uhms.dto.PatientDto;
import com.uhms.uhms.entity.PatientEntity;
import com.uhms.uhms.service.service.DoctorService;
import com.uhms.uhms.service.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ChangeHospitalController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private DoctorService doctorService;
    @RequestMapping("/select_change_hospital/{doctorId}")
    public String selectPatient(@PathVariable("doctorId")String doctorId,Model model){
        DoctorDto doctorDto = doctorService.getById(doctorId);
        List<PatientEntity> patientList = patientService.findAll();
        model.addAttribute("doctor",doctorDto);
        model.addAttribute("patientList",patientList);
        model.addAttribute("msg",null);
        return "/patientSelect";
    }


}
