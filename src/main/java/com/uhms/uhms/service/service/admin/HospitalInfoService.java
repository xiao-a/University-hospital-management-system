package com.uhms.uhms.service.service.admin;

import com.uhms.uhms.dto.HospitalInfoDto;
import com.uhms.uhms.dto.NewsDto;
import com.uhms.uhms.entity.HospitalInfoEntity;
import com.uhms.uhms.entity.NewsEntity;

import java.util.List;

public interface HospitalInfoService {
    void insert(HospitalInfoEntity hospitalInfoEntity);
    void deleteById(String id);
    HospitalInfoEntity getById(String id);
    void update(HospitalInfoDto hospitalInfoDto);
    HospitalInfoEntity getHospitalInfo();
}
