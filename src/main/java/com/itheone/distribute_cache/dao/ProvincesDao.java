package com.itheone.distribute_cache.dao;

import com.itheone.distribute_cache.entity.Provinces;

import java.io.Serializable;
import java.util.List;

public interface ProvincesDao extends Serializable{
    List<Provinces> list();
    Provinces detail(String provinceid);
    int update(Provinces entity);
    int insert(Provinces entity);
    void delete(String provinceid);
}