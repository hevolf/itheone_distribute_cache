package com.itheone.distribute_cache.dao;

import com.itheone.distribute_cache.entity.Areas;

import java.io.Serializable;
import java.util.List;

public interface AreasDao extends Serializable{

    int deleteById(String[] ids);

    int updateByEntity(final Areas entity);

    int insert(final Areas entity);

    List<Areas> list();

}