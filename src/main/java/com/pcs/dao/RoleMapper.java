package com.pcs.dao;

import java.util.List;

import com.pcs.pojo.RoleDTO;

public interface RoleMapper {
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