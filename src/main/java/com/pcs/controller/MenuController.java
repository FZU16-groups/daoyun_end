package com.pcs.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pcs.pojo.MenuDTO;
import com.pcs.service.IMenuService;

@Controller
public class MenuController {
	@Resource
	private IMenuService menuService;

	/**
	 * 获取单个菜单信息
	 * 
	 * @param menu
	 * @return
	 */
	@RequestMapping(value = "/selectByMenuPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody
    MenuDTO selectByPrimaryKey(@RequestBody MenuDTO menu) {
		return this.menuService.selectByPrimaryKey(menu.getmId());
	}

	/**
	 * 删除单个菜单信息
	 * 
	 * @param menu
	 * @return
	 */
	@RequestMapping(value = "/deleteByMenuPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody Integer deleteByPrimaryKey(@RequestBody MenuDTO menu) {
		return this.menuService.deleteByPrimaryKey(menu.getmId());
	}

	/**
	 * 修改单个菜单信息
	 * 
	 * @param menu
	 * @return
	 */
	@RequestMapping(value = "/updateByMenuPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody Integer updateByPrimaryKeySelective(@RequestBody MenuDTO menu) {
		return this.menuService.updateByPrimaryKeySelective(menu);
	}

	/**
	 * 添加单个菜单信息
	 * 
	 * @param menu
	 * @return
	 */
	@RequestMapping(value = "/insertMenu.do", method = { RequestMethod.POST })
	public @ResponseBody Integer insertSelective(@RequestBody MenuDTO menu) {
		return this.menuService.insertSelective(menu);
	}

	/**
	 * 查找全部菜单信息
	 */
	@RequestMapping("/findAllMenus.do")
	public @ResponseBody List<MenuDTO> findAll() {
		return this.menuService.findAll();
	}
}