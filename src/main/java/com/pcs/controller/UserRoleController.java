package com.pcs.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.xml.ws.Response;

import com.pcs.pojo.RoleDTO;
import com.pcs.service.IRoleService;
import com.pcs.utils.ResponseData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.pcs.pojo.UserRole;
import com.pcs.service.IUserRoleService;

@Controller
public class UserRoleController {
	@Resource
	private IRoleService roleService;
	@Resource
	private IUserRoleService userRoleService;
	/**
	 * 获取单个用户角色信息
	 * 
	 * @param userRole
	 * @return
	 */
	@RequestMapping(value = "/selectUserRoleByUId.do", method = { RequestMethod.POST })
	public @ResponseBody
	ResponseData selectByPrimaryKey(@RequestBody UserRole userRole){
		ResponseData responseData = ResponseData.ok();
		List<RoleDTO> role = this.roleService.selectRoleListByUser(userRole.getuId());
		responseData.putDataValue("role",role);
		return responseData;
	}

	/**
	 * 删除单个用户角色信息
	 * 
	 * @param userRole
	 * @return
	 */
	@RequestMapping(value = "/deleteByUserRolePrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody Integer deleteByPrimaryKey(@RequestBody UserRole userRole) {
		return this.userRoleService.deleteByPrimaryKey(userRole.getUrId());
	}

	/**
	 * 修改单个用户角色信息
	 * 
	 * @param userRole
	 * @return
	 */
	@RequestMapping(value = "/updateByUserRolePrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody Integer updateByPrimaryKeySelective(@RequestBody UserRole userRole) {
		return this.userRoleService.updateByPrimaryKeySelective(userRole);
	}

	/**
	 * 添加单个用户角色信息
	 * 
	 * @param userRole
	 * @return
	 */
	@RequestMapping(value = "/insertUserRole.do", method = { RequestMethod.POST })
	public @ResponseBody Integer insertSelective(@RequestBody UserRole userRole) {
		return this.userRoleService.insertSelective(userRole);
	}

	/**
	 * 查找全部用户角色信息
	 */
	@RequestMapping("/findAllUserRoles.do")
	public @ResponseBody List<UserRole> findAll() {
		return this.userRoleService.findAll();
	}
}