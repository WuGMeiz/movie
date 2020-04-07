<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

		/* $(function(){
		//alert(111);
  		$("input").blur(function(){
  			clearSpan();
  			if($("input[name='vname']").val()==""){
  				$("input[name='vname']").after("<span style='color:red;'>账号不能为空</span>");
  			} else if (!/^1[3|5|8][0-9]\d{8}$/.test($(":text[name='tel']").val())) {
						$(":text[name='vtel']").after("<span style='color:red'>电话号码不正确</span>");
			}else{
  					return true;
  			}
  				return false;
  		});
  		function clearSpan(){
  				$("input[name='vname']").next("span").remove();
  				$("input[name='vtel']").next("span").remove();
  			}
  	}); */
</script>

</head>
  
  <body>
    <form method="post" id="myForm" action="<%=path %>/addvip.do" onsubmit="return checkAll();">
      <table cellSpacing="1" cellPadding="5" width="60%" height="100%" align="center" style="border: 1px solid #8ba7e3" border="0">
         <tr>
					<td  align="center" bgColor="#afd1f3" colSpan="2"
						height="26">
						<strong><STRONG>添加会员</STRONG>
						</strong>
					</td>
		</tr>
         <tr>
             <td  align="center" bgColor="#f5fafe">真实姓名：</td>
             <td  align="left" bgColor="#f5fafe"><input type="text" name="vname" id="realname"/></td>
         </tr>
         <tr>
             <td  align="center" bgColor="#f5fafe">联系方式：</td>
             <td  align="left" bgColor="#f5fafe"><input type="text" name="vtel" id="tel"/></td>
         </tr>
         <tr>
             <td  align="center" bgColor="#f5fafe">会员号：</td>
             <td  align="left" bgColor="#f5fafe"><input type="text" name="vcard" id="card"/></td>
         </tr>
         <tr>
             <td  align="center" bgColor="#f5fafe">会员状态：</td>
             <td  align="left" bgColor="#f5fafe"><input type="radio" name="vstate" value="激活" id="sex"/>激活
             									 <input type="radio" name="vstate" value="未激活" />未激活
             </td>
         </tr>
             <td align="center" bgColor="#f5fafe" colSpan="2"><input type="submit" value="添加" class="button"/></td>
        </tr>
      </table>
   
</form>
  </body>
</html>
