package com.pcs.controller;

import java.util.List;

import javax.annotation.Resource;

import com.pcs.dto.RoleListDTO;
import com.pcs.pojo.RoleDTO;
import com.pcs.pojo.UserRole;
import com.pcs.utils.ResponseData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pcs.pojo.RolePermissionDTO;
import com.pcs.service.IRolePermissionService;

@Controller
public class RolePermissionController {
	@Resource
	private IRolePermissionService rolePermissionService;

	/**
	 * 获取单个角色权限信息
	 * 
	 * @param roleListDTO
	 * @return
	 */
	@RequestMapping(value = "/selectByRolePermissionPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody
    ResponseData selectByPrimaryKey(@RequestBody RoleListDTO roleListDTO) {
		if(roleListDTO == null){
			ResponseData responseData = ResponseData.emptyRole();
			return responseData;
		}
		List<RolePermissionDTO> permissionList = null;
		ResponseData responseData = ResponseData.ok();
		List<RoleDTO> roleList = roleListDTO.getRoleList();
		// 汇总用户各角色的权限和
		for(RoleDTO role: roleList){
			List<RolePermissionDTO> temp = this.rolePermissionService.selectByRId(role.getrId());
			if(permissionList == null){
				permissionList = temp;
			} else {
				for(int i=0;i<temp.size();i++){
					if(temp.get(i).getStatus() == 1){
						permissionList.get(i).setStatus(1);
					}
				}
			}
		}
		responseData.putDataValue("permissionList",permissionList);
		return responseData;
	}

	/**
	 * 删除单个角色权限信息
	 * 
	 * @param rolePermission
	 * @return
	 */
	@RequestMapping(value = "/deleteByRolePermissionPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody Integer deleteByPrimaryKey(@RequestBody RolePermissionDTO rolePermission) {
		return this.rolePermissionService.deleteByPrimaryKey(rolePermission.getRpId());
	}

	/**
	 * 根据rId和pId修改单个角色权限信息
	 * 
	 * @param rolePermission
	 * @return
	 */
	@RequestMapping(value = "/updateByrIdAndpId.do", method = { RequestMethod.POST })
	public @ResponseBody Integer updateByrIdAndpId(@RequestBody RolePermissionDTO rolePermission) {
		return this.rolePermissionService.updateByrIdAndpId(rolePermission);
	}

	/**
	 * 修改单个角色权限信息
	 * 
	 * @param rolePermission
	 * @return
	 */
	@RequestMapping(value = "/updateByRolePermissionPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody Integer updateByPrimaryKeySelective(@RequestBody RolePermissionDTO rolePermission) {
		return this.rolePermissionService.updateByPrimaryKeySelective(rolePermission);
	}

	/**
	 * 添加单个角色权限信息
	 * 
	 * @param rolePermission
	 * @return
	 */
	@RequestMapping(value = "/insertRolePermission.do", method = { RequestMethod.POST })
	public @ResponseBody Integer insertSelective(@RequestBody RolePermissionDTO rolePermission) {
		return this.rolePermissionService.insertSelective(rolePermission);
	}

	/**
	 * 查找全部角色权限信息
	 */
	@RequestMapping("/findAllRolePermissions.do")
	public @ResponseBody List<RolePermissionDTO> findAll() {
		return this.rolePermissionService.findAll();
	}
}