package com.pcs.service;

import java.util.List;

import com.pcs.dto.PageDTO;
import com.pcs.pojo.SchoolDTO;

public interface ISchoolService {
	int deleteByPrimaryKey(Integer sId);

	int insert(SchoolDTO record);

	int insertSelective(SchoolDTO record);

	SchoolDTO selectByPrimaryKey(Integer sId);

	int updateByPrimaryKeySelective(SchoolDTO record);

	int updateByPrimaryKey(SchoolDTO record);

	List<SchoolDTO> findAll(PageDTO pageDTO);

	int countSchool();
}
