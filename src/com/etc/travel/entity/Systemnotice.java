package com.etc.travel.entity;

import java.util.Date;

public class Systemnotice {
    private String snid;

    private String sntitle;

    private String sncontent;

    private Date sntime;

    private String snauthor;

    public String getSnid() {
        return snid;
    }

    public void setSnid(String snid) {
        this.snid = snid == null ? null : snid.trim();
    }

    public String getSntitle() {
        return sntitle;
    }

    public void setSntitle(String sntitle) {
        this.sntitle = sntitle == null ? null : sntitle.trim();
    }

    public String getSncontent() {
        return sncontent;
    }

    public void setSncontent(String sncontent) {
        this.sncontent = sncontent == null ? null : sncontent.trim();
    }

    public Date getSntime() {
        return sntime;
    }

    public void setSntime(Date sntime) {
        this.sntime = sntime;
    }

    public String getSnauthor() {
        return snauthor;
    }

    public void setSnauthor(String snauthor) {
        this.snauthor = snauthor == null ? null : snauthor.trim();
    }
}