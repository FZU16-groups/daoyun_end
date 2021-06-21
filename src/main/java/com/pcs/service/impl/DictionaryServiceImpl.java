package com.pcs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.pcs.dto.PageDTO;
import org.springframework.stereotype.Service;

import com.pcs.dao.DictionaryMapper;
import com.pcs.pojo.DictionaryDTO;
import com.pcs.service.IDictionaryService;

@Service("dictionaryService")
public class DictionaryServiceImpl implements IDictionaryService {
	@Resource
	private DictionaryMapper dictionaryDao;

	@Override
	public int deleteByPrimaryKey(Integer dId) {
		// TODO Auto-generated method stub
		return this.dictionaryDao.deleteByPrimaryKey(dId);
	}

	@Override
	public int insert(DictionaryDTO record) {
		// TODO Auto-generated method stub
		return this.dictionaryDao.insert(record);

	}

	@Override
	public int insertSelective(DictionaryDTO record) {
		// TODO Auto-generated method stub
		return this.dictionaryDao.insertSelective(record);

	}

	@Override
	public DictionaryDTO selectByPrimaryKey(Integer dId) {
		// TODO Auto-generated method stub
		return this.dictionaryDao.selectByPrimaryKey(dId);

	}

	@Override
	public int updateByPrimaryKeySelective(DictionaryDTO record) {
		// TODO Auto-generated method stub
		return this.dictionaryDao.updateByPrimaryKeySelective(record);

	}

	@Override
	public int updateByPrimaryKey(DictionaryDTO record) {
		// TODO Auto-generated method stub
		return this.dictionaryDao.updateByPrimaryKey(record);

	}

	@Override
	public List<DictionaryDTO> findAll(PageDTO pageDTO) {
		// TODO Auto-generated method stub
		return this.dictionaryDao.findAll(pageDTO);
	}

	@Override
	public int countDictionary() {
		// TODO Auto-generated method stub
		return this.dictionaryDao.countDictionary();
	}
}
