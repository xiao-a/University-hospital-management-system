package com.uhms.uhms.service.serviceimpl.patient;

import com.uhms.uhms.dao.dao.DoctorDao;
import com.uhms.uhms.dao.dao.WatchListDao;
import com.uhms.uhms.entity.DoctorEntity;
import com.uhms.uhms.entity.WatchListEntity;
import com.uhms.uhms.enums.DayWeekEnum;
import com.uhms.uhms.enums.DivisionTypeEnum;
import com.uhms.uhms.service.service.patient.TodayWorkDoctorService;
import com.uhms.uhms.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodayWorkDoctorServiceImpl implements TodayWorkDoctorService {
    @Autowired
    private WatchListDao watchListDao;
    @Autowired
    private DoctorDao doctorDao;
    DoctorEntity doctorEntity=new DoctorEntity();
    @Override
    public List<DoctorEntity> getDayWordDoctor() {
        List<DoctorEntity> doctorEntityList=new ArrayList<>();
        WatchListEntity watchListEntityByDayWeek = watchListDao.getWatchListEntityByDayWeek(DayWeekEnum.getTypeByName(DateUtils.getWeekOfDate()));
        doctorEntity=doctorDao.getById(watchListEntityByDayWeek.getNkDoctorId());
        doctorEntity.setDivision(DivisionTypeEnum.getNameByType(doctorEntity.getDivision()));
        doctorEntityList.add(doctorEntity);
        doctorEntity=doctorDao.getById(watchListEntityByDayWeek.getWkDoctorId());
        doctorEntity.setDivision(DivisionTypeEnum.getNameByType(doctorEntity.getDivision()));
        doctorEntityList.add(doctorEntity);
        doctorEntity=doctorDao.getById(watchListEntityByDayWeek.getFkDoctorId());
        doctorEntity.setDivision(DivisionTypeEnum.getNameByType(doctorEntity.getDivision()));
        doctorEntityList.add(doctorEntity);
        doctorEntity=doctorDao.getById(watchListEntityByDayWeek.getGkDoctorId());
        doctorEntity.setDivision(DivisionTypeEnum.getNameByType(doctorEntity.getDivision()));
        doctorEntityList.add(doctorEntity);
        doctorEntity=doctorDao.getById(watchListEntityByDayWeek.getWgkDoctorId());
        doctorEntity.setDivision(DivisionTypeEnum.getNameByType(doctorEntity.getDivision()));
        doctorEntityList.add(doctorEntity);
        doctorEntity=doctorDao.getById(watchListEntityByDayWeek.getPfkDoctorId());
        doctorEntity.setDivision(DivisionTypeEnum.getNameByType(doctorEntity.getDivision()));
        doctorEntityList.add(doctorEntity);
        return doctorEntityList;
    }
}
