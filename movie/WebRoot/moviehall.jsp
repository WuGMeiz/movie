<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link href="css/Common.css" rel="stylesheet" />
<link href="css/Index2.css" rel="stylesheet" />
<style type="text/css">
 a:link,a:visted{
     text-decoration: none;
     left:10px;
     font-size: 18px;
     line-height: 20px;  
  }
a:hover{
    text-decoration: none;
}
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<h4>影厅列表</h4>
			<div class="add">
				<a class="btn btn-success" onclick="openadd();">新增</a>
			</div>
			<div class="w">
				<div class="span12">
					<table class="table table-condensed table-bordered table-hover tab">
						<thead>
							<tr>
								<td>序号</td>
								<td>影厅名称</td>
								<td>座位数量</td>
								<td>影厅状态</td>
								<td>操作</td>
							</tr>

						</thead>
						<tbody id="tbody">
                          
						</tbody>
					</table>
				</div>
			</div>


			<div id="addModal" class="modal hide fade" tabindex="-1"
				role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h3 id="myModalLabel">添加影厅</h3>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" action="">
						<input type="hidden" id="sid">
						<div class="control-group">
							<label class="control-label" for="userName">名称</label>
							<div class="controls">
								<input type="text" id="hname" name="sname" placeholder="影厅名称">
								<input type="hidden" name="hid" id="hid">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="Chinese">容量</label>
							<div class="controls">
								<select id="hnum" name="code">
									<option disabled="disabled" selected="selected">==请选择座位数==</option>
									<option value="64">64</option>
									<option value="84">84</option>
									<option value="100">100</option>
								</select>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="English">状态</label>
							<div class="controls">
								<select id="hstate" placeholder="影厅营业状态">
									<option disabled="disabled" selected="selected">==请选择营业状态==</option>
									<option value="营业">营业</option>
									<option value="倒闭">倒闭</option>
								</select>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
					<button class="btn btn-primary" id="add" onclick="add();">保存</button>
					<button class="btn btn-primary" id="edt" onclick="edt();">编辑</button>
				</div>
			</div>
		</div>
	</div>
	<script src="js/jquery-1.9.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/layer/layer.js"></script>
	<script src="js/laypage/laypage.js"></script>
	<script type="text/javascript" src="js/Index2.js"></script>

</body>
</html>
