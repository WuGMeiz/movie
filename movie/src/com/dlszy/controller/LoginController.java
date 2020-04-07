package com.dlszy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dlszy.entity.Movie;
import com.dlszy.entity.Page;
import com.dlszy.entity.Role;
import com.dlszy.entity.User;
import com.dlszy.service.RoleService;
import com.dlszy.service.UserService;

@Controller
public class LoginController {
	@Autowired
  private UserService userService;
	@Autowired
  private RoleService roleService;
	@RequestMapping("dologin")
	public String dologin(HttpServletRequest request){
		HttpSession session = request.getSession();
		String code = (String)session.getAttribute("code");
		System.out.println(code);
		String yanzheng = request.getParameter("yanzheng");
		System.out.println(yanzheng);
		String uname = request.getParameter("uname");//登录名
		System.out.println(uname);
		String upsw = request.getParameter("upsw");//登录密码
		if(code.equalsIgnoreCase(yanzheng)){
			User user=userService.findByNameAndPsw(uname, upsw);
			if(user!=null){
				Role role=roleService.findByRid(user.getRole().getRid());
				session.setAttribute("user", user);
				session.setAttribute("uname", uname);
				session.setAttribute("role", role);
				session.setAttribute("limits", role.getLimits());
				return "main";
			}else{
				request.setAttribute("error", "用户名或密码错误");
				return "login";
			}
		}else{
			request.setAttribute("error", "验证码不正确");
			return "login";
		}
	}
	
}
