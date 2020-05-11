package com.uhms.uhms.controller;

import com.uhms.uhms.dto.DoctorDto;
import com.uhms.uhms.dto.PatientDto;
import com.uhms.uhms.entity.AdminEntity;
import com.uhms.uhms.entity.DoctorEntity;
import com.uhms.uhms.entity.PatientEntity;
import com.uhms.uhms.enums.IdentifyEnum;
import com.uhms.uhms.service.service.doctor.DoctorService;
import com.uhms.uhms.service.service.LoginService;
import com.uhms.uhms.service.service.PatientService;
import com.uhms.uhms.service.service.admin.AdminService;
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
    @Autowired
    private PatientService patientService;
    @Autowired
    private AdminService adminService;

    @RequestMapping(value = {"/index","/",""})
    public String index(Model model) {
        model.addAttribute("todayWorkDoctor",todayWorkDoctorService.getDayWordDoctor());
        model.addAttribute("date", DateUtils.showYearMonthDayStr());
        PatientDto patientDto = new PatientDto();
        patientDto.setName("登录");
        model.addAttribute("patient",patientDto);
        return "index";
    }
    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("msg",null);
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
            model.addAttribute("msg","用户名或密码错误，请重新填写！");
            return "/login";
        }else {
            if(IdentifyEnum.PATIENT.getType().equals(identify)){
                PatientEntity patient= patientService.getById(id);
                model.addAttribute("todayWorkDoctor",todayWorkDoctorService.getDayWordDoctor());
                model.addAttribute("date", DateUtils.showYearMonthDayStr());
                LogUtils.info(patient+"");
                model.addAttribute("patient",patient);
                return "/index";
            }else if(IdentifyEnum.DOCTOR.getType().equals(identify)){
                DoctorDto dto = doctorService.getById(id);
                model.addAttribute("doctor",dto);
                return "doctor/main";
            }else {
                AdminEntity adminEntity = adminService.getById(id);
                model.addAttribute("admin",adminEntity);
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
