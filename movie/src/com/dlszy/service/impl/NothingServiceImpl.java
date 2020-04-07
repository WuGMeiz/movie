package com.dlszy.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dlszy.dao.impl.NothingDaoImpl;
import com.dlszy.entity.MovieHallSeat;
import com.dlszy.entity.MovieTotal;
import com.dlszy.entity.Nothing;
import com.dlszy.service.NothingService;
@Service
public class NothingServiceImpl implements NothingService {
	@Autowired
	private NothingDaoImpl nothingDaoImpl;
	public List<Nothing> getAllNothing() {
		List<Nothing> list = new ArrayList<Nothing>();
		list = nothingDaoImpl.getAllNothing();
		return list;
	}
	public int getSeatNum(int hid, int tid2, double price) {
		return nothingDaoImpl.getSeatNum(hid, tid2, price);
	}
	public MovieTotal findByMtname(String mtname) {
		return nothingDaoImpl.findByMtname(mtname);
	}
	public boolean addmovietotal(MovieTotal movieTotal) {
		return nothingDaoImpl.addmovietotal(movieTotal);
	}
	public boolean updatemovietotal(MovieTotal movieTotal) {
		return nothingDaoImpl.updatemovietotal(movieTotal);
	}
	public List<MovieTotal> findAll() {
		return nothingDaoImpl.findAll();
	}
	public boolean updateState() {
		return nothingDaoImpl.updateState();
	}
	
	public List<MovieHallSeat> findAllSeat() {
		return nothingDaoImpl.findAllSeat();
	}

	public boolean updateState2(Object[] objs) {
		return nothingDaoImpl.updateState2(objs);
	}
}
