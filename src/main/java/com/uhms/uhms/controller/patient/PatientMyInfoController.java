package com.uhms.uhms.controller.patient;

import com.uhms.uhms.entity.PatientEntity;
import com.uhms.uhms.service.service.patient.PatientService;
import com.uhms.uhms.service.service.patient.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PatientMyInfoController {
    @Autowired
    PatientService patientService;
    @Autowired
    AppointmentService appointmentService;
    @RequestMapping(value = "myinfo/{patientId}" ,method = RequestMethod.GET)
    public String appointmentHistory(@PathVariable("patientId")String patientId,Model model){
        PatientEntity patientEntity = patientService.getById(patientId);
        model.addAttribute("patient",patientEntity);
        return "patient/myinfo";
    }


}
