package com.uhms.uhms.controller.doctor;

import com.uhms.uhms.dto.ChangeHospitalDto;
import com.uhms.uhms.dto.DoctorDto;
import com.uhms.uhms.entity.ChangeHospitalEntity;
import com.uhms.uhms.service.service.ChangeHospitalService;
import com.uhms.uhms.service.service.doctor.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ChangeHospitalController {
    @Autowired
    private ChangeHospitalService changeHospitalService;
    @Autowired
    private DoctorService doctorService;
    @RequestMapping("/select_change_hospital_list/{doctorId}")
    public String selectPatient(@PathVariable("doctorId")String doctorId,Model model){
        DoctorDto doctorDto = doctorService.getById(doctorId);
        List<ChangeHospitalEntity> changeHospitalList = changeHospitalService.findAll();
        model.addAttribute("doctor",doctorDto);
        model.addAttribute("changeHospitalList",changeHospitalList);
        model.addAttribute("msg",null);
        return "doctor/changeHospitalSelect";
    }
    @RequestMapping(value = "/add_change_hospital/{doctorId}" ,method = RequestMethod.GET)
    public String selectDetailPatient(@PathVariable("doctorId")String doctorId,Model model){
        DoctorDto doctorDto = doctorService.getById(doctorId);
        model.addAttribute("doctor",doctorDto);
        return "doctor/changeHospitalInsert";
    }
    @RequestMapping(value = "/change_hospital_insert_submission" ,method = RequestMethod.POST)
    public String selectDetailPatientSubmission(ChangeHospitalDto changeHospitalDto, Model model){
        DoctorDto doctorDto = doctorService.getById(changeHospitalDto.getDoctorId());
        changeHospitalService.insert(changeHospitalDto);
        List<ChangeHospitalEntity> changeHospitalList = changeHospitalService.findAll();
        model.addAttribute("doctor",doctorDto);
        model.addAttribute("changeHospitalList",changeHospitalList);
        model.addAttribute("msg",null);
        return "doctor/changeHospitalSelect";
    }

}
