package com.pcs.dao;

import java.util.List;

import com.pcs.pojo.DictionaryDetailDTO;

public interface DictionaryDetailMapper {
	int deleteByPrimaryKey(Integer ddId);
	int deleteAllByDId(Integer dId);

	int insert(DictionaryDetailDTO record);

	int insertSelective(DictionaryDetailDTO record);

	DictionaryDetailDTO selectByPrimaryKey(Integer ddId);

	int updateByPrimaryKeySelective(DictionaryDetailDTO record);

	int updateByPrimaryKey(DictionaryDetailDTO record);

	List<DictionaryDetailDTO> findAll();

	List<DictionaryDetailDTO> selectBydId(Integer dId);

	Integer countBydId(Integer dId);

	List<DictionaryDetailDTO> selectByddId(Integer ddId);

}