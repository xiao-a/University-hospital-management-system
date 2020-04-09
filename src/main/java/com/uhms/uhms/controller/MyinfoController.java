package com.uhms.uhms.controller;

import com.uhms.uhms.entity.DoctorEntity;
import com.uhms.uhms.service.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MyinfoController {
    @Autowired
    private DoctorService doctorService;
    @RequestMapping("/my_info/{id}")
    public String getMyInfo(@PathVariable("id") String id, Model model, HttpServletRequest request) {
        DoctorEntity entity = doctorService.getById(id);
        model.addAttribute("doctor",entity);
        return "/myInfo";
    }

    @RequestMapping("/update_my_info/{id}")
    public String UpdateMyInfo(@PathVariable("id") String id, Model model, HttpServletRequest request) {
        DoctorEntity entity = doctorService.getById(id);
        model.addAttribute("doctor",entity);
        return "/updateMyInfo";
    }
}
