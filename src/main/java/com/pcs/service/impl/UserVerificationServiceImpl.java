package com.pcs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pcs.dao.UserVerificationMapper;
import com.pcs.pojo.UserVerificationDTO;
import com.pcs.service.IUserVerificationService;

@Service("userVerificationService")
public class UserVerificationServiceImpl implements IUserVerificationService {
	@Resource
	private UserVerificationMapper userVerificationDao;

	@Override
	public int deleteByPrimaryKey(Integer uvId) {
		// TODO Auto-generated method stub
		return this.userVerificationDao.deleteByPrimaryKey(uvId);
	}

	@Override
	public int insert(UserVerificationDTO record) {
		// TODO Auto-generated method stub
		return this.userVerificationDao.insert(record);

	}

	@Override
	public int insertSelective(UserVerificationDTO record) {
		// TODO Auto-generated method stub
		return this.userVerificationDao.insertSelective(record);

	}

	@Override
	public UserVerificationDTO selectByPrimaryKey(Integer uvId) {
		// TODO Auto-generated method stub
		return this.userVerificationDao.selectByPrimaryKey(uvId);

	}

	@Override
	public int updateByPrimaryKeySelective(UserVerificationDTO record) {
		// TODO Auto-generated method stub
		return this.userVerificationDao.updateByPrimaryKeySelective(record);

	}

	@Override
	public int updateByPrimaryKey(UserVerificationDTO record) {
		// TODO Auto-generated method stub
		return this.userVerificationDao.updateByPrimaryKey(record);

	}

	@Override
	public UserVerificationDTO login(UserVerificationDTO record) {
		// TODO Auto-generated method stub
		return this.userVerificationDao.login(record);
	}

	@Override
	public UserVerificationDTO loginByMessage(String loginToken) {
		// TODO Auto-generated method stub
		return this.userVerificationDao.loginByMessage(loginToken);
	}

	@Override
	public List<UserVerificationDTO> findAll() {
		// TODO Auto-generated method stub
		return this.userVerificationDao.findAll();
	}

	@Override
	public int updateByuId(UserVerificationDTO record) {
		// TODO Auto-generated method stub
		return this.userVerificationDao.updateByuId(record);
	}

	@Override
	public Integer deleteByuId(Integer uId) {
		// TODO Auto-generated method stub
		return this.userVerificationDao.deleteByuId(uId);
	}

	@Override
	public Integer updatePassword(UserVerificationDTO userVerification) {
		// TODO Auto-generated method stub
		return this.userVerificationDao.updatePassword(userVerification);
	}


}
