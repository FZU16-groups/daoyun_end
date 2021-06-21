package com.pcs.pojo;

import java.io.Serializable;

public class PersonDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5538474747140824612L;

	private Integer peId;

	private Integer uId;

	private Integer sId;

	private String peNumber;

	private String peName;

	private Integer gender;

	private String grade;

	private String major;

	private Integer classes;

	private Integer isStudent;

	public PersonDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PersonDTO(Integer peId, String peNumber, String peName) {
		super();
		this.peId = peId;
		this.peNumber = peNumber;
		this.peName = peName;

		// TODO Auto-generated constructor stub
	}

	public PersonDTO(Integer peId, Integer uId, Integer sId, String peNumber, String peName, Integer gender, String grade,
					 String major, Integer classes, Integer isStudent) {
		super();
		this.peId = peId;
		this.uId = uId;
		this.sId = sId;
		this.peNumber = peNumber;
		this.peName = peName;
		this.gender = gender;
		this.grade = grade;
		this.major = major;
		this.classes = classes;
		this.isStudent = isStudent;
	}

	public PersonDTO(Integer uId, Integer sId, String peNumber, String peName, Integer gender, String grade, String major,
					 Integer classes, Integer isStudent) {
		super();
		this.uId = uId;
		this.sId = sId;
		this.peNumber = peNumber;
		this.peName = peName;
		this.gender = gender;
		this.grade = grade;
		this.major = major;
		this.classes = classes;
		this.isStudent = isStudent;
	}

	public Integer getPeId() {
		return peId;
	}

	public void setPeId(Integer peId) {
		this.peId = peId;
	}

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public Integer getsId() {
		return sId;
	}

	public void setsId(Integer sId) {
		this.sId = sId;
	}

	public String getPeNumber() {
		return peNumber;
	}

	public void setPeNumber(String peNumber) {
		this.peNumber = peNumber == null ? null : peNumber.trim();
	}

	public String getPeName() {
		return peName;
	}

	public void setPeName(String peName) {
		this.peName = peName == null ? null : peName.trim();
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade == null ? null : grade.trim();
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major == null ? null : major.trim();
	}

	public Integer getClasses() {
		return classes;
	}

	public void setClasses(Integer classes) {
		this.classes = classes;
	}

	public Integer getIsStudent() {
		return isStudent;
	}

	public void setIsStudent(Integer isStudent) {
		this.isStudent = isStudent;
	}
}