package com.uhms.uhms.controller;

import com.uhms.uhms.dto.DoctorDto;
import com.uhms.uhms.dto.PatientDto;
import com.uhms.uhms.entity.AdminEntity;
import com.uhms.uhms.entity.PatientEntity;
import com.uhms.uhms.enums.IdentifyEnum;
import com.uhms.uhms.service.service.admin.HospitalInfoService;
import com.uhms.uhms.service.service.admin.NewsService;
import com.uhms.uhms.service.service.doctor.DoctorService;
import com.uhms.uhms.service.service.LoginService;
import com.uhms.uhms.service.service.patient.PatientService;
import com.uhms.uhms.service.service.admin.AdminService;
import com.uhms.uhms.service.service.patient.TodayWorkDoctorService;
import com.uhms.uhms.utils.DateUtils;
import com.uhms.uhms.utils.EmptyUtils;
import com.uhms.uhms.utils.LogUtils;
import com.uhms.uhms.utils.SMSUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Controller
public class LoginController{
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private TodayWorkDoctorService todayWorkDoctorService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private NewsService newsService;
    @Autowired
    private HospitalInfoService hospitalInfoService;

    private String url;   //图片保存路径
    @Value("${com.uhms}") //获取项目使用tomcat端口号
    private  String post;
    private  String host;   //获取主机名
    private String rootPath="D:";  //图片根路径
    private String sonPath="/file/"; //图片子路径

    @RequestMapping(value = {"/index","/",""})
    public String index(Model model) {
        model.addAttribute("todayWorkDoctor",todayWorkDoctorService.getDayWordDoctor());
        model.addAttribute("date", DateUtils.showYearMonthDayStr());
        PatientDto patientDto = new PatientDto();
        patientDto.setName("登录");
        model.addAttribute("patient",patientDto);
        model.addAttribute("newsList",newsService.getAll());
        model.addAttribute("hospitalInfo",hospitalInfoService.getHospitalInfo());
        LogUtils.info("hospitalInfo"+hospitalInfoService.getHospitalInfo());
        return "index";
    }
    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("msg",null);
        return "/login";
    }
    @RequestMapping("/exit")
    public String exit(Model model,HttpSession session) {
        model.addAttribute("msg",null);
        session.setAttribute("LoginInfo",null);
        model.addAttribute("todayWorkDoctor",todayWorkDoctorService.getDayWordDoctor());
        model.addAttribute("date", DateUtils.showYearMonthDayStr());
        PatientDto patientDto = new PatientDto();
        patientDto.setName("登录");
        model.addAttribute("patient",patientDto);
        model.addAttribute("newsList",newsService.getAll());
        model.addAttribute("hospitalInfo",hospitalInfoService.getHospitalInfo());
        return "/index";
    }
    @RequestMapping(value ={ "/login/submit"} ,method = RequestMethod.POST)
    public String loginSubmission(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession httpSession) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String identify=request.getParameter("identify");
        LogUtils.info("identify:"+identify);
        String id = loginService.Login(username, password, identify);
        LogUtils.info("ID:"+id);
        if(EmptyUtils.isEmpty(id)){
            model.addAttribute("msg","用户名或密码错误，请重新填写！");
            return "/login";
        }else {
            if(IdentifyEnum.PATIENT.getType().equals(identify)){
                PatientEntity patient= patientService.getById(id);
                model.addAttribute("todayWorkDoctor",todayWorkDoctorService.getDayWordDoctor());
                model.addAttribute("date", DateUtils.showYearMonthDayStr());
                LogUtils.info(patient+"");
                model.addAttribute("patient",patient);
                model.addAttribute("newsList",newsService.getAll());
                model.addAttribute("hospitalInfo",hospitalInfoService.getHospitalInfo());
                httpSession.setAttribute("LoginInfo",id);
                return "/index";
            }else if(IdentifyEnum.DOCTOR.getType().equals(identify)){
                DoctorDto dto = doctorService.getById(id);
                model.addAttribute("doctor",dto);
                httpSession.setAttribute("LoginInfo",id);
                return "doctor/main";
            }else {
                AdminEntity adminEntity = adminService.getById(id);
                model.addAttribute("admin",adminEntity);
                httpSession.setAttribute("LoginInfo",id);
                return "admin/main";
            }

        }
    }
    @RequestMapping("/main/{doctorId}")
    public String UpdateMyInfo(@PathVariable("doctorId") String doctorId, Model model, HttpServletRequest request) {
        DoctorDto dto = doctorService.getById(doctorId);
        model.addAttribute("doctor",dto);
        return "doctor/main";
    }



    @RequestMapping("/register")
    public String hello() {
        return "/register";
    }
    @RequestMapping(value = "/register/submit",method = RequestMethod.POST)
    public String registerSubmission(PatientDto patientDto,Model model, @RequestParam("ai_files") MultipartFile file,HttpSession httpSession) {

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
        patientDto.setHeadUrl(filesPath);
        patientService.insert(patientDto);
        LogUtils.info("patientDto"+patientDto);
        String id = loginService.Login(patientDto.getUsername(), patientDto.getPassword(), IdentifyEnum.PATIENT.getType());
        httpSession.setAttribute("LoginInfo",id);
        PatientEntity patientEntity = patientService.getById(id);
        model.addAttribute("todayWorkDoctor",todayWorkDoctorService.getDayWordDoctor());
        model.addAttribute("date", DateUtils.showYearMonthDayStr());
        model.addAttribute("patient",patientEntity);
        model.addAttribute("newsList",newsService.getAll());
        model.addAttribute("hospitalInfo",hospitalInfoService.getHospitalInfo());
        return "/index";
    }


    @RequestMapping(value = "/jhk",method =RequestMethod.POST)
    public String fajsklfjk(Model model) {
        SMSUtils.sendMessage("15236561632","您的验证码为4534，有效时间为5分钟！");
        return "/login";
    }

}
