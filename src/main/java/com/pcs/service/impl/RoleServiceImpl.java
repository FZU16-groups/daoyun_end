package com.pcs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pcs.dao.RoleMapper;
import com.pcs.pojo.RoleDTO;
import com.pcs.service.IRoleService;

@Service("roleService")
public class RoleServiceImpl implements IRoleService {
	@Resource
	private RoleMapper roleDao;

	@Override
	public int deleteByPrimaryKey(Integer uId) {
		// TODO Auto-generated method stub
		return this.roleDao.deleteByPrimaryKey(uId);
	}

	@Override
	public int insert(RoleDTO record) {
		// TODO Auto-generated method stub
		return this.roleDao.insert(record);

	}

	@Override
	public int insertSelective(RoleDTO record) {
		// TODO Auto-generated method stub
		return this.roleDao.insertSelective(record);

	}

	@Override
	public RoleDTO selectByPrimaryKey(Integer uId) {
		// TODO Auto-generated method stub
		return this.roleDao.selectByPrimaryKey(uId);

	}

	@Override
	public List<RoleDTO> selectRoleListByUser(Integer uId) {
		// TODO Auto-generated method stub
		return this.roleDao.selectRoleListByUser(uId);

	}

	@Override
	public int updateByPrimaryKeySelective(RoleDTO record) {
		// TODO Auto-generated method stub
		return this.roleDao.updateByPrimaryKeySelective(record);

	}

	@Override
	public int updateByPrimaryKey(RoleDTO record) {
		// TODO Auto-generated method stub
		return this.roleDao.updateByPrimaryKey(record);

	}

	@Override
	public List<RoleDTO> findAll() {
		// TODO Auto-generated method stub
		return this.roleDao.findAll();
	}

	@Override
	public List<RoleDTO> selectRolePermission() {
		// TODO Auto-generated method stub
		return this.roleDao.selectRolePermission();
	}

}
