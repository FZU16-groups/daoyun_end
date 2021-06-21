package com.pcs.service;

import java.util.List;

import com.pcs.pojo.MenuDTO;

public interface IMenuService {
	int deleteByPrimaryKey(Integer mId);

	int insert(MenuDTO record);

	int insertSelective(MenuDTO record);

	MenuDTO selectByPrimaryKey(Integer mId);

	int updateByPrimaryKeySelective(MenuDTO record);

	int updateByPrimaryKey(MenuDTO record);
	
    List<MenuDTO> findAll();

}
