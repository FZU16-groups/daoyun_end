package com.pcs.service;

import java.util.List;

import com.pcs.pojo.PersonCourse;

public interface IPersonCourseService {
	int deleteByPrimaryKey(Integer pcId);

	int deleteBycId(Integer cId);

	int insert(PersonCourse record);

	int insertSelective(PersonCourse record);

	PersonCourse selectByPrimaryKey(Integer pcId);

	int updateByPrimaryKeySelective(PersonCourse record);

	int updateByPrimaryKey(PersonCourse record);

	List<PersonCourse> findAll();

	List<PersonCourse> createdCourse(PersonCourse personCourse);

	List<PersonCourse> addedCourse(PersonCourse personCourse);

	List<PersonCourse> selectPersonBycId(Integer cId);

	PersonCourse judgeJoinCourse(PersonCourse record);

	List<PersonCourse> selectBycId(Integer record);

	PersonCourse findTeacher(PersonCourse record);

	PersonCourse selectBycIdAndpeId(PersonCourse record);

	List<PersonCourse> selectStudentsBycId(Integer record);
}
