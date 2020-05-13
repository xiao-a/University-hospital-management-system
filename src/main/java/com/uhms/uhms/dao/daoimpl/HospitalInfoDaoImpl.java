package com.uhms.uhms.dao.daoimpl;

import com.uhms.uhms.dao.dao.HospitalInfoDao;
import com.uhms.uhms.dao.dao.WatchListDao;
import com.uhms.uhms.entity.HospitalInfoEntity;
import com.uhms.uhms.entity.NewsEntity;
import com.uhms.uhms.entity.WatchListEntity;
import com.uhms.uhms.enums.DataStatusEnum;
import com.uhms.uhms.repository.HospitalInfoRepository;
import com.uhms.uhms.repository.WatchListRepository;
import com.uhms.uhms.utils.DateUtils;
import com.uhms.uhms.utils.IdUtils;
import com.uhms.uhms.utils.JsonUtils;
import com.uhms.uhms.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import sun.rmi.runtime.Log;

import java.util.List;

@Component
public class HospitalInfoDaoImpl implements HospitalInfoDao {
    String hospitalInfo="HospitalInfo";
    @Autowired
    private HospitalInfoRepository hospitalInfoRepository;
    JedisPool jedisPool=new JedisPool();
    @Override
    public void insert(HospitalInfoEntity hospitalInfoEntity) {
        hospitalInfoEntity.setHospitalInfoId(IdUtils.createID("hospitalInfo"));
        hospitalInfoEntity.setCreateDate(DateUtils.getCurrentDate());
        hospitalInfoEntity.setUpdateDate( DateUtils.getCurrentDate());
        hospitalInfoEntity.setStatus(DataStatusEnum.VALID.getType());
        Jedis jedis = jedisPool.getResource();
        try{
            String json = jedis.set(hospitalInfo,JsonUtils.objectToJson(hospitalInfoEntity));
            LogUtils.info("数据写到Redis数据库!");
            jedis.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        hospitalInfoRepository.save(hospitalInfoEntity);
    }

    @Override
    public void deleteById(String id) {
        Jedis jedis = jedisPool.getResource();
        try{
            jedis.del(hospitalInfo);
            LogUtils.info("删除Redis数据库缓存的会议数据!");
            jedis.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        hospitalInfoRepository.deleteById(id);
    }

    @Override
    public HospitalInfoEntity getById(String id) {
        Jedis jedis = jedisPool.getResource();
        try{
            String json = jedis.hget(hospitalInfo, id.toString());
            if (!StringUtils.isEmpty(json))
            {
                HospitalInfoEntity hospitalInfoEntity = JsonUtils.jsonToPojo(json, HospitalInfoEntity.class);
                LogUtils.info("数据来自于redis数据库！");
                return hospitalInfoEntity;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        HospitalInfoEntity hospitalInfoEntity = hospitalInfoRepository.getOne(id);
        try{
            jedis.hset(hospitalInfo,id.toString(), JsonUtils.objectToJson(hospitalInfoEntity));
            LogUtils.info("数据来自MySql数据库!");
            jedis.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return hospitalInfoEntity;
    }


    @Override
    public void update(HospitalInfoEntity hospitalInfoEntity) {
        Jedis jedis = jedisPool.getResource();
        try{
            jedis.set(hospitalInfo,JsonUtils.objectToJson(hospitalInfoEntity));
            LogUtils.info("更新Redis数据库缓存的数据!");
            jedis.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        hospitalInfoRepository.save(hospitalInfoEntity);
    }

    @Override
    public HospitalInfoEntity getHospitalInfo() {
        Jedis jedis = jedisPool.getResource();
        try{
            String json=jedis.get(hospitalInfo);
            LogUtils.info("HospitalInfoJson:"+json);
            if (!StringUtils.isEmpty(json))
            {
                HospitalInfoEntity hospitalInfoEntity = JsonUtils.jsonToPojo(json, HospitalInfoEntity.class);
                LogUtils.info("数据来自于redis数据库！");
                return hospitalInfoEntity;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
