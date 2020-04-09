package com.uhms.uhms.controller;

import com.uhms.uhms.entity.DoctorEntity;
import com.uhms.uhms.service.service.DoctorService;
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
    @RequestMapping(value = "/login/submit" ,method = RequestMethod.POST)
    public String loginSubmission(HttpServletRequest request, HttpServletResponse response, Model model) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int i = doctorService.login(username, password);
        if(i>0)
            return "/main";
        else
            return "/loginFail";
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
