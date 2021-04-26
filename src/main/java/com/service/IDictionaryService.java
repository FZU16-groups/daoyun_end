package com.pcs.service;

import java.util.List;

import com.pcs.dto.PageDTO;
import com.pcs.pojo.Dictionary;

public interface IDictionaryService {
	int deleteByPrimaryKey(Integer dId);

	int insert(Dictionary record);

	int insertSelective(Dictionary record);

	Dictionary selectByPrimaryKey(Integer dId);

	int updateByPrimaryKeySelective(Dictionary record);

	int updateByPrimaryKey(Dictionary record);
	
    List<Dictionary> findAll(PageDTO pageDTO);

	int countDictionary();
}
