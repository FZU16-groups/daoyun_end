package com.pcs.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import com.pcs.dto.AddRoleDTO;
import com.pcs.dto.PageDTO;
import com.pcs.dto.RoleAndRolePermissionsDTO;
import com.pcs.pojo.PermissionDTO;
import com.pcs.pojo.RolePermissionDTO;
import com.pcs.service.IRolePermissionService;
import com.pcs.utils.ResponseData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.pcs.pojo.RoleDTO;
import com.pcs.service.IRoleService;

@Controller
public class RoleController {
	@Resource
	private IRoleService roleService;
	@Resource
	private IRolePermissionService rolePermissionService;
	/**
	 * 获取单个角色信息
	 * 
	 * @param role
	 * @return
	 */
	@RequestMapping(value = "/selectByRolePrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody
	RoleDTO selectByPrimaryKey(@RequestBody RoleDTO role) {
		return this.roleService.selectByPrimaryKey(role.getrId());
	}

	/**
	 * 获取用户对应角色信息
	 *
	 * @param rIdList
	 * @return
	 */
	@RequestMapping(value = "/selectRoleListByRolePrimary.do", method = { RequestMethod.POST })
	public @ResponseBody
	ResponseData selectRoleListByPrimaryKey(@RequestBody List<Integer> rIdList) {
		ResponseData responseData = ResponseData.ok();
		List<RoleDTO> roleList = new ArrayList<RoleDTO>();
		for(Integer rId: rIdList){
			roleList.add(this.roleService.selectByPrimaryKey(rId));
		}
		responseData.putDataValue("roleList",roleList);
		return responseData;
	}

	/**
	 * 删除单个角色信息
	 * 
	 * @param role
	 * @return
	 */
	@RequestMapping(value = "/deleteByRolePrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody Integer deleteByPrimaryKey(@RequestBody RoleDTO role) {
		// 软删除
		return this.roleService.deleteByPrimaryKey(role.getrId());
	}

	/**
	 * 修改单个角色信息
	 * 
	 * @param roleAndRolePermissionsDTO
	 * @return
	 */
	@RequestMapping(value = "/updateByRolePrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody Integer updateByPrimaryKeySelective(@RequestBody RoleAndRolePermissionsDTO roleAndRolePermissionsDTO) {
		List<RolePermissionDTO> permissions = roleAndRolePermissionsDTO.getPermissions();
		for(int i=0; i<permissions.size(); i++){
			this.rolePermissionService.updateByrIdAndpId(permissions.get(i));
		}
		RoleDTO role = roleAndRolePermissionsDTO.getRole();
		return this.roleService.updateByPrimaryKeySelective(role);
	}

	/**
	 * 添加单个角色信息
	 * 
	 * @param addRoleDTO
	 * @return
	 */
	@RequestMapping(value = "/insertRole.do", method = { RequestMethod.POST })
	public @ResponseBody ResponseData insertSelective(@RequestBody AddRoleDTO addRoleDTO) {
		ResponseData responseData = ResponseData.ok();
		RoleDTO role = addRoleDTO.getRole();
		this.roleService.insertSelective(role);
		int rId = role.getrId();
		RolePermissionDTO rolePermissionDTO = new RolePermissionDTO(null,rId,1,
				addRoleDTO.getBasicFunction()?1:0);
		this.rolePermissionService.insertSelective(rolePermissionDTO);
		rolePermissionDTO = new RolePermissionDTO(null,rId,2,addRoleDTO.getUserManagement()?1:0);
		this.rolePermissionService.insertSelective(rolePermissionDTO);
		rolePermissionDTO = new RolePermissionDTO(null,rId,3,addRoleDTO.getClassManagement()?1:0);
		this.rolePermissionService.insertSelective(rolePermissionDTO);
		rolePermissionDTO = new RolePermissionDTO(null,rId,4,addRoleDTO.getRoleManagement()?1:0);
		this.rolePermissionService.insertSelective(rolePermissionDTO);
		rolePermissionDTO = new RolePermissionDTO(null,rId,5,addRoleDTO.getCollegeManagement()?1:0);
		this.rolePermissionService.insertSelective(rolePermissionDTO);
		rolePermissionDTO = new RolePermissionDTO(null,rId,6,addRoleDTO.getAdvancedPermission()?1:0);
		this.rolePermissionService.insertSelective(rolePermissionDTO);
		return responseData;


	}

	/**
	 * 查找全部角色信息
	 */
	@RequestMapping("/findAllRoles.do")
	public @ResponseBody List<RoleDTO> findAll() {
		return this.roleService.findAll();
	}

	/**
	 * 查找角色权限信息
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/selectRolePermission.do")
	public @ResponseBody ResponseData selectRolePermission( PageDTO pageDTO) {
		List<Map<String, Object>> lm = new ArrayList<Map<String, Object>>();
		Set hs = new HashSet();
		List<RoleDTO> lr = this.roleService.selectRolePermission();
		for (RoleDTO role : lr) {
			hs.add(role.getrName()); // 获取所有角色信息
		}
		Iterator it = hs.iterator();
		while (it.hasNext()) {
			Map map = new HashMap();
			String rName = (String) it.next();
			for (RoleDTO role : lr) {
				if (rName.equals(role.getrName())) {
					map.put("rId", role.getrId());
					map.put("description", role.getDescription());
				}
			}
			map.put("rName", rName);

			List<Map<String, Object>> permissions = new ArrayList<Map<String, Object>>();
			for (RoleDTO role : lr) {
				if (rName.equals(role.getrName())) {
					Map m1 = new HashMap();
					m1.put("rId", role.getrId());
					m1.put("pId", role.getpId());
					m1.put("pName", role.getpName());
					m1.put("status", role.getStatus());
					permissions.add(m1);
				}
				map.put("permissions", permissions);
			}
			lm.add(map);
		}
		List<Map<String, Object>> roleList = new ArrayList<Map<String, Object>>();

		for (int i=pageDTO.getPageIndex(); i<lm.size() && i<pageDTO.getPageIndex()+pageDTO.getPageSize(); i++) {
			roleList.add(lm.get(i));
		}
		ResponseData responseData = ResponseData.ok();
		responseData.putDataValue("roleList",roleList);
		responseData.putDataValue("total",lm.size());
		return responseData;
	}
}