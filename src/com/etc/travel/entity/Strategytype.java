package com.etc.travel.entity;

public class Strategytype {
    private Integer stypesid;

    private String stypesname;

    public Integer getStypesid() {
        return stypesid;
    }

    public void setStypesid(Integer stypesid) {
        this.stypesid = stypesid;
    }

    public String getStypesname() {
        return stypesname;
    }

    public void setStypesname(String stypesname) {
        this.stypesname = stypesname == null ? null : stypesname.trim();
    }
}