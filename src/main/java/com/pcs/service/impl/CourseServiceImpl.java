package com.pcs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.pcs.dto.PageDTO;
import com.pcs.dto.PagePeIdDTO;
import org.springframework.stereotype.Service;

import com.pcs.dao.CourseMapper;
import com.pcs.pojo.CourseDTO;
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
	public int insert(CourseDTO record) {
		// TODO Auto-generated method stub
		return this.courseDao.insert(record);

	}

	@Override
	public int insertSelective(CourseDTO record) {
		// TODO Auto-generated method stub
		return this.courseDao.insertSelective(record);

	}

	@Override
	public CourseDTO selectByPrimaryKey(Integer cId) {
		// TODO Auto-generated method stub
		return this.courseDao.selectByPrimaryKey(cId);

	}

	@Override
	public int updateByPrimaryKeySelective(CourseDTO record) {
		// TODO Auto-generated method stub
		return this.courseDao.updateByPrimaryKeySelective(record);

	};

	@Override
	public int updateByPrimaryKey(CourseDTO record) {
		// TODO Auto-generated method stub
		return this.courseDao.updateByPrimaryKey(record);

	}

	@Override
	public List<CourseDTO> findAll(PageDTO pageDTO) {
		// TODO Auto-generated method stub
		return this.courseDao.findAll(pageDTO);
	}

	@Override
	public CourseDTO selectBycNumber(String cNumber) {
		// TODO Auto-generated method stub
		return this.courseDao.selectBycNumber(cNumber);
	}

	@Override
	public int countCourse() {
		// TODO Auto-generated method stub
		return this.courseDao.countCourse();
	}

	@Override
	public List<CourseDTO> findAllByPeId(PagePeIdDTO pagePeIdDTO) {
		// TODO Auto-generated method stub
		return this.courseDao.findAllByPeId(pagePeIdDTO);
	}

	@Override
	public int countCourseByPeId(int peId) {
		// TODO Auto-generated method stub
		return this.courseDao.countCourseByPeId(peId);
	}

	@Override
	public int updateBycNumberSelective(CourseDTO record) {
		return this.courseDao.updateBycNumberSelective(record);
	}
}
