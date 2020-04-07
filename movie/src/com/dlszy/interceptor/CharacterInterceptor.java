package com.dlszy.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.dlszy.entity.User;

public class CharacterInterceptor implements HandlerInterceptor{

	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//获取请求的url  
        String url=request.getRequestURI();  
        //判断url是否是公开地址(实际使用时将公开地址配置到配置文件中)  
          
        //判断session  
        HttpSession session=request.getSession();  
        //从session中取出用户份信息  
        String uname=(String)session.getAttribute("uname");  
          //System.out.println(uname);
        if(uname!=null){  
            //身份存在，放行  
            return true;  
        }else{
        	if(url.indexOf("dologin.do")>=0){  
                //如果要进行登录提交，放行  
                return true;  
            }
        	if(url.indexOf(".jsp")>=0){
        		request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }
          
        //执行这里表示用户身份需要验证，跳转到登录界面  
        request.getRequestDispatcher("/login.jsp").forward(request, response);  
          
        //return false表示拦截，不向下执行  
        //return true表示放行          
        return false;  
	}
  
}
