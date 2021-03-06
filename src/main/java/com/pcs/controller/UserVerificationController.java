package com.pcs.controller;

import java.util.List;

import javax.annotation.Resource;

import com.pcs.pojo.*;
import com.pcs.service.*;
import org.springframework.web.bind.annotation.*;

import com.pcs.utils.JWTUtil;
import com.pcs.utils.MD5Encryption;
import com.pcs.utils.ResponseData;

@RestController
public class UserVerificationController {
	@Resource
	private IUserVerificationService userVerificationService;
	@Resource
	private IUserService userService;
	@Resource
	private IPersonService personService;
	@Resource
	private IRoleService roleService;

	/**`
	 * 获取单个用户权限信息
	 * 
	 * @param userVerification
	 * @return
	 */
	@RequestMapping(value = "/selectByUserVerificationPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody
	UserVerificationDTO selectByPrimaryKey(@RequestBody UserVerificationDTO userVerification) {
		return this.userVerificationService.selectByPrimaryKey(userVerification.getUvId());
	}

	/**
	 * 删除单个用户权限信息
	 * 
	 * @param userVerification
	 * @return
	 */
	@RequestMapping(value = "/deleteByUserVerificationPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody Integer deleteByPrimaryKey(@RequestBody UserVerificationDTO userVerification) {
		return this.userVerificationService.deleteByPrimaryKey(userVerification.getUvId());
	}

	/**
	 * 修改单个用户权限信息
	 * 
	 * @param userVerification
	 * @return
	 */
	@RequestMapping(value = "/updateByUserVerificationPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody Integer updateByPrimaryKeySelective(@RequestBody UserVerificationDTO userVerification) {
		return this.userVerificationService.updateByPrimaryKeySelective(userVerification);
	}

	/**
	 * 添加单个用户权限信息
	 * 
	 * @param userVerification
	 * @return
	 */
	@RequestMapping(value = "/insertUserVerification.do", method = { RequestMethod.POST })
	public @ResponseBody Integer insertSelective(@RequestBody UserVerificationDTO userVerification) {
		return this.userVerificationService.insertSelective(userVerification);
	}

	/**
	 * 查找全部用户权限信息
	 */
	// @CrossOrigin(origins = "/*", maxAge = 3600)
	@RequestMapping(value = "/findAllUserVerifications.do", method = { RequestMethod.GET })
	public @ResponseBody List<UserVerificationDTO> findAll() {
		return this.userVerificationService.findAll();
	}

	@RequestMapping(value = "/login.do", method = { RequestMethod.OPTIONS })
	public void test() {return;}

	@RequestMapping(value = "/login", method = { RequestMethod.GET })
	public String  test2() {return "123";}

	/**
	 * 登录
	 */
	//@CrossOrigin(origins = "/*", maxAge = 3600)
	@RequestMapping(value = "/loginUser.do", method = { RequestMethod.POST })
	public @ResponseBody ResponseData login(@RequestBody UserVerificationDTO userVerification) {
		//UserVerification userVerification = new UserVerification(loginType, loginToken, passwordToken);
		userVerification.setPasswordToken(MD5Encryption.createPassword(userVerification.getPasswordToken()));
		userVerification = this.userVerificationService.login(userVerification);


		ResponseData responseData = ResponseData.ok();
		if (userVerification != null) {
			// 生成token
			String token = JWTUtil.generToken("1", "Jersey-Security-Basic", userVerification.getLoginToken());
			// 向浏览器返回token，客户端受到此token后存入cookie中，或者h5的本地存储中
			responseData.putDataValue("token", token);

			// 以及用户信息
			UserDTO user = this.userService.selectByPrimaryKey(userVerification.getuId());
			responseData.putDataValue("user", user);

			// 师生信息
			PersonDTO person = this.personService.selectByuId(userVerification.getuId());
			responseData.putDataValue("person", person);

			// 角色信息
			List<RoleDTO> role = this.roleService.selectRoleListByUser(user.getuId());
			responseData.putDataValue("role", role);

			// 以及用户账号密码信息
			responseData.putDataValue("userVerification", userVerification);
		} else {
			// 用户或者密码错误
			responseData = ResponseData.customerError();
		}
		return responseData;
	}

	/**
	 * 修改密码
	 */
	@RequestMapping(value = "/updatePassword.do", method = { RequestMethod.POST })
	public @ResponseBody Integer updatePassword(@RequestBody UserVerificationDTO userVerification) {
		// 根据uId修改用户的密码
		userVerification.setPasswordToken(MD5Encryption.createPassword(userVerification.getPasswordToken()));
		Integer result = this.userVerificationService.updatePassword(userVerification);
		return result;

	}

	/**
	 * 重置密码
	 */
	@RequestMapping(value = "/resetPassword.do", method = { RequestMethod.POST })
	public @ResponseBody Integer passwordReset(@RequestBody UserVerificationDTO userVerification) {
		userVerification.setPasswordToken(MD5Encryption.createPassword("123456"));
		Integer result = this.userVerificationService.updateByPrimaryKeySelective(userVerification);
		return result;

	}

}