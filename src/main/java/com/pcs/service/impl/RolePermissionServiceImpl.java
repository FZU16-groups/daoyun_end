package com.pcs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pcs.dao.RolePermissionMapper;
import com.pcs.pojo.RolePermissionDTO;
import com.pcs.service.IRolePermissionService;

@Service("rolePermissionService")
public class RolePermissionServiceImpl implements IRolePermissionService {
	@Resource
	private RolePermissionMapper rolePermissionDao;

	@Override
	public int deleteByPrimaryKey(Integer rpId) {
		// TODO Auto-generated method stub
		return this.rolePermissionDao.deleteByPrimaryKey(rpId);
	}

	@Override
	public int insert(RolePermissionDTO record) {
		// TODO Auto-generated method stub
		return this.rolePermissionDao.insert(record);

	}

	@Override
	public int insertSelective(RolePermissionDTO record) {
		// TODO Auto-generated method stub
		return this.rolePermissionDao.insertSelective(record);

	}

	@Override
	public List<RolePermissionDTO> selectByRId(Integer rId) {
		// TODO Auto-generated method stub
		return this.rolePermissionDao.selectByRId(rId);

	}

	@Override
	public int updateByPrimaryKeySelective(RolePermissionDTO record) {
		// TODO Auto-generated method stub
		return this.rolePermissionDao.updateByPrimaryKeySelective(record);

	}

	@Override
	public int updateByPrimaryKey(RolePermissionDTO record) {
		// TODO Auto-generated method stub
		return this.rolePermissionDao.updateByPrimaryKey(record);

	}

	@Override
	public List<RolePermissionDTO> findAll() {
		// TODO Auto-generated method stub
		return this.rolePermissionDao.findAll();
	}

	@Override
	public Integer updateByrIdAndpId(RolePermissionDTO rolePermission) {
		// TODO Auto-generated method stub
		return this.rolePermissionDao.updateByrIdAndpId(rolePermission);
	}

}
