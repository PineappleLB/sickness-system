package com.sickness.dao;

import com.sickness.entity.SickInfo;

public interface SickInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SickInfo record);

    int insertSelective(SickInfo record);

    SickInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SickInfo record);

    int updateByPrimaryKey(SickInfo record);
}