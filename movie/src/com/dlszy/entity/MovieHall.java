package com.dlszy.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class MovieHall implements Serializable{
	/**
	 * hname 影厅名称
	 * hnum 影厅容量
	 * hstate 影厅状态
	 */
  private Integer hid;
  private String hname;
  private Integer hnum;
  private String hstate;
  private List<Seat> seats;
public MovieHall() {
	this.hid=0;
	this.hnum=0;
	this.seats=new ArrayList<Seat>();
}
public MovieHall(String hname, Integer hnum, String hstate) {
	this();
	this.hname = hname;
	this.hnum = hnum;
	this.hstate = hstate;
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
public Integer getHnum() {
	return hnum;
}
public void setHnum(Integer hnum) {
	this.hnum = hnum;
}
public String getHstate() {
	return hstate;
}
public void setHstate(String hstate) {
	this.hstate = hstate;
}
public List<Seat> getSeats() {
	return seats;
}
public void setSeats(List<Seat> seats) {
	this.seats = seats;
}
@Override
public String toString() {
	return "MovieHall [hid=" + hid + ", hname=" + hname + ", hnum=" + hnum
			+ ", hstate=" + hstate + ", seats=" + seats + "]";
} 
}
