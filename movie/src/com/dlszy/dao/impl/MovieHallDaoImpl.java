package com.dlszy.dao.impl;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dlszy.dao.MovieHallDao;
import com.dlszy.entity.Movie;
import com.dlszy.entity.MovieHall;
import com.dlszy.entity.Page;
@Repository
public class MovieHallDaoImpl implements MovieHallDao{
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	public List<MovieHall> findAll() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<MovieHall> movieHalls = sqlSession.selectList("MovieHall.findAll");
		return movieHalls;
	}

	public MovieHall findById(int hid) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MovieHall movieHall = sqlSession.selectOne("MovieHall.findById",hid);
		return movieHall;
	}

	public void doAdd(MovieHall movieHall) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("MovieHall.doAdd",movieHall);
	
	}

	public void doDelete(int hid) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("MovieHall.doDelete",hid);
	
	}

	public void doUpdate(MovieHall movieHall) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("MovieHall.doUpdate",movieHall);
	}

	public Page<MovieHall> findByPage(int currentPage, int pageSize) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		Page<MovieHall> page=null;
		List<MovieHall> movieHalls=new ArrayList<MovieHall>();
		int totalNum=sqlSession.selectOne("MovieHall.count");
		//System.out.println("------"+totalNum);
		int beginIndex=(currentPage-1)*pageSize;
		int totalPage=(totalNum % pageSize==0)?totalNum/pageSize:totalNum/pageSize+1;
		int[] arr={beginIndex,pageSize};
		movieHalls=sqlSession.selectList("MovieHall.movieHallListByPage", arr);
		page=new Page<MovieHall>(totalNum,pageSize,totalPage,currentPage,movieHalls);
		return page;
	}

}
