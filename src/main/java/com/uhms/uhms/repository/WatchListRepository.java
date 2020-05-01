package com.uhms.uhms.repository;

import com.uhms.uhms.entity.WatchListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchListRepository extends JpaRepository<WatchListEntity,String> {
    @Query(value = "select * from t_watch_list where day_week=?1" ,nativeQuery = true)
    WatchListEntity getWatchListEntityByDayWeek(String dayWeek);
    @Query(value = "select * from t_watch_list where day_week=?1" ,nativeQuery = true)
    WatchListEntity getDoctorId(String dayWeek);
}
