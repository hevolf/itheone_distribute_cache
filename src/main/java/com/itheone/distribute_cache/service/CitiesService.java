package com.itheone.distribute_cache.service;

import com.itheone.distribute_cache.entity.Cities;

import java.util.List;

public interface CitiesService {
    public int update(final Cities entity);
    public int add(final Cities entity);
    public List<Cities> list(String provinceid);
}