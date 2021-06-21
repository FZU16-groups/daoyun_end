package com.pcs.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.pcs.dto.PageDTO;
import com.pcs.pojo.CourseDTO;
import com.pcs.pojo.PersonDTO;
import com.pcs.pojo.SendSignInDTO;
import com.pcs.service.ICourseService;
import com.pcs.service.IPersonService;
import com.pcs.service.ISendSignInService;
import com.pcs.utils.ResponseData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pcs.pojo.SignInDTO;
import com.pcs.service.ISignInService;

@Controller
public class SignInController {
	@Resource
	private ISignInService signInService;
	@Resource
	private ISendSignInService sendSignInService;
	@Resource
	private ICourseService courseService;
	@Resource
	private IPersonService personService;

	/**
	 * 获取单个签到信息
	 * 
	 * @param signIn
	 * @return
	 */
	@RequestMapping(value = "/selectBySignInPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody ResponseData selectByPrimaryKey(@RequestBody SignInDTO signIn) {
		ResponseData responseData = ResponseData.ok();
		SignInDTO signInDTO = this.signInService.selectByPrimaryKey(signIn.getSiId());
		if(signInDTO != null)
			responseData.putDataValue("signIn",signInDTO);
		else
			responseData = ResponseData.customerError();
		return responseData;
	}

	/**
	 * 删除单个签到信息
	 * 
	 * @param signIn
	 * @return
	 */
	@RequestMapping(value = "/deleteBySignInPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody Integer deleteByPrimaryKey(@RequestBody SignInDTO signIn) {
		return this.signInService.deleteByPrimaryKey(signIn.getSiId());
	}

	/**
	 * 修改单个签到信息
	 * 
	 * @param signIn
	 * @return
	 */
	@RequestMapping(value = "/updateBySignInPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody ResponseData updateByPrimaryKeySelective(@RequestBody SignInDTO signIn) {
		ResponseData responseData = ResponseData.ok();

		int res = this.signInService.updateByPrimaryKeySelective(signIn);
		if(res == 0)
			responseData = ResponseData.customerError();

		return responseData;
	}

	/**
	 * 根据课程号判断当前是否有签到任务
	 *
	 * @param signIn
	 * @return
	 */
	@RequestMapping(value = "/JudgeSignInByCourseNumber.do", method = { RequestMethod.POST })
	public @ResponseBody ResponseData JudgeSignInByCourseNumber(@RequestBody SignInDTO signIn) {
		ResponseData responseData = ResponseData.ok();

		CourseDTO course = this.courseService.selectBycNumber(signIn.getcNumber());
		SendSignInDTO sendSignInDTO = this.sendSignInService.JudgeSignInBycId(course.getcId());
		int flag=1;
		if(sendSignInDTO.getType() == 2){
			Date or_time = sendSignInDTO.getDate();
			Date limit_time = new Date(or_time.getTime() + sendSignInDTO.getLimitime() * 60 * 1000);
			Date now_time = new Date();
			if(now_time.after(limit_time)){
				flag=0;
				responseData = new ResponseData(1104,"签到已结束");;
			}
		}
		if(sendSignInDTO != null && flag == 1)
			responseData.putDataValue("sendSignIn",sendSignInDTO);
		else if(flag == 1)
			responseData = new ResponseData(1103,"老师没有开始签到");

		return responseData;
	}

	/**
	 * 添加单个签到信息
	 * 
	 * @param signIn
	 * @return
	 */
	@RequestMapping(value = "/insertSignInMessage.do", method = { RequestMethod.POST })
	public @ResponseBody ResponseData insertSelective(@RequestBody SignInDTO signIn) {
		ResponseData responseData = ResponseData.ok();
		//提取整个签到信息
		SendSignInDTO sendSignInDTO = this.sendSignInService.selectByPrimaryKey(signIn.getSsId());

		//判断当前位置是否在范围内
		int res1=1;
		final double EARTH_RADIUS = 6378.137;
		//两点之间的差值
		double jdDistance = sendSignInDTO.getPosition_x() - signIn.getPosition_x();
		double wdDistance = sendSignInDTO.getPosition_y() - signIn.getPosition_y();
		double distance = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(jdDistance / 2), 2) +
				Math.cos(sendSignInDTO.getPosition_x()) * Math.cos(signIn.getPosition_x()) * Math.pow(Math.sin(wdDistance / 2), 2)));
		distance = distance * EARTH_RADIUS;
		distance = Math.round(distance * 10000d) / 10000d;
		distance = distance*1000;//将计算出来的距离千米转为米
		//判断一个点是否在圆形区域内
		if (distance > sendSignInDTO.getLimitdis()) { //超过范围
			res1=0;
			responseData = new ResponseData(1100,"不在签到范围内");
		}


		//如果是限时签到，判断是否在签到有效时间内
		int res2=1;
		Date now_time = new Date();
		if(sendSignInDTO.getType() == 2) {
			Date or_time = sendSignInDTO.getDate();
			Date limit_time = new Date(or_time.getTime() + sendSignInDTO.getLimitime() * 60 * 1000);
			if (now_time.after(limit_time)) { //超时
				res2 = 0;
				responseData = new ResponseData(1101, "签到已结束");
			}
		}
		signIn.setDate(now_time);

		if(res1==1 && res2 ==1){
			//完善签到信息
			CourseDTO courseDTO = this.courseService.selectBycNumber(signIn.getcNumber());
			signIn.setcId(courseDTO.getcId());
			signIn.setcName(courseDTO.getcName());
			PersonDTO personDTO = this.personService.selectByPrimaryKey(signIn.getPeId());
			signIn.setPeName(personDTO.getPeName());
			signIn.setPeNumber(personDTO.getPeNumber());
			System.out.println(sendSignInDTO.getValue());
			signIn.setValue(sendSignInDTO.getValue());
			//signIn.setState(1);
			signIn.setType(sendSignInDTO.getType());

			int res = this.signInService.insertSelective(signIn);
			if(res == 1){
				List<SignInDTO> signInDTOList = this.signInService.findAll();
				signIn = signInDTOList.get(0);
			}
			responseData.putDataValue("signIn",signIn);
		}
		return responseData;
	}

	/**
	 * 查找在这门课程的全部签到信息
	 */
	@RequestMapping(value = "/selectSignInMessageBycId.do", method = { RequestMethod.POST })
	public @ResponseBody ResponseData selectSignInMessageBycId(@RequestBody SignInDTO signIn) {
		ResponseData responseData = ResponseData.ok();
		List<SignInDTO> signInDTOList = this.signInService.selectBycId(signIn);
		if(signInDTOList.size() > 0)
			responseData.putDataValue("signInDTOList",signInDTOList);
		else
			responseData = new ResponseData(1102,"没有签到信息");
		return responseData;
	}

	/**
	 * 查找全部签到信息
	 */
	@RequestMapping("/findAllSignInMessages.do")
	public @ResponseBody List<SignInDTO> findAll() {
		return this.signInService.findAll();
	}
}