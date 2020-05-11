package com.uhms.uhms.controller.admin;

import com.uhms.uhms.entity.AdminEntity;
import com.uhms.uhms.service.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/admin")
public class AdminMainController {

        @Autowired
        private AdminService adminService;
        @RequestMapping("/main/{adminId}")
        public String getMyInfo(@PathVariable("adminId") String adminId, Model model, HttpServletRequest request) {
            AdminEntity adminEntity = adminService.getById(adminId);
            model.addAttribute("admin",adminEntity);
            return "admin/main";
        }

}
