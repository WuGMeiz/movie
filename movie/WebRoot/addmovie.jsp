<%@ page language="java"  contentType="text/html; charset=utf-8"%>
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
	<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
	</HEAD>
	
	<body>
	<form id="uploadImg"  action="<%=path%>/addInmovie.do" method="post" enctype="multipart/form-data" >
			<input type="hidden" name="method" value="save">
			&nbsp;
			<table cellSpacing="1" cellPadding="5" width="100%" height="80%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>添加影片</STRONG>
						</strong>
					</td>
				</tr>

				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						影片名称：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="mname" value="" id="mname" class="bg"/>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						国家：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="mcountry" value="" id="shopPrice" class="bg"/>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						导演：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="mauthor" value="" id="shopNum" class="bg"/>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						主演：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="mactor" value="" id="shopNum" class="bg"/>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						价格：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="mprice" value="" id="shopNum" class="bg"/>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						上映日期：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="mdate" value="" id="shopNum" class="bg" onclick="WdatePicker()"/>
					</td>
				</tr>
				<tr>
					
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						是否上架：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<select id="mstate" name="mstate">
							<option value="1">是</option>
							<option value="0">否</option>
						</select>
					</td>
					
				</tr>
				<tr>
					
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						影片图片：
					</td>
					<td class="ta_01" bgColor="#ffffff">
					     <input type="file" id="goodspicture" name="mpic"/>
					</td>
				</tr>
				<tr>
					<td class="ta_01" style="WIDTH: 100%" align="center"
						bgColor="#f5fafe" colSpan="4">
						<input type="submit" id="userAction_save_do_submit"  value="确定" class="button_ok"></input>
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