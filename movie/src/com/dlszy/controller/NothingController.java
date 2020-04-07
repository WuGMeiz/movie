package com.dlszy.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dlszy.entity.MovieHallSeat;
import com.dlszy.entity.MovieTotal;
import com.dlszy.entity.Nothing;
import com.dlszy.service.NothingService;

@Controller
public class NothingController {
	@Autowired
	private NothingService nothingService;
	@RequestMapping("movietest")
	public ModelAndView test(){
		for(Nothing n:nothingService.getAllNothing()){
			MovieTotal mt = new MovieTotal();
			if(nothingService.findByMtname(n.getMname())==null){
				Date date=new Date();
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				String str=sdf.format(date);
				mt.setMtime(str);
				mt.setMtname(n.getMname());
				mt.setMtotal(nothingService.getSeatNum(n.getHid(), n.getTid(), n.getMprice()));
				nothingService.addmovietotal(mt);
			}else{
				mt = nothingService.findByMtname(n.getMname());
				int totle = mt.getMtotal()+nothingService.getSeatNum(n.getHid(), n.getTid(), n.getMprice());
				mt.setMtotal(totle);
				nothingService.updatemovietotal(mt);
			}
		}
		ModelAndView modelAndView=new ModelAndView("test2");//创建对象的同时指定要跳转的页面
		List<MovieTotal> list = nothingService.findAll();
		for(MovieTotal m:list){
			System.out.println(m);
		}
		modelAndView.addObject("list", list);
		return modelAndView;
	} 
	
	@RequestMapping("updateSeat")
	public ModelAndView test2(){
		ModelAndView modelAndView=new ModelAndView("test");
		nothingService.updateState();
		return modelAndView;
	}
	@RequestMapping("updateSeat2")
	public ModelAndView test3(){
		ModelAndView modelAndView=new ModelAndView("test");
		for(MovieHallSeat mhs:nothingService.findAllSeat()){
			 Random rd = new Random();
		        int x = rd.nextInt(3);
			Object[] objs = {mhs.getH_s_id(),x};
			nothingService.updateState2(objs);
		}
		return modelAndView;
	}
	@RequestMapping("test")
	public ModelAndView test4(){
		ModelAndView modelAndView = new ModelAndView("test");
		return modelAndView;
	}
}
