package com.uhms.uhms.controller;

import com.uhms.uhms.dto.DoctorDto;
import com.uhms.uhms.entity.DoctorEntity;
import com.uhms.uhms.service.service.DoctorService;
import com.uhms.uhms.utils.EmptyUtils;
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
    @RequestMapping("/login")
    public String login() {
        return "/login";
    }
    @RequestMapping(value ={ "/login/submit"} ,method = RequestMethod.POST)
    public String loginSubmission(HttpServletRequest request, HttpServletResponse response, Model model) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        DoctorEntity doctorEntity = doctorService.login(username, password);
        System.out.println(doctorEntity);
        if(EmptyUtils.isNotEmpty(doctorEntity)){
            model.addAttribute("doctor",doctorEntity);
            return "/main";
        }else {
            return "/loginFail";
        }
    }
    @RequestMapping("/main/{doctorId}")
    public String UpdateMyInfo(@PathVariable("doctorId") String doctorId, Model model, HttpServletRequest request) {
        DoctorDto dto = doctorService.getById(doctorId);
        model.addAttribute("doctor",dto);
        return "/main";
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
