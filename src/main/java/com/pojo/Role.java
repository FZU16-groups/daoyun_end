package com.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * role
 * @author 
 */
@Data
public class Role implements Serializable {
    private Integer id;

    private String rolename;

    private String roledetail;

    private String creator;

    private Date creationdate;

    private Integer modifier;

    private Date modificationdate;

    private static final long serialVersionUID = 1L;

    public Role(Integer id, String rolename, String roledetail, String creator, Date creationdate, Integer modifier, Date modificationdate) {
        this.id = id;
        this.rolename = rolename;
        this.roledetail = roledetail;
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

    public String getRoledetail() {
        return roledetail;
    }

    public void setRoledetail(String roledetail) {
        this.roledetail = roledetail;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
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