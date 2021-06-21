package com.pcs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pcs.dao.PersonMapper;
import com.pcs.pojo.PersonDTO;
import com.pcs.service.IPersonService;

@Service("personService")
public class PersonServiceImpl implements IPersonService {
	@Resource
	private PersonMapper personDao;

	@Override
	public int deleteByPrimaryKey(Integer peId) {
		// TODO Auto-generated method stub
		return this.personDao.deleteByPrimaryKey(peId);
	}

	@Override
	public int insert(PersonDTO record) {
		// TODO Auto-generated method stub
		return this.personDao.insert(record);

	}

	@Override
	public int insertSelective(PersonDTO record) {
		// TODO Auto-generated method stub
		return this.personDao.insertSelective(record);

	}

	@Override
	public PersonDTO selectByPrimaryKey(Integer peId) {
		// TODO Auto-generated method stub
		return this.personDao.selectByPrimaryKey(peId);

	}

	@Override
	public int updateByPrimaryKeySelective(PersonDTO record) {
		// TODO Auto-generated method stub
		return this.personDao.updateByPrimaryKeySelective(record);

	};

	@Override
	public int updateByPrimaryKey(PersonDTO record) {
		// TODO Auto-generated method stub
		return this.personDao.updateByPrimaryKey(record);

	}

	@Override
	public List<PersonDTO> findAll() {
		// TODO Auto-generated method stub
		return this.personDao.findAll();
	}

	@Override
	public PersonDTO selectByuId(Integer uId) {
		// TODO Auto-generated method stub
		return this.personDao.selectByuId(uId);
	}

	@Override
	public Integer deleteByuId(Integer uId) {
		// TODO Auto-generated method stub
		return this.personDao.deleteByuId(uId);
	}

}
