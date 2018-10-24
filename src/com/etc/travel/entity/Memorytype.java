package com.etc.travel.entity;

public class Memorytype {
    private Integer memorytypeid;

    private String memorytype;

    public Integer getMemorytypeid() {
        return memorytypeid;
    }

    public void setMemorytypeid(Integer memorytypeid) {
        this.memorytypeid = memorytypeid;
    }

    public String getMemorytype() {
        return memorytype;
    }

    public void setMemorytype(String memorytype) {
        this.memorytype = memorytype == null ? null : memorytype.trim();
    }
}