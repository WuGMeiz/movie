package com.dlszy.dao;
import java.util.List;

import com.dlszy.entity.Movie;
import com.dlszy.entity.MovieHall;
import com.dlszy.entity.Page;
public interface MovieHallDao {
	public abstract List<MovieHall> findAll();
	public abstract Page<MovieHall> findByPage(int currentPage, int pageSize);
	public abstract MovieHall findById(int hid);
	public abstract void doAdd(MovieHall movieHall);
	public abstract void doDelete(int hid);
	public abstract void doUpdate(MovieHall movieHall);
}
