package com.pcs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import com.pcs.dto.LoginDTO;
import com.pcs.dto.PageDTO;
import com.pcs.service.IMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pcs.pojo.Person;
import com.pcs.pojo.User;
import com.pcs.pojo.UserVerification;
import com.pcs.service.IPersonService;
import com.pcs.service.IUserService;
import com.pcs.service.IUserVerificationService;
import com.pcs.utils.JWTUtil;
import com.pcs.utils.MD5Encryption;
import com.pcs.utils.ResponseData;

@Controller
public class UserController {
	@Resource
	private IUserService userService;
	@Resource
	private IUserVerificationService userVerificationService;
	@Resource
	private IPersonService personService;
	@Resource
	private IMessageService messageService;

	private HashMap<String,String> captchaList = new HashMap<String, String>();
	private static final Logger LOG = LoggerFactory.getLogger(MessageController.class);

	/**
	 * 获取单个用戶信息
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/selectByUserPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody User selectByPrimaryKey(@RequestBody User user) {
		return this.userService.selectByPrimaryKey(user.getuId());
	}

	/**
	 * 删除单个用戶信息
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/deleteByUserPrimaryKey.do", method = { RequestMethod.POST })
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
	@RequestMapping(value = "/updateByUserPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody Integer updateByPrimaryKeySelective(@RequestBody User user) {
		// 如果修改的是用户名，手机号，邮箱，则修改对应的密码表
		if (user.getuName() != null && user.getuName().length() >= 0) {
			UserVerification uv = new UserVerification();
			uv.setuId(user.getuId());
			uv.setLoginType(1);
			uv.setLoginToken(user.getuName());
			this.userVerificationService.updateByuId(uv);
		}
		if (user.getPhone() != null && user.getPhone().length() >= 0) {
			UserVerification uv = new UserVerification();
			uv.setuId(user.getuId());
			uv.setLoginType(2);
			uv.setLoginToken(user.getPhone());
			this.userVerificationService.updateByuId(uv);
		}
		if (user.getEmaile() != null && user.getPhone().length() >= 0) {
			UserVerification uv = new UserVerification();
			uv.setuId(user.getuId());
			uv.setLoginType(3);
			uv.setLoginToken(user.getEmaile());
			this.userVerificationService.updateByuId(uv);
		}
		return this.userService.updateByPrimaryKeySelective(user);
	}

	/**
	 * 添加单个用戶信息
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/insertUser.do", method = { RequestMethod.POST })
	public @ResponseBody User insertSelective(@RequestBody User user) {
		// 添加注册用户信息
		Integer result = this.userService.insertSelective(user);
		if (result == 1) {
			// 获取注册的用户
			User user1 = this.userService.selectByuNumber(user.getuNumber());
			// 根据uId向person表插入一条记录
			Person person = new Person();
			person.setClasses(-1);
			person.setGender(-1);
			person.setGrade("unknow");
			person.setIsTeacher(-1);
			person.setMajor("unknow");
			person.setPeName("unknow");
			person.setPeNumber("unknow");
			person.setsId(null);
			person.setuId(user1.getuId());
			Integer pe_res = this.personService.insertSelective(person);
			Person person1 = new Person();
			person1 = this.personService.selectByuId(user1.getuId());
			user1.setPeId(person1.getPeId());

			// 根据注册用户的用户名,手机号和邮箱注册登录表
			// 1 - 用户名登录，2-手机号登录，3-邮箱登录
			UserVerification uv1 = new UserVerification(user1.getuId(), 1, user1.getuName(),
					MD5Encryption.createPassword("123456"), 1);
			UserVerification uv2 = new UserVerification(user1.getuId(), 2, user1.getPhone(),
					MD5Encryption.createPassword("123456"), 1);
			UserVerification uv3 = new UserVerification(user1.getuId(), 3, user1.getEmaile(),
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
	@RequestMapping(value = "/findAllUsers.do", method = { RequestMethod.POST })
	public @ResponseBody ResponseData findAll(@RequestBody PageDTO pageDTO) {
		ResponseData responseData = ResponseData.ok();
		int total =  this.userService.countUser();
		responseData.putDataValue("total", total);
		List<User> data =  this.userService.findAll(pageDTO);
		responseData.putDataValue("data", data);
		return responseData;
	}

	/**
	 * 用户注册
	 */
	@RequestMapping("/registerUser.do")
	public @ResponseBody ResponseData register(@RequestBody User user) {
		// 添加注册用户信息
		Integer result = this.userService.insertSelective(user);
		ResponseData responseData = ResponseData.ok();
		if (result == 1) {
			// 获取注册的用户
			User user1 = this.userService.selectByuNumber(user.getuNumber());
			// 根据uId向person表插入一条记录
			Person person = new Person();
			person.setClasses(-1);
			person.setGender(-1);
			person.setGrade("unknow");
			person.setIsTeacher(-1);
			person.setMajor("unknow");
			person.setPeName("unknow");
			person.setPeNumber("unknow");
			person.setsId(null);
			person.setuId(user1.getuId());
			Integer pe_res = this.personService.insertSelective(person);
			Person person1 = new Person();
			person1 = this.personService.selectByuId(user1.getuId());
			user1.setPeId(person1.getPeId());

			// 根据注册用户的用户名,手机号和邮箱注册登录表
			// 1 - 用户名登录，2-手机号登录，3-邮箱登录
			UserVerification uv1 = new UserVerification(user1.getuId(), 1, user1.getuName(),
					MD5Encryption.createPassword("123456"), 1);
			UserVerification uv2 = new UserVerification(user1.getuId(), 2, user1.getPhone(),
					MD5Encryption.createPassword("123456"), 1);
			UserVerification uv3 = new UserVerification(user1.getuId(), 3, user1.getEmaile(),
					MD5Encryption.createPassword("123456"), 1);
			int uv1_res = this.userVerificationService.insertSelective(uv1);
			int uv2_res = this.userVerificationService.insertSelective(uv2);
			int uv3_res = this.userVerificationService.insertSelective(uv3);
			if (uv1_res == 1 && uv2_res == 1 && uv3_res == 1 && pe_res == 1) {
				// 生成token
				String token = JWTUtil.generToken("1", "Jersey-Security-Basic", uv1.getLoginToken());
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

	/**
	 * 快速注册
	 */
	@RequestMapping(value = "/fastRegisterSendMessage.do", method = { RequestMethod.POST })
	public @ResponseBody ResponseData sendMessage(@RequestBody String loginToken) {
		String checkCode = String.valueOf(new Random().nextInt(899999) + 100000);
		ResponseData responseData = ResponseData.ok();
		if (loginToken != null) {

			try {
				LOG.info("======sendMessage======telephone：{}, checkCode:{}", loginToken, checkCode);
				messageService.sendMessage(loginToken, checkCode);
				if (captchaList.get(loginToken) != null ){
					captchaList.remove(loginToken);
				}
				captchaList.put(loginToken,checkCode);
				System.out.println(loginToken);
				System.out.println(checkCode);
				responseData.putDataValue("captcha",checkCode ); //验证码获取成功
			} catch (Exception e) {
				//输出日志
				LOG.info("======sendMessage======手机号错误，请输入真实手机号");
				e.printStackTrace();
				responseData = ResponseData.customerError(); //手机号无效错误
			}
		}
		else
			responseData.putDataValue("noPhone",1); //改手机号没有注册过，不可直接登录
		return responseData;
	}
	@RequestMapping("/registerFastUser.do")
	public @ResponseBody ResponseData registerEasy(@RequestBody LoginDTO loginDTO) {

		System.out.println("tel"+loginDTO.getLoginToken());
		System.out.println("code"+loginDTO.getCaptcha());

		ResponseData responseData = ResponseData.ok();
		//判断手机号是否已经被注册
		User t_user = this.userService.selectByPhone(loginDTO.getLoginToken());
		//System.out.println(t_user.getPhone());
		System.out.println(loginDTO.getLoginToken());
		if(t_user != null){
			System.out.println("手机号已被注册");
			responseData = new ResponseData(1002,"手机号已被注册");
		}
		else{
			User user = new User(loginDTO.getLoginToken());
			System.out.println(captchaList.get(loginDTO.getLoginToken()));
			if(captchaList.get(loginDTO.getLoginToken()).equals(loginDTO.getCaptcha())) {
				// 添加注册用户信息
				Integer result = this.userService.insertSelective(user);
				if (result == 1) {
					// 获取注册的用户
					System.out.println(user.getPhone());
					User user1 = this.userService.selectByPhone(user.getPhone());
					System.out.println(user1.getuId());
					// 根据uId向person表插入一条记录
					Person person = new Person();
					person.setClasses(-1);
					person.setGender(-1);
					person.setGrade("unknow");
					person.setIsTeacher(-1);
					person.setMajor("unknow");
					person.setPeName("unknow");
					person.setPeNumber("unknow");
					person.setsId(null);
					person.setuId(user1.getuId());
					Integer pe_res = this.personService.insertSelective(person);
					Person person1 = new Person();
					person1 = this.personService.selectByuId(user1.getuId());
					user1.setPeId(person1.getPeId());

					// 根据注册用户的手机号注册登录表
					//2-手机号登录
					UserVerification uv2 = new UserVerification(user1.getuId(), 2, user1.getPhone(),
							MD5Encryption.createPassword("123456"), 1);
					int uv2_res = this.userVerificationService.insertSelective(uv2);
					if (uv2_res == 1 && pe_res == 1) {
						// 用户信息
						responseData.putDataValue("user", user1);

					} else {
						// 用户或者密码错误
						responseData = ResponseData.customerError();
					}
					return responseData;

				} else {
					responseData = ResponseData.customerError();
				}
			}
			else
				responseData = ResponseData.customerError();
		}
		return responseData;
	}
}