package com.uhms.uhms.controller.doctor;

import com.uhms.uhms.dto.DoctorDto;
import com.uhms.uhms.service.service.doctor.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class doctorMyInfoController {
    @Autowired
    private DoctorService doctorService;
    @RequestMapping("/my_info/{doctorId}")
    public String getMyInfo(@PathVariable("doctorId") String doctorId, Model model, HttpServletRequest request) {
        DoctorDto dto = doctorService.getById(doctorId);
        model.addAttribute("doctor",dto);
        return "doctor/myInfo";
    }

    @RequestMapping("/update_my_info/{doctorId}")
    public String UpdateMyInfo(@PathVariable("doctorId") String doctorId, Model model, HttpServletRequest request) {
        DoctorDto dto = doctorService.getById(doctorId);
        model.addAttribute("doctor",dto);
        return "doctor/updateMyInfo";
    }
    @RequestMapping(value = "/update_myinfo_submission" ,method = RequestMethod.POST)
    public String UpdateMyInfoSubmission(DoctorDto doctorDto, Model model, HttpServletRequest request) {
        doctorService.updateJpa(doctorDto);
        DoctorDto doctorEntity = doctorService.getById(doctorDto.getDoctorId());
        model.addAttribute("doctor",doctorEntity);
        return "doctor/updateMyInfo";
    }
}
