package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.UserVerificationDao;
import com.pojo.UserVerification;
import com.service.IUserVerificationService;

@Service("userVerificationService")
public class UserVerificationServiceImpl implements IUserVerificationService {
	@Resource
	private UserVerificationDao userVerificationDao;

	@Override
	public int deleteByPrimaryKey(Integer uvId) {
		// TODO Auto-generated method stub
		return this.userVerificationDao.deleteByPrimaryKey(uvId);
	}

	@Override
	public int insert(UserVerification record) {
		// TODO Auto-generated method stub
		return this.userVerificationDao.insert(record);

	}

	@Override
	public int insertSelective(UserVerification record) {
		// TODO Auto-generated method stub
		return this.userVerificationDao.insertSelective(record);

	}

	@Override
	public UserVerification selectByPrimaryKey(Integer uvId) {
		// TODO Auto-generated method stub
		return this.userVerificationDao.selectByPrimaryKey(uvId);

	}

	@Override
	public int updateByPrimaryKeySelective(UserVerification record) {
		// TODO Auto-generated method stub
		return this.userVerificationDao.updateByPrimaryKeySelective(record);

	}

	@Override
	public int updateByPrimaryKey(UserVerification record) {
		// TODO Auto-generated method stub
		return this.userVerificationDao.updateByPrimaryKey(record);

	}

	@Override
	public UserVerification login(UserVerification record) {
		// TODO Auto-generated method stub
		return this.userVerificationDao.login(record);
	}

	@Override
	public List<UserVerification> findAll() {
		// TODO Auto-generated method stub
		return this.userVerificationDao.findAll();
	}

	@Override
	public int updateByUserId(UserVerification record) {
		// TODO Auto-generated method stub
		return this.userVerificationDao.updateByUserId(record);
	}

	@Override
	public Integer deleteByUserId(Integer uId) {
		// TODO Auto-generated method stub
		return this.userVerificationDao.deleteByUserId(uId);
	}

	@Override
	public Integer updatePassword(UserVerification userVerification) {
		// TODO Auto-generated method stub
		return this.userVerificationDao.updatePassword(userVerification);
	}

}
