package com.uhms.uhms.dao.daoimpl;

import com.uhms.uhms.dao.dao.CaseHistoryDao;
import com.uhms.uhms.entity.CaseHistoryEntity;
import com.uhms.uhms.repository.CaseHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CaseHistoryDaoImpl implements CaseHistoryDao {
    @Autowired
    private CaseHistoryRepository caseHistoryRepository;
    @Override
    public void insert(CaseHistoryEntity caseHistoryEntity) {

    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public CaseHistoryEntity getById(String id) {
        return null;
    }

    @Override
    public List<CaseHistoryEntity> getAll() {
        return null;
    }

    @Override
    public void update(String id, CaseHistoryEntity caseHistoryEntity) {

    }
}
