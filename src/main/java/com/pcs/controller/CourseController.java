package com.pcs.controller;

import java.util.List;

import javax.annotation.Resource;

import com.pcs.dto.PageDTO;
import com.pcs.dto.PagePeIdDTO;
import com.pcs.service.ISendSignInService;
import com.pcs.service.ISignInService;
import com.pcs.utils.ResponseData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pcs.pojo.CourseDTO;
import com.pcs.pojo.PersonCourse;
import com.pcs.service.ICourseService;
import com.pcs.service.IPersonCourseService;

@Controller
public class CourseController {
	@Resource
	private ICourseService courseService;
	@Resource
	private IPersonCourseService personCourseService;
	@Resource
	private ISignInService signInService;
	@Resource
	private ISendSignInService sendSignInService;
	/**
	 * 获取单个课程信息
	 * 
	 * @param course
	 * @return
	 */
	@RequestMapping(value = "/selectByCoursePrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody ResponseData selectByPrimaryKey(@RequestBody CourseDTO course) {
		ResponseData responseData = ResponseData.ok();
		CourseDTO courseDTO = this.courseService.selectByPrimaryKey(course.getcId());
		if(courseDTO != null)
			responseData.putDataValue("course",courseDTO);
		else
			responseData = new ResponseData(1400,"没有这门课");
		return responseData;
	}

	/**
	 * 删除单个课程信息
	 * 
	 * @param course
	 * @return
	 */
	@RequestMapping(value = "/deleteByCoursePrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody Integer deleteByPrimaryKey(@RequestBody CourseDTO course) {
		int cId = course.getcId();
		this.signInService.deleteAllSignInByCId(cId);
		this.sendSignInService.deleteAllSendSignByCId(cId);
		// 删除cId删除personCourse
		this.personCourseService.deleteBycId(course.getcId());
		return this.courseService.deleteByPrimaryKey(course.getcId());
	}

	/**
	 * 修改单个课程信息
	 *
	 * @param course
	 * @return
	 */
	@RequestMapping(value = "/updateByCoursePrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody ResponseData updateByPrimaryKeySelective(@RequestBody CourseDTO course) {
		ResponseData responseData = ResponseData.ok();
		int res = this.courseService.updateByPrimaryKeySelective(course);
		if(res == 1){
            CourseDTO courseDTO = this.courseService.selectByPrimaryKey(course.getcId());
			responseData.putDataValue("course",courseDTO);
		}
		else
			responseData = ResponseData.customerError();
		return responseData;
	}

	/**
	 * 根据课程号修改课程信息
	 *
	 * @param course
	 * @return
	 */
	@RequestMapping(value = "/updateByCourseNumber.do", method = { RequestMethod.POST })
	public @ResponseBody ResponseData updateBycNumberSelective(@RequestBody CourseDTO course) {
		ResponseData responseData = ResponseData.ok();
		int res = this.courseService.updateBycNumberSelective(course);
		if(res == 1){
			course = this.courseService.selectBycNumber(course.getcNumber());
			responseData.putDataValue("course",course);
		}
		else
			responseData = ResponseData.customerError();
		return responseData;
	}

	/**
	 * 添加单个课程信息
	 * 
	 * @param course
	 * @return
	 */
	@RequestMapping(value = "/insertCourses.do", method = { RequestMethod.POST })
	public @ResponseBody CourseDTO insertSelective(@RequestBody CourseDTO course) {

		course.setState(1);
		if(course.getCan_join() == null)
			course.setCan_join(1);
		Integer res = this.courseService.insertSelective(course);
		if (res > 0) {
			CourseDTO course1 = this.courseService.selectBycNumber(course.getcNumber());
			Integer cId = course1.getcId();
			Integer peId = course.getPeId();
			String peName = course.getPeName();
			// 向personCourse插入一条记录
			PersonCourse pc = new PersonCourse();
			pc.setPeId(peId);
			pc.setcId(cId);
			pc.setcId(cId);
			pc.setPeName(peName);
			pc.setValue(0);
			pc.setStatus(1);
			Integer pc_res = this.personCourseService.insertSelective(pc);
			if (pc_res > 0) {
				return course1;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * 查找全部课程信息
	 */
	@RequestMapping(value = "/findAllCourses.do",method = { RequestMethod.POST })
	public @ResponseBody ResponseData findAll(@RequestBody PageDTO pageDTO) {
		ResponseData responseData = ResponseData.ok();
		int total =  this.courseService.countCourse();
		responseData.putDataValue("total", total);
		List<CourseDTO> data =  this.courseService.findAll(pageDTO);
		responseData.putDataValue("data", data);
		return responseData;
	}

	/**
	 * 查找全部课程信息
	 */
	@RequestMapping(value = "/findAllCoursesByPeId.do",method = { RequestMethod.POST })
	public @ResponseBody ResponseData findAll(@RequestBody PagePeIdDTO pagePeIdDTO) {
		ResponseData responseData = ResponseData.ok();
		int peId = pagePeIdDTO.getPeId();
		int total =  this.courseService.countCourseByPeId(peId);
		responseData.putDataValue("total", total);
		List<CourseDTO> data =  this.courseService.findAllByPeId(pagePeIdDTO);
		responseData.putDataValue("data", data);
		return responseData;
	}
}