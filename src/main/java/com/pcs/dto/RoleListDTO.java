package com.pcs.dto;

import com.pcs.pojo.RoleDTO;

import java.util.List;

public class RoleListDTO {
    private List<RoleDTO> roleList;

    public RoleListDTO() {
        super();
    }
    public RoleListDTO(List<RoleDTO> roleList) {
        this.roleList = roleList;
    }

    public List<RoleDTO> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<RoleDTO> roleList) {
        this.roleList = roleList;
    }

}
