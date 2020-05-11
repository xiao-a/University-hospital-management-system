package com.uhms.uhms.service.serviceimpl.patient;

import com.uhms.uhms.dao.dao.AppointmentDao;
import com.uhms.uhms.dao.dao.DoctorDao;
import com.uhms.uhms.dao.dao.PatientDao;
import com.uhms.uhms.dao.dao.WatchListDao;
import com.uhms.uhms.dto.AppointmentDto;
import com.uhms.uhms.dto.AppointmentHistoryDto;
import com.uhms.uhms.entity.AppointmentEntity;
import com.uhms.uhms.entity.WatchListEntity;
import com.uhms.uhms.enums.AppointmentStatusEnum;
import com.uhms.uhms.enums.DayWeekEnum;
import com.uhms.uhms.enums.DivisionTypeEnum;
import com.uhms.uhms.service.service.patient.AppointmentService;
import com.uhms.uhms.utils.DateUtils;
import com.uhms.uhms.utils.JsonUtils;
import com.uhms.uhms.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentDao appointmentDao;
    @Autowired
    WatchListDao watchListDao;
    @Autowired
    DoctorDao doctorDao;
    @Autowired
    PatientDao patientDao;
    AppointmentEntity appointmentEntity=new AppointmentEntity();


    /**
     * 插入预约信息
     * @param appointmentJson
     */
    @Override
    public void appointmentSubmit(String appointmentJson) {
//        AppointmentDto(patientId=158830267825621258989_patient, division=gynecology, appointmentDate=2020-05-19, msg=多少分开垃圾堆上开了房间)
        AppointmentDto entity = JsonUtils.jsonToPojo(appointmentJson, AppointmentDto.class);
        LogUtils.info(entity+"");
        WatchListEntity watchListEntity = watchListDao.getDoctorId(DayWeekEnum.getTypeByName(DateUtils.getWeekOfDate()));
        switch(entity.getDivision()){
            case "physician" :
                appointmentEntity.setDoctorId(watchListEntity.getNkDoctorId());
                break;
            case "surgery" :
                appointmentEntity.setDoctorId(watchListEntity.getWkDoctorId());
                break; //可选
            case "gynecology" :
                appointmentEntity.setDoctorId(watchListEntity.getFkDoctorId());
                break; //可选
            case "orthopedics" :
                appointmentEntity.setDoctorId(watchListEntity.getGkDoctorId());
                break; //可选
            case "ophthalmology" :
                appointmentEntity.setDoctorId(watchListEntity.getWgkDoctorId());
                break; //可选
            case "dermatology" :
                appointmentEntity.setDoctorId(watchListEntity.getPfkDoctorId());
                break; //可选
            default : //可选
                appointmentEntity.setDoctorId(null);
        }
        appointmentEntity.setDivision(entity.getDivision());
        appointmentEntity.setDoctorName(doctorDao.getById(appointmentEntity.getDoctorId()).getName());
        appointmentEntity.setPatientId(entity.getPatientId());
        appointmentEntity.setPatientName(patientDao.getById(entity.getPatientId()).getName());
        appointmentEntity.setAppointmentDate(DateUtils.StringToDate(entity.getAppointmentDate()));
        appointmentEntity.setMsg(entity.getMsg());
        appointmentDao.insert(appointmentEntity);
    }

    /**
     * 传入患者Id，查看预约历史
     * @param patientId
     * @return
     */
    @Override
    public List<AppointmentHistoryDto> getAllByPatientId(String patientId) {
        LogUtils.info("before:"+appointmentDao.getAllByPatientId(patientId));
        List<AppointmentEntity> entityList = appointmentDao.getAllByPatientId(patientId);
        List<AppointmentHistoryDto> appointmentHistoryDtoList =new ArrayList<>();
        for(int i=0;i<entityList.size();i++) {
            AppointmentHistoryDto appointmentHistoryDto=new AppointmentHistoryDto();
            appointmentHistoryDto.setPatientId(entityList.get(i).getPatientId());
            appointmentHistoryDto.setDivision(DivisionTypeEnum.getNameByType(entityList.get(i).getDivision()));
            appointmentHistoryDto.setDoctorName(entityList.get(i).getDoctorName());
            appointmentHistoryDto.setAppointmentStatus(AppointmentStatusEnum.getNameByType(entityList.get(i).getAppointmentStatus()));
            appointmentHistoryDto.setAppointmentDate(DateUtils.DateToStrHH(entityList.get(i).getAppointmentDate()));
            appointmentHistoryDto.setSubmitDate(DateUtils.DateToStrHH(entityList.get(i).getCreateDate()));
            appointmentHistoryDto.setMsg(entityList.get(i).getMsg());
            appointmentHistoryDtoList.add(appointmentHistoryDto);
        }
        LogUtils.info("after:"+appointmentHistoryDtoList);
        return appointmentHistoryDtoList;
    }
}
