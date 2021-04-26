package com.pcs.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pcs.pojo.Dictionary;
import com.pcs.pojo.DictionaryDetail;
import com.pcs.service.IDictionaryDetailService;

@Controller
public class DictionaryDetailController {
	@Resource
	private IDictionaryDetailService dictionaryDetailService;

	/**
	 * 获取单个字典详情信息
	 * 
	 * @param dictionaryDetail
	 * @return
	 */
	@RequestMapping(value = "/selectByDictionaryDetailPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody DictionaryDetail selectByPrimaryKey(DictionaryDetail dictionaryDetail) {
		return this.dictionaryDetailService.selectByPrimaryKey(dictionaryDetail.getDdId());
	}

	/**
	 * 删除单个字典详情信息
	 * 
	 * @param dictionaryDetail
	 * @return
	 */
	@RequestMapping(value = "/deleteByDictionaryDetailPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody Integer deleteByPrimaryKey(@RequestBody DictionaryDetail dictionaryDetail) {
		return this.dictionaryDetailService.deleteByPrimaryKey(dictionaryDetail.getDdId());
	}

	/**
	 * 修改单个字典详情信息
	 * 
	 * @param dictionaryDetail
	 * @return
	 */
	@RequestMapping(value = "/updateByDictionaryDetailPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody Integer updateByPrimaryKeySelective(@RequestBody DictionaryDetail dictionaryDetail) {
		return this.dictionaryDetailService.updateByPrimaryKeySelective(dictionaryDetail);
	}

	/**
	 * 添加单个字典详情信息
	 * 
	 * @param dictionaryDetail
	 * @return
	 */
	@RequestMapping(value = "/insertDictionaryDetail.do", method = { RequestMethod.POST })
	public @ResponseBody Integer insertSelective(@RequestBody DictionaryDetail dictionaryDetail) {
		return this.dictionaryDetailService.insertSelective(dictionaryDetail);
	}

	/**
	 * 查找全部字典详情信息
	 */
	@RequestMapping("/findAllDictionaryDetails.do")
	public @ResponseBody List<DictionaryDetail> findAll() {
		return this.dictionaryDetailService.findAll();
	}

	/**
	 * 根据字典dId查询字典详情信息
	 */
	@RequestMapping(value = "/selectByDictionaryDetailId.do", method = { RequestMethod.POST })
	public @ResponseBody List<DictionaryDetail> selectBydId(@RequestBody Dictionary dictionary) {
		return this.dictionaryDetailService.selectBydId(dictionary.getdId());
	}
}