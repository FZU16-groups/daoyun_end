package com.dao;

import com.pojo.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("PersonDao")
public interface PersonDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Person record);

    int insertSelective(Person record);

    Person selectByPrimaryKey(Integer id);

    Person selectByUserId(Integer uId);

    int updateByPrimaryKeySelective(Person record);

    int updateByPrimaryKey(Person record);

    List<Person> findAll();

    Integer deleteByUserId(Integer uId);
}