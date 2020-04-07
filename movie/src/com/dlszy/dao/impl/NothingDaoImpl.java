package com.dlszy.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.dlszy.dao.NothingDao;
import com.dlszy.entity.MovieHallSeat;
import com.dlszy.entity.MovieTotal;
import com.dlszy.entity.Nothing;

@Repository
public class NothingDaoImpl implements NothingDao {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	public List<Nothing> getAllNothing() {
		SqlSession session = sqlSessionFactory.openSession();
		List<Nothing> list = new ArrayList<Nothing>();
		list = session.selectList("MovieHallMovieTime.findallmovie_moviehall_time");
		return list;
	}
	public int getSeatNum(int hid, int tid2,double mprice) {
		SqlSession session = sqlSessionFactory.openSession();
		Object[] objs = {hid,tid2};
		int seat = session.selectOne("MovieHallSeat.findseat",objs);
		System.out.println("++++++++++++++++++"+seat);
		int seatvip = session.selectOne("MovieHallSeat.findseatvip",objs);
		System.out.println("++++++++++++++++++"+seatvip);
		int totle = (int) (seat*mprice+seatvip*mprice*0.8);
		return totle;
	}
	public MovieTotal findByMtname(String mtname) {
		SqlSession session = sqlSessionFactory.openSession();
		MovieTotal mt = session.selectOne("MovieHallTotal.findByMtname", mtname);
		return mt;
	}
	public boolean addmovietotal(MovieTotal movieTotal) {
		SqlSession session = sqlSessionFactory.openSession();
		session.insert("MovieHallTotal.addmovietotal",movieTotal);
		return true;
	}
	public boolean updatemovietotal(MovieTotal movieTotal) {
		SqlSession session = sqlSessionFactory.openSession();
		session.update("MovieHallTotal.updatemovietotal", movieTotal);
		return true;
	}
	public List<MovieTotal> findAll() {
		SqlSession session = sqlSessionFactory.openSession();
		List<MovieTotal> list = session.selectList("MovieHallTotal.findAll");
		return list;
	}
	public boolean updateState() {
		SqlSession session = sqlSessionFactory.openSession();
		session.update("updateState");
		return true;
	}
	public List<MovieHallSeat> findAllSeat() {
		List<MovieHallSeat> list = new ArrayList<MovieHallSeat>();
		SqlSession session = sqlSessionFactory.openSession();
		list = session.selectList("findAllSeat");
		session.close();
		return list;
	}
	public boolean updateState2(Object[] objs) {
		SqlSession session = sqlSessionFactory.openSession();
		session.update("updateState2", objs);
		session.close();
		return false;
	}
}
