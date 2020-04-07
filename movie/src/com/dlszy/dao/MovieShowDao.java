package com.dlszy.dao;

import java.util.List;

import com.dlszy.entity.Movie;
import com.dlszy.entity.MovieHall;
import com.dlszy.entity.MovieHallMovieTime;
import com.dlszy.entity.Page;
import com.dlszy.entity.Time;

public interface MovieShowDao {
	public abstract List<MovieHallMovieTime> findAll();
	public abstract Page<MovieHallMovieTime> findByPage(int currentPage, int pageSize,String condition);
	public abstract MovieHallMovieTime findById(int m_m_id);
	public abstract String deleteMsg(int m_m_id);
	public abstract List<MovieHall> findAllMovieHall();
	public abstract List<Movie> findAllMovie();
	public abstract List<Time> findAllTime();
	public abstract List<MovieHallMovieTime> findByName(String mname);
	public abstract List<MovieHallMovieTime> findByHall(String hname);
	public abstract List<MovieHallMovieTime> findByNameAndHall(String mname, String hname);
	public abstract String check(String hname);
	public abstract String addMovieHallTime(String mname, String hname, String timespace);
	public abstract String updateMsg(String mname, String hname, String timespace, int m_m_id);
}
