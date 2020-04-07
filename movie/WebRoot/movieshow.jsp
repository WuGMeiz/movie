<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  </head>
 <body>
    <div class="container-fluid">
        <div class="row-fluid">
            <h4>影片上映计划</h4>
            <div class="add"> <a class="btn btn-success" onclick="openadd();">新增</a>
            		<span class="form-horizontal" style="margin: 0 100px;">
                    				影片名: <input type="text"  id="userName" placeholder="片名">
                             		影厅: <select id="hall" onChange="moviehall(this.value)">
                             				<option selected="selected" disabled="disabled">=请选择=</option>
                             			</select>
                             		<input class="btn btn-success" type="submit" value="查询" onClick="find()">
                    </span>
            </div>
            <div class="w">
                <div class="span12">
                    <table class="table table-condensed table-bordered table-hover tab">
                            <tr>
                                <th>序号</th>
                                <th>影片名称</th>
                                <th>所在放映厅</th>
                                <th>播放时间</th>
                                <th>票价</th>
                                <th>操作</th>
                            </tr>
                        <tbody id="tbody">
                        	
                        </tbody>
                    </table>
                    <div id="page" class="tr"></div>
                </div>
            </div>
           
            <div id="addModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h3 id="myModalLabel">添加影片</h3>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" action="">
                    	<input type="hidden" id="sid">
                        <div class="control-group">
                            <label class="control-label" for="userName">影片名</label>
                            <div class="controls">
                                <select id="movies" onChange="movie(this.value)">
                                	<option selected="selected" disabled="disabled">=请选择=</option>
                                </select>
                                <input type="hidden" name="m_m_id" id="m_m_id">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="Chinese">电影放映厅</label>
                            <div class="controls">
                                <select id="movieHall" onChange="movie(this.value)">
                                	<option selected="selected" disabled="disabled">=请选择=</option>
                                </select>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="English">播放时间段</label>
                            <div class="controls">
                               <select id="times" onChange="movie(this.value)">
                                	<option selected="selected" disabled="disabled">=请选择=</option>
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
    <script src="js/Index3.js"></script>
    <script type="text/javascript">
    	function add(){
    	var formdata = {
	    	mname: $("#movies").val(),
	        hname: $("#movieHall").val(),
	        timespace: $("#times").val(),
    	};
    		$.ajax({
    			url:"addMovieHallTime.do",
    			timeout: 300000,
				dataType : "json",
				type : "post",
				data : formdata,
				success: function (data) {
					$("#addModal").modal("hide");
		            layer.alert(data);
                	$("input").val("");
            		load(curr);
        		}
			});
		}
	</script>
</body>
</html>
