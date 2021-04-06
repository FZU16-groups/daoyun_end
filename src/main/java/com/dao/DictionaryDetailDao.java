package com.dao;

import com.pojo.DictionaryDetail;

public interface DictionaryDetailDao {
    int deleteByPrimaryKey(Integer id);

    int insert(DictionaryDetail record);

    int insertSelective(DictionaryDetail record);

    DictionaryDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DictionaryDetail record);

    int updateByPrimaryKey(DictionaryDetail record);
}