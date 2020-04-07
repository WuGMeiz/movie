package com.dlszy.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dlszy.dao.MovieShowDao;
import com.dlszy.entity.Movie;
import com.dlszy.entity.MovieHall;
import com.dlszy.entity.MovieHallMovieTime;
import com.dlszy.entity.Page;
import com.dlszy.entity.Time;
@Repository
public class MovieShowDaoImpl implements MovieShowDao{
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	//查询全部
	public List<MovieHallMovieTime> findAll() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<MovieHallMovieTime> hallMovieTimes = sqlSession.selectList("MovieHallMovieTime.findAll");
		return hallMovieTimes;
	}
	public Page<MovieHallMovieTime> findByPage(int currentPage, int pageSize,
			String condition) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		Page<MovieHallMovieTime> page=null;
		List<MovieHallMovieTime> movies=new ArrayList<MovieHallMovieTime>();
		int totalNum=sqlSession.selectOne("MovieHallMovieTime.count");
		int beginIndex=(currentPage-1)*pageSize;
		int totalPage=(totalNum % pageSize==0)?totalNum/pageSize:totalNum/pageSize+1;
		Object[] arr={beginIndex,pageSize};
		movies=sqlSession.selectList("MovieHallMovieTime.findByPage", arr);
		page=new Page<MovieHallMovieTime>(totalNum,pageSize,totalPage,currentPage,movies);
		return page;
	}
	//单个查询（修改）
	public MovieHallMovieTime findById(int m_m_id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MovieHallMovieTime hallMovieTime = sqlSession.selectOne("MovieHallMovieTime.findById",m_m_id);
		return hallMovieTime;
	}
	
	//删除操作
	public String deleteMsg(int m_m_id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int num = sqlSession.delete("MovieHallMovieTime.deleteMsg",m_m_id);
		if(num>0){
			return "删除成功..";
		}
		return "删除失败..";
	}

	//查询全部影厅
	public List<MovieHall> findAllMovieHall() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<MovieHall> movieHalls = sqlSession.selectList("MovieHall.findAllMovieHall");
		return movieHalls;
	}
	
	//通过影片名查询排片情况
	public List<MovieHallMovieTime> findByName(String mname) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<MovieHallMovieTime> hallMovieTimes = sqlSession.selectList("MovieHallMovieTime.findByName",mname);
		return hallMovieTimes;
	}

	//通过影厅查询影片排片情况
	public List<MovieHallMovieTime> findByHall(String hname) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<MovieHallMovieTime> hallMovieTimes = sqlSession.selectList("MovieHallMovieTime.findByHall",hname);
		return hallMovieTimes;
	}

	//通过片名、影厅共同查询拍片情况
	public List<MovieHallMovieTime> findByNameAndHall(String mname, String hname) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		String[] strs = {mname,hname};
		List<MovieHallMovieTime> hallMovieTimes = sqlSession.selectList("MovieHallMovieTime.findByNameAndHall",strs);
		return hallMovieTimes;
	}

	//查询全部影片
	public List<Movie> findAllMovie() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Movie> movies = sqlSession.selectList("Movie.findAllMovies");
		return movies;
	}

	//查询全部时间段
	public List<Time> findAllTime() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Time> times = sqlSession.selectList("Time.findAllTime");
		return times;
	}

	//检查时间
	public String check(String hname) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<MovieHallMovieTime> hallMovieTimes = sqlSession.selectList("MovieHallMovieTime.findByHall",hname);
		List<String> movieTimes = new ArrayList<String>();
		for (int i = 0; i < hallMovieTimes.size(); i++) {
			movieTimes.add(hallMovieTimes.get(i).getTime().getTimespace());
		}
		List<Time> allTimes = sqlSession.selectList("Time.findAllTime");
		List<String> times = new ArrayList<String>();;
		for (Time time : allTimes) {
			times.add(time.getTimespace());
		}
		movieTimes.retainAll(times);
    	String html="";
    	for(String time : times){
    		if(movieTimes.contains(time)){
    			html+="<option value='"+time+"' disabled='disabled' style='color: red;'>"+time+"</option>";
    		}else{
    			html+="<option value='"+time+"'>"+time+"</option>";
    		}
    	}
		return html;
	}

	//新增拍片
	public String addMovieHallTime(String mname, String hname, String timespace) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Movie movie = sqlSession.selectOne("Movie.findByName",mname);
		int mid = movie.getMid();
		MovieHall movieHall = sqlSession.selectOne("MovieHall.findByName",hname);
		int hid = movieHall.getHid();
		Time time = sqlSession.selectOne("Time.findByName",timespace);
		int tid = time.getTid();
		int[] strs = {mid,hid,tid};
		int num = sqlSession.insert("MovieHallMovieTime.addMovieHallTime", strs);
		if(num>0){
			return "添加成功...";
		}
		return "添加失败...";
	}

	public String updateMsg(String mname, String hname, String timespace, int m_m_id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Movie movie = sqlSession.selectOne("Movie.findByName",mname);
		int mid = movie.getMid();
		MovieHall movieHall = sqlSession.selectOne("MovieHall.findByName",hname);
		int hid = movieHall.getHid();
		Time time = sqlSession.selectOne("Time.findByName",timespace);
		int tid = time.getTid();
		int[] strs = {mid,hid,tid,m_m_id};
		int num = sqlSession.insert("MovieHallMovieTime.updateMsg", strs);
		if(num>0){
			return "修改成功...";
		}
		return "修改失败...";
	}

	
}
