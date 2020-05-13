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
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@Component
public class NewsDaoImpl implements NewsDao {
    String news_list="NEWS_LIST";
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
            jedis.hset(news_list,newsEntity.getNewsId().toString(), JsonUtils.objectToJson(newsEntity));
            LogUtils.info("数据写到Redis数据库!");
            jedis.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        newsRepository.save(newsEntity);
    }

    @Override
    public void deleteById(String id) {
        Jedis jedis = jedisPool.getResource();
        try{
            jedis.hdel(news_list, id.toString());
            LogUtils.info("删除Redis数据库缓存的会议数据!");
            jedis.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        newsRepository.deleteById(id);
    }

    @Override
    public NewsEntity getById(String id) {
        Jedis jedis = jedisPool.getResource();
        try{
            String json = jedis.hget(news_list, id.toString());
            if (!StringUtils.isEmpty(json))
            {
                NewsEntity newsEntity = JsonUtils.jsonToPojo(json, NewsEntity.class);
                LogUtils.info("数据来自于redis数据库！");
                return newsEntity;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        NewsEntity newsEntity = newsRepository.getOne(id);
        try{
            jedis.hset(news_list,id.toString(), JsonUtils.objectToJson(newsEntity));
            LogUtils.info("数据来自MySql数据库!");
            jedis.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return newsEntity ;
    }

    @Override
    public List<NewsEntity> getAll() {
//        Jedis jedis = jedisPool.getResource();
//
//        /*从redis数据库取数据*/
//        try{
//            String json = jedis.hget(news_list, "newList");
//
//            LogUtils.info("数据："+json);
//            if (!StringUtils.isEmpty(json))
//            {
//                List<NewsEntity> entityList = JsonUtils.jsonToList(json, NewsEntity.class);
//                LogUtils.info("数据来自于redis数据库！");
//                return entityList;
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        return newsRepository.findAll();
    }

    @Override
    public void update(NewsEntity NewsEntity) {
        Jedis jedis = jedisPool.getResource();
        try{
            jedis.hset(news_list, NewsEntity.getNewsId(),JsonUtils.objectToJson(NewsEntity));
            LogUtils.info("更新Redis数据库缓存的数据!");
            jedis.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        newsRepository.save(NewsEntity);
    }
}
