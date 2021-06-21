package com.pcs.pojo;

import java.io.Serializable;
import java.util.Date;

public class UserDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6680738692943252902L;

	private Integer uId;

	private String uNumber;

	private String uName;

	private String phone;

	private String emaile;

	private Date createDate;

	private Integer status;

	private Integer peId;

	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDTO(Integer uId, String uNumber, String uName, String phone, String emaile, Date createDate,
				   Integer status) {
		super();
		this.uId = uId;
		this.uNumber = uNumber;
		this.uName = uName;
		this.phone = phone;
		this.emaile = emaile;
		this.createDate = createDate;
		this.status = status;
	}

	public UserDTO(String phone) {
		this.phone = phone;
	}

	public UserDTO(String uNumber, String uName, Date createDate, Integer status) {
		this.uNumber = uNumber;
		this.uName = uName;
		this.createDate = createDate;
		this.status = status;
	}

	public UserDTO(String uName, String uNumber, String phone, String email, Date createDate,Integer status) {
		this.phone = phone;
		this.uNumber = uNumber;
		this.uName = uName;
		this.emaile = email;
		this.createDate = createDate;
		this.status = status;
	}

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public String getuNumber() {
		return uNumber;
	}

	public void setuNumber(String uNumber) {
		this.uNumber = uNumber == null ? null : uNumber.trim();
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName == null ? null : uName.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public String getEmaile() {
		return emaile;
	}

	public void setEmaile(String emaile) {
		this.emaile = emaile == null ? null : emaile.trim();
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getPeId() {
		return peId;
	}

	public void setPeId(Integer peId) {
		this.peId = peId;
	}

}