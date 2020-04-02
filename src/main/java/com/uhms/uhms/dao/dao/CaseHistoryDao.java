package com.uhms.uhms.dao.dao;

import com.uhms.uhms.entity.AppointmentEntity;
import com.uhms.uhms.entity.CaseHistoryEntity;

import java.util.List;

public interface CaseHistoryDao {
    void insert(CaseHistoryEntity caseHistoryEntity);
    void deleteById(String id);
    CaseHistoryEntity getById(String id);
    List<CaseHistoryEntity> getAll();
    void update(String id, CaseHistoryEntity caseHistoryEntity);
}
