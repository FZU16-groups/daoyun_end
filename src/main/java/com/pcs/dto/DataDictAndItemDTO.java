package com.pcs.dto;

import com.pcs.pojo.DictionaryDetailDTO;

import java.util.List;

public class DataDictAndItemDTO {
    private Integer dId;

    private String chineseName;

    private String englishName;

    List<DictionaryDetailDTO> items;

    public DataDictAndItemDTO() {
    }

    public DataDictAndItemDTO(Integer dId, String chineseName, String englishName, List<DictionaryDetailDTO> items) {
        this.dId = dId;
        this.chineseName = chineseName;
        this.englishName = englishName;
        this.items = items;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public List<DictionaryDetailDTO> getItems() {
        return items;
    }

    public void setItems(List<DictionaryDetailDTO> items) {
        this.items = items;
    }
}
