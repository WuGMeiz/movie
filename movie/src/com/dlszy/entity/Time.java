package com.dlszy.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Time implements Serializable{
  private Integer tid;
  private String timespace;
public Time() {
	this.tid=0;
}
public Time(String timespace) {
	this();
	this.timespace = timespace;
}
public Integer getTid() {
	return tid;
}
public void setTid(Integer tid) {
	this.tid = tid;
}
public String getTimespace() {
	return timespace;
}
public void setTimespace(String timespace) {
	this.timespace = timespace;
}
@Override
public String toString() {
	return "Time [tid=" + tid + ", timespace=" + timespace + "]";
}
}
