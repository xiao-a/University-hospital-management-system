package com.uhms.uhms.dao.daoimpl;

import com.uhms.uhms.dao.dao.AdminDao;
import com.uhms.uhms.dao.dao.NewsDao;
import com.uhms.uhms.entity.AdminEntity;
import com.uhms.uhms.entity.NewsEntity;
import com.uhms.uhms.enums.DataStatusEnum;
import com.uhms.uhms.repository.AdminRepository;
import com.uhms.uhms.repository.NewsRepository;
import com.uhms.uhms.utils.DateUtils;
import com.uhms.uhms.utils.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NewsDaoImpl implements NewsDao {
    @Autowired
    private NewsRepository newsRepository;

    @Override
    public void insert(NewsEntity newsEntity) {
        newsEntity.setNewsId(IdUtils.createID("news"));
        newsEntity.setCreateDate(DateUtils.getCurrentDate());
        newsEntity.setUpdateDate( DateUtils.getCurrentDate());
        newsEntity.setStatus(DataStatusEnum.VALID.getType());
        newsRepository.save(newsEntity);
    }

    @Override
    public void deleteById(String id) {
        newsRepository.deleteById(id);
    }

    @Override
    public NewsEntity getById(String id) {
        return newsRepository.getOne(id);
    }

    @Override
    public List<NewsEntity> getAll() {
        return newsRepository.findAll();
    }

    @Override
    public void update(NewsEntity NewsEntity) {
        newsRepository.save(NewsEntity);
    }
}
