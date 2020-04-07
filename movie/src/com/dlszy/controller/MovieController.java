package com.dlszy.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.runners.Parameterized.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.dlszy.entity.Movie;
import com.dlszy.entity.Page;
import com.dlszy.service.MovieService;


@Controller
public class MovieController {
	@Autowired
	private MovieService movieService;
	@RequestMapping("findmovie")
	public String findAllMovie(HttpServletRequest request){
		List<Movie> movies = movieService.findAll();
		request.setAttribute("movies", movies);
		return "movieList";
	}
	@RequestMapping("findmoviepage")
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
		Page<Movie> page= movieService.findByPage(currentPage, pageSize, condition);
		request.setAttribute("page", page);
		request.getSession().setAttribute("condition", condition);
		return "movieList";
	}
	@RequestMapping(value="updatemovie")
	public String updatemovie(HttpServletRequest request){
		int id = Integer.parseInt(request.getParameter("mid"));
		Movie movie =movieService.findById(id);
		request.setAttribute("movie", movie);
		return "updatemovie";
	}
	@RequestMapping(value="updateInmovie")
	public String updateInmovie(HttpServletRequest request) throws ParseException{
		//判断文件上传的路径是否存在,如果不存在则创建
		File uploadFile=new File(request.getSession().getServletContext().getRealPath("upload"));
		if(!uploadFile.exists()){
			uploadFile.mkdir();
		}
		String filename="";
		//单个文件的上传
		//将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
		CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
				request.getSession().getServletContext());
		//检查form中是否有enctype="multipart/form-data"
		if(multipartResolver.isMultipart(request)){
			//将request变成多部分request
			MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
			//获取multiRequest 中所有的文件名
			Iterator iter=multiRequest.getFileNames();
			while(iter.hasNext())
			{
				//一次遍历所有文件
				MultipartFile file=multiRequest.getFile(iter.next().toString());
				if(file!=null)
				{
					//上传到服务器中对应项目中的根目录下的upload文件夹中
					try {
						filename="upload/"+file.getOriginalFilename();
						file.transferTo(new File(uploadFile.getPath()+"/"+file.getOriginalFilename()));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request; 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		int mid = Integer.parseInt(multipartRequest.getParameter("mid"));
		String mname = multipartRequest.getParameter("mname");
		//System.out.println(mname);
		String mcountry = multipartRequest.getParameter("mcountry");
		String mauthor = multipartRequest.getParameter("mauthor");
		Double mprice = Double.parseDouble(multipartRequest.getParameter("mprice"));
		String mactor = multipartRequest.getParameter("mactor");
		Date mdate = sdf.parse(request.getParameter("mdate"));
		String mstate =multipartRequest.getParameter("mstate");
		Movie m=new Movie(mname, mcountry, mauthor, mprice, mactor, mdate, mstate);
		m.setMpic(filename);
		m.setMid(mid);
		System.out.println(m);
		movieService.doUpdateMovie(m);
		return "redirect:findmoviepage.do";
	}
	@RequestMapping(value="deletemovie")
	public String deletemovie(HttpServletRequest request){
		int id = Integer.parseInt(request.getParameter("mid"));
		movieService.doDelMovie(id);
		return "redirect:findmoviepage.do";
	}
	@RequestMapping(value="doDelAllId")
	public String doDelAllId(HttpServletRequest request){
		String allid=request.getParameter("allid");
		System.out.println(allid);
		return "index";
	}
	@RequestMapping("addmovie")
	public String addmovie(){
		return "redirect:addmovie.jsp";
	}
	@RequestMapping("addInmovie")
	public String addInmovie(HttpServletRequest request) throws ParseException{
		//判断文件上传的路径是否存在,如果不存在则创建
				File uploadFile=new File(request.getSession().getServletContext().getRealPath("upload"));
				if(!uploadFile.exists()){
					uploadFile.mkdir();
				}
				String filename="";
				//单个文件的上传
				//将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
				CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
						request.getSession().getServletContext());
				//检查form中是否有enctype="multipart/form-data"
				if(multipartResolver.isMultipart(request)){
					//将request变成多部分request
					MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
					//获取multiRequest 中所有的文件名
					Iterator iter=multiRequest.getFileNames();
					while(iter.hasNext())
					{
						//一次遍历所有文件
						MultipartFile file=multiRequest.getFile(iter.next().toString());
						if(file!=null)
						{
							//上传到服务器中对应项目中的根目录下的upload文件夹中
							try {
								filename="upload/"+file.getOriginalFilename();
								file.transferTo(new File(uploadFile.getPath()+"/"+file.getOriginalFilename()));
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
				MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request; 
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String mname = multipartRequest.getParameter("mname");
				System.out.println(mname);
				String mcountry = multipartRequest.getParameter("mcountry");
				String mauthor = multipartRequest.getParameter("mauthor");
				Double mprice = Double.parseDouble(multipartRequest.getParameter("mprice"));
				String mactor = multipartRequest.getParameter("mactor");
				Date mdate = sdf.parse(request.getParameter("mdate"));
				String mstate =multipartRequest.getParameter("mstate");
				Movie m=new Movie(mname, mcountry, mauthor, mprice, mactor, mdate, mstate);
				m.setMpic(filename);
				System.out.println(m);
				movieService.doAddMovie(m);
				return "redirect:findmoviepage.do";
	}
	
}
