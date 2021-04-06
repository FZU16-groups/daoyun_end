package com.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * person
 * @author 
 */
@Data
public class Person implements Serializable {
    private Integer id;

    private Integer userid;

    private Integer schoolid;

    private String personnumber;

    private String personname;

    private Integer gender;

    private String grade;

    private String major;

    private Integer classes;

    private Integer isteacher;

    private static final long serialVersionUID = 1L;

    public Person() {
    }

    public Person(Integer id, Integer userid, Integer schoolid, String personnumber, String personname, Integer gender, String grade, String major, Integer classes, Integer isteacher) {
        this.id = id;
        this.userid = userid;
        this.schoolid = schoolid;
        this.personnumber = personnumber;
        this.personname = personname;
        this.gender = gender;
        this.grade = grade;
        this.major = major;
        this.classes = classes;
        this.isteacher = isteacher;
    }

    public Person(Integer userid, Integer schoolid, String personnumber, String personname, Integer gender, String grade, String major, Integer classes, Integer isteacher) {
        this.userid = userid;
        this.schoolid = schoolid;
        this.personnumber = personnumber;
        this.personname = personname;
        this.gender = gender;
        this.grade = grade;
        this.major = major;
        this.classes = classes;
        this.isteacher = isteacher;
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

    public Integer getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(Integer schoolid) {
        this.schoolid = schoolid;
    }

    public String getPersonnumber() {
        return personnumber;
    }

    public void setPersonnumber(String personnumber) {
        this.personnumber = personnumber;
    }

    public String getPersonname() {
        return personname;
    }

    public void setPersonname(String personname) {
        this.personname = personname;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Integer getClasses() {
        return classes;
    }

    public void setClasses(Integer classes) {
        this.classes = classes;
    }

    public Integer getIsteacher() {
        return isteacher;
    }

    public void setIsteacher(Integer isteacher) {
        this.isteacher = isteacher;
    }
}