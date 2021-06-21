package com.pcs.pojo;

import java.io.Serializable;
import java.util.Date;

public class ButtonDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6661822666241228220L;

	private Integer bId;

	private String bName;

	private String icon;

	private String description;

	private Integer creator;

	private Date createTime;

	private Integer lastModifier;

	private Date lastModifyDate;

	public ButtonDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ButtonDTO(Integer bId, String bName, String icon, String description, Integer creator, Date createTime,
					 Integer lastModifier, Date lastModifyDate) {
		super();
		this.bId = bId;
		this.bName = bName;
		this.icon = icon;
		this.description = description;
		this.creator = creator;
		this.createTime = createTime;
		this.lastModifier = lastModifier;
		this.lastModifyDate = lastModifyDate;
	}

	public Integer getbId() {
		return bId;
	}

	public void setbId(Integer bId) {
		this.bId = bId;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName == null ? null : bName.trim();
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon == null ? null : icon.trim();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public Integer getCreator() {
		return creator;
	}

	public void setCreator(Integer creator) {
		this.creator = creator;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getLastModifier() {
		return lastModifier;
	}

	public void setLastModifier(Integer lastModifier) {
		this.lastModifier = lastModifier;
	}

	public Date getLastModifyDate() {
		return lastModifyDate;
	}

	public void setLastModifyDate(Date lastModifyDate) {
		this.lastModifyDate = lastModifyDate;
	}
}