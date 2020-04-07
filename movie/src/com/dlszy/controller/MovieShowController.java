package com.dlszy.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dlszy.entity.Movie;
import com.dlszy.entity.MovieHall;
import com.dlszy.entity.MovieHallMovieTime;
import com.dlszy.entity.Page;
import com.dlszy.entity.Time;
import com.dlszy.service.MovieShowService;
@Controller
public class MovieShowController {
	@Autowired
	private MovieShowService movieShowService;
	@RequestMapping("getAll")
	@ResponseBody
	public List<MovieHallMovieTime> getAll(){
		return movieShowService.findAll();
	}
	@RequestMapping("getAllPage")
	@ResponseBody
	public Page<MovieHallMovieTime> getAllPage(HttpServletRequest request){
		int currentPage=1;
		if(request.getParameter("currentPage")!=null){
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		int pageSize=5;
		if(request.getParameter("pageSize")!=null){
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
		}
		String condition="";
		if(request.getParameter("condition")!=null){
			condition = request.getParameter("condition");
		}
		Page<MovieHallMovieTime> page= movieShowService.findByPage(currentPage, pageSize, condition);
		System.out.println(page);
		return page;
	}
	@RequestMapping("getOne")
	@ResponseBody
	public MovieHallMovieTime getOne(int sid){
		return movieShowService.findById(sid);
	}
	@RequestMapping("deleteMsg")
	@ResponseBody
	public String deleteMsg(int scode){
		return movieShowService.deleteMsg(scode);
	}
	@RequestMapping("findAllHall")
	@ResponseBody
	public List<MovieHall> findAllMovieHall(){
		return movieShowService.findAllMovieHall();
	}
	@RequestMapping("findByName")
	@ResponseBody
	public List<MovieHallMovieTime> findByName(String userName){
		return movieShowService.findByName(userName);
	}
	@RequestMapping("findByHall")
	@ResponseBody
	public List<MovieHallMovieTime> findByHall(String hall){
		return movieShowService.findByHall(hall);
	}
	@RequestMapping("findByNameAndHall")
	@ResponseBody
	public List<MovieHallMovieTime> findByNameAndHall(String mname, String hname){
		return movieShowService.findByNameAndHall(mname, hname);
	}
	@RequestMapping("findAllMovie")
	@ResponseBody
	public List<Movie> findAllMovie(){
		return movieShowService.findAllMovie();
	}
	@RequestMapping("findAllTime")
	@ResponseBody
	public List<Time> findAllTime(){
		return movieShowService.findAllTime();
	}
	@RequestMapping("checkTime")
	@ResponseBody
	public String checkTime(String hname){
		return movieShowService.check(hname);
	}
	@RequestMapping("addMovieHallTime")
	@ResponseBody
	public String addMovieHallTime(String mname, String hname, String timespace){
		return movieShowService.addMovieHallTime(mname, hname, timespace);
	}
	@RequestMapping("updateMsg")
	@ResponseBody
	public String updateMsg(String mname, String hname, String timespace,
			int m_m_id) {
		return movieShowService.updateMsg(mname, hname, timespace, m_m_id);
	}
	@RequestMapping("movieshow")
	public ModelAndView test(){
		ModelAndView modelAndView = new ModelAndView("movieshow");
		return modelAndView;
	}
}
