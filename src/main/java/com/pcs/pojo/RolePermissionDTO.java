package com.pcs.pojo;

import java.io.Serializable;

public class RolePermissionDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3648560770240139647L;

	private Integer rpId;

	private Integer rId;

	private Integer pId;

	private Integer status;

	private String pName;
	public RolePermissionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RolePermissionDTO(Integer rpId, Integer rId, Integer pId, Integer status, String pName) {
		this.rpId = rpId;
		this.rId = rId;
		this.pId = pId;
		this.status = status;
		this.pName = pName;
	}

	public RolePermissionDTO(Integer rpId, Integer rId, Integer pId, Integer status) {
		this.rpId = rpId;
		this.rId = rId;
		this.pId = pId;
		this.status = status;
	}
	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public Integer getRpId() {
		return rpId;
	}

	public void setRpId(Integer rpId) {
		this.rpId = rpId;
	}

	public Integer getrId() {
		return rId;
	}

	public void setrId(Integer rId) {
		this.rId = rId;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}