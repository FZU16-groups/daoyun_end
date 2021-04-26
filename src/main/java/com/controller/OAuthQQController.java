package com.pcs.controller;

import com.pcs.dto.AuthqqDTO;
import com.pcs.pojo.Person;
import com.pcs.pojo.User;
import com.pcs.service.IOauthQQService;
import com.pcs.service.IPersonService;
import com.pcs.service.IUserService;
import com.pcs.utils.ResponseData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Controller
public class OAuthQQController {
    @Resource
    private IUserService userService;
    @Resource
    private IPersonService personService;
    @Resource
    private IOauthQQService oauthQQService;

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
            // 用户信息
            User user = this.userService.selectByPrimaryKey(authqqDTO.getUserId());
            responseData.putDataValue("user", user);

            // 师生信息
            Person person = this.personService.selectByuId(authqqDTO.getUserId());
            responseData.putDataValue("person", person);
        } else { //返回的结果为空，为该用户注册各类数据
            //生成一个随机码
            String Code = String.valueOf(new Random().nextInt(899999) + 100000);
            String userNumber = openId;
            String userName = "QQ用户_" + Code;
            Date createDate = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            User new_user = new User(userNumber, userName, createDate, 1);
            Integer result = this.userService.insertSelective(new_user);
            t_authqqDTO.setState(1);
            Integer auth_result = this.oauthQQService.insertSelective(t_authqqDTO);
            if (result == 1 && auth_result == 1) {
                // 获取注册的用户
                User user1 = this.userService.selectByuNumber(userNumber);
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

                //更新第三方登录表
                AuthqqDTO authqqDTO1 = this.oauthQQService.selectByOpenId(openId);
                authqqDTO1.setUserId(user1.getuId());
                System.out.println("userid"+authqqDTO1.getUserId());
                if(oauthQQService.updateByPrimaryKeySelective(authqqDTO1) == 1){
                    // 用户信息
                    responseData.putDataValue("user", user1);
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
