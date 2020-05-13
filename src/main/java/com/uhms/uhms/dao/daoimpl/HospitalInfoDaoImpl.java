package com.uhms.uhms.dao.daoimpl;

import com.uhms.uhms.dao.dao.HospitalInfoDao;
import com.uhms.uhms.dao.dao.WatchListDao;
import com.uhms.uhms.entity.HospitalInfoEntity;
import com.uhms.uhms.entity.WatchListEntity;
import com.uhms.uhms.enums.DataStatusEnum;
import com.uhms.uhms.repository.HospitalInfoRepository;
import com.uhms.uhms.repository.WatchListRepository;
import com.uhms.uhms.utils.DateUtils;
import com.uhms.uhms.utils.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HospitalInfoDaoImpl implements HospitalInfoDao {
    @Autowired
    private HospitalInfoRepository hospitalInfoRepository;

    @Override
    public void insert(HospitalInfoEntity hospitalInfoEntity) {
        hospitalInfoEntity.setHospitalInfoId(IdUtils.createID("hospitalInfo"));
        hospitalInfoEntity.setCreateDate(DateUtils.getCurrentDate());
        hospitalInfoEntity.setUpdateDate( DateUtils.getCurrentDate());
        hospitalInfoEntity.setStatus(DataStatusEnum.VALID.getType());
        hospitalInfoRepository.save(hospitalInfoEntity);
    }

    @Override
    public void deleteById(String id) {
        hospitalInfoRepository.deleteById(id);
    }

    @Override
    public HospitalInfoEntity getById(String id) {
        return hospitalInfoRepository.getOne(id);
    }

    @Override
    public List<HospitalInfoEntity> getAll() {
        return hospitalInfoRepository.findAll();
    }

    @Override
    public void update(HospitalInfoEntity hospitalInfoEntity) {
        hospitalInfoRepository.save(hospitalInfoEntity);
    }
}
