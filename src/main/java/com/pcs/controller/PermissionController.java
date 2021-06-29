package com.pcs.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pcs.pojo.PermissionDTO;
import com.pcs.service.IPermissionService;

@Controller
public class PermissionController {
	@Resource
	private IPermissionService permissionService;

	/**
	 * 获取单个权限信息
	 * 
	 * @param permission
	 * @return
	 */
	@RequestMapping(value = "/selectByPermissionPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody
    PermissionDTO selectByPrimaryKey(@RequestBody PermissionDTO permission) {
		return this.permissionService.selectByPrimaryKey(permission.getpId());
	}

	/**
	 * 删除单个权限信息
	 * 
	 * @param permission
	 * @return
	 */
	@RequestMapping(value = "/deleteByPermissionPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody Integer deleteByPrimaryKey(@RequestBody PermissionDTO permission) {
		return this.permissionService.deleteByPrimaryKey(permission.getpId());
	}

	/**
	 * 修改单个权限信息
	 * 
	 * @param permission
	 * @return
	 */
	@RequestMapping(value = "/updateByPermissionPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody Integer updateByPrimaryKeySelective(@RequestBody PermissionDTO permission) {
		return this.permissionService.updateByPrimaryKeySelective(permission);
	}

	/**
	 * 添加单个权限信息
	 * 
	 * @param permission
	 * @return
	 */
	@RequestMapping(value = "/insertPermission.do", method = { RequestMethod.POST })
	public @ResponseBody Integer insertSelective(@RequestBody PermissionDTO permission) {
		return this.permissionService.insertSelective(permission);
	}

	/**
	 * 查找全部权限信息
	 */
	@RequestMapping("/findAllPermissions.do")
	public @ResponseBody List<PermissionDTO> findAll() {
		return this.permissionService.findAll();
	}
}