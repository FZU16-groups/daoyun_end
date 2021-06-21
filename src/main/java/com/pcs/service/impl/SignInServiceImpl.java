package com.pcs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pcs.dao.SignInMapper;
import com.pcs.pojo.SignInDTO;
import com.pcs.service.ISignInService;

@Service("signInService")
public class SignInServiceImpl implements ISignInService {
	@Resource
	private SignInMapper signInDao;

	@Override
	public int deleteByPrimaryKey(Integer siId) {
		// TODO Auto-generated method stub
		return this.signInDao.deleteByPrimaryKey(siId);
	}

	@Override
	public int insert(SignInDTO record) {
		// TODO Auto-generated method stub
		return this.signInDao.insert(record);

	}

	@Override
	public int insertSelective(SignInDTO record) {
		// TODO Auto-generated method stub
		return this.signInDao.insertSelective(record);

	}

	@Override
	public SignInDTO selectByPrimaryKey(Integer siId) {
		// TODO Auto-generated method stub
		return this.signInDao.selectByPrimaryKey(siId);

	}

	@Override
	public int updateByPrimaryKeySelective(SignInDTO record) {
		// TODO Auto-generated method stub
		return this.signInDao.updateByPrimaryKeySelective(record);

	};

	@Override
	public int updateByPrimaryKey(SignInDTO record) {
		// TODO Auto-generated method stub
		return this.signInDao.updateByPrimaryKey(record);

	}

	@Override
	public List<SignInDTO> findAll() {
		// TODO Auto-generated method stub
		return this.signInDao.findAll();
	}

	@Override
	public List<SignInDTO> selectByssId(Integer ssId) {
		return this.signInDao.selectByssId(ssId);
	}

	@Override
	public List<SignInDTO> selectBycId(SignInDTO record) {
		return this.signInDao.selectBycId(record);
	}

}
