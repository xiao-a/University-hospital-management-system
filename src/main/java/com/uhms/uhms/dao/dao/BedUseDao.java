package com.uhms.uhms.dao.dao;

import com.uhms.uhms.entity.BedUseEntity;

import java.util.List;


public interface BedUseDao {
    void insert(BedUseEntity bedUseEntity);
    void deleteById(String id);
    BedUseEntity getById(String id);
    List<BedUseEntity> getAll();
    void update(String id,BedUseEntity bedUseEntity);

}
