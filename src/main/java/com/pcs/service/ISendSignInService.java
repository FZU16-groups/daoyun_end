package com.pcs.service;


import com.pcs.pojo.SendSignInDTO;

import java.util.List;

public interface ISendSignInService {

    int deleteByPrimaryKey(Integer ssId);

    int insert(SendSignInDTO record);

    int insertSelective(SendSignInDTO record);

    SendSignInDTO selectByPrimaryKey(Integer ssId);

    int updateByPrimaryKeySelective(SendSignInDTO record);

    int updateByPrimaryKey(SendSignInDTO record);

    List<SendSignInDTO> findAll();

    SendSignInDTO remindOneButtonSignIn(SendSignInDTO record);

    SendSignInDTO remindLimitTimeSignIn(SendSignInDTO record);

    List<SendSignInDTO> selectBycId(SendSignInDTO record);

    SendSignInDTO JudgeSignInBycId(Integer cId);

}
