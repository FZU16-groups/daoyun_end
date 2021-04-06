package com.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * dictionary
 * @author 
 */
@Data
public class Dictionary implements Serializable {
    private Integer id;

    private String chinesename;

    private String englishname;

    private static final long serialVersionUID = 1L;

    public Dictionary(Integer id, String chinesename, String englishname) {
        this.id = id;
        this.chinesename = chinesename;
        this.englishname = englishname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChinesename() {
        return chinesename;
    }

    public void setChinesename(String chinesename) {
        this.chinesename = chinesename;
    }

    public String getEnglishname() {
        return englishname;
    }

    public void setEnglishname(String englishname) {
        this.englishname = englishname;
    }
}