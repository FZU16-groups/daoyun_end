package com.pcs.dto;

public class LoginDTO {
    private String loginToken;
    private String captcha;

    public LoginDTO() { }

    public LoginDTO(String loginToken, String captcha) {
        this.loginToken = loginToken;
        this.captcha = captcha;
    }

    public String getLoginToken() {
        return loginToken;
    }

    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
