package com.pcs.dto;

public class PagePeIdDTO {
    private Integer peId;
    private Integer pageIndex;
    private Integer pageSize;

    public Integer getPeId() {
        return peId;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPeId(Integer peId) {
        this.peId = peId;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public PagePeIdDTO(Integer peId, Integer pageIndex, Integer pageSize) {
        this.peId = peId;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }

    public PagePeIdDTO( ){

    }
}
