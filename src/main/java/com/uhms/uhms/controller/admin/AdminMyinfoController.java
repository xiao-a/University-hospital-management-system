package com.uhms.uhms.controller.admin;

import com.uhms.uhms.entity.AdminEntity;
import com.uhms.uhms.service.service.admin.AdminService;
import com.uhms.uhms.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/admin")
public class AdminMyinfoController {
    @Autowired
    private AdminService adminService;
    @RequestMapping("/show_personal/{adminId}")
    public String getMyInfo(@PathVariable("adminId") String adminId, Model model, HttpServletRequest request) {
        AdminEntity adminEntity = adminService.getById(adminId);
        model.addAttribute("admin",adminEntity);
        return "admin/myInfo";
    }

    @RequestMapping("/update_personal/{adminId}")
    public String UpdateMyInfo(@PathVariable("adminId") String adminId, Model model, HttpServletRequest request) {
        AdminEntity adminEntity = adminService.getById(adminId);
        model.addAttribute("admin",adminEntity);
        return "admin/updateMyInfo";
    }
    @RequestMapping(value = "/update_myinfo_submission" ,method = RequestMethod.POST)
    public String UpdateMyInfoSubmission(AdminEntity adminEntity, Model model, HttpServletRequest request) {
        LogUtils.info("adminId:"+adminEntity.getAdminId());
        adminService.updateJpa(adminEntity);
        AdminEntity admin = adminService.getById(adminEntity.getAdminId());
        model.addAttribute("admin",admin);
        return "admin/updateMyInfo";
    }
}
