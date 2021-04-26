package com.pcs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pcs.dao.DictionaryDetailMapper;
import com.pcs.pojo.DictionaryDetail;
import com.pcs.service.IDictionaryDetailService;

@Service("dictionaryDetailService")
public class DictionaryDetailServiceImpl implements IDictionaryDetailService {
	@Resource
	private DictionaryDetailMapper dictionaryDetailDao;

	@Override
	public int deleteByPrimaryKey(Integer ddId) {
		// TODO Auto-generated method stub
		return this.dictionaryDetailDao.deleteByPrimaryKey(ddId);
	}

	@Override
	public int insert(DictionaryDetail record) {
		// TODO Auto-generated method stub
		return this.dictionaryDetailDao.insert(record);

	}

	@Override
	public int insertSelective(DictionaryDetail record) {
		// TODO Auto-generated method stub
		return this.dictionaryDetailDao.insertSelective(record);

	}

	@Override
	public DictionaryDetail selectByPrimaryKey(Integer ddId) {
		// TODO Auto-generated method stub
		return this.dictionaryDetailDao.selectByPrimaryKey(ddId);

	}

	@Override
	public int updateByPrimaryKeySelective(DictionaryDetail record) {
		// TODO Auto-generated method stub
		return this.dictionaryDetailDao.updateByPrimaryKeySelective(record);

	}

	@Override
	public int updateByPrimaryKey(DictionaryDetail record) {
		// TODO Auto-generated method stub
		return this.dictionaryDetailDao.updateByPrimaryKey(record);

	}

	@Override
	public List<DictionaryDetail> findAll() {
		// TODO Auto-generated method stub
		return this.dictionaryDetailDao.findAll();
	}

	@Override
	public List<DictionaryDetail> selectBydId(Integer dId) {
		// TODO Auto-generated method stub
		return this.dictionaryDetailDao.selectBydId(dId);
	}

}
