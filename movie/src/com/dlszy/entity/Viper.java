package com.dlszy.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Viper implements Serializable{
   private Integer vid;
   private String vname;
   private String vtel;
   private String vcard;
   private String vstate;
public Viper() {
	this.vid=0;
}
public Viper(String vname, String vtel, String vcard,String vstate) {
	this();
	this.vname = vname;
	this.vtel = vtel;
	this.vcard = vcard;
	this.vstate = vstate;
}
public String getVstate() {
	return vstate;
}
public void setVstate(String vstate) {
	this.vstate = vstate;
}
public Integer getVid() {
	return vid;
}
public void setVid(Integer vid) {
	this.vid = vid;
}
public String getVname() {
	return vname;
}
public void setVname(String vname) {
	this.vname = vname;
}
public String getVtel() {
	return vtel;
}
public void setVtel(String vtel) {
	this.vtel = vtel;
}
public String getVcard() {
	return vcard;
}
public void setVcard(String vcard) {
	this.vcard = vcard;
}
@Override
public String toString() {
	return "Viper [vid=" + vid + ", vname=" + vname + ", vtel=" + vtel
			+ ", vcard=" + vcard + ", vstate=" + vstate + "]";
}

}
