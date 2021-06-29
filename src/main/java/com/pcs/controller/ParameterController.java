package com.pcs.controller;

import java.util.List;

import javax.annotation.Resource;

import com.pcs.utils.ResponseData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pcs.pojo.ParameterDTO;
import com.pcs.service.IParameterService;

@Controller
public class ParameterController {
	@Resource
	private IParameterService parameterService;

	/**
	 * 获取单个参数信息
	 * 
	 * @param parameter
	 * @return
	 */
	@RequestMapping(value = "/selectByParameterPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody
    ParameterDTO selectByPrimaryKey(@RequestBody ParameterDTO parameter) {
		return this.parameterService.selectByPrimaryKey(parameter.getPaId());
	}

	/**
	 * 删除单个参数信息
	 * 
	 * @param parameter
	 * @return
	 */
	@RequestMapping(value = "/deleteByParameterPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody Integer deleteByPrimaryKey(@RequestBody ParameterDTO parameter) {
		return this.parameterService.deleteByPrimaryKey(parameter.getPaId());
	}

	/**
	 * 修改单个参数信息
	 * 
	 * @param parameter
	 * @return
	 */
	@RequestMapping(value = "/updateByParameterPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody Integer updateByPrimaryKeySelective(@RequestBody ParameterDTO parameter) {
		return this.parameterService.updateByPrimaryKeySelective(parameter);
	}

	/**
	 * 添加单个参数信息
	 * 
	 * @param parameter
	 * @return
	 */
	@RequestMapping(value = "/insertParameter.do", method = { RequestMethod.POST })
	public @ResponseBody Integer insertSelective(@RequestBody ParameterDTO parameter) {
		return this.parameterService.insertSelective(parameter);
	}

	/**
	 * 查找全部参数信息
	 */
	@RequestMapping("/findAllParameters.do")
	public @ResponseBody
    ResponseData findAll() {
		ResponseData responseData = ResponseData.ok();
	    List<ParameterDTO> parameterList = this.parameterService.findAll();
	    responseData.putDataValue("parameterList",parameterList);
	    return responseData;
	}

    /**
     * 关键字重复判断
     */
    @RequestMapping("/isKeywordExist.do")
    public @ResponseBody
    ResponseData isKeywordExist(ParameterDTO parameterDTO) {
		ResponseData responseData = null;
		if(parameterDTO.getPaId() == null){
			if(this.parameterService.countKeyword(parameterDTO)!=0){
				responseData = ResponseData.existError();
				return responseData;
			}
		}else if(this.parameterService.countKeywordByPaId(parameterDTO)!=0){
        	responseData = ResponseData.existError();
			return responseData;
		}
		responseData = ResponseData.ok();
        return responseData;
    }
}