package com.dlszy.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MovieTotal implements Serializable{
   private Integer mcid;
   private String mtime;
   private Integer mtotal;
   private String mtname;
public MovieTotal() {
	this.mcid=0;
}
public MovieTotal(String mtime, Integer mtotal,String mtname) {
	this();
	this.mtime = mtime;
	this.mtotal = mtotal;
	this.mtname=mtname;
}
public String getMtname() {
	return mtname;
}
public void setMtname(String mtname) {
	this.mtname = mtname;
}
public Integer getMcid() {
	return mcid;
}
public void setMcid(Integer mcid) {
	this.mcid = mcid;
}
public String getMtime() {
	return mtime;
}
public void setMtime(String mtime) {
	this.mtime = mtime;
}
public Integer getMtotal() {
	return mtotal;
}
public void setMtotal(Integer mtotal) {
	this.mtotal = mtotal;
}
@Override
public String toString() {
	return "MovieTotal [mcid=" + mcid + ", mtime=" + mtime + ", mtotal="
			+ mtotal + ", mtname=" + mtname + "]";
}

}
