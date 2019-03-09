package com.sickness.dao;

import com.sickness.entity.UserSick;

public interface UserSickMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserSick record);

    int insertSelective(UserSick record);

    UserSick selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserSick record);

    int updateByPrimaryKey(UserSick record);
}