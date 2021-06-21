package com.pcs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pcs.dao.ParameterMapper;
import com.pcs.pojo.ParameterDTO;
import com.pcs.service.IParameterService;

@Service("parameterService")
public class ParameterServiceImpl implements IParameterService {
	@Resource
	private ParameterMapper parameterDao;

	@Override
	public int deleteByPrimaryKey(Integer dId) {
		// TODO Auto-generated method stub
		return this.parameterDao.deleteByPrimaryKey(dId);
	}

	@Override
	public int insert(ParameterDTO record) {
		// TODO Auto-generated method stub
		return this.parameterDao.insert(record);

	}

	@Override
	public int insertSelective(ParameterDTO record) {
		// TODO Auto-generated method stub
		return this.parameterDao.insertSelective(record);

	}

	@Override
	public ParameterDTO selectByPrimaryKey(Integer dId) {
		// TODO Auto-generated method stub
		return this.parameterDao.selectByPrimaryKey(dId);

	}

	@Override
	public int updateByPrimaryKeySelective(ParameterDTO record) {
		// TODO Auto-generated method stub
		return this.parameterDao.updateByPrimaryKeySelective(record);

	}

	@Override
	public int updateByPrimaryKey(ParameterDTO record) {
		// TODO Auto-generated method stub
		return this.parameterDao.updateByPrimaryKey(record);

	}

	@Override
	public List<ParameterDTO> findAll() {
		// TODO Auto-generated method stub
		return this.parameterDao.findAll();
	}

	@Override
	public Integer countKeywordByPaId(ParameterDTO record) {
		return this.parameterDao.countKeywordByPaId(record);
	}

	@Override
	public Integer countKeyword(ParameterDTO record) {
		return this.parameterDao.countKeyword(record);
	}
}
