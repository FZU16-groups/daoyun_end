package com.pcs.dao;

import java.util.List;

import com.pcs.pojo.ButtonDTO;

public interface ButtonMapper {
    int deleteByPrimaryKey(Integer bId);

    int insert(ButtonDTO record);

    int insertSelective(ButtonDTO record);

    ButtonDTO selectByPrimaryKey(Integer bId);

    int updateByPrimaryKeySelective(ButtonDTO record);

    int updateByPrimaryKey(ButtonDTO record);
    
    List<ButtonDTO> findAll();

}