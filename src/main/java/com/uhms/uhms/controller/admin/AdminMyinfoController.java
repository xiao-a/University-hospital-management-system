package com.uhms.uhms.controller.admin;

import com.uhms.uhms.entity.AdminEntity;
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

@Controller
@RequestMapping(value = "/admin")
public class AdminMyinfoController {
    private String url;   //图片保存路径
    @Value("${com.uhms}") //获取项目使用tomcat端口号
    private  String post;
    private  String host;   //获取主机名
    private String rootPath="D:";  //图片根路径
    private String sonPath="/file/"; //图片子路径
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
    public String UpdateMyInfoSubmission(AdminEntity adminEntity, @RequestParam("ai_files") MultipartFile file, Model model, HttpServletRequest request) {
        LogUtils.info("adminId:"+adminEntity.getAdminId());
        LogUtils.info("file:"+file.isEmpty());
        LogUtils.info("EmptyUtils.isNotEmpty(file):"+EmptyUtils.isNotEmpty(file));
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
            adminEntity.setHeadUrl(filesPath);
        }else {
            adminEntity.setHeadUrl(null);
        }

        adminService.updateJpa(adminEntity);
        AdminEntity admin = adminService.getById(adminEntity.getAdminId());
        model.addAttribute("admin",admin);
        return "admin/updateMyInfo";
    }
}
