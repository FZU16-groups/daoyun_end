package com.pcs.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.pcs.dto.DataDictAndItemDTO;
import com.pcs.dto.PageDTO;
import com.pcs.pojo.DictionaryDetailDTO;
import com.pcs.service.IDictionaryDetailService;
import com.pcs.utils.ResponseData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pcs.pojo.DictionaryDTO;
import com.pcs.service.IDictionaryService;

@Controller
public class DictionaryController {
	@Resource
	private IDictionaryService dictionaryService;
	@Resource
	private IDictionaryDetailService dictionaryDetailService;

	/**
	 * 获取单个字典信息
	 * 
	 * @param dictionary
	 * @return
	 */
	@RequestMapping(value = "/selectByDictionaryPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody DictionaryDTO selectByPrimaryKey(@RequestBody DictionaryDTO dictionary) {
		return this.dictionaryService.selectByPrimaryKey(dictionary.getdId());
	}

	/**
	 * 删除单个字典信息
	 * 
	 * @param dataDictAndItemDTO
	 * @return
	 */
	@RequestMapping(value = "/deleteByDictionaryPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody ResponseData deleteByPrimaryKey(@RequestBody DataDictAndItemDTO dataDictAndItemDTO) {
		int total = this.dictionaryDetailService.countBydId(dataDictAndItemDTO.getdId());
		if(total == 0){
			this.dictionaryService.deleteByPrimaryKey(dataDictAndItemDTO.getdId());
			ResponseData responseData= ResponseData.ok();
			return  responseData;
		} else {
			ResponseData responseData= ResponseData.deleteError();
			return  responseData;
		}
	}

	/**
	 * 修改单个字典信息
	 * 
	 * @param dataDictAndItemDTO
	 * @return
	 */
	@RequestMapping(value = "/updateDataDictAndItem.do", method = { RequestMethod.POST })
	public @ResponseBody ResponseData updateByPrimaryKeySelective(@RequestBody DataDictAndItemDTO dataDictAndItemDTO) {
		ResponseData responseData = ResponseData.ok();
		DictionaryDTO dictionary = new DictionaryDTO(dataDictAndItemDTO.getdId(),
				dataDictAndItemDTO.getChineseName(),dataDictAndItemDTO.getEnglishName());
		this.dictionaryService.updateByPrimaryKeySelective(dictionary);
		List<DictionaryDetailDTO> items = dataDictAndItemDTO.getItems();
		this.dictionaryDetailService.deleteAllByDId(dataDictAndItemDTO.getdId());
		for(DictionaryDetailDTO item: items){
			item.setdId(dataDictAndItemDTO.getdId());
			this.dictionaryDetailService.insertSelective(item);
		}
		return responseData;
	}

	/**
	 * 添加单个字典信息
	 * 
	 * @param dataDictAndItemDTO
	 * @return
	 */
	@RequestMapping(value = "/insertDictionary.do", method = { RequestMethod.POST })
	public @ResponseBody ResponseData insertSelective(@RequestBody DataDictAndItemDTO dataDictAndItemDTO) {
		DictionaryDTO dictionary = new DictionaryDTO(dataDictAndItemDTO.getChineseName(),dataDictAndItemDTO.getEnglishName());
		this.dictionaryService.insertSelective(dictionary);
		int dId = dictionary.getdId();
		List<DictionaryDetailDTO> items = dataDictAndItemDTO.getItems();
		for(DictionaryDetailDTO dictionaryDetail:items){
			dictionaryDetail.setdId(dId);
			this.dictionaryDetailService.insertSelective(dictionaryDetail);
		}
		ResponseData responseData = ResponseData.ok();
		return responseData;
	}

	/**
	 * 查找全部字典信息
	 */
	@RequestMapping(value = "/findAllDictionaries.do", method = { RequestMethod.POST })
	public @ResponseBody ResponseData findAll(@RequestBody PageDTO pageDTO) {
		ResponseData responseData = ResponseData.ok();
		int total =  this.dictionaryService.countDictionary();
		responseData.putDataValue("total", total);

		List<Map<String, Object>> datas = new ArrayList<Map<String, Object>>();
		List<DictionaryDTO> dictionaries = this.dictionaryService.findAll(pageDTO);
		for(int i =0;i<dictionaries.size();i++){
			Map<String, Object> data = new HashMap<String, Object>();
			DictionaryDTO one = dictionaries.get(i);
			data.put("dId",one.getdId());
			data.put("chineseName",one.getChineseName());
			data.put("englishName",one.getEnglishName());
			int dId = one.getdId();
			List<DictionaryDetailDTO> ones =  this.dictionaryDetailService.selectBydId(dId);
			data.put("items",ones);
			datas.add(data);
		}
		responseData.putDataValue("data",datas);
		return responseData;
	}
}