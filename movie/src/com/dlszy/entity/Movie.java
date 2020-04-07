package com.dlszy.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
public class Movie implements Serializable{
  private Integer mid;
  private String mname;
  private String mpic;
  private String mcountry;
  private String mauthor;
  private Double mprice;
  private String mactor;
  private Date mdate;
  private String mstate;
  private List<MovieHall> movieHalls;
public Movie() {
	this.mid=0;
	this.mprice=0.0;
	this.movieHalls=new ArrayList<MovieHall>();
}

public Movie(String mname, String mcountry, String mauthor, Double mprice,
		String mactor, Date mdate, String mstate) {
	this();
	this.mname = mname;
	this.mcountry = mcountry;
	this.mauthor = mauthor;
	this.mprice = mprice;
	this.mactor = mactor;
	this.mdate = mdate;
	this.mstate = mstate;
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
public String getMpic() {
	return mpic;
}
public void setMpic(String mpic) {
	this.mpic = mpic;
}
public String getMcountry() {
	return mcountry;
}
public void setMcountry(String mcountry) {
	this.mcountry = mcountry;
}
public String getMauthor() {
	return mauthor;
}
public void setMauthor(String mauthor) {
	this.mauthor = mauthor;
}
public Double getMprice() {
	return mprice;
}
public void setMprice(Double mprice) {
	this.mprice = mprice;
}
public String getMactor() {
	return mactor;
}
public void setMactor(String mactor) {
	this.mactor = mactor;
}
public Date getMdate() {
	return mdate;
}
public void setMdate(Date mdate) {
	this.mdate = mdate;
}
public String getMstate() {
	return mstate;
}
public void setMstate(String mstate) {
	this.mstate = mstate;
}
public List<MovieHall> getMovieHalls() {
	return movieHalls;
}
public void setMovieHalls(List<MovieHall> movieHalls) {
	this.movieHalls = movieHalls;
}
@Override
public String toString() {
	return "Movie [mid=" + mid + ", mname=" + mname + ", mpic=" + mpic
			+ ", mcountry=" + mcountry + ", mauthor=" + mauthor + ", mprice="
			+ mprice + ", mactor=" + mactor + ", mdate=" + mdate + ", mstate="
			+ mstate + ", movieHalls=" + movieHalls + "]";
} 
}
