package com.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * button
 * @author 
 */
@Data
public class Button implements Serializable {
    private Integer id;

    private String buttonname;

    private String buttonicon;

    private String buttondetail;

    private Integer creator;

    private Date creationdate;

    private Integer modifier;

    private Date modificationdate;

    private static final long serialVersionUID = 1L;

    public Button(Integer id, String buttonname, String buttonicon, String buttondetail, Integer creator, Date creationdate, Integer modifier, Date modificationdate) {
        this.id = id;
        this.buttonname = buttonname;
        this.buttonicon = buttonicon;
        this.buttondetail = buttondetail;
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

    public String getButtonname() {
        return buttonname;
    }

    public void setButtonname(String buttonname) {
        this.buttonname = buttonname;
    }

    public String getButtonicon() {
        return buttonicon;
    }

    public void setButtonicon(String buttonicon) {
        this.buttonicon = buttonicon;
    }

    public String getButtondetail() {
        return buttondetail;
    }

    public void setButtondetail(String buttondetail) {
        this.buttondetail = buttondetail;
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