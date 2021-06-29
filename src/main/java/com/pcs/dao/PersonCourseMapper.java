package com.pcs.dao;

import java.util.List;

import com.pcs.pojo.PersonCourse;

public interface PersonCourseMapper {
	int deleteByPrimaryKey(Integer pcId);
	
	int deleteBycId(Integer cId);

	int insert(PersonCourse record);

	int insertSelective(PersonCourse record);

	PersonCourse selectByPrimaryKey(Integer pcId);

	int updateByPrimaryKeySelective(PersonCourse record);

	int updateByPrimaryKey(PersonCourse record);

	List<PersonCourse> findAll();

	List<PersonCourse> createdCourse(PersonCourse record);

	List<PersonCourse> addedCourse(PersonCourse record);

	List<PersonCourse> selectPersonBycId(Integer record);

	PersonCourse judgeJoinCourse(PersonCourse record);

	List<PersonCourse> selectBycId(Integer record);

	PersonCourse findTeacher(PersonCourse record);

	PersonCourse selectBycIdAndpeId(PersonCourse record);

	List<PersonCourse> selectStudentsBycId(Integer record);
}