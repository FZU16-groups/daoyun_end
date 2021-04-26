package com.pcs.dao;

import java.util.List;

import com.pcs.dto.PageDTO;
import com.pcs.pojo.User;

public interface UserMapper {
	int deleteByPrimaryKey(Integer uId);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer uId);

	User selectByuNumber(String uNumber);

	User selectByPhone(String phone);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	List<User> findAll(PageDTO pageDTO);

	int countUser();
}