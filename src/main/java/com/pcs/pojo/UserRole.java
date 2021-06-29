package com.pcs.pojo;

import java.io.Serializable;

public class UserRole implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3261168710191061920L;

	private Integer urId;

	private Integer uId;

	private Integer rId;

	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRole(Integer urId, Integer uId, Integer rId) {
		super();
		this.urId = urId;
		this.uId = uId;
		this.rId = rId;
	}

	public Integer getUrId() {
		return urId;
	}

	public void setUrId(Integer urId) {
		this.urId = urId;
	}

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public Integer getrId() {
		return rId;
	}

	public void setrId(Integer rId) {
		this.rId = rId;
	}

}