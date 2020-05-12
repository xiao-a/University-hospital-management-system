package com.uhms.uhms.dao.daoimpl;

import com.uhms.uhms.dao.dao.AdminDao;
import com.uhms.uhms.dao.dao.NewsDao;
import com.uhms.uhms.entity.AdminEntity;
import com.uhms.uhms.entity.NewsEntity;
import com.uhms.uhms.enums.DataStatusEnum;
import com.uhms.uhms.repository.NewsRepository;
import com.uhms.uhms.utils.DateUtils;
import com.uhms.uhms.utils.IdUtils;
import com.uhms.uhms.utils.JsonUtils;
import com.uhms.uhms.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.List;

@Component
public class NewsDaoImpl implements NewsDao {
    @Autowired
    private NewsRepository newsRepository;
    JedisPool jedisPool=new JedisPool();
    @Override
    public void insert(NewsEntity newsEntity) {
        newsEntity.setNewsId(IdUtils.createID("news"));
        newsEntity.setCreateDate(DateUtils.getCurrentDate());
        newsEntity.setUpdateDate( DateUtils.getCurrentDate());
        newsEntity.setStatus(DataStatusEnum.VALID.getType());

        Jedis jedis = jedisPool.getResource();
        try{
            jedis.hset("NEWS_LIST",newsEntity.getNewsId().toString(), JsonUtils.objectToJson(newsEntity));
            LogUtils.info("插入会议数据到Redis数据库!");
            jedis.close();
        }catch (Exception e){
            e.printStackTrace();
        }
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
