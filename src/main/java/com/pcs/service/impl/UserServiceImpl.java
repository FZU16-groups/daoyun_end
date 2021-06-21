package com.pcs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.pcs.dto.PageDTO;
import com.pcs.dto.UserRoleDTO;
import org.springframework.stereotype.Service;

import com.pcs.dao.UserMapper;
import com.pcs.pojo.UserDTO;
import com.pcs.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private UserMapper userDao;

	@Override
	public int deleteByPrimaryKey(Integer uId) {
		// TODO Auto-generated method stub
		return this.userDao.deleteByPrimaryKey(uId);
	}

	@Override
	public int insert(UserDTO record) {
		// TODO Auto-generated method stub
		return this.userDao.insert(record);

	}

	@Override
	public int insertSelective(UserDTO record) {
		// TODO Auto-generated method stub
		return this.userDao.insertSelective(record);

	}

	@Override
	public UserDTO selectByPrimaryKey(Integer uId) {
		// TODO Auto-generated method stub
		return this.userDao.selectByPrimaryKey(uId);

	}

	@Override
	public int updateByPrimaryKeySelective(UserDTO record) {
		// TODO Auto-generated method stub
		return this.userDao.updateByPrimaryKeySelective(record);

	}

	@Override
	public int updateByPrimaryKey(UserDTO record) {
		// TODO Auto-generated method stub
		return this.userDao.updateByPrimaryKey(record);

	}

	@Override
	public List<UserRoleDTO> findAll() {
		// TODO Auto-generated method stub
		return this.userDao.findAll();
	}

	@Override
	public int countUser() {
		// TODO Auto-generated method stub
		return this.userDao.countUser();
	}

	@Override
	public int countUName(String uNmae) {
		// TODO Auto-generated method stub
		return this.userDao.countUName(uNmae);
	}

	@Override
	public int countPhone(String phone) {
		// TODO Auto-generated method stub
		return this.userDao.countPhone(phone);
	}

	@Override
	public int countEmail(String email) {
		// TODO Auto-generated method stub
		return this.userDao.countEmail(email);
	}

	@Override
	public UserDTO selectByuNumber(String uNumber) {
		// TODO Auto-generated method stub
		return this.userDao.selectByuNumber(uNumber);
	}

	@Override
	public UserDTO selectByPhone(String phone) {
		// TODO Auto-generated method stub
		return this.userDao.selectByPhone(phone);
	}

}
