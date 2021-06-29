package com.pcs.dto;

import com.pcs.pojo.RoleDTO;
import com.pcs.pojo.UserDTO;
import com.pcs.pojo.UserRole;

import java.util.Date;
import java.util.List;

public class UserRoleDTO {
    private Integer uId;

    private String uNumber;

    private String uName;

    private String phone;

    private String emaile;

    private Date createDate;

    private Integer status;

    private Integer peId;

    private List<Integer> yourRIdList;

    public UserRoleDTO() {
        super();
        // TODO Auto-generated constructor stub
    }

    public UserRoleDTO(Integer uId, String uNumber, String uName, String phone, String emaile, Date createDate, Integer status, Integer peId, List<Integer> yourRIdList) {
        this.uId = uId;
        this.uNumber = uNumber;
        this.uName = uName;
        this.phone = phone;
        this.emaile = emaile;
        this.createDate = createDate;
        this.status = status;
        this.peId = peId;
        this.yourRIdList = yourRIdList;
    }

    public List<Integer> getYourRIdList() {
        return yourRIdList;
    }

    public void setYourRIdList(List<Integer> yourRIdList) {
        this.yourRIdList = yourRIdList;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuNumber() {
        return uNumber;
    }

    public void setuNumber(String uNumber) {
        this.uNumber = uNumber == null ? null : uNumber.trim();
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName == null ? null : uName.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmaile() {
        return emaile;
    }

    public void setEmaile(String emaile) {
        this.emaile = emaile == null ? null : emaile.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPeId() {
        return peId;
    }

    public void setPeId(Integer peId) {
        this.peId = peId;
    }


}
