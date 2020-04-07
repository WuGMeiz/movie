package com.dlszy.dao;

import java.util.List;

import com.dlszy.entity.MovieHallSeat;
import com.dlszy.entity.MovieTotal;
import com.dlszy.entity.Nothing;

public interface NothingDao {
	public abstract List<Nothing> getAllNothing();
	public abstract int getSeatNum(int hid,int tid2,double price);
	public abstract MovieTotal findByMtname(String mtname);
	public abstract boolean addmovietotal(MovieTotal movieTotal);
	public abstract boolean updatemovietotal(MovieTotal movieTotal);
	public abstract List<MovieTotal> findAll();
	public abstract boolean updateState();
	public abstract List<MovieHallSeat> findAllSeat();
	public abstract boolean updateState2(Object[] objs);
}
