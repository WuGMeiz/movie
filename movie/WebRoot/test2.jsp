<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adminlist3.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="resource/css/pintuer.css">
	<link rel="stylesheet" href="resource/css/admin.css">
	<link href="resource/css/pagination.css" rel="stylesheet" />
	<script src="resource/js/jquery.js"></script>
	<script src="resource/js/pintuer.js"></script>
    <script src="resource/js/jquery-1.9.1.min.js"></script>
	<script src="resource/js/jquery.pagination.js"></script>
  </head>
  
  <body>

  <div class="panel admin-panel">
    <table class="table table-hover text-center" height="45px">
      <tr>
        <th width="10%">序列</th>
        <th width="15%">片名</th>
        <th width="20%">时间</th>
        <th width="20%">总收入</th>
      </tr>
      <c:forEach items="${list}" var="u" varStatus="b">
      	<tr>
	        <td>${u.mcid }</td>
	        <td>${u.mtname}</td>
	        <td>${u.mtime}</td>
	        <td>${u.mtotal }￥</td>
        </tr>
      </c:forEach>
    </table>
  </div>
</body>
</html>