package com.pcs.controller;

import com.pcs.dto.BindPhoneDTO;
import com.pcs.pojo.AuthqqDTO;
import com.pcs.pojo.PersonDTO;
import com.pcs.pojo.UserDTO;
import com.pcs.pojo.UserVerificationDTO;
import com.pcs.service.*;
import com.pcs.utils.MD5Encryption;
import com.pcs.utils.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

@Controller
public class OAuthQQController {
    @Resource
    private IUserService userService;
    @Resource
    private IUserVerificationService userVerificationService;
    @Resource
    private IPersonService personService;
    @Resource
    private IOauthQQService oauthQQService;
    @Resource
    private IMessageService messageService;


    private HashMap<String,String> captchaList = new HashMap<String, String>();
    private static final Logger LOG = LoggerFactory.getLogger(MessageController.class);

    @RequestMapping(value = "/sendTheAuthMessage.do", method = { RequestMethod.POST })
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

    /*
    * 绑定手机号
    */
    @RequestMapping(value = "/bindPhone.do",method = { RequestMethod.POST })
    public @ResponseBody ResponseData bindThePhone(@RequestBody BindPhoneDTO bindPhoneDTO) {

        System.out.println(bindPhoneDTO.getOpenId());
        System.out.println(bindPhoneDTO.getPhone());
        System.out.println(bindPhoneDTO.getCaptcha());

        System.out.println(captchaList.get(bindPhoneDTO.getPhone()));

        ResponseData responseData = ResponseData.ok();

        if(captchaList.get(bindPhoneDTO.getPhone()).equals(bindPhoneDTO.getCaptcha())){

            //通过phone判断其中在用户表中是否有相同手机号
            String phone = bindPhoneDTO.getPhone();
            UserDTO user = this.userService.selectByPhone(phone);

            //返回的结果不为空，表示该手机号已经注册过，更新第三方表的userid，删除user表中对应openid的用户信息
            if (user != null) {
                System.out.println("the phone is exist!");
                // 更新第三方登录表
                AuthqqDTO authqqDTO = this.oauthQQService.selectByOpenId(bindPhoneDTO.getOpenId());
                Integer old_userid = authqqDTO.getUserId();
                authqqDTO.setUserId(user.getuId());
                Integer res1 = this.oauthQQService.updateByPrimaryKeySelective(authqqDTO);
                if(res1 == 1){
                    //删除person表中对应userid的信息
                    Integer res2 = this.personService.deleteByuId(old_userid);
                    //删除user表中对应userid的用户信息
                    Integer res3 = this.userService.deleteByPrimaryKey(old_userid);
                    if(res2 != 1 || res3 != 1)
                        responseData = ResponseData.customerError();
                }
                else
                    responseData = ResponseData.customerError();
            } else { //返回的结果为空，直接在用户表中加入手机号信息
                AuthqqDTO authqqDTO = this.oauthQQService.selectByOpenId(bindPhoneDTO.getOpenId());
                UserDTO user1 = this.userService.selectByPrimaryKey(authqqDTO.getUserId());
                user1.setPhone(bindPhoneDTO.getPhone());
                Integer res1 = this.userService.updateByPrimaryKeySelective(user1);
                if(res1 == 1){
                    // 根据注册用户的手机号注册登录表
                    //2-手机号登录
                    UserVerificationDTO uv2 = new UserVerificationDTO(user1.getuId(), 2, user1.getPhone(),
                            MD5Encryption.createPassword("123456"), 1);
                    int uv2_res = this.userVerificationService.insertSelective(uv2);
                    if(uv2_res == 1){
                        // 用户信息
                        responseData.putDataValue("user", user1);
                        PersonDTO person = this.personService.selectByuId(user1.getuId());
                        responseData.putDataValue("person",person);
                    }
                    else
                        responseData = ResponseData.customerError();
                }
                else
                    responseData = ResponseData.customerError();
            }
        }
        else{
            responseData = new ResponseData(1003,"验证码错误");
        }

        return responseData;
    }

    /*
    * 第三方登录--QQ
    */
    @RequestMapping("/loginByQQ.do")
    public @ResponseBody ResponseData loginByQQ(@RequestBody AuthqqDTO t_authqqDTO) {

        System.out.println(t_authqqDTO.getOpenId());
        System.out.println(t_authqqDTO.getAccessToken());

        ResponseData responseData = ResponseData.ok();

        //通过openId判断其中在第三方登录表中是否有相同的用户
        String openId = t_authqqDTO.getOpenId();
        AuthqqDTO authqqDTO = oauthQQService.selectByOpenId(openId);

        //返回的结果不为空，表示该用户已经登录过，取出用户的信息返回
        if (authqqDTO != null) {
            System.out.println("not null!");
            UserDTO user = this.userService.selectByPrimaryKey(authqqDTO.getUserId());
            String phone = user.getPhone();
            if(phone == null)
                responseData = new ResponseData(1004,"绑定手机号");
            else{
                // 用户信息
                responseData.putDataValue("user", user);

                // 师生信息
                PersonDTO person = this.personService.selectByuId(authqqDTO.getUserId());
                responseData.putDataValue("person", person);
            }
        } else { //返回的结果为空，为该用户注册各类数据
            //生成一个随机码
            String Code = String.valueOf(new Random().nextInt(899999) + 100000);
            String userNumber = openId;
            String userName = "QQ用户_" + Code;
            Date createDate = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            UserDTO new_user = new UserDTO(userNumber, userName, createDate, 1);
            Integer result = this.userService.insertSelective(new_user);
            t_authqqDTO.setState(1);
            Integer auth_result = this.oauthQQService.insertSelective(t_authqqDTO);
            if (result == 1 && auth_result == 1) {
                // 获取注册的用户
                UserDTO user1 = this.userService.selectByuNumber(userNumber);
                // 根据uId向person表插入一条记录
                PersonDTO person = new PersonDTO();
                person.setClasses(-1);
                person.setGender(-1);
                person.setGrade("unknow");
                person.setIsStudent(-1);
                person.setMajor("unknow");
                person.setPeName("unknow");
                person.setPeNumber("unknow");
                person.setsId(null);
                person.setuId(user1.getuId());
                Integer pe_res = this.personService.insertSelective(person);
                PersonDTO person1 = new PersonDTO();
                person1 = this.personService.selectByuId(user1.getuId());
                user1.setPeId(person1.getPeId());

                //更新第三方登录表
                AuthqqDTO authqqDTO1 = this.oauthQQService.selectByOpenId(openId);
                authqqDTO1.setUserId(user1.getuId());
                System.out.println("userid"+authqqDTO1.getUserId());
                if(oauthQQService.updateByPrimaryKeySelective(authqqDTO1) == 1){
                    responseData = new ResponseData(1004,"绑定手机号");
                }
                else
                    responseData = ResponseData.customerError();
            }
            else{
                responseData = ResponseData.customerError();
            }
        }
        return responseData;
    }
}
