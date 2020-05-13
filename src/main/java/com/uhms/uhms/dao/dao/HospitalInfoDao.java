package com.uhms.uhms.dao.dao;

import com.uhms.uhms.entity.HospitalInfoEntity;
import com.uhms.uhms.entity.WatchListEntity;

import java.util.List;

public interface HospitalInfoDao {
    void insert(HospitalInfoEntity hospitalInfoEntity);
    void deleteById(String id);
    HospitalInfoEntity getById(String id);
    List<HospitalInfoEntity> getAll();
    void update(HospitalInfoEntity hospitalInfoEntity);
}
