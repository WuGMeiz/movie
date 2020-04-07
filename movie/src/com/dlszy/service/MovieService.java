package com.dlszy.service;

import java.util.List;

import com.dlszy.entity.Movie;
import com.dlszy.entity.Page;

public interface MovieService {
	public abstract List<Movie> findAll();
	public abstract Page<Movie> findByPage(int currentPage, int pageSize, String condition);
	public abstract Movie findById(int id);
	public abstract void doDelMovie(int id);
	public abstract void doAddMovie(Movie movie);
	public abstract void doUpdateMovie(Movie movie);
}
