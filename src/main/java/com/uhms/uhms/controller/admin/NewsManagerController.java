package com.uhms.uhms.controller.admin;

import com.uhms.uhms.dto.NewsDto;
import com.uhms.uhms.entity.AdminEntity;
import com.uhms.uhms.entity.NewsEntity;
import com.uhms.uhms.service.service.admin.NewsService;
import com.uhms.uhms.service.service.admin.AdminService;
import com.uhms.uhms.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class NewsManagerController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private NewsService newsService;
    @RequestMapping(value = "/get_news_list/{adminId}" ,method = RequestMethod.GET)
    public String selectDetailPatient(@PathVariable("adminId")String adminId,Model model){
        AdminEntity adminEntity = adminService.getById(adminId);
        List<NewsEntity> all = newsService.getAll();
        LogUtils.info("NewsList:"+all);
        model.addAttribute("admin",adminEntity);
        model.addAttribute("newsList",all);
        return "admin/newsSelect";
    }
    @RequestMapping(value = "/get_news_detail/{adminId}/{newsId}" ,method = RequestMethod.GET)
    public String selectDetailPatient(@PathVariable("adminId")String adminId,@PathVariable("newsId")String newsId,Model model){
        AdminEntity adminEntity = adminService.getById(adminId);
        NewsEntity newsEntity = newsService.getById(newsId);
        model.addAttribute("admin",adminEntity);
        model.addAttribute("news",newsEntity);
        return "admin/newsDetailSelect";
    }

    @RequestMapping(value = "/admin_update_news/{adminId}/{newsId}",method = RequestMethod.GET)
    public String adminUpdateNews(@PathVariable("adminId")String adminId,@PathVariable("newsId")String newsId,Model model){
        AdminEntity adminEntity = adminService.getById(adminId);
        NewsEntity newsEntity = newsService.getById(newsId);
        model.addAttribute("news",newsEntity);
        model.addAttribute("admin",adminEntity);
        return "admin/newsUpdate";
    }

    @RequestMapping(value = "/admin_news_update_submission" ,method = RequestMethod.POST)
    public String doctorUpdateSubmission(NewsDto newsDto, Model model, HttpServletRequest request) {
        newsService.update(newsDto);
        AdminEntity adminEntity = adminService.getById(newsDto.getAdminId());
        NewsEntity newsEntity = newsService.getById(newsDto.getNewsId());
        model.addAttribute("news",newsEntity);
        model.addAttribute("admin",adminEntity);
        return "admin/newsUpdate";
    }
    @RequestMapping(value = "/delete_news/{adminId}/{newsId}",method = RequestMethod.GET)
    public String deletePatient(@PathVariable("adminId")String adminId,@PathVariable("newsId")String newsId,Model model){
        newsService.deleteById(newsId);
        AdminEntity admin = adminService.getById(adminId);
        List<NewsEntity> all = newsService.getAll();
        LogUtils.info("NewsList:"+all);
        model.addAttribute("admin",admin);
        model.addAttribute("newsList",all);
        return "admin/newsSelect";
    }
    @RequestMapping(value = "/news_insert/{adminId}" ,method = RequestMethod.GET)
    public String insertNews(@PathVariable("adminId")String adminId,Model model){
        AdminEntity adminEntity = adminService.getById(adminId);
        model.addAttribute("admin",adminEntity);
        return "admin/newsInsert";
    }
    @RequestMapping(value = "/news_insert_submission" ,method = RequestMethod.POST)
    public String insertNewsSubmission(NewsDto newsDto, Model model){
        newsService.insert(newsDto);
        AdminEntity admin = adminService.getById(newsDto.getAdminId());
        List<NewsEntity> all = newsService.getAll();
        LogUtils.info("NewsList:"+all);
        model.addAttribute("admin",admin);
        model.addAttribute("newsList",all);
        return "admin/newsSelect";
    }

}
