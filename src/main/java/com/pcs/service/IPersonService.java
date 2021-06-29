package com.pcs.service;

import java.util.List;

import com.pcs.pojo.PersonDTO;

public interface IPersonService {
	int deleteByPrimaryKey(Integer peId);

	int insert(PersonDTO record);

	int insertSelective(PersonDTO record);

	PersonDTO selectByuId(Integer uId);

	PersonDTO selectByPrimaryKey(Integer peId);

	int updateByPrimaryKeySelective(PersonDTO record);

	int updateByPrimaryKey(PersonDTO record);

	List<PersonDTO> findAll();

	Integer deleteByuId(Integer uId);

}
