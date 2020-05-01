package com.uhms.uhms.dao.dao;

import com.uhms.uhms.entity.WatchListEntity;

import java.util.List;

public interface WatchListDao {
    void insert(WatchListEntity watchListEntity);
    void deleteById(String id);
    WatchListEntity getById(String id);
    List<WatchListEntity> getAll();
    void update(WatchListEntity watchListEntity);
    WatchListEntity getWatchListEntityByDayWeek(String dayWeek);
    WatchListEntity getDoctorId(String dayWeek);
}
