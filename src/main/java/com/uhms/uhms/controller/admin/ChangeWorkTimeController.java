package com.uhms.uhms.controller.admin;

import com.uhms.uhms.dao.dao.WatchListDao;
import com.uhms.uhms.dto.PatientDto;
import com.uhms.uhms.entity.AdminEntity;
import com.uhms.uhms.entity.PatientEntity;
import com.uhms.uhms.entity.WatchListEntity;
import com.uhms.uhms.service.service.admin.AdminService;
import com.uhms.uhms.service.service.admin.WatchListService;
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
public class ChangeWorkTimeController {
   @Autowired
   private WatchListService watchListService;

    @RequestMapping("/watchList_select/{adminId}")
    public String login(Model model,@PathVariable("adminId") String id) {
        List<WatchListEntity> watchListEntityList = watchListService.getAll();
        model.addAttribute("watchListList",watchListEntityList);
        return "/login";
    }
}
