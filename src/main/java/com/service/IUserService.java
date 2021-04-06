package com.service;

import java.util.List;

import com.pojo.User;

public interface IUserService {
	int deleteByPrimaryKey(Integer uId);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer uId);

	User selectByUserNumber(String uNumber);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	List<User> findAll();

}
