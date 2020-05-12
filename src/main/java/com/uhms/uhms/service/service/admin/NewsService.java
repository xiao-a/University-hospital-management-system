package com.uhms.uhms.service.service.admin;

import com.uhms.uhms.dto.NewsDto;
import com.uhms.uhms.entity.BedEntity;
import com.uhms.uhms.entity.NewsEntity;

import java.util.List;

public interface NewsService {
    void insert(NewsDto newsDto);
    void deleteById(String id);
    NewsEntity getById(String id);
    List<NewsEntity> getAll();
    void update(NewsDto newsDto);
}
