package com.uhms.uhms.controller;

import com.uhms.uhms.dto.DoctorDto;
import com.uhms.uhms.entity.DoctorEntity;
import com.uhms.uhms.enums.IdentifyEnum;
import com.uhms.uhms.service.service.DoctorService;
import com.uhms.uhms.service.service.LoginService;
import com.uhms.uhms.service.service.patient.TodayWorkDoctorService;
import com.uhms.uhms.utils.DateUtils;
import com.uhms.uhms.utils.EmptyUtils;
import com.uhms.uhms.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController{
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private TodayWorkDoctorService todayWorkDoctorService;
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = {"/index","/",""})
    public String index(Model model) {
        model.addAttribute("todayWorkDoctor",todayWorkDoctorService.getDayWordDoctor());
        model.addAttribute("date", DateUtils.showYearMonthDayStr());
        return "index";
    }
    @RequestMapping("/login")
    public String login() {
        return "/login";
    }
    @RequestMapping(value ={ "/login/submit"} ,method = RequestMethod.POST)
    public String loginSubmission(HttpServletRequest request, HttpServletResponse response, Model model) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String identify=request.getParameter("identify");
        LogUtils.info("identify:"+identify);
        String id = loginService.Login(username, password, identify);
        LogUtils.info("ID:"+id);
        if(EmptyUtils.isEmpty(id)){
            return "/loginFail";
        }else {
            if(IdentifyEnum.PATIENT.getType().equals(identify)){
                model.addAttribute("todayWorkDoctor",todayWorkDoctorService.getDayWordDoctor());
                model.addAttribute("date", DateUtils.showYearMonthDayStr());
                return "/index";
            }else if(IdentifyEnum.DOCTOR.getType().equals(identify)){
                DoctorDto dto = doctorService.getById(id);
                model.addAttribute("doctor",dto);
                return "doctor/main";
            }else {
                return "admin/main";
            }

        }
    }
    @RequestMapping("/main/{doctorId}")
    public String UpdateMyInfo(@PathVariable("doctorId") String doctorId, Model model, HttpServletRequest request) {
        DoctorDto dto = doctorService.getById(doctorId);
        model.addAttribute("doctor",dto);
        return "doctor/main";
    }



    @RequestMapping("/register")
    public String hello() {
        return "/register";
    }
    @RequestMapping(value = "/register/submit",method = RequestMethod.POST)
    public String registerSubmission(DoctorEntity entity) {
        doctorService.insert(entity);
        return "/index";
    }

}
