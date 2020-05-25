package com.uhms.uhms.service.service.admin;

import com.uhms.uhms.entity.WatchListEntity;

import java.util.List;

public interface WatchListService {
    void insert(WatchListEntity watchListEntity);
    void deleteById(String id);
    WatchListEntity getById(String id);
    List<WatchListEntity> getAll();
    void update(WatchListEntity watchListEntity);
}
