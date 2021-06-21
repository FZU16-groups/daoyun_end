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
    private Integer value;
    private Double limitdis;
    private Integer limitime;
    private Double position_x;
    private Double position_y;
    private Integer state;

    public SendSignInDTO(){

    }

    public SendSignInDTO(Integer ssId, Integer cId, String cNumber, String cName, Integer peId, Integer type, Date date, Integer value, Double limitdis, Integer limitime, Double position_x, Double position_y, Integer state) {
        this.ssId = ssId;
        this.cId = cId;
        this.cNumber = cNumber;
        this.cName = cName;
        this.peId = peId;
        this.type = type;
        this.date = date;
        this.value = value;
        this.limitdis = limitdis;
        this.limitime = limitime;
        this.position_x = position_x;
        this.position_y = position_y;
        this.state = state;
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
}