package com.pcs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pcs.dao.MenuButtonMapper;
import com.pcs.pojo.MenuButton;
import com.pcs.service.IMenuButtonService;

@Service("menuButtonService")
public class MenuButtonServiceImpl implements IMenuButtonService {
	@Resource
	private MenuButtonMapper menuButtonDao;

	@Override
	public int deleteByPrimaryKey(Integer mbId) {
		// TODO Auto-generated method stub
		return this.menuButtonDao.deleteByPrimaryKey(mbId);
	}

	@Override
	public int insert(MenuButton record) {
		// TODO Auto-generated method stub
		return this.menuButtonDao.insert(record);

	}

	@Override
	public int insertSelective(MenuButton record) {
		// TODO Auto-generated method stub
		return this.menuButtonDao.insertSelective(record);

	}

	@Override
	public MenuButton selectByPrimaryKey(Integer mbId) {
		// TODO Auto-generated method stub
		return this.menuButtonDao.selectByPrimaryKey(mbId);

	}

	@Override
	public int updateByPrimaryKeySelective(MenuButton record) {
		// TODO Auto-generated method stub
		return this.menuButtonDao.updateByPrimaryKeySelective(record);

	}

	@Override
	public int updateByPrimaryKey(MenuButton record) {
		// TODO Auto-generated method stub
		return this.menuButtonDao.updateByPrimaryKey(record);

	}

	@Override
	public List<MenuButton> findAll() {
		// TODO Auto-generated method stub
		return this.menuButtonDao.findAll();
	}

}
