package com.pcs.dto;

public class BindPhoneDTO {

    private String openId;
    private String phone;
    private String captcha;

    public BindPhoneDTO() {
    }

    public BindPhoneDTO(String openId, String phone, String captcha) {
        this.openId = openId;
        this.phone = phone;
        this.captcha = captcha;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
