package com.pcs.controller;

import java.util.List;

import javax.annotation.Resource;

import com.pcs.pojo.CourseDTO;
import com.pcs.pojo.PersonDTO;
import com.pcs.pojo.UserDTO;
import com.pcs.service.ICourseService;
import com.pcs.service.IPersonService;
import com.pcs.utils.ResponseData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.pcs.pojo.PersonCourse;
import com.pcs.service.IPersonCourseService;

@Controller
public class PersonCourseController {
	@Resource
	private IPersonCourseService personCourseService;
	@Resource
	private IPersonService personService;
	@Resource
	private ICourseService courseService;
	/**
	 * 获取单个师生课程信息
	 * 
	 * @param personCourse
	 * @return
	 */
	@RequestMapping(value = "/selectByPersonCoursePrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody PersonCourse selectByPrimaryKey(@RequestBody PersonCourse personCourse) {
		return this.personCourseService.selectByPrimaryKey(personCourse.getPcId());
	}

	/**
	 * 删除单个师生课程信息
	 * 
	 * @param personCourse
	 * @return
	 */
	@RequestMapping(value = "/deleteByPersonCoursePrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody Integer deleteByPrimaryKey(@RequestBody PersonCourse personCourse) {
		return this.personCourseService.deleteByPrimaryKey(personCourse.getPcId());
	}

	/**
	 * 修改单个师生课程信息
	 * 
	 * @param personCourse
	 * @return
	 */
	@RequestMapping(value = "/updateByPersonCoursePrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody Integer updateByPrimaryKeySelective(@RequestBody PersonCourse personCourse) {
		PersonDTO personDTO = new PersonDTO(personCourse.getPeId(),personCourse.getPeNumber(),personCourse.getPeName());
		this.personService.updateByPrimaryKeySelective(personDTO);
		return this.personCourseService.updateByPrimaryKeySelective(personCourse);
	}

	/**
	 * 添加单个师生课程信息
	 * 
	 * @param personCourse
	 * @return
	 */
	@RequestMapping(value = "/insertPersonCourse.do", method = { RequestMethod.POST })
	public @ResponseBody ResponseData insertSelective(@RequestBody PersonCourse personCourse) {
		ResponseData responseData = ResponseData.ok();
		//判断该班课号是否存在/结束和是否已经加入该班课
		CourseDTO course = this.courseService.selectBycNumber(personCourse.getcNumber());
		if(course != null){
			if(course.getState() == 1 && course.getCan_join() == 1) {
				personCourse.setcId(course.getcId());
				PersonCourse personCourse1 = this.personCourseService.judgeJoinCourse(personCourse);
				if (personCourse1 != null) {
					responseData = new ResponseData(1005, "已加入该班课");
				} else {
					personCourse.setStatus(0); //加入班课，此时为学生
					int res = this.personCourseService.insertSelective(personCourse);
					if (res == 1) { //加入班课成功
						personCourse1 = this.personCourseService.judgeJoinCourse(personCourse);
						List<PersonCourse> personCourseList = this.personCourseService.selectBycId(personCourse1.getcId());
						int size = personCourseList.size();
						System.out.println(size);
						for (int i = 0; i < size; i++) {
							PersonCourse personCourse2 = personCourseList.get(i);
							if (personCourse2.getStatus() == 1) {
								course.setPeId(personCourse2.getPeId());
								course.setPeName(this.personService.selectByPrimaryKey(personCourse2.getPeId()).getPeName());
							}
						}
						responseData.putDataValue("course", course);
						//responseData.putDataValue("personcourse",personCourse1);
					}
				}
			}
			else {
				if(course.getState() == 0)
					responseData = new ResponseData(1006, "该班课已结束");
				else
					responseData = new ResponseData(1006, "该班课不允许加入");
			}
		}
		else{
			responseData = new ResponseData(1006,"该班课不存在");
		}
		return responseData;
	}

	/**
	 * 查找全部师生课程信息
	 */
	@RequestMapping("/findAllPersonCourses.do")
	public @ResponseBody List<PersonCourse> findAll() {
		return this.personCourseService.findAll();
	}

	/**
	 * 我创建的
	 */
	@RequestMapping("/createdCourse.do")
	public @ResponseBody ResponseData createdCourse(@RequestBody PersonCourse personCourse) {
		ResponseData responseData = ResponseData.ok();
		System.out.println(personCourse.getPeId());
		List<PersonCourse> personCourseList = this.personCourseService.createdCourse(personCourse);
		if(personCourseList.size() != 0){
			for(int i=0;i<personCourseList.size();i++){
				personCourseList.get((i)).setTeacher(this.personService.selectByPrimaryKey(personCourseList.get(i).getPeId()).getPeName());
			}
			responseData.putDataValue("personCourseList",personCourseList);
		}
		else{
			responseData = new ResponseData(1007,"用户未创建班课");
		}
		return responseData;
	}

	/**
	 * 我加入的
	 */
	@RequestMapping("/addedCourse.do")
	public @ResponseBody  ResponseData addedCourse(@RequestBody PersonCourse personCourse) {
		ResponseData responseData = ResponseData.ok();
		System.out.println(personCourse.getPeId());
		List<PersonCourse> personCourseList = this.personCourseService.addedCourse(personCourse);
		if(personCourseList.size() != 0){
			for(int i=0;i<personCourseList.size();i++){
				int teacherId = this.personCourseService.findTeacher(personCourseList.get(i)).getPeId();
				personCourseList.get(i).setTeacher(this.personService.selectByPrimaryKey(teacherId).getPeName());
			}
			responseData.putDataValue("personCourseList",personCourseList);
		}
		else{
			responseData = new ResponseData(1007,"用户未加入班课");
		}
		return responseData;
	}

	/**
	 * 根据班课编号显示所有成员
	 *
	 */
	@RequestMapping("/selectPersonByPersonCourseId.do")
	public @ResponseBody ResponseData selectPersonBycId(@RequestBody PersonCourse personCourse) {
		ResponseData  responseData = ResponseData.ok();
		List<PersonCourse> personCourseList = this.personCourseService.selectPersonBycId(personCourse.getcId());
		if(personCourseList.size() > 0)
			responseData.putDataValue("personCourseList",personCourseList);
		else
			responseData = new ResponseData(1200,"该班课下没有用户加入");
		return responseData;
	}
}