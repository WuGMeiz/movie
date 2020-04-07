package com.dlszy.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Time2 implements Serializable{
	  private Integer tid2;
	  private String timespace2;
	public Time2() {
		this.tid2=0;
	}
	public Time2(String timespace2) {
		this();
		this.timespace2 = timespace2;
	}
	public Integer getTid2() {
		return tid2;
	}
	public void setTid2(Integer tid2) {
		this.tid2 = tid2;
	}
	public String getTimespace2() {
		return timespace2;
	}
	public void setTimespace2(String timespace2) {
		this.timespace2 = timespace2;
	}
	@Override
	public String toString() {
		return "Time [tid2=" + tid2 + ", timespace2=" + timespace2 + "]";
	}
}
