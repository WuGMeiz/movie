package com.dlszy.entity;
import java.io.Serializable;
import java.util.List;
@SuppressWarnings("serial")
public class User implements Serializable{
	private Integer uid;
	private String uname;
	private String upsw;
	private String realName;
	private String sex;
	private String tel;
	private String email;
	private Role role;
	public User() {
		this.uid=0;
	}
	public User(String uname, String upsw, String realName, String sex,
			String tel, String email, Role role) {
		this();
		this.uname = uname;
		this.upsw = upsw;
		this.realName = realName;
		this.sex = sex;
		this.tel = tel;
		this.email = email;
		this.role = role;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpsw() {
		return upsw;
	}
	public void setUpsw(String upsw) {
		this.upsw = upsw;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", upsw=" + upsw
				+ ", realName=" + realName + ", sex=" + sex + ", tel=" + tel
				+ ", email=" + email + ", role=" + role + "]";
	}
}