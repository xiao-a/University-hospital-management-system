package com.uhms.uhms.controller.admin;

import com.uhms.uhms.dto.DoctorDto;
import com.uhms.uhms.dto.DoctorVagueDto;
import com.uhms.uhms.entity.AdminEntity;
import com.uhms.uhms.service.service.doctor.DoctorService;
import com.uhms.uhms.service.service.admin.AdminService;
import com.uhms.uhms.utils.EmptyUtils;
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
public class DoctorManagerController {
    private String url;   //图片保存路径
    @Value("${com.uhms}") //获取项目使用tomcat端口号
    private  String post;
    private  String host;   //获取主机名
    private String rootPath="D:";  //图片根路径
    private String sonPath="/file/"; //图片子路径
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
    public String doctorUpdateSubmission(DoctorDto doctorDto, Model model,@RequestParam("ai_files") MultipartFile file, HttpServletRequest request) {
        LogUtils.info("EmptyUtils.isNotEmpty(file):"+ EmptyUtils.isNotEmpty(file));
        if(EmptyUtils.isNotEmpty(file)){
            if (file.isEmpty()) {
                return "文件为空";
            }
            try {
                host = InetAddress.getLocalHost().getHostAddress();
            } catch (UnknownHostException e) {
                e.printStackTrace();
                LogUtils.info("get server host Exception e:"+ e);
            }
            String fileName = file.getOriginalFilename();
            String[] strarray=fileName.split("\\\\");
            String x=strarray[strarray.length-1];
            String filePath = rootPath + sonPath;
            LogUtils.info("上传的文件路径：" + fileName);
            LogUtils.info("整个文件路径：" + host + ":" + post + sonPath + x);
            //创建文件路径
            File dest = new File(filePath + x);
            LogUtils.info("dest：" +dest);
            LogUtils.info("post：" +post);
            //
            //String filesPath = (host + ":" + post + sonPath + x).toString();
            String filesPath = (sonPath + x).toString();
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try {
                file.transferTo(dest);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            doctorDto.setHeadUrl(filesPath);
        }else {
            doctorDto.setHeadUrl(null);
        }
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
    public String insertDoctorSubmission(DoctorDto doctorDto, @RequestParam("ai_files") MultipartFile file, Model model){
        if (file.isEmpty()) {
            return "文件为空";
        }
        try {
            host = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            LogUtils.info("get server host Exception e:"+ e);
        }
        String fileName = file.getOriginalFilename();
        String[] strarray=fileName.split("\\\\");
        String x=strarray[strarray.length-1];
        String filePath = rootPath + sonPath;
        LogUtils.info("上传的文件路径：" + fileName);
        LogUtils.info("整个文件路径：" + host + ":" + post + sonPath + x);
        //创建文件路径
        File dest = new File(filePath + x);
        LogUtils.info("dest：" +dest);
        LogUtils.info("post：" +post);
        //
        //String filesPath = (host + ":" + post + sonPath + x).toString();
        String filesPath = (sonPath + x).toString();
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        doctorDto.setHeadUrl(filesPath);
        doctorService.insert(doctorDto);
        AdminEntity admin = adminService.getById(doctorDto.getAdminId());
        List<DoctorDto> doctorDtoList = doctorService.getAll();
        model.addAttribute("admin",admin);
        model.addAttribute("doctorList",doctorDtoList);
        return "admin/doctorSelect";
    }

    @RequestMapping("/admin/select_doctor_vague")
    public String adminSelectDoctorVague(Model model, DoctorVagueDto doctorVagueDto){
        AdminEntity adminEntity = adminService.getById(doctorVagueDto.getAdminId());
        List<DoctorDto> doctorDtoList = doctorService.vague_find(doctorVagueDto.getDoctorId(),doctorVagueDto.getDivision(),doctorVagueDto.getName());
        model.addAttribute("admin",adminEntity);
        model.addAttribute("doctorList",doctorDtoList);
        return "admin/doctorSelect";
    }

}
