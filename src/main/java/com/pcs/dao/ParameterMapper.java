package com.pcs.dao;

import java.util.List;

import com.pcs.pojo.ParameterDTO;

public interface ParameterMapper {
    int deleteByPrimaryKey(Integer paId);

    int insert(ParameterDTO record);

    int insertSelective(ParameterDTO record);

    ParameterDTO selectByPrimaryKey(Integer paId);

    int updateByPrimaryKeySelective(ParameterDTO record);

    int updateByPrimaryKey(ParameterDTO record);
    
    List<ParameterDTO> findAll();

    Integer countKeywordByPaId(ParameterDTO record);

    Integer countKeyword(ParameterDTO record);
}