package com.pcs.service;

import java.util.List;

import com.pcs.dto.PageDTO;
import com.pcs.dto.PagePeIdDTO;
import com.pcs.pojo.CourseDTO;

public interface ICourseService {
	int deleteByPrimaryKey(Integer cId);

	int insert(CourseDTO record);

	int insertSelective(CourseDTO record);

	CourseDTO selectByPrimaryKey(Integer cId);

	CourseDTO selectBycNumber(String cNumber);

	int updateByPrimaryKeySelective(CourseDTO record);

	int updateByPrimaryKey(CourseDTO record);

	List<CourseDTO> findAll(PageDTO pageDTO);

	int countCourse();

	List<CourseDTO> findAllByPeId(PagePeIdDTO pagePeIdDTO);

	int countCourseByPeId(int peId);

	int updateBycNumberSelective(CourseDTO record);
}
