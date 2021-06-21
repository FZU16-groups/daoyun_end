package com.pcs.dao;

import java.util.List;

import com.pcs.pojo.PermissionDTO;

public interface PermissionMapper {
    int deleteByPrimaryKey(Integer pId);

    int insert(PermissionDTO record);

    int insertSelective(PermissionDTO record);

    PermissionDTO selectByPrimaryKey(Integer pId);

    int updateByPrimaryKeySelective(PermissionDTO record);

    int updateByPrimaryKey(PermissionDTO record);
    
    List<PermissionDTO> findAll();

}