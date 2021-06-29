package com.pcs.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pcs.pojo.ButtonDTO;
import com.pcs.service.IButtonService;

@Controller
public class ButtonController {
	@Resource
	private IButtonService buttonService;

	/**
	 * 获取单个按钮信息
	 * 
	 * @param button
	 * @return
	 */
	@RequestMapping(value = "/selectByButtonPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody
    ButtonDTO selectByPrimaryKey(@RequestBody ButtonDTO button) {
		return this.buttonService.selectByPrimaryKey(button.getbId());
	}

	/**
	 * 删除单个按钮信息
	 * 
	 * @param button
	 * @return
	 */
	@RequestMapping(value = "/deleteByButtonPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody Integer deleteByPrimaryKey(@RequestBody ButtonDTO button) {
		return this.buttonService.deleteByPrimaryKey(button.getbId());
	}

	/**
	 * 修改单个按钮信息
	 * 
	 * @param button
	 * @return
	 */
	@RequestMapping(value = "/updateByButtonPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody Integer updateByPrimaryKeySelective(@RequestBody ButtonDTO button) {
		return this.buttonService.updateByPrimaryKeySelective(button);
	}

	/**
	 * 添加单个按钮信息
	 * 
	 * @param Button
	 * @return
	 */
	@RequestMapping(value = "/insertButton.do", method = { RequestMethod.POST })
	public @ResponseBody Integer insertSelective(@RequestBody ButtonDTO Button) {
		return this.buttonService.insertSelective(Button);
	}

	/**
	 * 查找全部按钮信息
	 */
	@RequestMapping("/findAllButtons.do")
	public @ResponseBody List<ButtonDTO> findAll() {
		return this.buttonService.findAll();
	}
}