package com.dlszy.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MovieHallSeat implements Serializable{
  private Integer h_s_id;
  private MovieHall movieHall;
  private Seat seat;
  private String h_s_state;
  private Time2 time2;
public MovieHallSeat() {
	this.h_s_id=0;
}
public MovieHallSeat(MovieHall movieHall, Seat seat, String h_s_state,
		Time2 time2) {
	this();
	this.movieHall = movieHall;
	this.seat = seat;
	this.h_s_state = h_s_state;
	this.time2 = time2;
}


public Integer getH_s_id() {
	return h_s_id;
}
public void setH_s_id(Integer h_s_id) {
	this.h_s_id = h_s_id;
}
public MovieHall getMovieHall() {
	return movieHall;
}
public void setMovieHall(MovieHall movieHall) {
	this.movieHall = movieHall;
}
public Seat getSeat() {
	return seat;
}
public void setSeat(Seat seat) {
	this.seat = seat;
}

public String getH_s_state() {
	return h_s_state;
}

public void setH_s_state(String h_s_state) {
	this.h_s_state = h_s_state;
}

public Time2 getTime2() {
	return time2;
}
public void setTime2(Time2 time2) {
	this.time2 = time2;
}
@Override
public String toString() {
	return "MovieHallSeat [h_s_id=" + h_s_id + ", movieHall=" + movieHall
			+ ", seat=" + seat + ", h_s_state=" + h_s_state + ", time2="
			+ time2 + "]";
}
}
