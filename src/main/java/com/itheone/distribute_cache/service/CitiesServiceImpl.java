package com.itheone.distribute_cache.service;

import com.itheone.distribute_cache.dao.CitiesDao;
import com.itheone.distribute_cache.entity.Cities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("citiesService")
public class CitiesServiceImpl implements CitiesService{
    @Autowired
    private CitiesDao citiesDao;

    @Override
    public int update(final Cities entity){
        return citiesDao.updateByEntity(entity);
    }

    @Override
    public int add(final Cities entity){
        return citiesDao.insert(entity);
    }

    @Override
    @Cacheable(value = "city")
    public List<Cities> list(String provinceid){
        return citiesDao.list(provinceid);
    }



}