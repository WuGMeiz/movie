package com.dlszy.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Seat implements Serializable{
	/**
	 * srow 第几列
	 * sline 第几行
	 * sstate 座位状态（0-未出售  1-会员 2-普通用户购票）
	 */
	private Integer sid;
	private Integer sline;
	private Integer srow;
	private List<MovieHall> movieHalls;
	public Seat() {
		this.sid=0;
		this.sline=0;
		this.srow=0;
		this.movieHalls=new ArrayList<MovieHall>();
	}
	public Seat(Integer srow, Integer sline) {
		this();
		this.srow = srow;
		this.sline = sline;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getSrow() {
		return srow;
	}
	public void setSrow(Integer srow) {
		this.srow = srow;
	}
	public Integer getSline() {
		return sline;
	}
	public void setSline(Integer sline) {
		this.sline = sline;
	}
	public List<MovieHall> getMovieHalls() {
		return movieHalls;
	}
	public void setMovieHalls(List<MovieHall> movieHalls) {
		this.movieHalls = movieHalls;
	}
	@Override
	public String toString() {
		return "Seat [sid=" + sid + ", sline=" + sline + ", srow=" + srow
				+ "]";
	}
}


