package com.uhms.uhms.dao.dao;

import com.uhms.uhms.entity.NewsEntity;

import java.util.List;

public interface NewsDao {
    void insert(NewsEntity NewsEntity);
    void deleteById(String id);
    NewsEntity getById(String id);
    List<NewsEntity> getAll();
    void update(NewsEntity NewsEntity);
}
