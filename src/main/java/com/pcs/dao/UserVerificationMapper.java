package com.pcs.dao;

import java.util.List;

import com.pcs.pojo.UserVerificationDTO;

public interface UserVerificationMapper {
	int deleteByPrimaryKey(Integer uvId);

	int insert(UserVerificationDTO record);

	int insertSelective(UserVerificationDTO record);

	UserVerificationDTO selectByPrimaryKey(Integer uvId);

	int updateByPrimaryKeySelective(UserVerificationDTO record);

	int updateByuId(UserVerificationDTO record);

	int updateByPrimaryKey(UserVerificationDTO record);

	List<UserVerificationDTO> findAll();

	UserVerificationDTO login(UserVerificationDTO record);

	UserVerificationDTO loginByMessage(String loginToken);

	Integer deleteByuId(Integer uId);

	Integer updatePassword(UserVerificationDTO userVerification);



}