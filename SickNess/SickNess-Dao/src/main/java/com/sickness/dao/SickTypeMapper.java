package com.sickness.dao;

import com.sickness.entity.SickType;

public interface SickTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SickType record);

    int insertSelective(SickType record);

    SickType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SickType record);

    int updateByPrimaryKey(SickType record);
}