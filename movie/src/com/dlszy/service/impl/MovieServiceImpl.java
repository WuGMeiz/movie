package com.dlszy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlszy.dao.MovieDao;
import com.dlszy.entity.Movie;
import com.dlszy.entity.Page;
import com.dlszy.service.MovieService;
@Service
public class MovieServiceImpl implements MovieService{
	@Autowired
	private MovieDao movieDao;
	public List<Movie> findAll() {
		return movieDao.findAll();
	}
	public void doDelMovie(int id) {
		movieDao.doDelMovie(id);
	}
	public void doAddMovie(Movie movie) {
		movieDao.doAddMovie(movie);
	}
	public void doUpdateMovie(Movie movie) {
		movieDao.doUpdateMovie(movie);
		
	}
	public Movie findById(int id) {
		return movieDao.findById(id);
	}
	public Page<Movie> findByPage(int currentPage, int pageSize,
			String condition) {
		return movieDao.findByPage(currentPage, pageSize, condition);
	}

}
