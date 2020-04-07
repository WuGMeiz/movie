package com.dlszy.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@SuppressWarnings("serial")
public class Limit implements Serializable{
	
	private Integer lid;
	private String lname;
	private String url;
	private List<Role> roles;
	public Limit() {
		this.lid=0;
		this.roles=new ArrayList<Role>();
	}
	public Integer getLid() {
		return lid;
	}
	public void setLid(Integer lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "Limit [lid=" + lid + ", lname=" + lname + ", url=" + url + "]";
	}
}
