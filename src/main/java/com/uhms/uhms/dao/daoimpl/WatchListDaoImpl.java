package com.uhms.uhms.dao.daoimpl;

import com.uhms.uhms.dao.dao.WatchListDao;
import com.uhms.uhms.entity.WatchListEntity;
import com.uhms.uhms.enums.DataStatusEnum;
import com.uhms.uhms.repository.WatchListRepository;
import com.uhms.uhms.utils.DateUtils;
import com.uhms.uhms.utils.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WatchListDaoImpl implements WatchListDao {
    @Autowired
    private WatchListRepository watchListRepository;

    @Override
    public void insert(WatchListEntity watchListEntity) {
        watchListEntity.setWatchListId(IdUtils.createID("watch_list"));
        watchListEntity.setCreateDate(DateUtils.getCurrentDate());
        watchListEntity.setUpdateDate( DateUtils.getCurrentDate());
        watchListEntity.setStatus(DataStatusEnum.VALID.getType());
        watchListRepository.save(watchListEntity);
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public WatchListEntity getById(String id) {
        return null;
    }

    @Override
    public List<WatchListEntity> getAll() {
        return null;
    }

    @Override
    public void update(WatchListEntity watchListEntity) {

    }

    @Override
    public WatchListEntity getWatchListEntityByDayWeek(String dayWeek) {
        return watchListRepository.getWatchListEntityByDayWeek(dayWeek);
    }
}
