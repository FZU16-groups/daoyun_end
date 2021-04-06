package com.service;

import java.util.List;

import com.pojo.Person;

public interface IPersonService {
	int deleteByPrimaryKey(Integer peId);

	int insert(Person record);

	int insertSelective(Person record);

	Person selectByuId(Integer uId);

	Person selectByPrimaryKey(Integer peId);

	int updateByPrimaryKeySelective(Person record);

	int updateByPrimaryKey(Person record);

	List<Person> findAll();

	Integer deleteByuId(Integer uId);

}
