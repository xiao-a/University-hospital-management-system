package com.uhms.uhms.controller;

import com.uhms.uhms.service.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController{
    @Autowired
    private DoctorService doctorService;
    @RequestMapping("/login")
    public String hello() {
        return "/login";
    }
    @RequestMapping("/login/submit")
    public String loginSubmission(HttpServletRequest request, HttpServletResponse response, Model model) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int i = doctorService.login(username, password);
        if(i>0)
            return "/main";
        else
            return "/loginFail";
    }

}
