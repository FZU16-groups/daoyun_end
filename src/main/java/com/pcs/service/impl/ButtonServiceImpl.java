package com.pcs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pcs.dao.ButtonMapper;
import com.pcs.pojo.ButtonDTO;
import com.pcs.service.IButtonService;

@Service("buttonService")
public class ButtonServiceImpl implements IButtonService {
	@Resource
	private ButtonMapper buttonDao;

	@Override
	public int deleteByPrimaryKey(Integer bId) {
		// TODO Auto-generated method stub
		return this.buttonDao.deleteByPrimaryKey(bId);
	}

	@Override
	public int insert(ButtonDTO record) {
		// TODO Auto-generated method stub
		return this.buttonDao.insert(record);

	}

	@Override
	public int insertSelective(ButtonDTO record) {
		// TODO Auto-generated method stub
		return this.buttonDao.insertSelective(record);

	}

	@Override
	public ButtonDTO selectByPrimaryKey(Integer bId) {
		// TODO Auto-generated method stub
		return this.buttonDao.selectByPrimaryKey(bId);

	}

	@Override
	public int updateByPrimaryKeySelective(ButtonDTO record) {
		// TODO Auto-generated method stub
		return this.buttonDao.updateByPrimaryKeySelective(record);

	};

	@Override
	public int updateByPrimaryKey(ButtonDTO record) {
		// TODO Auto-generated method stub
		return this.buttonDao.updateByPrimaryKey(record);

	}

	@Override
	public List<ButtonDTO> findAll() {
		// TODO Auto-generated method stub
		return  this.buttonDao.findAll();
	}

}
