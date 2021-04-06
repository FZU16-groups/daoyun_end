package com.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * permission
 * @author 
 */
@Data
public class Permission implements Serializable {
    private Integer id;

    private Integer parentid;

    private String permissionname;

    private String permissiondetail;

    private Integer creator;

    private Date creationdate;

    private Integer modifier;

    private Date modificationdate;

    private static final long serialVersionUID = 1L;

    public Permission(Integer id, String permissionname, String permissiondetail, Integer creator, Date creationdate, Integer modifier, Date modificationdate) {
        this.id = id;
        this.permissionname = permissionname;
        this.permissiondetail = permissiondetail;
        this.creator = creator;
        this.creationdate = creationdate;
        this.modifier = modifier;
        this.modificationdate = modificationdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getPermissionname() {
        return permissionname;
    }

    public void setPermissionname(String permissionname) {
        this.permissionname = permissionname;
    }

    public String getPermissiondetail() {
        return permissiondetail;
    }

    public void setPermissiondetail(String permissiondetail) {
        this.permissiondetail = permissiondetail;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Integer getModifier() {
        return modifier;
    }

    public void setModifier(Integer modifier) {
        this.modifier = modifier;
    }

    public Date getModificationdate() {
        return modificationdate;
    }

    public void setModificationdate(Date modificationdate) {
        this.modificationdate = modificationdate;
    }
}