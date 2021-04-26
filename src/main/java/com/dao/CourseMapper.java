package com.pcs.dao;

import java.util.List;

import com.pcs.dto.PageDTO;
import com.pcs.pojo.Course;

public interface CourseMapper {
	int deleteByPrimaryKey(Integer cId);

	int insert(Course record);

	int insertSelective(Course record);

	Course selectByPrimaryKey(Integer cId);

	Course selectBycNumber(String cNumber);

	int updateByPrimaryKeySelective(Course record);

	int updateByPrimaryKey(Course record);

	List<Course> findAll(PageDTO pageDTO);

	int countCourse();
}