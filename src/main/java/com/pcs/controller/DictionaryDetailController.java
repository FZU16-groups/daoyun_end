package com.pcs.controller;

import java.util.List;

import javax.annotation.Resource;

import com.pcs.utils.ResponseData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pcs.pojo.DictionaryDTO;
import com.pcs.pojo.DictionaryDetailDTO;
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
	public @ResponseBody
	DictionaryDetailDTO selectByPrimaryKey(DictionaryDetailDTO dictionaryDetail) {
		return this.dictionaryDetailService.selectByPrimaryKey(dictionaryDetail.getDdId());
	}

	/**
	 * 删除单个字典详情信息
	 * 
	 * @param dictionaryDetail
	 * @return
	 */
	@RequestMapping(value = "/deleteByDictionaryDetailPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody ResponseData deleteByPrimaryKey(@RequestBody DictionaryDetailDTO dictionaryDetail) {
		this.dictionaryDetailService.deleteByPrimaryKey(dictionaryDetail.getDdId());
		ResponseData responseData = ResponseData.ok();
		return responseData;
	}

	/**
	 * 修改单个字典详情信息
	 * 
	 * @param dictionaryDetail
	 * @return
	 */
	@RequestMapping(value = "/updateByDictionaryDetailPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody ResponseData updateByPrimaryKeySelective(@RequestBody DictionaryDetailDTO dictionaryDetail) {
		ResponseData responseData = ResponseData.ok();
		if(dictionaryDetail.getIsDefault().equals(1)){
			//修改并保存当前数据明细项
			dictionaryDetail.setSort(0);
			int res = this.dictionaryDetailService.updateByPrimaryKeySelective(dictionaryDetail);
			//修改并保存其他项
			int res1=0;
			List<DictionaryDetailDTO> dictionaryDetailDTOList = this.dictionaryDetailService.selectBydId(dictionaryDetail.getdId());
			for(int i=0;i<dictionaryDetailDTOList.size();i++){
				DictionaryDetailDTO dictionaryDetail1 = dictionaryDetailDTOList.get(i);
				if(dictionaryDetail1.getDdId() != dictionaryDetail.getDdId()){
					dictionaryDetail1.setIsDefault(0);
					dictionaryDetail1.setSort(dictionaryDetail1.getSort()+1);
					res1 = this.dictionaryDetailService.updateByPrimaryKeySelective(dictionaryDetail1);
				}
				if(res1 == 0)
					break;
			}
			if(res == 0 || res1 == 0){
				responseData = new ResponseData(1009,"fall");
			}
		}
		return responseData;
	}

	/**
	 * 添加单个字典详情信息
	 * 
	 * @param dictionaryDetail
	 * @return
	 */
	@RequestMapping(value = "/insertDictionaryDetail.do", method = { RequestMethod.POST })
	public @ResponseBody ResponseData insertSelective(@RequestBody DictionaryDetailDTO dictionaryDetail) {
		ResponseData responseData = ResponseData.ok();
		List<DictionaryDetailDTO> dictionaryDetailDTOList = this.dictionaryDetailService.selectBydId(dictionaryDetail.getdId());
		int size = dictionaryDetailDTOList.size();
		if(size == 0){
			dictionaryDetail.setSort(0);
			dictionaryDetail.setIsDefault(1);
		}
		else{
			dictionaryDetail.setSort(size);
			dictionaryDetail.setIsDefault(0);
		}
		responseData.putDataValue("dictionaryDetail",dictionaryDetail);
		return responseData;
	}

	/**
	 * 保存单个字典详情信息
	 *
	 * @param dictionaryDetail
	 * @return
	 */
	@RequestMapping(value = "/saveDictionaryDetail.do", method = { RequestMethod.POST })
	public @ResponseBody ResponseData saveSelective(@RequestBody DictionaryDetailDTO dictionaryDetail) {
		ResponseData responseData = ResponseData.ok();
		this.dictionaryDetailService.insertSelective(dictionaryDetail);
		return responseData;
	}

	/**
	 * 查找全部字典详情信息
	 */
	@RequestMapping("/findAllDictionaryDetails.do")
	public @ResponseBody List<DictionaryDetailDTO> findAll() {
		return this.dictionaryDetailService.findAll();
	}

	/**
	 * 根据字典dId查询字典详情信息
	 */
	@RequestMapping(value = "/selectDictionaryDetailByDictionaryId.do", method = { RequestMethod.POST })
	public @ResponseBody ResponseData selectBydId(@RequestBody DictionaryDTO dictionary) {
		ResponseData responseData = ResponseData.ok();
		List<DictionaryDetailDTO> dictionaryDetailDTOList = this.dictionaryDetailService.selectBydId(dictionary.getdId());
		if(dictionaryDetailDTOList.size() > 0)
			responseData.putDataValue("dictionaryDetailDTOList",dictionaryDetailDTOList);
		else
			responseData = new ResponseData(1008,"null");
		return responseData;
	}

	/**
	 * 根据字典ddId查询字典详情信息
	 */
	@RequestMapping(value = "/selectDictionaryDetailByDictionaryDetailId.do", method = { RequestMethod.POST })
	public @ResponseBody ResponseData selectByddId(@RequestBody DictionaryDetailDTO dictionaryDetail) {
		ResponseData responseData = ResponseData.ok();
		List<DictionaryDetailDTO> dictionaryDetailDTOList = this.dictionaryDetailService.selectByddId(dictionaryDetail.getDdId());
		if(dictionaryDetailDTOList.size() > 0)
			responseData.putDataValue("dictionaryDetailDTOList",dictionaryDetailDTOList);
		else
			responseData = new ResponseData(1008,"null");
		return responseData;
	}
}