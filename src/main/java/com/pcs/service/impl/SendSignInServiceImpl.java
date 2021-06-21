package com.pcs.service.impl;


import com.pcs.dao.SendSignInMapper;
import com.pcs.pojo.SendSignInDTO;
import com.pcs.service.ISendSignInService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("sendSignInService")
public class SendSignInServiceImpl implements ISendSignInService {

    @Resource SendSignInMapper sendSignInDao;


    @Override
    public int deleteByPrimaryKey(Integer ssId) {
        return this.sendSignInDao.deleteByPrimaryKey(ssId);
    }

    @Override
    public int insert(SendSignInDTO record) {
        return this.sendSignInDao.insert(record);
    }

    @Override
    public int insertSelective(SendSignInDTO record) {
        return this.sendSignInDao.insertSelective(record);
    }

    @Override
    public SendSignInDTO selectByPrimaryKey(Integer ssId) {
        return this.sendSignInDao.selectByPrimaryKey(ssId);
    }

    @Override
    public int updateByPrimaryKeySelective(SendSignInDTO record) {
        return this.sendSignInDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SendSignInDTO record) {
        return this.sendSignInDao.updateByPrimaryKey(record);
    }

    @Override
    public List<SendSignInDTO> findAll() {
        return this.sendSignInDao.findAll();
    }

    @Override
    public SendSignInDTO remindOneButtonSignIn(SendSignInDTO record) {
        return this.sendSignInDao.remindOneButtonSignIn(record);
    }

    @Override
    public SendSignInDTO remindLimitTimeSignIn(SendSignInDTO record) {
        return this.sendSignInDao.remindLimitTimeSignIn(record);
    }

    @Override
    public List<SendSignInDTO> selectBycId(SendSignInDTO record) {
        return this.sendSignInDao.selectBycId(record);
    }

    @Override
    public SendSignInDTO JudgeSignInBycId(Integer cId) {
        return this.sendSignInDao.JudgeSignInBycId(cId);
    }


}
