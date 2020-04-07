<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<LINK href="${pageContext.request.contextPath}/css/Style1.css" type="text/css" rel="stylesheet">
		<script type="text/javascript" src="<%=path%>/js/jquery-1.9.1.min.js"></script>
		<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
	</HEAD>
	
	<body>
			<form id="uploadImg"  action="<%=path%>/updateInmovie.do" method="post" enctype="multipart/form-data">
			<input type="hidden" id="updateid" name="mid" value="${movie.mid}">
			<%-- <input type="hidden" name="goodspicture" value="${goods.goodspicture }"> --%>
			&nbsp;
			<table cellSpacing="1" cellPadding="5" width="100%" height="80%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>修改影片</STRONG>
						</strong>
					</td>
				</tr>

				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						影片名称：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text"  name="mname" value="${movie.mname}" id="movieName" class="bg"/>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						价格：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="mprice" value="${movie.mprice }" id="moviePrice" class="bg"/>
					</td>
				</tr>
				
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						国家：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="mcountry" value="${movie.mcountry}" id="movieCountry" class="bg"/>
					</td>
					
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						图片：
					</td>
					<td class="ta_01" bgColor="#ffffff">
					     <img src="<%=path%>/${movie.mpic}" width="100px">
					     <input type="file"  id="goodspicture" name="mpic"/>
					</td>
					
				</tr>
				
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						导演：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="mauthor" value="${movie.mauthor }" id="movieAuthor" class="bg"/>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						是否上架：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<select id="movieState" name="mstate">
							<option value="1">是</option>
							<option value="0">否</option>
						</select>
					</td>
				</tr>
				
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						主演：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text"  name="mactor" value="${movie.mactor }" id="movieActor" class="bg"/>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						上映时间：
					</td>
					<td class="ta_01" bgColor="#ffffff">
				      <input type="text" name="mdate" value="${movie.mdate}" id="movieDate" class="bg" onclick="WdatePicker()"/>
					</td>
				</tr>
				<tr>
					<td class="ta_01" style="WIDTH: 100%" align="center"
						bgColor="#f5fafe" colSpan="4">
						<input type="submit" id="userAction_save_do_submit" onclick="submitAll();" value="确定" class="button_ok"></input>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<button type="reset" value="重置" class="button_cancel">&#37325;&#32622;</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<INPUT class="button_ok" type="button" onclick="history.go(-1)" value="返回"/>
						<span id="Label1"></span>
					</td>
				</tr>
			</table>
			</form>
	</body>
</HTML>