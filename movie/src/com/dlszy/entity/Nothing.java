package com.dlszy.entity;

public class Nothing {
	private Integer mid;
	private String mname;
	private Integer hid;
	private String hname;
	private Integer tid;
	private Integer mprice;
	public Nothing() {
		this.mid=0;
		this.hid=0;
		this.tid=0;
		this.mprice=0;
	}
	public Nothing(Integer mid, String mname, Integer hid, String hname,
			Integer tid, Integer mprice) {
		this();
		this.mid = mid;
		this.mname = mname;
		this.hid = hid;
		this.hname = hname;
		this.tid = tid;
		this.mprice = mprice;
	}
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public Integer getHid() {
		return hid;
	}
	public void setHid(Integer hid) {
		this.hid = hid;
	}
	public String getHname() {
		return hname;
	}
	public void setHname(String hname) {
		this.hname = hname;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public Integer getMprice() {
		return mprice;
	}
	public void setMprice(Integer mprice) {
		this.mprice = mprice;
	}
	@Override
	public String toString() {
		return "Nothing [mid=" + mid + ", mname=" + mname + ", hid=" + hid
				+ ", hname=" + hname + ", tid=" + tid + ", mprice=" + mprice
				+ "]";
	}
	
}
