package com.uhms.uhms.controller.admin;

import com.uhms.uhms.dto.HospitalInfoDto;
import com.uhms.uhms.dto.NewsDto;
import com.uhms.uhms.entity.AdminEntity;
import com.uhms.uhms.entity.HospitalInfoEntity;
import com.uhms.uhms.entity.NewsEntity;
import com.uhms.uhms.service.service.admin.AdminService;
import com.uhms.uhms.service.service.admin.HospitalInfoService;
import com.uhms.uhms.service.service.admin.NewsService;
import com.uhms.uhms.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

@Controller
public class HospitalInfoManagerController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private HospitalInfoService hospitalInfoService;
    @RequestMapping(value = "/admin_select_hospitalInfo/{adminId}",method = RequestMethod.GET)
    public String adminSelectHospitalInfo(@PathVariable("adminId")String adminId,Model model){
        AdminEntity adminEntity = adminService.getById(adminId);
        HospitalInfoEntity hospitalInfo = hospitalInfoService.getHospitalInfo();
        model.addAttribute("hospitalInfo",hospitalInfo);
        model.addAttribute("admin",adminEntity);
        return "admin/hospitalInfoSelect";
    }
    @RequestMapping(value = "/admin_update_hospitalInfo/{adminId}/{hospitalInfoId}",method = RequestMethod.GET)
    public String adminUpdateHospitalInfo(@PathVariable("adminId")String adminId,@PathVariable("hospitalInfoId")String hospitalInfoId,Model model){
        AdminEntity adminEntity = adminService.getById(adminId);
        HospitalInfoEntity hospitalInfo = hospitalInfoService.getHospitalInfo();
        model.addAttribute("hospitalInfo",hospitalInfo);
        model.addAttribute("admin",adminEntity);
        return "admin/hospitalInfoUpdate";
    }

    @RequestMapping(value = "/admin__hospitalInfo_update_submission" ,method = RequestMethod.POST)
    public String doctorUpdateSubmissionHospitalInfo(HospitalInfoDto hospitalInfoDto, Model model, HttpServletRequest request) {
        hospitalInfoService.update(hospitalInfoDto);
        AdminEntity adminEntity = adminService.getById(hospitalInfoDto.getAdminId());
        HospitalInfoEntity hospitalInfo = hospitalInfoService.getHospitalInfo();
        model.addAttribute("hospitalInfo",hospitalInfo);
        model.addAttribute("admin",adminEntity);
        return "admin/hospitalInfoUpdate";
    }
}
