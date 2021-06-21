package com.pcs.service;

import java.util.List;

import com.pcs.pojo.SignInDTO;

public interface ISignInService {
	int deleteByPrimaryKey(Integer siId);

	int insert(SignInDTO record);

	int insertSelective(SignInDTO record);

	SignInDTO selectByPrimaryKey(Integer siId);

	int updateByPrimaryKeySelective(SignInDTO record);

	int updateByPrimaryKey(SignInDTO record);

	List<SignInDTO> findAll();

	List<SignInDTO> selectByssId(Integer ssId);

	List<SignInDTO> selectBycId(SignInDTO record);

}
