package com.dlszy.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MovieHallMovieTime implements Serializable{
	/**
	 *  影厅、影片、时间表
	 */
   private Integer m_m_id;
   private Movie movie;
   private MovieHall movieHall;
   private Time time;
public MovieHallMovieTime() {
	this.m_m_id=0;
}
public Integer getM_m_id() {
	return m_m_id;
}
public void setM_m_id(Integer m_m_id) {
	this.m_m_id = m_m_id;
}
public Movie getMovie() {
	return movie;
}
public void setMovie(Movie movie) {
	this.movie = movie;
}
public MovieHall getMovieHall() {
	return movieHall;
}
public void setMovieHall(MovieHall movieHall) {
	this.movieHall = movieHall;
}
public Time getTime() {
	return time;
}
public void setTime(Time time) {
	this.time = time;
}
@Override
public String toString() {
	return "MovieHallMovieTime [m_m_id=" + m_m_id + ", movie=" + movie
			+ ", movieHall=" + movieHall + ", time=" + time + "]";
}  
}
