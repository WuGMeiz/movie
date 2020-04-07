<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>后台管理系统</title>  
    <link rel="stylesheet" href="resource/css/pintuer.css">
    <link rel="stylesheet" href="resource/css/admin.css">
    <link rel="stylesheet" href="resource/css/name.css">
    <script type="text/javascript" src="resource/js/Clock.js"></script>
    <script src="resource/js/jquery.js"></script>   
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1><img src="images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />后台管理中心</h1>
  </div>
  <div class="head-l">&nbsp;&nbsp;<a class="button button-little bg-red" href="<%=path%>/logout.do" target="_parent"><span class="icon-power-off" ></span> 退出登录</a> 
  </div>
  <div style="margin-right: 60px; margin-top: 30px;float: right" >
	<span id="clock" style="color: white"></span>
	<script type="text/javascript">
  	var clock = new Clock();
    clock.display(document.getElementById("clock"));
  </script>
</div>
  
</div>
<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
  
  
  <div id="c">
  	<span style="color:white;">${user.realName}登录</span>
  </div>
	<div id="cr">
	    <h2><span class="icon-user"></span>${role.rname}基本操作</h2>
	  	<ul style="display:block">
	  	<c:forEach items="${limits }" var="limit">
	  	<li><a href="${limit.url }" target="right"><span class="icon-caret-right"></span>${limit.lname }</a></li>
	  	</c:forEach>
	 	 </ul>  
  	</div>
  
  
 	<%-- <c:if test="${chaojimemu==1}">
 	<div id="b">
 		<span id="a1" style="color:white;">${adminrealname }登录</span>
 	</div>
 	<div id="br">
	   	<h2><span class="icon-user"></span>超级管理员基本操作</h2>
	  	<ul style="display:block">
	  	<c:forEach items="${menus3 }" var="m3">
	  	<li><a href="${m3.url }" target="right"><span class="icon-caret-right"></span>${m3.mname }</a></li>
	  	</c:forEach>
	  	</ul>  
  	</div>
 	 </c:if> --%>
</div>
<script type="text/javascript">
$(function(){
  $(".leftnav h2").click(function(){
	  $(this).next().slideToggle(200);	
	  $(this).toggleClass("on"); 
  })
  $(".leftnav ul li a").click(function(){
	    $("#a_leader_txt").text($(this).text());
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  })
});
</script>
<ul class="bread">
</ul>
<div class="admin">
  <iframe scrolling="auto" rameborder="0" src="welcome.jsp" name="right" width="100%" height="100%"></iframe>
</div>
<div style="text-align:center;">
</div>

</body>
</html>
