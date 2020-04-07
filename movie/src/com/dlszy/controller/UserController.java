package com.dlszy.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dlszy.entity.Page;
import com.dlszy.entity.User;
import com.dlszy.service.UserService;

@Controller
public class UserController {
	@Autowired
	  private UserService userService;
	@RequestMapping("finduserpage")
	public String findUserPage(HttpServletRequest request){
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
		Page<User> page= userService.findByPage(currentPage, pageSize, condition);
		request.setAttribute("page", page);
		request.getSession().setAttribute("condition", condition);
		return "userList";
	}
	@RequestMapping("adduser")
	public String adduser(){
		return "redirect:adduser.jsp";
	}
	@RequestMapping("addInuser")
	public String addInuser(User user){
		//System.out.println(user);
		userService.doAddUser(user);
		return "redirect:finduserpage.do";
	}
	@RequestMapping(value="deleteuser")
	public String deleteuser(HttpServletRequest request){
		int id = Integer.parseInt(request.getParameter("uid"));
		userService.doDelUser(id);
		return "redirect:finduserpage.do";
	}
	@RequestMapping("updateInuser")
	public String updateInuser(User user){
		System.out.println(user);
		userService.doUpdateUser(user);
		return "redirect:finduserpage.do";
	}
	@RequestMapping(value="updateuser")
	public String updateuser(HttpServletRequest request){
		int id = Integer.parseInt(request.getParameter("uid"));
		User user =userService.findById(id);
		request.setAttribute("user", user);
		return "updateuser";
	}
}
