package com.pcs.service;

import com.pcs.dto.AuthqqDTO;

public interface IOauthQQService {

    int deleteByPrimaryKey(Integer Id);

    int insert(AuthqqDTO record);

    int insertSelective(AuthqqDTO record);

    AuthqqDTO selectByPrimaryKey(Integer Id);

    AuthqqDTO selectByOpenId(String OpenId);

    AuthqqDTO selectByUserId(Integer userId);

    int updateByPrimaryKeySelective(AuthqqDTO record);

    int updateByPrimaryKey(AuthqqDTO record);

}
