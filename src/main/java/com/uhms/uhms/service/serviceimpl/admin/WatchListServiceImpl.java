package com.uhms.uhms.service.serviceimpl.admin;

import com.uhms.uhms.dao.dao.WatchListDao;
import com.uhms.uhms.entity.WatchListEntity;
import com.uhms.uhms.service.service.admin.WatchListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchListServiceImpl implements WatchListService {
    @Autowired
    private WatchListDao watchListDao;
    @Override
    public void insert(WatchListEntity watchListEntity) {
        watchListDao.insert(watchListEntity);
    }

    @Override
    public void deleteById(String id) {
        watchListDao.deleteById(id);
    }

    @Override
    public WatchListEntity getById(String id) {
        return watchListDao.getById(id);
    }

    @Override
    public List<WatchListEntity> getAll() {
        return watchListDao.getAll();
    }

    @Override
    public void update(WatchListEntity watchListEntity) {
        watchListDao.update(watchListEntity);
    }
}
