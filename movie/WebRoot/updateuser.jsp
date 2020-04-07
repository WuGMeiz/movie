<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updateManager.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <form method="post" action="<%=path%>/updateInuser.do">
    <input type="hidden" name="uid" value="${user.uid }">
  <table cellspacing="0" cellpadding="0" height="80%" style="margin-top: 100x" align="center" width="60%" >
      <tr>
					<td  align="center" bgColor="#afd1f3" colSpan="2"
						height="26">
						<strong><STRONG>修改管理员信息</STRONG>
						</strong>
					</td>
     </tr>
     <tr>
             <td  align="center" bgColor="#f5fafe">管理员姓名：</td>
             <td  align="left" bgColor="#f5fafe"><input type="text" name="uname" id="managername" value="${user.uname }"/></td>
         </tr>
         <tr>
             <td  align="center" bgColor="#f5fafe">管理员密码：</td>
             <td  align="left" bgColor="#f5fafe"><input type="password" name="upsw" id="managerpassword" value="${user.upsw }"/></td>
         </tr>
   		 
         <tr>
             <td  align="center" bgColor="#f5fafe">联系方式：</td>
             <td  align="left" bgColor="#f5fafe"><input type="text" name="tel" id="managerpassword" value="${user.tel }"/></td>
         </tr>
         <tr>
             <td  align="center" bgColor="#f5fafe">Email：</td>
             <td  align="left" bgColor="#f5fafe"><input type="text" name="email" id="managerpassword" value="${user.email }"/></td>
         </tr>
         <tr>
             <td  align="center" bgColor="#f5fafe">真实姓名：</td>
             <td  align="left" bgColor="#f5fafe"><input type="text" name="realName" id="managername" value="${user.realName }"/></td>
         </tr>
          <tr>
             <td  align="center" bgColor="#f5fafe">性别：</td>
             <td  align="left" bgColor="#f5fafe">
          <c:choose>
            <c:when test="${user.sex=='男'}">
                <input type="radio" name="sex" value="男" checked="checked" id="nan">男
          		
                <input type="radio" name="sex" value="女" id="nv">女
              
            </c:when>
            <c:otherwise>
                <input type="radio" name="sex" value="男"  id="nan">男
      
                <input type="radio" name="sex" value="女" checked="checked" id="nv">女
                
            </c:otherwise>
            </c:choose>
            </td>
         </tr>
      <tr>
             <td align="center" bgColor="#f5fafe" colSpan="2"><input type="submit" value="修改" class="button"/></td>
       </tr>
  </table>
</form>
  </body>
</html>
