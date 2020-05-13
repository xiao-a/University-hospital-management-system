package com.uhms.uhms.service.serviceimpl.admin;

import com.uhms.uhms.dao.dao.HospitalInfoDao;
import com.uhms.uhms.dao.dao.NewsDao;
import com.uhms.uhms.dto.HospitalInfoDto;
import com.uhms.uhms.dto.NewsDto;
import com.uhms.uhms.entity.HospitalInfoEntity;
import com.uhms.uhms.entity.NewsEntity;
import com.uhms.uhms.enums.DataStatusEnum;
import com.uhms.uhms.repository.HospitalInfoRepository;
import com.uhms.uhms.service.service.admin.HospitalInfoService;
import com.uhms.uhms.service.service.admin.NewsService;
import com.uhms.uhms.utils.DateUtils;
import com.uhms.uhms.utils.IdUtils;
import com.uhms.uhms.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalInfoServiceImpl implements HospitalInfoService {

    @Autowired
    private HospitalInfoDao hospitalInfoDao;

    @Override
    public void insert(HospitalInfoEntity hospitalInfoEntity) {
        hospitalInfoEntity.setHospitalInfoId(IdUtils.createID("hospitalInfo"));
        hospitalInfoEntity.setCreateDate(DateUtils.getCurrentDate());
        hospitalInfoEntity.setUpdateDate( DateUtils.getCurrentDate());
        hospitalInfoEntity.setStatus(DataStatusEnum.VALID.getType());
        hospitalInfoDao.insert(hospitalInfoEntity);
    }

    @Override
    public void deleteById(String id) {
        hospitalInfoDao.deleteById(id);
    }

    @Override
    public HospitalInfoEntity getById(String id) {
        return hospitalInfoDao.getById(id);
    }
    @Override
    public void update(HospitalInfoDto hospitalInfoDto) {
        HospitalInfoEntity hospitalInfoEntity = hospitalInfoDao.getHospitalInfo();
        hospitalInfoEntity.setCommonStartTime(hospitalInfoDto.getCommonStartTime());
        hospitalInfoEntity.setCommonEndTime(hospitalInfoDto.getCommonEndTime());
        hospitalInfoEntity.setWeekStartTime(hospitalInfoDto.getWeekStartTime());
        hospitalInfoEntity.setWeekEndTime(hospitalInfoDto.getWeekEndTime());
        hospitalInfoEntity.setPhoneNumber(hospitalInfoDto.getPhoneNumber());
        hospitalInfoEntity.setAddress(hospitalInfoDto.getAddress());
        LogUtils.info("Service->hospitalInfoEntity:"+hospitalInfoEntity);
        hospitalInfoDao.update(hospitalInfoEntity);
    }

    @Override
    public HospitalInfoEntity getHospitalInfo() {
        HospitalInfoEntity hospitalInfo = hospitalInfoDao.getHospitalInfo();
        LogUtils.info("hospitalInfo:"+hospitalInfo);
        return hospitalInfo;
    }
}
