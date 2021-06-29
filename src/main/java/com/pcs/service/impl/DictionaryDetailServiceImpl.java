package com.pcs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pcs.dao.DictionaryDetailMapper;
import com.pcs.pojo.DictionaryDetailDTO;
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
	public int deleteAllByDId(Integer dId) {
		return this.dictionaryDetailDao.deleteAllByDId(dId);
	}

	@Override
	public int insert(DictionaryDetailDTO record) {
		// TODO Auto-generated method stub
		return this.dictionaryDetailDao.insert(record);

	}

	@Override
	public int insertSelective(DictionaryDetailDTO record) {
		// TODO Auto-generated method stub
		return this.dictionaryDetailDao.insertSelective(record);

	}

	@Override
	public DictionaryDetailDTO selectByPrimaryKey(Integer ddId) {
		// TODO Auto-generated method stub
		return this.dictionaryDetailDao.selectByPrimaryKey(ddId);

	}

	@Override
	public int updateByPrimaryKeySelective(DictionaryDetailDTO record) {
		// TODO Auto-generated method stub
		return this.dictionaryDetailDao.updateByPrimaryKeySelective(record);

	}

	@Override
	public int updateByPrimaryKey(DictionaryDetailDTO record) {
		// TODO Auto-generated method stub
		return this.dictionaryDetailDao.updateByPrimaryKey(record);

	}

	@Override
	public List<DictionaryDetailDTO> findAll() {
		// TODO Auto-generated method stub
		return this.dictionaryDetailDao.findAll();
	}

	@Override
	public List<DictionaryDetailDTO> selectBydId(Integer dId) {
		// TODO Auto-generated method stub
		return this.dictionaryDetailDao.selectBydId(dId);
	}

	@Override
	public 	Integer countBydId(Integer dId) {
		// TODO Auto-generated method stub
		return this.dictionaryDetailDao.countBydId(dId);
	}

	@Override
	public List<DictionaryDetailDTO> selectByddId(Integer ddId) {
		return this.dictionaryDetailDao.selectByddId(ddId);
	}
}
