package com.pcs.dto;

public class AuthqqDTO {
    private Integer aId;
    private Integer userId;
    private String openId;
    private String accessToken;
    private Integer state;

    public AuthqqDTO() {
    }

    public AuthqqDTO(Integer aId, Integer userId, String openId, String accessToken, Integer state) {
        this.aId = aId;
        this.userId = userId;
        this.openId = openId;
        this.accessToken = accessToken;
        this.state = state;
    }

    public AuthqqDTO(String openId, String accessToken) {
        this.openId = openId;
        this.accessToken = accessToken;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
