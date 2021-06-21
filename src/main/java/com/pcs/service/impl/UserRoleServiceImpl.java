package com.pcs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.pcs.pojo.UserDTO;
import org.springframework.stereotype.Service;

import com.pcs.dao.UserRoleMapper;
import com.pcs.pojo.UserRole;
import com.pcs.service.IUserRoleService;

@Service("userRoleService")
public class UserRoleServiceImpl implements IUserRoleService {
	@Resource
	private UserRoleMapper userRoleDao;

	@Override
	public int deleteByPrimaryKey(Integer urId) {
		// TODO Auto-generated method stub
		return this.userRoleDao.deleteByPrimaryKey(urId);
	}

	@Override
	public int deleteByUId(Integer uId) {
		// TODO Auto-generated method stub
		return this.userRoleDao.deleteByUId(uId);
	}

	@Override
	public int insert(UserRole record) {
		// TODO Auto-generated method stub
		return this.userRoleDao.insert(record);

	}

	@Override
	public int insertSelective(UserRole record) {
		// TODO Auto-generated method stub
		return this.userRoleDao.insertSelective(record);

	}

	@Override
	public UserRole selectByPrimaryKey(Integer urId) {
		// TODO Auto-generated method stub
		return this.userRoleDao.selectByPrimaryKey(urId);

	}

	@Override
	public List<UserRole> selectByUId(Integer uId) {
		// TODO Auto-generated method stub
		return this.userRoleDao.selectByUId(uId);

	}

	@Override
	public int updateByPrimaryKeySelective(UserRole record) {
		// TODO Auto-generated method stub
		return this.userRoleDao.updateByPrimaryKeySelective(record);

	}

	@Override
	public int updateByPrimaryKey(UserRole record) {
		// TODO Auto-generated method stub
		return this.userRoleDao.updateByPrimaryKey(record);

	}

	@Override
	public int updateByUId(UserDTO user) {
		// TODO Auto-generated method stub
		return this.userRoleDao.updateByUId(user);

	}

	@Override
	public List<UserRole> findAll() {
		// TODO Auto-generated method stub
		return this.userRoleDao.findAll();
	}

}
