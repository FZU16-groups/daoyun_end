package com.pcs.dao;

import java.util.List;

import com.pcs.dto.PageDTO;
import com.pcs.dto.UserRoleDTO;
import com.pcs.pojo.UserDTO;

public interface UserMapper {
	int deleteByPrimaryKey(Integer uId);

	int insert(UserDTO record);

	int insertSelective(UserDTO record);

	UserDTO selectByPrimaryKey(Integer uId);

	UserDTO selectByuNumber(String uNumber);

	UserDTO selectByPhone(String phone);

	int updateByPrimaryKeySelective(UserDTO record);

	int updateByPrimaryKey(UserDTO record);

	List<UserRoleDTO> findAll( );

	int countUser();

	int countUName(String uName);
	int countPhone(String phone);
	int countEmail(String email);


}