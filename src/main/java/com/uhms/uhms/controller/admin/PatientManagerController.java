package com.uhms.uhms.controller.admin;

import com.uhms.uhms.dto.PatientDto;
import com.uhms.uhms.entity.AdminEntity;
import com.uhms.uhms.entity.PatientEntity;
import com.uhms.uhms.service.service.admin.AdminService;
import com.uhms.uhms.service.service.patient.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PatientManagerController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private AdminService adminService;
    @RequestMapping("/admin/select_patient/{adminId}")
    public String adminSelectPatient(@PathVariable("adminId")String adminId,Model model){
        AdminEntity adminEntity = adminService.getById(adminId);
        List<PatientEntity> patientList = patientService.findAll();
        model.addAttribute("admin",adminEntity);
        model.addAttribute("patientList",patientList);
        model.addAttribute("msg",null);
        return "admin/patientSelect";
    }
    @RequestMapping(value = "/admin_select_patient_detail/{adminId}/{patientId}" ,method = RequestMethod.GET)
    public String adminSelectDetailPatient(@PathVariable("adminId")String adminId,@PathVariable("patientId")String patientId,Model model){
        AdminEntity adminEntity = adminService.getById(adminId);
        PatientEntity patient = patientService.getById(patientId);
        System.out.println(patient);
        model.addAttribute("admin",adminEntity);
        model.addAttribute("patient",patient);
        return "admin/patientDetailSelect";
    }

    @RequestMapping(value = "/update_patient/{adminId}/{patientId}",method = RequestMethod.GET)
    public String adminUpdatePatient(@PathVariable("adminId")String adminId,@PathVariable("patientId")String patientId,Model model){
        AdminEntity adminEntity = adminService.getById(adminId);
        PatientEntity patient = patientService.getById(patientId);
        model.addAttribute("admin",adminEntity);
        model.addAttribute("patient",patient);
        return "admin/patientUpdate";
    }

    @RequestMapping(value = "/admin_patient_update_submission" ,method = RequestMethod.POST)
    public String patientUpadateSubmission(PatientDto patientDto, Model model, HttpServletRequest request) {
        patientService.updateJpa(patientDto);
        PatientEntity patientEntity = patientService.getById(patientDto.getPatientId());
        model.addAttribute("patient",patientEntity);
        model.addAttribute("admin",adminService.getById(patientDto.getAdminId()));
        return "admin/patientUpdate";
    }
    @RequestMapping(value = "/delete_patient/{adminId}/{patientId}",method = RequestMethod.GET)
    public String adminDeletePatient(@PathVariable("adminId")String adminId,@PathVariable("patientId")String patientId,Model model){
        patientService.deleteById(patientId);
        AdminEntity adminEntity = adminService.getById(adminId);
        List<PatientEntity> patientList = patientService.findAll();
        model.addAttribute("admin",adminEntity);
        model.addAttribute("patientList",patientList);
        model.addAttribute("msg",null);
        return "admin/patientSelect";
    }
    @RequestMapping(value = "/patient_insert/{adminId}" ,method = RequestMethod.GET)
    public String adminInsertPatient(@PathVariable("adminId")String adminId,Model model){
        AdminEntity adminEntity = adminService.getById(adminId);
        model.addAttribute("admin",adminEntity);
        return "admin/patientInsert";
    }
    @RequestMapping(value = "/patient_insert_submission" ,method = RequestMethod.POST)
    public String selectDetailPatientSubmission(PatientDto patientDto, Model model){
        patientService.insert(patientDto);
        List<PatientEntity> patientList = patientService.findAll();
        model.addAttribute("patientList",patientList);
        model.addAttribute("admin",adminService.getById(patientDto.getAdminId()));
        model.addAttribute("msg",null);
        return "admin/patientSelect";
    }
}
