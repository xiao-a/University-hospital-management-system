package com.uhms.uhms.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.uhms.uhms.dto.DoctorDto;
import com.uhms.uhms.entity.PatientEntity;
import com.uhms.uhms.service.service.DoctorService;
import com.uhms.uhms.service.service.PatientService;
import com.uhms.uhms.utils.ExcelUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Controller
public class EasyPoiController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private DoctorService doctorService;
    /**
     * 导出
     *
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public void exportExcel(HttpServletResponse response) throws IOException {
        List<PatientEntity> patientList = patientService.findAll();
        System.out.println(patientList);
        ExcelUtils.exportExcel(patientList, "患者信息表", "患者信息sheet", PatientEntity.class, "患者信息表", response);
    }

    /**
     * 导入
     *
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/import", method = RequestMethod.POST)
    public Object importExcel(@RequestParam("file") MultipartFile file) throws IOException {
        long start = System.currentTimeMillis();
        List<PatientEntity> personList = ExcelUtils.importExcel(file, PatientEntity.class);
        System.out.println("导入excel所花时间：" + (System.currentTimeMillis() - start) + "'ms");
        return personList;
    }
    /**
     * 导入
     *
     * @param
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/print_patient_list/{doctorId}", method = RequestMethod.GET)
    public String importToExcel(@PathVariable("doctorId")String doctorId, Model model) throws IOException {
        List<PatientEntity> patientLists = patientService.findAll();
        ExcelUtils.listToExcel("patient",PatientEntity.class,patientLists);
        List<PatientEntity> patientList = patientService.findAll();
        model.addAttribute("patientList",patientList);
        DoctorDto doctorDto = doctorService.getById(doctorId);
        model.addAttribute("doctor",doctorDto);
        model.addAttribute("msg","打印成功路径：D:/excel/");
        return "/patient/patientSelect";
    }
}
