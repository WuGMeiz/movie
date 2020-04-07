package com.dlszy.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dlszy.dao.MovieDao;
import com.dlszy.entity.Movie;
import com.dlszy.entity.Page;
@Repository
public class MovieDaoImpl implements MovieDao{
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	public List<Movie> findAll() {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		 List<Movie> movies=sqlSession.selectList("Movie.findAll");
		return movies;
	}
	public void doDelMovie(int id) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		sqlSession.delete("Movie.doDel",id);
		sqlSession.commit();
	}
	public void doAddMovie(Movie movie) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		sqlSession.insert("Movie.doAdd",movie);
		sqlSession.commit();
	}
	public void doUpdateMovie(Movie movie) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		sqlSession.update("Movie.doUpdate",movie);
		sqlSession.commit();
		
	}
	public Movie findById(int id) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		 Movie movie=sqlSession.selectOne("Movie.findbyid",id);
		return movie;
	}
	public Page<Movie> findByPage(int currentPage, int pageSize,
			String condition) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		Page<Movie> page=null;
		List<Movie> movies=new ArrayList<Movie>();
		int totalNum=sqlSession.selectOne("Movie.count",condition.trim());
		int beginIndex=(currentPage-1)*pageSize;
		int totalPage=(totalNum % pageSize==0)?totalNum/pageSize:totalNum/pageSize+1;
		Object[] arr={beginIndex,pageSize,condition};
		movies=sqlSession.selectList("Movie.findMovieListByPage", arr);
		page=new Page<Movie>(totalNum,pageSize,totalPage,currentPage,movies);
		return page;
	}

}
