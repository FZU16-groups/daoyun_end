package com.dao;

import com.pojo.MenuButton;

public interface MenuButtonDao {
    int deleteByPrimaryKey(Integer id);

    int insert(MenuButton record);

    int insertSelective(MenuButton record);

    MenuButton selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MenuButton record);

    int updateByPrimaryKey(MenuButton record);
}