package com.pcs.dao;

import com.pcs.pojo.AuthqqDTO;

public interface OauthQQMapper {

    int insert(AuthqqDTO record);

    int insertSelective(AuthqqDTO record);

    int deleteByPrimaryKey(Integer Id);

    AuthqqDTO selectByPrimaryKey(Integer Id);

    AuthqqDTO selectByUserId(Integer userId);

    AuthqqDTO selectByOpenId(String OpenId);

    int updateByPrimaryKeySelective(AuthqqDTO record);

    int updateByPrimaryKey(AuthqqDTO record);
}
