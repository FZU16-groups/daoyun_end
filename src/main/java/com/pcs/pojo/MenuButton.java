package com.pcs.pojo;

import java.io.Serializable;

public class MenuButton implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -7563201421034746594L;

	private Integer mbId;

    private Integer mId;

    private Integer bId;

    private Integer status;

    
    public MenuButton() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MenuButton(Integer mbId, Integer mId, Integer bId, Integer status) {
		super();
		this.mbId = mbId;
		this.mId = mId;
		this.bId = bId;
		this.status = status;
	}

	public Integer getMbId() {
        return mbId;
    }

    public void setMbId(Integer mbId) {
        this.mbId = mbId;
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}