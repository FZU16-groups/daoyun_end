package com.dao;

import com.pojo.UserVerification;

import java.util.List;

public interface UserVerificationDao {
    int deleteByPrimaryKey(Integer id);

    int insert(UserVerification record);

    int insertSelective(UserVerification record);

    UserVerification selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserVerification record);

    int updateByPrimaryKey(UserVerification record);

    int updateByUserId(UserVerification record);

    List<UserVerification> findAll();

    UserVerification login(UserVerification record);

    Integer deleteByUserId(Integer uId);

    Integer updatePassword(UserVerification userVerification);
}