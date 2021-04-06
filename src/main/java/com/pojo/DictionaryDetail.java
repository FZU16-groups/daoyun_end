package com.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * dictionarydetail
 * @author 
 */
@Data
public class DictionaryDetail implements Serializable {
    private Integer id;

    private Integer dictionaryid;

    private String dictionarydetailname;

    private Integer isdefault;

    private static final long serialVersionUID = 1L;

    public DictionaryDetail(Integer id, Integer dictionaryid, String dictionarydetailname, Integer isdefault) {
        this.id = id;
        this.dictionaryid = dictionaryid;
        this.dictionarydetailname = dictionarydetailname;
        this.isdefault = isdefault;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDictionaryid() {
        return dictionaryid;
    }

    public void setDictionaryid(Integer dictionaryid) {
        this.dictionaryid = dictionaryid;
    }

    public String getDictionarydetailname() {
        return dictionarydetailname;
    }

    public void setDictionarydetailname(String dictionarydetailname) {
        this.dictionarydetailname = dictionarydetailname;
    }

    public Integer getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Integer isdefault) {
        this.isdefault = isdefault;
    }
}