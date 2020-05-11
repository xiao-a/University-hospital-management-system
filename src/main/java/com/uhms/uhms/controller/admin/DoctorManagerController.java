package com.uhms.uhms.controller.admin;

import com.uhms.uhms.dto.DoctorDto;
import com.uhms.uhms.dto.PatientDto;
import com.uhms.uhms.entity.AdminEntity;
import com.uhms.uhms.entity.PatientEntity;
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
    public String adminSelectDetailPatient(@PathVariable("adminId")String adminId,@PathVariable("doctorId")String doctorId,Model model){
        AdminEntity adminEntity = adminService.getById(adminId);
        DoctorDto doctorDto = doctorService.getById(doctorId);
        model.addAttribute("doctor",doctorDto);
        model.addAttribute("admin",adminEntity);
        return "admin/doctorDetailSelect";
    }
//
//    @RequestMapping(value = "/update_patient/{adminId}/{patientId}",method = RequestMethod.GET)
//    public String updatePatient(@PathVariable("adminId")String adminId,@PathVariable("patientId")String patientId,Model model){
//        DoctorDto doctorDto = doctorService.getById(adminId);
//        PatientEntity patient = patientService.getById(patientId);
//        System.out.println(patient);
//        model.addAttribute("doctor",doctorDto);
//        model.addAttribute("patient",patient);
//        return "admin/patientUpdate";
//    }
//
//    @RequestMapping(value = "/patient_update_submission" ,method = RequestMethod.POST)
//    public String patientUpadateSubmission(PatientDto patientDto, Model model, HttpServletRequest request) {
//        patientService.updateJpa(patientDto);
//        PatientEntity patientEntity = patientService.getById(patientDto.getPatientId());
//        model.addAttribute("patient",patientEntity);
//        System.out.println(patientEntity);
//        return "admin/patientUpdate";
//    }
//    @RequestMapping(value = "/delete_patient/{adminId}/{patientId}",method = RequestMethod.GET)
//    public String deletePatient(@PathVariable("adminId")String adminId,@PathVariable("patientId")String patientId,Model model){
//        patientService.deleteById(patientId);
//        DoctorDto doctorDto = doctorService.getById(adminId);
//        List<PatientEntity> patientList = patientService.findAll();
//        model.addAttribute("doctor",doctorDto);
//        model.addAttribute("patientList",patientList);
//        model.addAttribute("msg",null);
//        return "admin/patientSelect";
//    }
//    @RequestMapping(value = "/patient_insert/{adminId}" ,method = RequestMethod.GET)
//    public String selectDetailPatient(@PathVariable("adminId")String adminId,Model model){
//        DoctorDto doctorDto = doctorService.getById(adminId);
//        model.addAttribute("doctor",doctorDto);
//        return "admin/patientInsert";
//    }
//    @RequestMapping(value = "/patient_insert_submission" ,method = RequestMethod.POST)
//    public String selectDetailPatientSubmission(PatientDto patientDto, Model model){
//        patientService.insert(patientDto);
//        List<PatientEntity> patientList = patientService.findAll();
//        model.addAttribute("patientList",patientList);
//        model.addAttribute("msg",null);
//        return "admin/patientSelect";
//    }
}
