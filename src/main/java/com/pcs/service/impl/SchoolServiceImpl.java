package com.pcs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.pcs.dto.PageDTO;
import org.springframework.stereotype.Service;

import com.pcs.dao.SchoolMapper;
import com.pcs.pojo.SchoolDTO;
import com.pcs.service.ISchoolService;

@Service("schoolService")
public class SchoolServiceImpl implements ISchoolService {
	@Resource
	private SchoolMapper schoolDao;

	@Override
	public int deleteByPrimaryKey(Integer sId) {
		// TODO Auto-generated method stub
		return this.schoolDao.deleteByPrimaryKey(sId);
	}

	@Override
	public int insert(SchoolDTO record) {
		// TODO Auto-generated method stub
		return this.schoolDao.insert(record);

	}

	@Override
	public int insertSelective(SchoolDTO record) {
		// TODO Auto-generated method stub
		return this.schoolDao.insertSelective(record);

	}

	@Override
	public SchoolDTO selectByPrimaryKey(Integer sId) {
		// TODO Auto-generated method stub
		return this.schoolDao.selectByPrimaryKey(sId);

	}

	@Override
	public int updateByPrimaryKeySelective(SchoolDTO record) {
		// TODO Auto-generated method stub
		return this.schoolDao.updateByPrimaryKeySelective(record);

	};

	@Override
	public int updateByPrimaryKey(SchoolDTO record) {
		// TODO Auto-generated method stub
		return this.schoolDao.updateByPrimaryKey(record);

	}

	@Override
	public List<SchoolDTO> findAll(PageDTO pageDTO) {
		// TODO Auto-generated method stub
		return this.schoolDao.findAll(pageDTO);
	}

	@Override
	public int countSchool( ) {
		// TODO Auto-generated method stub
		return this.schoolDao.countSchool();
	}
}
