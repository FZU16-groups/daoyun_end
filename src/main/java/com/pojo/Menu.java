package com.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * menu
 * @author 
 */
@Data
public class Menu implements Serializable {
    private Integer id;

    private Integer parentid;

    private String menunname;

    private String menuicon;

    private String menulink;

    private Integer menusort;

    private Boolean isdisplay;

    private Boolean ispage;

    private Integer creator;

    private Date creationdate;

    private Integer modifier;

    private Date modificationdate;

    private static final long serialVersionUID = 1L;

    public Menu(Integer id, Integer parentid, String menunname, String menuicon, String menulink, Integer menusort, Boolean isdisplay, Boolean ispage, Integer creator, Date creationdate, Integer modifier, Date modificationdate) {
        this.id = id;
        this.parentid = parentid;
        this.menunname = menunname;
        this.menuicon = menuicon;
        this.menulink = menulink;
        this.menusort = menusort;
        this.isdisplay = isdisplay;
        this.ispage = ispage;
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

    public String getMenunname() {
        return menunname;
    }

    public void setMenunname(String menunname) {
        this.menunname = menunname;
    }

    public String getMenuicon() {
        return menuicon;
    }

    public void setMenuicon(String menuicon) {
        this.menuicon = menuicon;
    }

    public String getMenulink() {
        return menulink;
    }

    public void setMenulink(String menulink) {
        this.menulink = menulink;
    }

    public Integer getMenusort() {
        return menusort;
    }

    public void setMenusort(Integer menusort) {
        this.menusort = menusort;
    }

    public Boolean getIsdisplay() {
        return isdisplay;
    }

    public void setIsdisplay(Boolean isdisplay) {
        this.isdisplay = isdisplay;
    }

    public Boolean getIspage() {
        return ispage;
    }

    public void setIspage(Boolean ispage) {
        this.ispage = ispage;
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