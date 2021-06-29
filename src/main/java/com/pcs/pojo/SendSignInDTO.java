package com.pcs.pojo;

import java.util.Date;

public class SendSignInDTO {
    private Integer ssId;
    private Integer cId;
    private String cNumber;
    private String cName;
    private Integer peId;
    private Integer type;
    private Date date;
    private Date endDate;
    private Integer value;
    private Double limitdis;
    private Integer limitime;
    private Double position_x;
    private Double position_y;
    private Integer state;
    private Long reminTime;
    private Integer studentCount;
    private Integer signedCount;
    private String startTime;
    private String endTime;

    public SendSignInDTO(){

    }

    public SendSignInDTO(Integer ssId, Integer cId, String cNumber, String cName, Integer peId, Integer type, Date date, Date endDate, Integer value, Double limitdis, Integer limitime, Double position_x, Double position_y, Integer state, Long reminTime, Integer studentCount, Integer signedCount) {
        this.ssId = ssId;
        this.cId = cId;
        this.cNumber = cNumber;
        this.cName = cName;
        this.peId = peId;
        this.type = type;
        this.date = date;
        this.endDate = endDate;
        this.value = value;
        this.limitdis = limitdis;
        this.limitime = limitime;
        this.position_x = position_x;
        this.position_y = position_y;
        this.state = state;
        this.reminTime = reminTime;
        this.studentCount = studentCount;
        this.signedCount = signedCount;
    }

    public SendSignInDTO(Integer cId, Integer peId) {
        this.cId = cId;
        this.peId = peId;
    }

    public Integer getSsId() {
        return ssId;
    }

    public void setSsId(Integer ssId) {
        this.ssId = ssId;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcNumber() {
        return cNumber;
    }

    public void setcNumber(String cNumber) {
        this.cNumber = cNumber;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Integer getPeId() {
        return peId;
    }

    public void setPeId(Integer peId) {
        this.peId = peId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Double getLimitdis() {
        return limitdis;
    }

    public void setLimitdis(Double limitdis) {
        this.limitdis = limitdis;
    }

    public Integer getLimitime() {
        return limitime;
    }

    public void setLimitime(Integer limitime) {
        this.limitime = limitime;
    }

    public Double getPosition_x() {
        return position_x;
    }

    public void setPosition_x(Double position_x) {
        this.position_x = position_x;
    }

    public Double getPosition_y() {
        return position_y;
    }

    public void setPosition_y(Double position_y) {
        this.position_y = position_y;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getReminTime() {
        return reminTime;
    }

    public void setReminTime(Long reminTime) {
        this.reminTime = reminTime;
    }

    public Integer getSignedCount() {
        return signedCount;
    }

    public void setSignedCount(Integer signedCount) {
        this.signedCount = signedCount;
    }

    public Integer getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(Integer studentCount) {
        this.studentCount = studentCount;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}