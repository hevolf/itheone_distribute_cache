package com.itheone.distribute_cache.service;

import com.itheone.distribute_cache.entity.Provinces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 编码实现redis缓存
 */
@Service("provincesService")
public class ProvincesServiceImpl1 extends ProvincesServiceImpl implements ProvincesService{

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public Provinces detail(String provinceid) {
        Provinces provinces = null;

        //在redis查询
        provinces = (Provinces)redisTemplate.opsForValue().get(provinceid);
        if (null != provinces){
//            redisTemplate.expire(provinceid,20000, TimeUnit.MILLISECONDS);
            System.out.println("缓存中得到数据");
            return provinces;
        }
        // 继承自父类，父类从数据库获取数据
        provinces = super.detail(provinceid);
        if (null != provinces){
            redisTemplate.opsForValue().set(provinceid,provinces);//set缓存
            redisTemplate.expire(provinceid,20000, TimeUnit.MILLISECONDS);//设置过期
        }

        return provinces;
    }

    @Override
    public Provinces update(Provinces entity) {//双删
        redisTemplate.delete(entity.getProvinceid());//直接删除缓存，预防数据库成功，缓存失败
        super.update(entity);
        // 防止其他线程更新了旧数据，所以更新完数据库再次删除缓存
        redisTemplate.delete(entity.getProvinceid());//双删
        return entity;
    }

    @Override
    public Provinces add(Provinces entity) {
        redisTemplate.delete(entity.getProvinceid());//set a=2
        super.add(entity);
        redisTemplate.delete(entity.getProvinceid());//双删
        return entity;
    }

    @Override
    public void delete(String provinceid) {
        redisTemplate.delete(provinceid);
        super.delete(provinceid);
        redisTemplate.delete(provinceid);//双删
    }


}