package com.pcs.controller;

import com.pcs.pojo.*;
import com.pcs.service.*;
import com.pcs.utils.ResponseData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
public class SendSignInController {
    @Resource
    ISendSignInService sendSignInService;
    @Resource
    ICourseService courseService;
    @Resource
    ISignInService signInService;
    @Resource
    IPersonCourseService personCourseService;
    @Resource
    IPersonService personService;

    /**
     * 获取单个签到信息
     *
     * @param sendSignInDTO
     * @return
     */
    @RequestMapping(value = "/selectBySendSignInPrimaryKey.do", method = { RequestMethod.POST })
    public @ResponseBody ResponseData selectByPrimaryKey(@RequestBody SendSignInDTO sendSignInDTO){
        ResponseData responseData = ResponseData.ok();
        SendSignInDTO sendSignInDTO1 = this.sendSignInService.selectByPrimaryKey(sendSignInDTO.getSsId());
        if(sendSignInDTO1 != null)
            responseData.putDataValue("sendSignIn",sendSignInDTO1);
        else
            responseData = ResponseData.customerError();

        return responseData;
    }

    /**
     * 删除单个签到信息
     *
     * @param sendSignInDTO
     * @return
     */
    @RequestMapping(value = "/deleteBySendSignInPrimaryKey.do", method = { RequestMethod.POST })
    public @ResponseBody ResponseData deleteByPrimaryKey(@RequestBody SendSignInDTO sendSignInDTO){
        ResponseData responseData = ResponseData.ok();
        int res = this.sendSignInService.deleteByPrimaryKey(sendSignInDTO.getSsId());
        if(res == 0)
            responseData = ResponseData.deleteError();
        return responseData;
    }

    /**
     * 修改单个签到信息
     *
     * @param sendSignInDTO
     * @return
     */
    @RequestMapping(value = "/updateBySendSignInPrimaryKey.do", method = { RequestMethod.POST })
    public @ResponseBody ResponseData updateByPrimaryKey(@RequestBody SendSignInDTO sendSignInDTO){
        ResponseData responseData = ResponseData.ok();
        int res = this.sendSignInService.updateByPrimaryKeySelective(sendSignInDTO);
        if(res == 0)
            responseData = ResponseData.customerError();
        return responseData;
    }

    /**
     * 修改学生签到信息
     *
     * @param signInDTO
     * @return
     */
    @RequestMapping(value = "/updateStudentSignIn.do", method = { RequestMethod.POST })
    public @ResponseBody ResponseData updateStudentSignIn(@RequestBody SignInDTO signInDTO){
        ResponseData responseData = ResponseData.ok();
        SignInDTO signInDTO1 = this.signInService.selectByPrimaryKey(signInDTO.getSiId());
        signInDTO1.setState(1);
        int res = this.signInService.updateByPrimaryKeySelective(signInDTO1);

        if(res == 0)
            responseData = ResponseData.customerError();

        return responseData;
    }


    /**
     * 判断是否可以签到
     *
     * @param sendSignInDTO
     * @return
     */
    @RequestMapping(value = "/JudgeSignIn.do", method = { RequestMethod.POST })
    public @ResponseBody ResponseData judgeSelective(@RequestBody SendSignInDTO sendSignInDTO){
        ResponseData responseData = ResponseData.ok();
        sendSignInDTO.setcId(this.courseService.selectBycNumber(sendSignInDTO.getcNumber()).getcId());
        SendSignInDTO sendSignInDTO1 = this.sendSignInService.remindOneButtonSignIn(sendSignInDTO);
        SendSignInDTO sendSignInDTO2 = this.sendSignInService.remindLimitTimeSignIn(sendSignInDTO);
        int flag = 0;
        if(sendSignInDTO2 != null) {
            Date or_time = sendSignInDTO2.getDate();
            Date limit_time = new Date(or_time.getTime() + sendSignInDTO2.getLimitime() * 60 * 1000);
            Date now_time = new Date();
            if(now_time.after(limit_time)){
                flag=1;
                sendSignInDTO2.setEndDate(limit_time);
            }
            else{
                long remin = (limit_time.getTime() - now_time.getTime()) / 1000;
                sendSignInDTO2.setReminTime(remin);
            }
        }
        if(sendSignInDTO1 == null && (flag == 1 || sendSignInDTO2 == null)){ //以前发起的签到都已结束
            //更新显示签到信息
            if(sendSignInDTO2 != null) {
                sendSignInDTO2.setState(0);
                this.sendSignInService.updateByPrimaryKeySelective(sendSignInDTO2);
            }
//          //完善签到内容
//          sendSignInDTO.setState(1);

        }
        else{
            responseData = new ResponseData(1010,"还有签到未结束");
            if(sendSignInDTO1 != null)
                responseData.putDataValue("OneButton",sendSignInDTO1);
            if(flag == 0 && sendSignInDTO2 != null)
                responseData.putDataValue("LimitTime",sendSignInDTO2);
        }
        return responseData;
    }

    /**
     * 发起签到
     *
     * @param sendSignInDTO
     * @return
     */
    @RequestMapping(value = "/SendSign.do", method = { RequestMethod.POST })
    public @ResponseBody ResponseData insertSelective(@RequestBody SendSignInDTO sendSignInDTO){
        ResponseData responseData = ResponseData.ok();

        //完善签到信息
        sendSignInDTO.setState(1);
        Date date = new Date();
        sendSignInDTO.setDate(date);
        CourseDTO course = this.courseService.selectBycNumber(sendSignInDTO.getcNumber());
        sendSignInDTO.setcId(course.getcId());
        sendSignInDTO.setcName(course.getcName());

        int res = this.sendSignInService.insertSelective(sendSignInDTO);
        if(res == 1) {
            List<SendSignInDTO> sendSignInDTOList = this.sendSignInService.findAll();
            sendSignInDTO = sendSignInDTOList.get(0);
            responseData.putDataValue("sendSignIn", sendSignInDTO);
        }

        return responseData;
    }

