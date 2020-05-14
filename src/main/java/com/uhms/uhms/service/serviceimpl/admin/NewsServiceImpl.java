package com.uhms.uhms.service.serviceimpl.admin;

import com.uhms.uhms.dao.dao.NewsDao;
import com.uhms.uhms.dto.NewsDto;
import com.uhms.uhms.entity.NewsEntity;
import com.uhms.uhms.service.service.admin.NewsService;
import com.uhms.uhms.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsDao newsDao;

    @Override
    public void insert(NewsDto  newsDto) {

        NewsEntity newsEntity=new NewsEntity();
        newsEntity.setNewsTitle(newsDto.getNewsTitle());
        newsEntity.setNewsImg(newsDto.getNewsImg());
        newsEntity.setNewsText(newsDto.getNewsText());
        newsDao.insert(newsEntity);
    }

    @Override
    public void deleteById(String id) {
        newsDao.deleteById(id);
    }

    @Override
    public NewsEntity getById(String id) {
        return newsDao.getById(id);
    }

    @Override
    public List<NewsEntity> getAll() {
        return newsDao.getAll();
    }

    @Override
    public void update(NewsDto newsDto) {
        NewsEntity entity = newsDao.getById(newsDto.getNewsId());
        entity.setNewsTitle(newsDto.getNewsTitle());
        entity.setNewsText(newsDto.getNewsText());
        entity.setNewsImg(newsDto.getNewsImg());
        entity.setUpdateDate(DateUtils.getCurrentDate());
        newsDao.update(entity);
    }
}
