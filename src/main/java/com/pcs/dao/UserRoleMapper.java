package com.pcs.dao;

import java.util.List;

import com.pcs.pojo.UserDTO;
import com.pcs.pojo.UserRole;

public interface UserRoleMapper {
    int deleteByPrimaryKey(Integer urId);

    int deleteByUId(Integer uId );

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Integer urId);

    List<UserRole> selectByUId(Integer uId);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

    int updateByUId(UserDTO user);
    
	List<UserRole> findAll();

}