    /**
     * 停止签到
     *
     * @param sendSignInDTO
     * @return
     */
    @RequestMapping(value = "/StopSignIn.do", method = { RequestMethod.POST })
    public @ResponseBody ResponseData stopSignIn(@RequestBody SendSignInDTO sendSignInDTO){
        ResponseData responseData = ResponseData.ok();

        SendSignInDTO sendSignInDTO1 = this.sendSignInService.selectByPrimaryKey(sendSignInDTO.getSsId());

        if(sendSignInDTO1 != null){
            sendSignInDTO1.setState(0);
            Date now_time = new Date();
            sendSignInDTO1.setEndDate(now_time);
            this.sendSignInService.updateByPrimaryKeySelective(sendSignInDTO1);
        }
        return responseData;
    }

    /**
     * 查找在这门课程发起的全部签到
     */
    @RequestMapping(value = "/selectSendSignInMessageBycNumerAndpeId.do", method = { RequestMethod.POST })
    public @ResponseBody ResponseData selectSignInMessageBycId(@RequestBody SendSignInDTO sendSignInDTO) throws ParseException {
        ResponseData responseData = ResponseData.ok();
        CourseDTO courseDTO = this.courseService.selectBycNumber(sendSignInDTO.getcNumber());
        sendSignInDTO.setcId(courseDTO.getcId());
        List<SendSignInDTO> sendSignInDTOList = this.sendSignInService.selectBycId(sendSignInDTO);
        if(sendSignInDTOList.size() > 0){
            int course_stu = this.personCourseService.selectStudentsBycId(courseDTO.getcId()).size();
            for(int i=0;i<sendSignInDTOList.size();i++){
                SendSignInDTO sendSignInDTO1 = sendSignInDTOList.get(i);
                sendSignInDTO1.setStudentCount(course_stu);
                int sign_stu = this.signInService.selectByssId(sendSignInDTO1.getSsId()).size();
                sendSignInDTO1.setSignedCount(sign_stu);
                SimpleDateFormat ft = new SimpleDateFormat ("HH:mm");
                sendSignInDTO1.setStartTime(ft.format(sendSignInDTO1.getDate()));
                if(sendSignInDTO1.getEndDate() != null)
                    sendSignInDTO1.setEndTime(ft.format(sendSignInDTO1.getEndDate()));
                else{
                    if(sendSignInDTO1.getType() == 2){
                        Date or_time = sendSignInDTO1.getDate();
                        Date limit_time = new Date(or_time.getTime() + sendSignInDTO1.getLimitime() * 60 * 1000);
                        Date now_time = new Date();
                        if(now_time.after(limit_time)){
                            sendSignInDTO1.setEndTime(ft.format(limit_time));
                            sendSignInDTO1.setEndDate(limit_time);
                            sendSignInDTO1.setState(0);
                            this.sendSignInService.updateByPrimaryKeySelective(sendSignInDTO1);
                        }
                        else
                            sendSignInDTO1.setEndTime("-1");
                    }
                    else
                        sendSignInDTO1.setEndTime("-1");
                }
            }
            responseData.putDataValue("sendSignInDTOList",sendSignInDTOList);
        }
        else
            responseData = new ResponseData(1011,"没有发起签到");
        return responseData;
    }

    /**
     * 查看某次的签到情况
     *
     * @param sendSignInDTO
     * @return
     */
    @RequestMapping(value = "/selectSignInInformByssId.do", method = { RequestMethod.POST })
    public @ResponseBody ResponseData SignInInform(@RequestBody SendSignInDTO sendSignInDTO){
        ResponseData responseData = ResponseData.ok();
        sendSignInDTO = this.sendSignInService.selectByPrimaryKey(sendSignInDTO.getSsId());
        CourseDTO courseDTO = this.courseService.selectBycNumber(sendSignInDTO.getcNumber());
        sendSignInDTO.setcId(courseDTO.getcId());
//        List<SignInDTO> signInDTOList = this.signInService.selectByssId(sendSignInDTO.getSsId());
//        List<Integer> signedStuList = new LinkedList<Integer>();
//        for(int i=0;i<signInDTOList.size();i++){
//            SignInDTO signInDTO = signInDTOList.get(i);
//            signedStuList.add(signInDTO.getPeId());
//        }
        List<PersonCourse> personCourseList = this.personCourseService.selectStudentsBycId(courseDTO.getcId());
        List<PersonDTO> signedList = new LinkedList<PersonDTO>();
        List<PersonDTO> NotSignList = new LinkedList<PersonDTO>();
        for(int i=0;i<personCourseList.size();i++){
            PersonCourse personCourse = personCourseList.get(i);
            PersonDTO personDTO = this.personService.selectByPrimaryKey(personCourse.getPeId());
            SignInDTO signInDTO = new SignInDTO();
            signInDTO.setSsId(sendSignInDTO.getSsId());
            signInDTO.setPeId(personCourse.getPeId());
            SignInDTO signInDTO1 = this.signInService.JudgeSignedByssId(signInDTO);
            if(signInDTO1 != null){
                signedList.add(personDTO);
            }
            else{
                NotSignList.add(personDTO);
            }
        }
        responseData.putDataValue("sendSignIn",sendSignInDTO);
        responseData.putDataValue("signedList",signedList);
        responseData.putDataValue("NotSignList",NotSignList);
        return responseData;
    }

}
