package com.pcs.service;

import java.util.List;

import com.pcs.pojo.UserVerificationDTO;

public interface IUserVerificationService {
	int deleteByPrimaryKey(Integer uvId);

	int insert(UserVerificationDTO record);

	int insertSelective(UserVerificationDTO record);

	UserVerificationDTO selectByPrimaryKey(Integer uvId);

	int updateByPrimaryKeySelective(UserVerificationDTO record);

	int updateByuId(UserVerificationDTO record);

	int updateByPrimaryKey(UserVerificationDTO record);

	UserVerificationDTO login(UserVerificationDTO record);

	UserVerificationDTO loginByMessage(String loginToken);

	List<UserVerificationDTO> findAll();

	Integer deleteByuId(Integer uId);

	Integer updatePassword(UserVerificationDTO userVerification);

}
