package com.uhms.uhms.dao.daoimpl;

import com.uhms.uhms.dao.dao.ChangeHospitalDao;
import com.uhms.uhms.entity.ChangeHospitalEntity;
import com.uhms.uhms.enums.DataStatusEnum;
import com.uhms.uhms.repository.ChangeHospitalRepository;
import com.uhms.uhms.utils.DateUtils;
import com.uhms.uhms.utils.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.ws.Action;
import java.util.List;

@Component
public class ChangeHospitalDaoImpl implements ChangeHospitalDao {

    @Autowired
    private ChangeHospitalRepository changeHospitalRepository;
    @Override
    public void insert(ChangeHospitalEntity changeHospitalEntity) {
        changeHospitalEntity.setChangeHospitalId(IdUtils.createID("change_hospital"));
        changeHospitalEntity.setCreateDate(DateUtils.getCurrentDate());
        changeHospitalEntity.setUpdateDate( DateUtils.getCurrentDate());
        changeHospitalEntity.setStatus(DataStatusEnum.VALID.getType());
        changeHospitalRepository.save(changeHospitalEntity);
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public ChangeHospitalEntity getById(String id) {
        return null;
    }

    @Override
    public List<ChangeHospitalEntity> getAll() {
        return changeHospitalRepository.findAll();
    }

    @Override
    public void update(String id, ChangeHospitalEntity changeHospitalEntity) {
        changeHospitalEntity.setUpdateDate(DateUtils.getCurrentDate());
        changeHospitalRepository.save(changeHospitalEntity);
    }
}
