package com.uhms.uhms.dao.dao;


import com.uhms.uhms.entity.BedEntity;

import java.util.List;

public interface BedDao  {
    void insert(BedEntity bedEntity);
    void deleteById(String id);
    BedEntity getById(String id);
    List<BedEntity> getAll();
    void update(String id,BedEntity bedEntity);
}
