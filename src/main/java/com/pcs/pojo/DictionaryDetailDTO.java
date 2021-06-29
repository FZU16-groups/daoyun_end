package com.pcs.pojo;

import java.io.Serializable;

public class DictionaryDetailDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 301294356609957009L;

	private Integer ddId;

	private Integer pa_dd_id;

	private Integer dId;

	private Integer sort;

	private String ddName;

	private Integer isDefault;

	public DictionaryDetailDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DictionaryDetailDTO(Integer ddId, Integer dId, String ddName, Integer isDefault) {
		super();
		this.ddId = ddId;
		this.dId = dId;
		this.ddName = ddName;
		this.isDefault = isDefault;
	}

	public DictionaryDetailDTO(Integer ddId, Integer dId, Integer sort, String ddName, Integer isDefault) {
		this.ddId = ddId;
		this.dId = dId;
		this.sort = sort;
		this.ddName = ddName;
		this.isDefault = isDefault;
	}

	public Integer getDdId() {
		return ddId;
	}

	public void setDdId(Integer ddId) {
		this.ddId = ddId;
	}

	public Integer getdId() {
		return dId;
	}

	public void setdId(Integer dId) {
		this.dId = dId;
	}

	public String getDdName() {
		return ddName;
	}

	public void setDdName(String ddName) {
		this.ddName = ddName == null ? null : ddName.trim();
	}

	public Integer getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
}