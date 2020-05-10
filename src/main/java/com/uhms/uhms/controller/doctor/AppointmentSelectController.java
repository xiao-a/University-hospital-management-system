package com.uhms.uhms.controller.doctor;


import com.uhms.uhms.dao.dao.DoctorDao;
import com.uhms.uhms.dto.DoctorDto;
import com.uhms.uhms.entity.AppointmentEntity;
import com.uhms.uhms.entity.PatientEntity;
import com.uhms.uhms.service.service.DoctorService;
import com.uhms.uhms.service.service.doctor.AppointmentDoctorService;
import com.uhms.uhms.utils.JsonUtils;
import com.uhms.uhms.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AppointmentSelectController {

    @Autowired
    private AppointmentDoctorService appointmentDoctorService;
    @Autowired
    private DoctorService doctorService;
    @RequestMapping(value = "/appointment/select/{doctorId}" ,method = RequestMethod.GET)
    public String appointmentSelect(@PathVariable("doctorId")String doctorId, Model model){
        List<AppointmentEntity> appointmentEntityList= appointmentDoctorService.getAllByDoctorId(doctorId);
        DoctorDto doctorDto = doctorService.getById(doctorId);
        model.addAttribute("appointmentList",appointmentEntityList);
        model.addAttribute("doctor",doctorDto);
        LogUtils.info(appointmentEntityList+"");
        return "doctor/appointmentSelect";
    }
    @RequestMapping(value = "/confirm/{appointmentId}/{doctorId}",method =RequestMethod.GET)
    public String selectDetailPatient(@PathVariable("appointmentId")String appointmentId,@PathVariable("doctorId")String doctorId,Model model){
        appointmentDoctorService.changeAppointment(appointmentId);
        List<AppointmentEntity> appointmentEntityList= appointmentDoctorService.getAllByDoctorId(doctorId);
        DoctorDto doctorDto = doctorService.getById(doctorId);
        model.addAttribute("appointmentList",appointmentEntityList);
        model.addAttribute("doctor",doctorDto);
        LogUtils.info("confirm");
        return "doctor/appointmentSelect";
    }
}
