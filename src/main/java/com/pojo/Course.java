package com.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * course
 * @author 
 */
@Data
public class Course implements Serializable {
    private Integer id;

    private String coursenumber;

    private String coursename;

    private String coursedeatil;

    private String courseterm;

    private Integer coursedate;

    private Double coursecredit;

    private Double dailyweight;

    private Double finalweight;

    private static final long serialVersionUID = 1L;

    public Course(String coursenumber, String coursename, String coursedeatil, String courseterm, Integer coursedate, Double coursecredit, Double dailyweight, Double finalweight) {
        this.coursenumber = coursenumber;
        this.coursename = coursename;
        this.coursedeatil = coursedeatil;
        this.courseterm = courseterm;
        this.coursedate = coursedate;
        this.coursecredit = coursecredit;
        this.dailyweight = dailyweight;
        this.finalweight = finalweight;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCoursenumber() {
        return coursenumber;
    }

    public void setCoursenumber(String coursenumber) {
        this.coursenumber = coursenumber;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getCoursedeatil() {
        return coursedeatil;
    }

    public void setCoursedeatil(String coursedeatil) {
        this.coursedeatil = coursedeatil;
    }

    public String getCourseterm() {
        return courseterm;
    }

    public void setCourseterm(String courseterm) {
        this.courseterm = courseterm;
    }

    public Integer getCoursedate() {
        return coursedate;
    }

    public void setCoursedate(Integer coursedate) {
        this.coursedate = coursedate;
    }

    public Double getCoursecredit() {
        return coursecredit;
    }

    public void setCoursecredit(Double coursecredit) {
        this.coursecredit = coursecredit;
    }

    public Double getDailyweight() {
        return dailyweight;
    }

    public void setDailyweight(Double dailyweight) {
        this.dailyweight = dailyweight;
    }

    public Double getFinalweight() {
        return finalweight;
    }

    public void setFinalweight(Double finalweight) {
        this.finalweight = finalweight;
    }
}