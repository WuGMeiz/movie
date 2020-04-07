package com.dlszy.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlszy.dao.MovieHallDao;
import com.dlszy.entity.MovieHall;
import com.dlszy.entity.Page;
import com.dlszy.service.MovieHallService;
@Service
public class MovieHallServiceImpl implements MovieHallService{
	@Autowired
	private MovieHallDao movieHallDao;
	public List<MovieHall> findAll() {
		return movieHallDao.findAll();
	}
	public MovieHall findById(int hid) {
		return movieHallDao.findById(hid);
	}

	public void doAdd(MovieHall movieHall) {
		movieHallDao.doAdd(movieHall);
	}

	public void doDelete(int hid) {
		movieHallDao.doDelete(hid);
	}

	public void doUpdate(MovieHall movieHall) {
		movieHallDao.doUpdate(movieHall);
	}
	public Page<MovieHall> findByPage(int currentPage, int pageSize) {
		return movieHallDao.findByPage(currentPage, pageSize);
	}

}
