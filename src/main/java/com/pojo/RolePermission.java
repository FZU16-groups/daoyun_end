package com.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * rolepermission
 * @author 
 */
@Data
public class RolePermission implements Serializable {
    private Integer id;

    private Integer roleid;

    private Integer permissionid;

    private Integer status;

    private static final long serialVersionUID = 1L;

    public RolePermission(Integer id, Integer roleid, Integer permissionid, Integer status) {
        this.id = id;
        this.roleid = roleid;
        this.permissionid = permissionid;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(Integer permissionid) {
        this.permissionid = permissionid;
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