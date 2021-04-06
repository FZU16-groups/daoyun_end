package com.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * userrole
 * @author 
 */
@Data
public class UserRole implements Serializable {
    private Integer id;

    private Integer userid;

    private Integer roleid;

    private Integer status;

    private static final long serialVersionUID = 1L;

    public UserRole(Integer id, Integer userid, Integer roleid, Integer status) {
        this.id = id;
        this.userid = userid;
        this.roleid = roleid;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}