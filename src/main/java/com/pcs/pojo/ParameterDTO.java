package com.pcs.pojo;

import java.io.Serializable;

public class ParameterDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5256244066213570065L;

	private Integer paId;

	private String paName;

	private String keyword;

	private Double value;

	public ParameterDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ParameterDTO(Integer paId, String paName, String keyword, Double value) {
		super();
		this.paId = paId;
		this.paName = paName;
		this.keyword = keyword;
		this.value = value;
	}

	public Integer getPaId() {
		return paId;
	}

	public void setPaId(Integer paId) {
		this.paId = paId;
	}

	public String getPaName() {
		return paName;
	}

	public void setPaName(String paName) {
		this.paName = paName == null ? null : paName.trim();
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
}