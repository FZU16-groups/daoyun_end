package com.pcs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.pcs.dto.PageDTO;
import org.springframework.stereotype.Service;

import com.pcs.dao.CourseMapper;
import com.pcs.pojo.Course;
import com.pcs.service.ICourseService;

@Service("courseService")
public class CourseServiceImpl implements ICourseService {
	@Resource
	private CourseMapper courseDao;

	@Override
	public int deleteByPrimaryKey(Integer cId) {
		// TODO Auto-generated method stub
		return this.courseDao.deleteByPrimaryKey(cId);
	}

	@Override
	public int insert(Course record) {
		// TODO Auto-generated method stub
		return this.courseDao.insert(record);

	}

	@Override
	public int insertSelective(Course record) {
		// TODO Auto-generated method stub
		return this.courseDao.insertSelective(record);

	}

	@Override
	public Course selectByPrimaryKey(Integer cId) {
		// TODO Auto-generated method stub
		return this.courseDao.selectByPrimaryKey(cId);

	}

	@Override
	public int updateByPrimaryKeySelective(Course record) {
		// TODO Auto-generated method stub
		return this.courseDao.updateByPrimaryKeySelective(record);

	};

	@Override
	public int updateByPrimaryKey(Course record) {
		// TODO Auto-generated method stub
		return this.courseDao.updateByPrimaryKey(record);

	}

	@Override
	public List<Course> findAll(PageDTO pageDTO) {
		// TODO Auto-generated method stub
		return this.courseDao.findAll(pageDTO);
	}

	@Override
	public Course selectBycNumber(String cNumber) {
		// TODO Auto-generated method stub
		return this.courseDao.selectBycNumber(cNumber);
	}

	@Override
	public int countCourse() {
		// TODO Auto-generated method stub
		return this.courseDao.countCourse();
	}
}
