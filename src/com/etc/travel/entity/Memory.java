package com.etc.travel.entity;

public class Memory extends User{
	
	private String tmid;
	private String tmtitle;
	private int memorytypeid;
	private String tmimg;
	private String tmtime;
	private String tmcontent;
	
	public String getTmid() {
		return tmid;
	}
	public void setTmid(String tmid) {
		this.tmid = tmid;
	}
	public String getTmtitle() {
		return tmtitle;
	}
	public void setTmtitle(String tmtitle) {
		this.tmtitle = tmtitle;
	}
	public int getMemorytypeid() {
		return memorytypeid;
	}
	public void setMemorytypeid(int memorytypeid) {
		this.memorytypeid = memorytypeid;
	}
	public String getTmimg() {
		return tmimg;
	}
	public void setTmimg(String tmimg) {
		this.tmimg = tmimg;
	}
	public String getTmtime() {
		return tmtime;
	}
	public void setTmtime(String tmtime) {
		this.tmtime = tmtime;
	}
	public String getTmcontent() {
		return tmcontent;
	}
	public void setTmcontent(String tmcontent) {
		this.tmcontent = tmcontent;
	}
	@Override
	public String toString() {
		return "Memory [tmid=" + tmid + ", tmtitle=" + tmtitle
				+ ", memorytypeid=" + memorytypeid + ", tmimg=" + tmimg
				+ ", tmtime=" + tmtime + ", tmcontent=" + tmcontent + "]";
	}
	
}
