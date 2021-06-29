package com.pcs.service;

import java.util.List;

import com.pcs.pojo.RoleDTO;

public interface IRoleService {
	int deleteByPrimaryKey(Integer rId);

	int insert(RoleDTO record);

	int insertSelective(RoleDTO record);

	RoleDTO selectByPrimaryKey(Integer rId);

	List<RoleDTO> selectRoleListByUser(Integer uId);

	int updateByPrimaryKeySelective(RoleDTO record);

	int updateByPrimaryKey(RoleDTO record);

	List<RoleDTO> findAll();

	List<RoleDTO> selectRolePermission();

}
