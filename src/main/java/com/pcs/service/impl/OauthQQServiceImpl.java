package com.pcs.service.impl;

import com.pcs.dao.OauthQQMapper;
import com.pcs.pojo.AuthqqDTO;
import com.pcs.service.IOauthQQService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("oAuthQQService")
public class OauthQQServiceImpl implements IOauthQQService {

    @Resource
    private OauthQQMapper oauthQQDao;

    @Override
    public int deleteByPrimaryKey(Integer Id) {
        return this.oauthQQDao.deleteByPrimaryKey(Id);
    }

    @Override
    public int insert(AuthqqDTO record) {
        return this.oauthQQDao.insert(record);
    }

    @Override
    public int insertSelective(AuthqqDTO record) {
        return this.oauthQQDao.insertSelective(record);
    }

    @Override
    public AuthqqDTO selectByPrimaryKey(Integer Id) {
        return this.oauthQQDao.selectByPrimaryKey(Id);
    }

    @Override
    public AuthqqDTO selectByOpenId(String OpenId) {
        return this.oauthQQDao.selectByOpenId(OpenId);
    }

    @Override
    public AuthqqDTO selectByUserId(Integer userId) {
        return this.oauthQQDao.selectByUserId(userId);
    }

    @Override
    public int updateByPrimaryKeySelective(AuthqqDTO record) {
        return this.oauthQQDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(AuthqqDTO record) {
        return this.oauthQQDao.updateByPrimaryKey(record);
    }
}
