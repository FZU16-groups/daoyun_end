package com.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.Person;
import com.service.IPersonService;

@Controller
@RequestMapping("/person")
public class PersonController {
	@Resource
	private IPersonService personService;

	/**
	 * 获取单个师生信息
	 * 
	 * @param person
	 * @return
	 */
	@RequestMapping(value = "/selectByPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody Person selectByPrimaryKey(@RequestBody Person person) {
		return this.personService.selectByPrimaryKey(person.getId());
	}

	/**
	 * 删除单个师生信息
	 * 
	 * @param person
	 * @return
	 */
	@RequestMapping(value = "/deleteByPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody Integer deleteByPrimaryKey(@RequestBody Person person) {
		return this.personService.deleteByPrimaryKey(person.getId());
	}

	/**
	 * 修改单个师生信息
	 * 
	 * @param person
	 * @return
	 */
	@RequestMapping(value = "/updateByPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody Person updateByPrimaryKeySelective(@RequestBody Person person) {
		Integer res = this.personService.updateByPrimaryKeySelective(person);
		if (res > 0) {
			return this.personService.selectByPrimaryKey(person.getId());
		} else {
			return null;
		}
	}

	/**
	 * 添加单个师生信息
	 * 
	 * @param person
	 * @return
	 */
	@RequestMapping(value = "/insert.do", method = { RequestMethod.POST })
	public @ResponseBody Person insertSelective(@RequestBody Person person) {
		Integer res = this.personService.insertSelective(person);
		if (res == 1) {
			Person person1 = this.personService.selectByuId(person.getUserid());
			return person1;
		} else {
			return null;
		}

	}

	/**
	 * 查找全部师生信息
	 */
	@RequestMapping("/findAll.do")
	public @ResponseBody List<Person> findAll() {
		return this.personService.findAll();
	}
}