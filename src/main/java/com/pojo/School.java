package com.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * school
 * @author 
 */
@Data
public class School implements Serializable {
    private Integer id;

    private String schoolname;

    private String college;

    private String major;

    private static final long serialVersionUID = 1L;

    public School(Integer id, String schoolname, String college, String major) {
        this.id = id;
        this.schoolname = schoolname;
        this.college = college;
        this.major = major;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}