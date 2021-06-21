package com.pcs.service;

import java.util.List;

import com.pcs.pojo.RolePermissionDTO;

public interface IRolePermissionService {
	int deleteByPrimaryKey(Integer rpId);

	int insert(RolePermissionDTO record);

	int insertSelective(RolePermissionDTO record);

	List<RolePermissionDTO> selectByRId(Integer rId);

	int updateByPrimaryKeySelective(RolePermissionDTO record);

	int updateByPrimaryKey(RolePermissionDTO record);

	List<RolePermissionDTO> findAll();

	Integer updateByrIdAndpId(RolePermissionDTO rolePermission);

}
