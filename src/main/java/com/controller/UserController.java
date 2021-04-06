package com.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.Person;
import com.pojo.User;
import com.pojo.UserVerification;
import com.service.IPersonService;
import com.service.IUserService;
import com.service.IUserVerificationService;
import com.utils.JWTUtil;
import com.utils.MD5Encryption;
import com.utils.ResponseData;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserService userService;
	@Resource
	private IUserVerificationService userVerificationService;
	@Resource
	private IPersonService personService;

	/**
	 * 获取单个用戶信息
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/selectByPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody User selectByPrimaryKey(@RequestBody User user) {
		return this.userService.selectByPrimaryKey(user.getId());
	}

	/**
	 * 删除单个用戶信息
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/deleteByPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody Integer deleteByPrimaryKey(@RequestBody User user) {
		// // 根据uId删除密码表对应的记录
		// this.userVerificationService.deleteByuId(user.getuId());
		// // 根据uId删除person
		// this.personService.deleteByuId(user.getuId());
		// status 置0
		user.setStatus(0);
		return this.userService.updateByPrimaryKeySelective(user);

	}

	/**
	 * 修改单个用戶信息
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/updateByPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody Integer updateByPrimaryKeySelective(@RequestBody User user) {
		// 如果修改的是用户名，手机号，邮箱，则修改对应的密码表
		if (user.getUsername() != null && user.getUsername().length() >= 0) {
			UserVerification uv = new UserVerification();
			uv.setId(user.getId());
			uv.setLogintype(1);
			uv.setLogintoken(user.getUsername());
			this.userVerificationService.updateByUserId(uv);
		}
		if (user.getUserphone() != null && user.getUserphone().length() >= 0) {
			UserVerification uv = new UserVerification();
			uv.setId(user.getId());
			uv.setLogintype(2);
			uv.setLogintoken(user.getUserphone());
			this.userVerificationService.updateByUserId(uv);
		}
		if (user.getUseremail() != null && user.getUserphone().length() >= 0) {
			UserVerification uv = new UserVerification();
			uv.setId(user.getId());
			uv.setLogintype(3);
			uv.setLogintoken(user.getUseremail());
			this.userVerificationService.updateByUserId(uv);
		}
		return this.userService.updateByPrimaryKeySelective(user);
	}

	/**
	 * 添加单个用戶信息
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/insert.do", method = { RequestMethod.POST })
	public @ResponseBody User insertSelective(@RequestBody User user) {
		// 添加注册用户信息
		Integer result = this.userService.insertSelective(user);
		if (result == 1) {
			// 获取注册的用户
			User user1 = this.userService.selectByUserNumber(user.getUsernumber());
			// 根据uId向person表插入一条记录
			Person person = new Person();
			person.setClasses(-1);
			person.setGender(-1);
			person.setGrade("unknow");
			person.setIsteacher(-1);
			person.setMajor("unknow");
			person.setPersonname("unknow");
			person.setPersonnumber("unknow");
			person.setSchoolid(null);
			person.setId(user1.getId());
			Integer pe_res = this.personService.insertSelective(person);
			Person person1 = new Person();
			person1 = this.personService.selectByuId(user1.getId());
			user1.setPersonId(person1.getId());

			// 根据注册用户的用户名,手机号和邮箱注册登录表
			// 1 - 用户名登录，2-手机号登录，3-邮箱登录
			UserVerification uv1 = new UserVerification(user1.getId(), 1, user1.getUsername(),
					MD5Encryption.createPassword("123456"), 1);
			UserVerification uv2 = new UserVerification(user1.getId(), 2, user1.getUserphone(),
					MD5Encryption.createPassword("123456"), 1);
			UserVerification uv3 = new UserVerification(user1.getId(), 3, user1.getUseremail(),
					MD5Encryption.createPassword("123456"), 1);
			int uv1_res = this.userVerificationService.insertSelective(uv1);
			int uv2_res = this.userVerificationService.insertSelective(uv2);
			int uv3_res = this.userVerificationService.insertSelective(uv3);
			if (uv1_res == 1 && uv2_res == 1 && uv3_res == 1 && pe_res == 1) {
				return user1;

			} else {
				return null;
			}

		} else {
			return null;
		}
	}

	/**
	 * 查找全部用戶信息
	 */
	@RequestMapping("/findAll.do")
	public @ResponseBody List<User> findAll() {
		return this.userService.findAll();
	}

	/**
	 * 用户注册
	 */
	@RequestMapping("/register.do")
	public @ResponseBody ResponseData register(@RequestBody User user) {
		// 添加注册用户信息
		Integer result = this.userService.insertSelective(user);
		ResponseData responseData = ResponseData.ok();
		if (result == 1) {
			// 获取注册的用户
			User user1 = this.userService.selectByUserNumber(user.getUsernumber());
			// 根据uId向person表插入一条记录
			Person person = new Person();
			person.setClasses(-1);
			person.setGender(-1);
			person.setGrade("unknow");
			person.setIsteacher(-1);
			person.setMajor("unknow");
			person.setPersonname("unknow");
			person.setPersonnumber("unknow");
			person.setSchoolid(null);
			person.setUserid(user1.getId());
			Integer pe_res = this.personService.insertSelective(person);
			Person person1 = new Person();
			person1 = this.personService.selectByuId(user1.getId());
			user1.setPersonId(person1.getId());

			// 根据注册用户的用户名,手机号和邮箱注册登录表
			// 1 - 用户名登录，2-手机号登录，3-邮箱登录
			UserVerification uv1 = new UserVerification(user1.getId(), 1, user1.getUsername(),
					MD5Encryption.createPassword("123456"), 1);
			UserVerification uv2 = new UserVerification(user1.getId(), 2, user1.getUserphone(),
					MD5Encryption.createPassword("123456"), 1);
			UserVerification uv3 = new UserVerification(user1.getId(), 3, user1.getUseremail(),
					MD5Encryption.createPassword("123456"), 1);
			int uv1_res = this.userVerificationService.insertSelective(uv1);
			int uv2_res = this.userVerificationService.insertSelective(uv2);
			int uv3_res = this.userVerificationService.insertSelective(uv3);
			if (uv1_res == 1 && uv2_res == 1 && uv3_res == 1 && pe_res == 1) {
				// 生成token
				String token = JWTUtil.generToken("1", "Jersey-Security-Basic", uv1.getLogintoken());
				// 向浏览器返回token，客户端受到此token后存入cookie中，或者h5的本地存储中
				responseData.putDataValue("token", token);
				// 用户信息
				responseData.putDataValue("user", user1);

			} else {
				// 用户或者密码错误
				responseData = ResponseData.customerError();
			}
			return responseData;

		} else {
			responseData = ResponseData.customerError();
			return responseData;
		}
	}

}