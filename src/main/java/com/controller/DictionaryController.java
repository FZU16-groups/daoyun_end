package com.pcs.controller;

import java.util.List;

import javax.annotation.Resource;

import com.pcs.dto.PageDTO;
import com.pcs.utils.ResponseData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pcs.pojo.Dictionary;
import com.pcs.service.IDictionaryService;

@Controller
public class DictionaryController {
	@Resource
	private IDictionaryService dictionaryService;

	/**
	 * 获取单个字典信息
	 * 
	 * @param dictionary
	 * @return
	 */
	@RequestMapping(value = "/selectByDictionaryPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody Dictionary selectByPrimaryKey(@RequestBody Dictionary dictionary) {
		return this.dictionaryService.selectByPrimaryKey(dictionary.getdId());
	}

	/**
	 * 删除单个字典信息
	 * 
	 * @param dictionary
	 * @return
	 */
	@RequestMapping(value = "/deleteByDictionaryPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody Integer deleteByPrimaryKey(@RequestBody Dictionary dictionary) {
		return this.dictionaryService.deleteByPrimaryKey(dictionary.getdId());
	}

	/**
	 * 修改单个字典信息
	 * 
	 * @param dictionary
	 * @return
	 */
	@RequestMapping(value = "/updateByDictionaryPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody Integer updateByPrimaryKeySelective(@RequestBody Dictionary dictionary) {
		return this.dictionaryService.updateByPrimaryKeySelective(dictionary);
	}

	/**
	 * 添加单个字典信息
	 * 
	 * @param dictionary
	 * @return
	 */
	@RequestMapping(value = "/insertDictionary.do", method = { RequestMethod.POST })
	public @ResponseBody Integer insertSelective(@RequestBody Dictionary dictionary) {
		return this.dictionaryService.insertSelective(dictionary);
	}

	/**
	 * 查找全部字典信息
	 */
	@RequestMapping(value = "/findAllDictionaries.do", method = { RequestMethod.POST })
	public @ResponseBody ResponseData findAll(@RequestBody PageDTO pageDTO) {
		ResponseData responseData = ResponseData.ok();
		int total =  this.dictionaryService.countDictionary();
		responseData.putDataValue("total", total);
		List<Dictionary> data = this.dictionaryService.findAll(pageDTO);
		responseData.putDataValue("data",data);
		return responseData;
	}
}