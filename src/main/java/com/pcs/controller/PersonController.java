package com.pcs.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pcs.pojo.PersonDTO;
import com.pcs.service.IPersonService;

@Controller
public class PersonController {
	@Resource
	private IPersonService personService;

	/**
	 * 获取单个师生信息
	 * 
	 * @param person
	 * @return
	 */
	@RequestMapping(value = "/selectByPersonPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody
    PersonDTO selectByPrimaryKey(@RequestBody PersonDTO person) {
		return this.personService.selectByPrimaryKey(person.getPeId());
	}

	/**
	 * 删除单个师生信息
	 * 
	 * @param person
	 * @return
	 */
	@RequestMapping(value = "/deleteByPersonPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody Integer deleteByPrimaryKey(@RequestBody PersonDTO person) {
		return this.personService.deleteByPrimaryKey(person.getPeId());
	}

	/**
	 * 修改单个师生信息
	 * 
	 * @param person
	 * @return
	 */
	@RequestMapping(value = "/updateByPersonPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody
    PersonDTO updateByPrimaryKeySelective(@RequestBody PersonDTO person) {
		Integer res = this.personService.updateByPrimaryKeySelective(person);
		if (res > 0) {
			return this.personService.selectByPrimaryKey(person.getPeId());
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
	@RequestMapping(value = "/insertPerson.do", method = { RequestMethod.POST })
	public @ResponseBody
    PersonDTO insertSelective(@RequestBody PersonDTO person) {
		Integer res = this.personService.insertSelective(person);
		if (res == 1) {
			PersonDTO person1 = this.personService.selectByuId(person.getuId());
			return person1;
		} else {
			return null;
		}

	}

	/**
	 * 查找全部师生信息
	 */
	@RequestMapping("/findAllPersons.do")
	public @ResponseBody List<PersonDTO> findAll() {
		return this.personService.findAll();
	}
}