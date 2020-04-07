package com.dlszy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {
	@RequestMapping("logout")
	public String logout(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		session.removeAttribute("role");
		session.removeAttribute("limits");
		session.removeAttribute("uname");
		return "redirect:login.jsp";
	}
}
