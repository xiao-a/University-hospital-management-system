package com.uhms.uhms.controller.patient;


import com.uhms.uhms.service.service.patient.AppointmentService;
import com.uhms.uhms.utils.JsonUtils;
import com.uhms.uhms.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("login")
public class PatientsController {
    @Autowired
    private AppointmentService appointmentService;
    @RequestMapping(value = "/appointment/submission",method =RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public String insertAppointment(@RequestBody String o) {
        appointmentService.appointmentSubmit(o);
        LogUtils.info("msg:"+o);
        String msg="预约提交成功，医生确认中!";
        return JsonUtils.objectToJson(msg);
    }
}
