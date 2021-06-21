package com.pcs.controller;

import com.pcs.dto.LoginDTO;
import com.pcs.pojo.*;
import com.pcs.service.*;
import com.pcs.utils.JWTUtil;
import com.pcs.utils.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@RestController
public class MessageController{
    @Resource
    private IUserVerificationService userVerificationService;
    @Resource
    private IUserService userService;
    @Resource
    private IPersonService personService;
    @Resource
    private IMessageService messageService;
    @Resource
    private IRoleService roleService;

//    private HashMap<String,String> captchaList = new HashMap<String, String>();

    private static final Logger LOG = LoggerFactory.getLogger(MessageController.class);

    @RequestMapping(value = "/sendMessage.do", method = { RequestMethod.POST })
    public @ResponseBody ResponseData sendMessage(@RequestBody String loginToken, HttpServletRequest req) {
        ServletContext application=req.getServletContext();
        String checkCode = String.valueOf(new Random().nextInt(899999) + 100000);

        ResponseData responseData = ResponseData.ok();
        if (loginToken != null) {
            try {
                LOG.info("======sendMessage======telephone：{}, checkCode:{}", loginToken, checkCode);
                messageService.sendMessage(loginToken, checkCode);
                if (application.getAttribute(loginToken) != null ){
                    application.removeAttribute(loginToken);
                }
                application.setAttribute(loginToken,checkCode);
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



    @RequestMapping(value = "/loginByMessage.do", method = { RequestMethod.POST })
    public @ResponseBody ResponseData loginByMessage(@RequestBody LoginDTO loginDTO,HttpServletRequest req){
        UserVerificationDTO userVerification = this.userVerificationService.loginByMessage(loginDTO.getLoginToken());
        ServletContext application=req.getServletContext();
        ResponseData responseData = ResponseData.ok();

        System.out.println("tel"+loginDTO.getLoginToken());
        System.out.println("code"+loginDTO.getCaptcha());

        if (userVerification != null && application.getAttribute(loginDTO.getLoginToken()).equals(loginDTO.getCaptcha())) {
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

    @RequestMapping(value = "/updatePasswordByMessage.do", method = { RequestMethod.POST })
    public @ResponseBody ResponseData getPasswordByMessage(@RequestBody LoginDTO loginDTO,HttpServletRequest req){
        ServletContext application=req.getServletContext();

        UserVerificationDTO userVerification = this.userVerificationService.loginByMessage(loginDTO.getLoginToken());
        ResponseData responseData = ResponseData.ok();

        if (userVerification != null && application.getAttribute(loginDTO.getLoginToken()).equals(loginDTO.getCaptcha())) {
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

            // 以及用户账号密码信息
            responseData.putDataValue("userVerification", userVerification);
        } else {
            // 用户或者密码错误
            responseData = ResponseData.customerError();
        }
        return responseData;
    }
}
