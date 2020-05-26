package com.uhms.uhms.controller.doctor;

import com.uhms.uhms.dto.DoctorDto;
import com.uhms.uhms.service.service.doctor.DoctorService;
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

@Controller
public class doctorMyInfoController {
    private String url;   //图片保存路径
    @Value("${com.uhms}") //获取项目使用tomcat端口号
    private  String post;
    private  String host;   //获取主机名
    private String rootPath="D:";  //图片根路径
    private String sonPath="/file/"; //图片子路径
    @Autowired
    private DoctorService doctorService;
    @RequestMapping("/my_info/{doctorId}")
    public String getMyInfo(@PathVariable("doctorId") String doctorId, Model model, HttpServletRequest request) {
        DoctorDto dto = doctorService.getById(doctorId);
        model.addAttribute("doctor",dto);
        LogUtils.info("DoctorDto:"+dto);
        return "doctor/myInfo";
    }

    @RequestMapping("/update_my_info/{doctorId}")
    public String UpdateMyInfo(@PathVariable("doctorId") String doctorId, Model model, HttpServletRequest request) {
        DoctorDto dto = doctorService.getById(doctorId);
        model.addAttribute("doctor",dto);
        return "doctor/updateMyInfo";
    }
    @RequestMapping(value = "/update_myinfo_submission" ,method = RequestMethod.POST)
    public String UpdateMyInfoSubmission(DoctorDto doctorDto, Model model, @RequestParam("ai_files") MultipartFile file, HttpServletRequest request) {
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
        DoctorDto doctorEntity = doctorService.getById(doctorDto.getDoctorId());
        model.addAttribute("doctor",doctorEntity);
        return "doctor/updateMyInfo";
    }
}
