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
    
    <title>登录页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="resource/css/pintuer.css">
    <link rel="stylesheet" href="resource/css/admin.css">
    <script src="resource/js/jquery.js"></script>
    <script src="resource/js/pintuer.js"></script> 
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		 function check(form1){
			/* if(form1.user.value=="0"){
				alert("请选择要登录的角色！");form.user.focus();return;
			} */
			
			var name = form1.uname.value;
			var password = form1.upsw.value;
			var yanzheng = form1.yanzheng.value;
			if(name==""||password==""||yanzheng==""){
				document.getElementById("#btn").disabled=true;
			}else{
			    form1.submit();
			}
		} 
	</script>
	<script type="text/javascript">
		if(window.parent!=window){
				window.parent.location.href=window.location.href;
			}
	</script>
  </head>
  
  <body>
<div class="bg"></div>
<div class="container">
    <div class="line bouncein">
        <div class="xs6 xm4 xs3-move xm4-move">
            <div style="height:150px;"></div>
            <div class="media media-y margin-big-bottom">           
            </div>         
            <form name="form1" action="<%=path%>/dologin.do" method="post">
            <div class="panel loginbox">
                <div class="text-center margin-big padding-big-top"><h1>影院后台管理中心</h1></div>
                <div class="panel-body" style="padding:30px; padding-bottom:10px; padding-top:10px;">
                    <div class="form-group">
                        <div class="field field-icon-right">
                            <input type="text" class="input input-big" name="uname" placeholder="登录账号" data-validate="required:请填写账号" />
                            <span class="icon icon-user margin-small"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="field field-icon-right">
                            <input type="password" class="input input-big" name="upsw" placeholder="登录密码" data-validate="required:请填写密码" />
                            <span class="icon icon-key margin-small"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="field">
                            <input type="text" class="input input-big" name="yanzheng" placeholder="填写右侧的验证码" data-validate="required:请填写右侧的验证码" />
                           <img style="cursor: pointer" src="VerCode.jsp" width="100" height="32" class="passcode" style="height:43px; cursor:pointer;" onclick="this.src = 'VerCode.jsp?'+new Date().getTime()" >               
                        </div>
                    </div>
                    		<%-- <select name="user">
                    		<option value="0">---请选择你要登录的用户---</option>
                    		<c:forEach items="${roles }" var="r">
                    		<option value="${r.rid }">---${r.rname }---</option>
                    		</c:forEach>
                    		</select></br>--%>
                    		<font color="red" size="+1">${error}</font> 
                </div>
                <div style="padding:30px;"><input type="button" onclick="check(form1)" id="btn" class="button button-block bg-main text-big input-big" value="登录"></div>
               
            </div>
            </form>          
        </div>
    </div>
</div>

</body>
</html>
