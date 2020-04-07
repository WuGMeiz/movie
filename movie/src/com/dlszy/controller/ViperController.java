package com.dlszy.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.dlszy.entity.Page;
import com.dlszy.entity.Viper;
import com.dlszy.service.ViperService;

@Controller
public class ViperController {
	@Autowired
	public ViperService viperService;
	@RequestMapping("findAllVip")
	public String findMoviePage(HttpServletRequest request){
		int currentPage=1;
		if(request.getParameter("currentPage")!=null){
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		int pageSize=3;
		if(request.getParameter("pageSize")!=null){
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
		}
		String condition="";
		if(request.getParameter("condition")!=null){
			condition = request.getParameter("condition");
		}
		Page<Viper> page= viperService.findAllVip(currentPage, pageSize, condition);
		request.setAttribute("page", page);
		request.getSession().setAttribute("condition", condition);
		return "viperList";
	}
	@RequestMapping("addvipbefore")
	public ModelAndView addvipbefore(){
		ModelAndView modelAndView=new ModelAndView("addvip");//创建对象的同时指定要跳转的页面
		return modelAndView;
	}
	@RequestMapping("addvip")
	public String addvip(Viper vip){
		viperService.addViper(vip);
		return "redirect:findAllVip.do";
	}
	@RequestMapping("updvipbefore")
	public ModelAndView updvipbefore(int vid){
		System.out.println(vid);
		Viper vip = viperService.findByVid(vid);
		System.out.println(vip);
		ModelAndView modelAndView=new ModelAndView("updatevip");//创建对象的同时指定要跳转的页面
		modelAndView.addObject("vip",vip);
		return modelAndView;
	}
	@RequestMapping("updatevip")
	public String updatevip(Viper vip){
		System.out.println(vip);
		viperService.updateViper(vip);
		return "redirect:findAllVip.do";
	}
	@RequestMapping("delViper")
	public String delViper(int vid){
		viperService.delViper(vid+"");
		return "redirect:findAllVip.do";
	}
}
