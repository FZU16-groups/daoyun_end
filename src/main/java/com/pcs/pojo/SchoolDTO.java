package com.pcs.pojo;

import java.io.Serializable;

public class SchoolDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4848610531873777473L;

	private Integer sId;

	private String sName;

	private String college;

	private String major;

	public SchoolDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SchoolDTO(Integer sId, String sName, String college, String major) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.college = college;
		this.major = major;
	}

	public Integer getsId() {
		return sId;
	}

	public void setsId(Integer sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName == null ? null : sName.trim();
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college == null ? null : college.trim();
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major == null ? null : major.trim();
	}
}