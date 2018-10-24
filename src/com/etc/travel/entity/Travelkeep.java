package com.etc.travel.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Travelkeep extends User {
    private String tkid;

    private String tktitle;

    private String tkdestination;

    private Date tkbegintime;

    private Date tkaftertime;

    private String tkimg;
    
	private Date tktime;

    private String tkphone;

    private String tkdetails;

    public String getTkimg() {
 		return tkimg;
 	}

 	public void setTkimg(String tkimg) {
 		this.tkimg = tkimg;
 	}
    
    public String getTkid() {
        return tkid;
    }

    public void setTkid(String tkid) {
        this.tkid = tkid == null ? null : tkid.trim();
    }

    public String getTktitle() {
        return tktitle;
    }

    public void setTktitle(String tktitle) {
        this.tktitle = tktitle == null ? null : tktitle.trim();
    }

    public String getTkdestination() {
        return tkdestination;
    }

    public void setTkdestination(String tkdestination) {
        this.tkdestination = tkdestination == null ? null : tkdestination.trim();
    }

    public Date getTkbegintime() {
        return tkbegintime;
    }

    public void setTkbegintime(Date tkbegintime) {
        this.tkbegintime = tkbegintime;
    }

    public Date getTkaftertime() {
        return tkaftertime;
    }

    public void setTkaftertime(Date tkaftertime) {
        this.tkaftertime = tkaftertime;
    }


    public Date getTktime() {
        return tktime;
    }

    public void setTktime(Date tktime) {
        this.tktime = tktime;
    }

    public String getTkphone() {
        return tkphone;
    }

    public void setTkphone(String tkphone) {
        this.tkphone = tkphone == null ? null : tkphone.trim();
    }

    public String getTkdetails() {
        return tkdetails;
    }

    public void setTkdetails(String tkdetails) {
        this.tkdetails = tkdetails == null ? null : tkdetails.trim();
    }
}