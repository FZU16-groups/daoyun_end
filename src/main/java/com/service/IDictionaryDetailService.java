package com.pcs.service;

import java.util.List;

import com.pcs.pojo.DictionaryDetail;

public interface IDictionaryDetailService {
	int deleteByPrimaryKey(Integer ddId);

	int insert(DictionaryDetail record);

	int insertSelective(DictionaryDetail record);

	DictionaryDetail selectByPrimaryKey(Integer ddId);

	int updateByPrimaryKeySelective(DictionaryDetail record);

	int updateByPrimaryKey(DictionaryDetail record);

	List<DictionaryDetail> findAll();

	List<DictionaryDetail> selectBydId(Integer dId);

}
