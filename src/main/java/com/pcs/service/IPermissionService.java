package com.pcs.service;

import java.util.List;

import com.pcs.pojo.PermissionDTO;

public interface IPermissionService {
	int deleteByPrimaryKey(Integer pId);

	int insert(PermissionDTO record);

	int insertSelective(PermissionDTO record);

	PermissionDTO selectByPrimaryKey(Integer pId);

	int updateByPrimaryKeySelective(PermissionDTO record);

	int updateByPrimaryKey(PermissionDTO record);
	
    List<PermissionDTO> findAll();

}
