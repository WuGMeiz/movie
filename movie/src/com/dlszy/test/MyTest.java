package com.dlszy.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.dlszy.entity.MovieHallMovieTime;

public class MyTest {
    @Test
	public void test1() throws IOException{
    	InputStream inputStream= Resources.getResourceAsStream("Configuration.xml");
	    SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
	    SqlSession sqlSession= sqlSessionFactory.openSession();
	    List<MovieHallMovieTime> movies= sqlSession.selectList("MovieHallMovieTime.findAll");
	    System.out.println(movies.size());
	    for (MovieHallMovieTime movieHallMovieTime : movies) {
			System.out.println(movieHallMovieTime.getMovie().getMname()+"--"+movieHallMovieTime.getMovieHall().getHname()+"--"+movieHallMovieTime.getTime().getTimespace());
		}
	   /* List<Movie> movies=sqlSession.selectList("Movie.findAll");
	    for (Movie movie : movies) {
			System.out.println(movie.getMname());
			for (MovieHall movieHall : movie.getMovieHalls()) {
				System.out.println(movieHall.getHname());
			}
		}*/
	}
}
