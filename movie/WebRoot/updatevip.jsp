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
  <form method="post" action="<%=path%>/updatevip.do">
    <input type="hidden" name="vid" value="${vip.vid }">
  <table cellspacing="0" cellpadding="0" style="margin-top: 100x" align="center" width="80%" height="100%">
      <tr>
					<td  align="center" bgColor="#afd1f3" colSpan="2"
						height="26">
						<strong><STRONG>修改会员信息</STRONG>
						</strong>
					</td>
     </tr>
      <tr align="center" bgColor="#f5fafe">
        <td>会员姓名：</td>
        <td align="left"><input type="text" name="vname" id="vname" value="${vip.vname}"/></td>
      </tr>
      <tr align="center" bgColor="#f5fafe">
        <td>联系方式：</td>
        <td align="left"><input type="text" name="vtel" id="vtel" value="${vip.vtel}"/></td>
      </tr>
      <tr  align="center" bgColor="#f5fafe">
        <td>会员号：</td>
        <td  align="left"><input type="text" name="vcard" id="card" value="${vip.vcard}"/></td>
      </tr>
      <tr>
             <td  align="center" bgColor="#f5fafe">会员状态：</td>
             <td  align="left" bgColor="#f5fafe">
             	 <c:choose>
            <c:when test="${vip.vstate=='激活'}">
                <input type="radio" name="vstate" value="激活" checked="checked" id="nan">激活
                <input type="radio" name="vstate" value="未激活" id="nv">未激活
                </c:when>
            <c:otherwise>
                <input type="radio" name="vstate" value="激活"  id="nan">
          		<label for="nan">激活</label>
                <input type="radio" name="vstate" value="未激活" checked="checked" id="nv">
                <label for="nv">女</label><br /><br /><br />
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
