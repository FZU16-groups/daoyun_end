package com.pcs.dao;

import java.util.List;

import com.pcs.pojo.MenuButton;

public interface MenuButtonMapper {
    int deleteByPrimaryKey(Integer mbId);

    int insert(MenuButton record);

    int insertSelective(MenuButton record);

    MenuButton selectByPrimaryKey(Integer mbId);

    int updateByPrimaryKeySelective(MenuButton record);

    int updateByPrimaryKey(MenuButton record);
    
    List<MenuButton> findAll();

}