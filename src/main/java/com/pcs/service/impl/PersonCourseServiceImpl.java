package com.pcs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pcs.dao.PersonCourseMapper;
import com.pcs.pojo.PersonCourse;
import com.pcs.service.IPersonCourseService;

@Service("personCourseService")
public class PersonCourseServiceImpl implements IPersonCourseService {
	@Resource
	private PersonCourseMapper personCourseDao;

	@Override
	public int deleteByPrimaryKey(Integer pcId) {
		// TODO Auto-generated method stub
		return this.personCourseDao.deleteByPrimaryKey(pcId);
	}

	@Override
	public int insert(PersonCourse record) {
		// TODO Auto-generated method stub
		return this.personCourseDao.insert(record);

	}

	@Override
	public int insertSelective(PersonCourse record) {
		// TODO Auto-generated method stub
		return this.personCourseDao.insertSelective(record);

	}

	@Override
	public PersonCourse selectByPrimaryKey(Integer pcId) {
		// TODO Auto-generated method stub
		return this.personCourseDao.selectByPrimaryKey(pcId);

	}

	@Override
	public int updateByPrimaryKeySelective(PersonCourse record) {
		// TODO Auto-generated method stub
		return this.personCourseDao.updateByPrimaryKeySelective(record);

	};

	@Override
	public int updateByPrimaryKey(PersonCourse record) {
		// TODO Auto-generated method stub
		return this.personCourseDao.updateByPrimaryKey(record);

	}

	@Override
	public List<PersonCourse> findAll() {
		// TODO Auto-generated method stub
		return this.personCourseDao.findAll();
	}

	@Override
	public List<PersonCourse> createdCourse(PersonCourse personCourse) {
		// TODO Auto-generated method stub
		return this.personCourseDao.createdCourse(personCourse);
	}

	@Override
	public List<PersonCourse> addedCourse(PersonCourse personCourse) {
		// TODO Auto-generated method stub
		return this.personCourseDao.addedCourse(personCourse);
	}

	@Override
	public List<PersonCourse> selectPersonBycId(Integer cId) {
		// TODO Auto-generated method stub
		return this.personCourseDao.selectPersonBycId(cId);
	}

    @Override
    public PersonCourse judgeJoinCourse(PersonCourse record) {
        return this.personCourseDao.judgeJoinCourse(record);
    }

	@Override
	public List<PersonCourse> selectBycId(Integer record) {
		return this.personCourseDao.selectBycId(record);
	}

	@Override
	public PersonCourse findTeacher(PersonCourse record) {
		return this.personCourseDao.findTeacher(record);
	}

	@Override
	public PersonCourse selectBycIdAndpeId(PersonCourse record) {
		return this.personCourseDao.selectBycIdAndpeId(record);
	}

	@Override
	public List<PersonCourse> selectStudentsBycId(Integer record) {
		return this.personCourseDao.selectStudentsBycId(record);
	}

	@Override
	public int deleteBycId(Integer cId) {
		// TODO Auto-generated method stub
		return this.personCourseDao.deleteBycId(cId);
	}

}
