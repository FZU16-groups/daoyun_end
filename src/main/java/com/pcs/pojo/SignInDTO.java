package com.pcs.pojo;

import java.io.Serializable;
import java.util.Date;

public class SignInDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2603379872267330811L;

	private Integer siId;

	private Integer ssId;

	private Integer cId;

	private String cNumber;

	private String cName;

	private Integer peId;

	private String peNumber;

	private String peName;

	private Integer type;

	private Date date;

	private double position_x;

	private double position_y;

	private Integer value;

	public SignInDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SignInDTO(Integer siId, Integer cId, String cNumber, String cName, Integer peId, String peNumber, String peName, Integer type, Date date, double position_x, double position_y, Integer value) {
		this.siId = siId;
		this.cId = cId;
		this.cNumber = cNumber;
		this.cName = cName;
		this.peId = peId;
		this.peNumber = peNumber;
		this.peName = peName;
		this.type = type;
		this.date = date;
		this.position_x = position_x;
		this.position_y = position_y;
		this.value = value;
	}

	public SignInDTO(Integer cId, Integer peId) {
		this.cId = cId;
		this.peId = peId;
	}

	public Integer getSiId() {
		return siId;
	}

	public void setSiId(Integer siId) {
		this.siId = siId;
	}

	public Integer getSsId() {
		return ssId;
	}

	public void setSsId(Integer ssId) {
		this.ssId = ssId;
	}

	public String getcNumber() {
		return cNumber;
	}

	public void setcNumber(String cNumber) {
		this.cNumber = cNumber == null ? null : cNumber.trim();
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName == null ? null : cName.trim();
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

	public Integer getState() {
		return value;
	}

	public void setState(Integer state) {
		this.value = state;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getPosition_x() {
		return position_x;
	}

	public void setPosition_x(double position_x) {
		this.position_x = position_x;
	}

	public double getPosition_y() {
		return position_y;
	}

	public void setPosition_y(double position_y) {
		this.position_y = position_y;
	}

	public Integer getcId() {
		return cId;
	}

	public void setcId(Integer cId) {
		this.cId = cId;
	}

	public Integer getPeId() {
		return peId;
	}

	public void setPeId(Integer peId) {
		this.peId = peId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
}