package com.uhms.uhms.controller.patient;

import com.uhms.uhms.service.service.DoctorService;
import com.uhms.uhms.service.service.PatientService;
import com.uhms.uhms.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class PatientsController {
    @RequestMapping(value = "/appointment/submission",method =RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public String selectPatient(@RequestBody String o) {
        LogUtils.info("msg:"+o);
        return o+"123456";
    }
}
