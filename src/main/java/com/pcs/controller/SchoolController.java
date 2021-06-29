package com.pcs.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.pcs.dto.PageDTO;
import com.pcs.utils.ResponseData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pcs.pojo.SchoolDTO;
import com.pcs.service.ISchoolService;

@Controller
public class SchoolController {
	@Resource
	private ISchoolService schoolService;

	/**
	 * 获取单个校园信息
	 * 
	 * @param school
	 * @return
	 */
	@RequestMapping(value = "/selectBySchoolPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody
    SchoolDTO selectByPrimaryKey(@RequestBody SchoolDTO school) {
		return this.schoolService.selectByPrimaryKey(school.getsId());
	}

	/**
	 * 删除单个校园信息
	 * 
	 * @param school
	 * @return
	 */
	@RequestMapping(value = "/deleteBySchoolPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody Integer deleteByPrimaryKey(@RequestBody SchoolDTO school) {
		return this.schoolService.deleteByPrimaryKey(school.getsId());
	}

	/**
	 * 修改单个校园信息
	 * 
	 * @param school
	 * @return
	 */
	@RequestMapping(value = "/updateBySchoolPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody Integer updateByPrimaryKeySelective(@RequestBody SchoolDTO school) {
		return this.schoolService.updateByPrimaryKeySelective(school);
	}

	/**
	 * 添加单个校园信息
	 * 
	 * @param school
	 * @return
	 */
	@RequestMapping(value = "/insertSchool.do", method = { RequestMethod.POST })
	public @ResponseBody Integer insertSelective(@RequestBody SchoolDTO school) {
		return this.schoolService.insertSelective(school);
	}

	/**
	 * 查找全部校园信息
	 */
	@RequestMapping("/findAllSchools.do")
	public @ResponseBody List<SchoolDTO> findAll(PageDTO pageDTO) {
		return this.schoolService.findAll(pageDTO);
	}

	/**
	 * 级联方式校园信息
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/classify.do", method = { RequestMethod.POST })
	public @ResponseBody ResponseData classify(@RequestBody PageDTO pageDTO) {
		ResponseData responseData = ResponseData.ok();
		int total =  this.schoolService.countSchool();
		responseData.putDataValue("total", total);

		List<SchoolDTO> ls = this.schoolService.findAll(pageDTO);
		List<Map<String, Object>> lm = new ArrayList<Map<String, Object>>();
		for (SchoolDTO school : ls) {
			Map map = new HashMap();
			String sName = school.getsName();
			map.put("sName", sName);
			map.put("sId",school.getsId());
			map.put("major",school.getMajor());
			map.put("college",school.getCollege());
			lm.add(map);
		}
		responseData.putDataValue("data", lm);

		return responseData;
	}
}