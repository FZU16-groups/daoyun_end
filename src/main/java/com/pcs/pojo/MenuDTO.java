package com.pcs.pojo;

import java.io.Serializable;
import java.util.Date;

public class MenuDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3173970956537163347L;

	private Integer mId;

	private Integer parentId;

	private String menuName;

	private String icon;

	private String link;

	private Integer sort;

	private Boolean isDisplay;

	private Boolean isPage;

	private Integer creator;

	private Date createTime;

	private Integer lastModifier;

	private Date lastModifyDate;

	public MenuDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MenuDTO(Integer mId, Integer parentId, String menuName, String icon, String link, Integer sort,
				   Boolean isDisplay, Boolean isPage, Integer creator, Date createTime, Integer lastModifier,
				   Date lastModifyDate) {
		super();
		this.mId = mId;
		this.parentId = parentId;
		this.menuName = menuName;
		this.icon = icon;
		this.link = link;
		this.sort = sort;
		this.isDisplay = isDisplay;
		this.isPage = isPage;
		this.creator = creator;
		this.createTime = createTime;
		this.lastModifier = lastModifier;
		this.lastModifyDate = lastModifyDate;
	}

	public Integer getmId() {
		return mId;
	}

	public void setmId(Integer mId) {
		this.mId = mId;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName == null ? null : menuName.trim();
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon == null ? null : icon.trim();
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link == null ? null : link.trim();
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Boolean getIsDisplay() {
		return isDisplay;
	}

	public void setIsDisplay(Boolean isDisplay) {
		this.isDisplay = isDisplay;
	}

	public Boolean getIsPage() {
		return isPage;
	}

	public void setIsPage(Boolean isPage) {
		this.isPage = isPage;
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