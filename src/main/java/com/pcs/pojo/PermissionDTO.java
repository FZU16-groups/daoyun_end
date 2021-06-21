package com.pcs.pojo;

import java.io.Serializable;
import java.util.Date;

public class PermissionDTO implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -2104477971223443279L;

	private Integer pId;

    private String pName;

    private String description;

    private Integer creator;

    private Date createTime;

    private Integer lastModifier;

    private Date lastModifyDate;

    public PermissionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PermissionDTO(Integer pId, String pName, String description, Integer creator, Date createTime,
                         Integer lastModifier, Date lastModifyDate) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.description = description;
		this.creator = creator;
		this.createTime = createTime;
		this.lastModifier = lastModifier;
		this.lastModifyDate = lastModifyDate;
	}

	public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
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