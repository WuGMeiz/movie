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
    
    <title>My JSP 'addManager.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		
  		$("input").blur(function(){
  			clearSpan();
  			if($("input[name='uname']").val()==""){
  				$("input[name='uname']").after("<span style='color:red;'>账号不能为空</span>");
  			}else if ($("input[name='upsw']").val().length < 6|| $("input[name='upsw']").val().length > 16) {
						$("input[name='upsw']").after("<span style='color:red'>密码为6-16位</span>");
  			}else if(!/^1[3|5|8][0-9]\d{8}$/.test($("input[name='tel']").val())) {
						$("input[name='tel']").after("<span style='color:red'>电话号码不正确</span>");
			}
			else if(!/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/.test($("input[name='email']").val())) {
						$("input[name='email']").after("<span style='color:red'>邮箱格式不正确</span>");
			}else{
  				return true;
  			}
  				return false;
  		});
  		$("input").focus(function(){
  			clearSpan();
  			if($("input[name='uname']").val()==""){
  				$("input[name='uname']").after("<span style='color:red;'>账号不能为空</span>");
  			}else if ($("input[name='upsw']").val().length < 6|| $("input[name='upsw']").val().length > 16) {
						$("input[name='upsw']").after("<span style='color:red'>密码不能为空</span>");
  			}else if(!/^1[3|5|8][0-9]\d{8}$/.test($("input[name='tel']").val())) {
						$("input[name='tel']").after("<span style='color:red'>电话号码不为空</span>");
			}
			else if(!/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/.test($("input[name='email']").val())) {
						$("input[name='email']").after("<span style='color:red'>邮箱格式不为空</span>");
			}else{
  				return true;
  			}
  				return false;
  		});
  		function clearSpan(){
  				$("input[name='uname']").next("span").remove();
  				$("input[name='upsw']").next("span").remove();
  				$("input[name='tel']").next("span").remove();
  				$("input[name='email']").next("span").remove();
			};	
  	});

</script>

</head>
  
  <body>
    <form method="post" id="myForm" action="<%=path %>/addInuser.do" >
      <table cellSpacing="1" cellPadding="5" width="60%" height="80%"  align="center" style="border: 1px solid #8ba7e3" border="0">
         <tr>
					<td  align="center" bgColor="#afd1f3" colSpan="2"
						height="26">
						<strong><STRONG>添加管理员</STRONG>
						</strong>
					</td>
		</tr>
         
         <tr>
             <td  align="center" bgColor="#f5fafe">管理员姓名：</td>
             <td  align="left" bgColor="#f5fafe"><input type="text" name="uname" id="managername"/></td>
         </tr>
         <tr>
             <td  align="center" bgColor="#f5fafe">管理员密码：</td>
             <td  align="left" bgColor="#f5fafe"><input type="password" name="upsw" id="managerpassword"/></td>
         </tr>
   		 
         <tr>
             <td  align="center" bgColor="#f5fafe">联系方式：</td>
             <td  align="left" bgColor="#f5fafe"><input type="text" name="tel" id="managerpassword"/></td>
         </tr>
         <tr>
             <td  align="center" bgColor="#f5fafe">Email：</td>
             <td  align="left" bgColor="#f5fafe"><input type="text" name="email" id="managerpassword"/></td>
         </tr>
         <tr>
             <td  align="center" bgColor="#f5fafe">真实姓名：</td>
             <td  align="left" bgColor="#f5fafe"><input type="text" name="realName" id="managername"/></td>
         </tr>
          <tr>
             <td  align="center" bgColor="#f5fafe">性别：</td>
             <td  align="left" bgColor="#f5fafe">
        
                <input type="radio" name="sex" value="男"  id="nan">男
                <input type="radio" name="sex" value="女"  id="nv">女
       
         </tr>
        <tr>
             <td align="center" bgColor="#f5fafe" colSpan="2"><input type="submit" value="添加" class="button"/></td>
        </tr>
      </table>
   
</form>
  </body>
</html>
