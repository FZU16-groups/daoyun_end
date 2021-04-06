package com.service;

import java.util.List;

import com.pojo.UserVerification;

public interface IUserVerificationService {
	int deleteByPrimaryKey(Integer uvId);

	int insert(UserVerification record);

	int insertSelective(UserVerification record);

	UserVerification selectByPrimaryKey(Integer uvId);

	int updateByPrimaryKeySelective(UserVerification record);

	int updateByUserId(UserVerification record);

	int updateByPrimaryKey(UserVerification record);

	UserVerification login(UserVerification record);

	List<UserVerification> findAll();

	Integer deleteByUserId(Integer uId);

	Integer updatePassword(UserVerification userVerification);

}
