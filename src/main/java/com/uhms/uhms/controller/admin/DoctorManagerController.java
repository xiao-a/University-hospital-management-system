package com.uhms.uhms.controller.admin;

import com.uhms.uhms.dto.DoctorDto;
import com.uhms.uhms.entity.AdminEntity;
import com.uhms.uhms.service.service.doctor.DoctorService;
import com.uhms.uhms.service.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class DoctorManagerController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private DoctorService doctorService;
    @RequestMapping("/admin/select_doctor/{adminId}")
    public String adminSelectDoctor(@PathVariable("adminId")String adminId,Model model){
        AdminEntity adminEntity = adminService.getById(adminId);
        List<DoctorDto> doctorDtoList = doctorService.getAll();
        model.addAttribute("admin",adminEntity);
        model.addAttribute("doctorList",doctorDtoList);
        return "admin/doctorSelect";
    }
    @RequestMapping(value = "/admin_select_doctor_detail/{adminId}/{doctorId}" ,method = RequestMethod.GET)
    public String adminSelectDetailDoctor(@PathVariable("adminId")String adminId,@PathVariable("doctorId")String doctorId,Model model){
        AdminEntity adminEntity = adminService.getById(adminId);
        DoctorDto doctorDto = doctorService.getById(doctorId);
        model.addAttribute("doctor",doctorDto);
        model.addAttribute("admin",adminEntity);
        return "admin/doctorDetailSelect";
    }

    @RequestMapping(value = "/admin_update_doctor/{adminId}/{doctorId}",method = RequestMethod.GET)
    public String adminUpdateDoctor(@PathVariable("adminId")String adminId,@PathVariable("doctorId")String doctorId,Model model){
        AdminEntity adminEntity = adminService.getById(adminId);
        DoctorDto doctorDto = doctorService.getById(doctorId);
        model.addAttribute("doctor",doctorDto);
        model.addAttribute("admin",adminEntity);
        return "admin/doctorUpdate";
    }

    @RequestMapping(value = "/doctor_update_submission" ,method = RequestMethod.POST)
    public String doctorUpdateSubmission(DoctorDto doctorDto, Model model, HttpServletRequest request) {
        doctorService.updateJpa(doctorDto);
        DoctorDto doctor = doctorService.getById(doctorDto.getDoctorId());
        model.addAttribute("doctor",doctor);
        model.addAttribute("admin",adminService.getById(doctorDto.getAdminId()));
        return "admin/doctorUpdate";
    }
    @RequestMapping(value = "/delete_doctor/{adminId}/{doctorId}",method = RequestMethod.GET)
    public String deletePatient(@PathVariable("adminId")String adminId,@PathVariable("doctorId")String doctorId,Model model){
        doctorService.deleteById(doctorId);
        AdminEntity admin = adminService.getById(adminId);
        List<DoctorDto> doctorDtoList = doctorService.getAll();
        model.addAttribute("admin",admin);
        model.addAttribute("doctorList",doctorDtoList);
        return "admin/doctorSelect";
    }
    @RequestMapping(value = "/doctor_insert/{adminId}" ,method = RequestMethod.GET)
    public String insertDoctor(@PathVariable("adminId")String adminId,Model model){
        AdminEntity adminEntity = adminService.getById(adminId);
        model.addAttribute("admin",adminEntity);
        return "admin/doctorInsert";
    }
    @RequestMapping(value = "/doctor_insert_submission" ,method = RequestMethod.POST)
    public String insertDoctorSubmission(DoctorDto doctorDto, Model model){
        doctorService.insert(doctorDto);
        AdminEntity admin = adminService.getById(doctorDto.getAdminId());
        List<DoctorDto> doctorDtoList = doctorService.getAll();
        model.addAttribute("admin",admin);
        model.addAttribute("doctorList",doctorDtoList);
        return "admin/doctorSelect";
    }
}
