package com.pcs.service;

import java.util.List;

import com.pcs.dto.PageDTO;
import com.pcs.pojo.DictionaryDTO;

public interface IDictionaryService {
	int deleteByPrimaryKey(Integer dId);

	int insert(DictionaryDTO record);

	int insertSelective(DictionaryDTO record);

	DictionaryDTO selectByPrimaryKey(Integer dId);

	int updateByPrimaryKeySelective(DictionaryDTO record);

	int updateByPrimaryKey(DictionaryDTO record);
	
    List<DictionaryDTO> findAll(PageDTO pageDTO);

	int countDictionary();
}
