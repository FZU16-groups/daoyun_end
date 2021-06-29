package com.pcs.dao;

import java.util.List;

import com.pcs.pojo.PersonDTO;

public interface PersonMapper {
	int deleteByPrimaryKey(Integer peId);

	int insert(PersonDTO record);

	int insertSelective(PersonDTO record);

	PersonDTO selectByPrimaryKey(Integer peId);

	PersonDTO selectByuId(Integer uId);

	int updateByPrimaryKeySelective(PersonDTO record);

	int updateByPrimaryKey(PersonDTO record);

	List<PersonDTO> findAll();

	Integer deleteByuId(Integer uId);
}