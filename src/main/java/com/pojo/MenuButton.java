package com.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * menubutton
 * @author 
 */
@Data
public class MenuButton implements Serializable {
    private Integer id;

    private Integer menuid;

    private Integer buttonid;

    private Integer status;

    private static final long serialVersionUID = 1L;

    public MenuButton(Integer id, Integer menuid, Integer buttonid, Integer status) {
        this.id = id;
        this.menuid = menuid;
        this.buttonid = buttonid;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    public Integer getButtonid() {
        return buttonid;
    }

    public void setButtonid(Integer buttonid) {
        this.buttonid = buttonid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}