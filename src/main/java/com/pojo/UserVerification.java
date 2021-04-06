package com.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * userverification
 * @author 
 */
@Data
public class UserVerification implements Serializable {
    private Integer id;

    private Integer userid;

    private Integer logintype;

    private String logintoken;

    private String passwordtoken;

    private Integer staus;

    private static final long serialVersionUID = 1L;

    public UserVerification() {
    }

    public UserVerification(Integer id, Integer userid, Integer logintype, String logintoken, String passwordtoken, Integer staus) {
        this.id = id;
        this.userid = userid;
        this.logintype = logintype;
        this.logintoken = logintoken;
        this.passwordtoken = passwordtoken;
        this.staus = staus;
    }

    public UserVerification(Integer userid, Integer logintype, String logintoken, String passwordtoken, Integer staus) {
        this.userid = userid;
        this.logintype = logintype;
        this.logintoken = logintoken;
        this.passwordtoken = passwordtoken;
        this.staus = staus;
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

    public Integer getLogintype() {
        return logintype;
    }

    public void setLogintype(Integer logintype) {
        this.logintype = logintype;
    }

    public String getLogintoken() {
        return logintoken;
    }

    public void setLogintoken(String logintoken) {
        this.logintoken = logintoken;
    }

    public String getPasswordtoken() {
        return passwordtoken;
    }

    public void setPasswordtoken(String passwordtoken) {
        this.passwordtoken = passwordtoken;
    }

    public Integer getStaus() {
        return staus;
    }

    public void setStaus(Integer staus) {
        this.staus = staus;
    }
}