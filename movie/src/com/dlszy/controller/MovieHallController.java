package com.dlszy.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dlszy.entity.MovieHall;
import com.dlszy.entity.Page;
import com.dlszy.service.MovieHallService;
@Controller
public class MovieHallController {
	@Autowired
	private MovieHallService movieHallService;
	/*@RequestMapping("moviehallList")
	@ResponseBody
	public List<MovieHall> modelAndView(){
		 System.out.println(movieHallService.findAll().size());
		return movieHallService.findAll();
	}*/
	@RequestMapping("moviehallListByPage")
	@ResponseBody
	public Page<MovieHall> moviehallListByPage(HttpServletRequest request){
		int currentPage=1;
		if(request.getParameter("currentPage")!=null){
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		int pageSize=3;
		/*if(request.getParameter("pageSize")!=null){
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
		}*/
		
		Page<MovieHall> page= movieHallService.findByPage(currentPage, pageSize);
		//System.out.println(page);
		return page;
	}
	
	@RequestMapping("del")
	@ResponseBody
	public String del(int hid){
		System.out.println(hid);
		if(hid==1||hid==2||hid==3){
			return "不可删除";
		}else{
			movieHallService.doDelete(hid);
			return "删除成功";
		}
	}
	@RequestMapping("addMovieHall")
	@ResponseBody
	public String addMovieHall(MovieHall movieHall){
		movieHallService.doAdd(movieHall);
		return "添加成功";
	}
	@RequestMapping("updateMovieHall")
	@ResponseBody
	public String updateMovieHall(MovieHall movieHall){
		System.out.println(movieHall);
		movieHallService.doUpdate(movieHall);
		return "修改成功";
	}
	@RequestMapping("findById")
	@ResponseBody
	public MovieHall findById(int hid){
		return movieHallService.findById(hid);
	}
	@RequestMapping("moviehall")
	public ModelAndView test(){
		ModelAndView modelAndView = new ModelAndView("moviehall");
		return modelAndView;
	}
}
