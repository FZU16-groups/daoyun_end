package com.pcs.dao;

import java.util.List;

import com.pcs.pojo.UserVerification;

public interface UserVerificationMapper {
	int deleteByPrimaryKey(Integer uvId);

	int insert(UserVerification record);

	int insertSelective(UserVerification record);

	UserVerification selectByPrimaryKey(Integer uvId);

	int updateByPrimaryKeySelective(UserVerification record);

	int updateByuId(UserVerification record);

	int updateByPrimaryKey(UserVerification record);

	List<UserVerification> findAll();

	UserVerification login(UserVerification record);

	UserVerification loginByMessage(String loginToken);

	Integer deleteByuId(Integer uId);

	Integer updatePassword(UserVerification userVerification);



}