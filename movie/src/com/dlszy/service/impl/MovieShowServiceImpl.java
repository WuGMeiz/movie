package com.dlszy.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlszy.dao.MovieShowDao;
import com.dlszy.entity.Movie;
import com.dlszy.entity.MovieHall;
import com.dlszy.entity.MovieHallMovieTime;
import com.dlszy.entity.Page;
import com.dlszy.entity.Time;
import com.dlszy.service.MovieShowService;
@Service
public class MovieShowServiceImpl implements MovieShowService{
	@Autowired
	private MovieShowDao movieShowDao;
	public List<MovieHallMovieTime> findAll() {
		return movieShowDao.findAll();
	}
	public MovieHallMovieTime findById(int m_m_id) {
		return movieShowDao.findById(m_m_id);
	}
	public String deleteMsg(int m_m_id) {
		return movieShowDao.deleteMsg(m_m_id);
	}
	public List<MovieHall> findAllMovieHall() {
		return movieShowDao.findAllMovieHall();
	}
	public List<MovieHallMovieTime> findByName(String mname) {
		return movieShowDao.findByName(mname);
	}
	public List<MovieHallMovieTime> findByHall(String hname) {
		return movieShowDao.findByHall(hname);
	}
	public List<MovieHallMovieTime> findByNameAndHall(String mname, String hname) {
		return movieShowDao.findByNameAndHall(mname, hname);
	}
	public List<Movie> findAllMovie() {
		return movieShowDao.findAllMovie();
	}
	public List<Time> findAllTime() {
		return movieShowDao.findAllTime();
	}
	public String check(String hname) {
		return movieShowDao.check(hname);
	}
	public String addMovieHallTime(String mname, String hname, String timespace) {
		return movieShowDao.addMovieHallTime(mname, hname, timespace);
	}
	public String updateMsg(String mname, String hname, String timespace,
			int m_m_id) {
		return movieShowDao.updateMsg(mname, hname, timespace, m_m_id);
	}
	public Page<MovieHallMovieTime> findByPage(int currentPage, int pageSize,
			String condition) {
		return movieShowDao.findByPage(currentPage, pageSize, condition);
	}
}
