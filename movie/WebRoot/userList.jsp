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
  <script type="text/javascript">
     $(function(){
       var totalNum=${page.totalNum};
       var pageSize=${page.pageSize};
       var currentPage=${page.currentPage};
       $("#News-Pagination").pagination(totalNum,{
          items_per_page:pageSize, // 每页显示多少条记录
		  current_page:currentPage-1, // 当前显示第几页数据
		  num_display_entries:2, // 分页显示的条目数
		  next_text:"下一页",
		  prev_text:"上一页",
		  num_edge_entries:2, // 连接分页主体，显示的条目数
		  callback:handlePaginationClick
       });
      });
      function handlePaginationClick(new_page_index, pagination_container){
         $("#mainForm").attr("action", "<%=path%>/finduserpage.do?currentPage=" + (new_page_index+1));
		  $("#mainForm").submit();
		   	 return false;
      };
  </script>
  <body>

  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
    <form method="post" action="<%=path %>/finduserpage.do" name="form1" id="mainForm">
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <li>
          <input type="text" placeholder="请输入搜索关键字" name="condition" value="${condition}" class="input" style="width:250px; line-height:17px;display:inline-block" />
          <button onclick="check(form1)" class="button border-main icon-search"> 搜索</button></li>
          <li>&nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp; &nbsp; &nbsp;</li>
          <li><a class="button border-main icon-plus-square-o" href="<%=path %>/adduser.do">添加管理员</a> </li>
      </ul>
    </div>
    </form>
    <h2 align="center"><font  color="red">${error3 }</font></h2>
    <table class="table table-hover text-center" >
      <tr>
       <!--  <th width="100" style="text-align:left; padding-left:20px;">序列</th>
        <th width="10%">排序</th> -->
        
        <th width="14%">序列</th>
        <th width="14%">用户账号</th>
        <th width="14%">真实姓名</th>
        <th width="14%">性别</th>
        <th width="14%">联系方式</th>
	    <th width="14%">email</th>
        <th width="16%">操作</th>
      </tr>
      <c:forEach items="${page.content}" var="u" varStatus="b">
      	<tr>
         <td><!-- <input type="checkbox"> --><input type="hidden" name="uid" value="${u.uid }">${b.count}</td>
        <td>${u.uname}</td>
        <td>${u.realName }</td>
        <td>${u.sex }</td>
	    <td>${u.tel }</td>
        <td>${u.email}</td>
       	<td><div class="button-group"> <a class="button border-main" href="<%=path %>/updateuser.do?uid=${u.uid }"><span class="icon-edit"></span> 修改</a> <a class="button border-red" href="<%=path%>/deleteuser.do?uid=${u.uid}" onclick="return confirm('确认删除？')"><span class="icon-trash-o"></span> 删除</a> </div></td>
        </tr>
      </c:forEach>
  		<tr>
        <td colspan="9">
        <div class="pagelist">
            <div class="pagination" style="text-align: center;line-height: 20px">
			  <pre>共${page.totalNum}条记录 </pre>     
			</div>
           <div id="News-Pagination" class="pagination"></div>
		</div>
		</td>
      	</tr> 
      	    
    </table>
  </div>

<script type="text/javascript">

//搜索
function changesearch(){	
		
}

//单个删除
function del(id,mid,iscid){
	if(confirm("您确定要删除吗?")){
		
	}
}

//全选
$("#checkall").click(function(){ 
  $("input[name='id[]']").each(function(){
	  if (this.checked) {
		  this.checked = false;
	  }
	  else {
		  this.checked = true;
	  }
  });
})

//批量删除
function DelSelect(){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){
		var t=confirm("您确认要删除选中的内容吗？");
		if (t==false) return false;		
		$("#listform").submit();		
	}
	else{
		alert("请选择您要删除的内容!");
		return false;
	}
}

//批量排序
function sorts(){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){	
		
		$("#listform").submit();		
	}
	else{
		alert("请选择要操作的内容!");
		return false;
	}
}


//批量首页显示
function changeishome(o){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){
		
		$("#listform").submit();	
	}
	else{
		alert("请选择要操作的内容!");		
	
		return false;
	}
}

//批量推荐
function changeisvouch(o){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){
		
		
		$("#listform").submit();	
	}
	else{
		alert("请选择要操作的内容!");	
		
		return false;
	}
}

//批量置顶
function changeistop(o){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){		
		
		$("#listform").submit();	
	}
	else{
		alert("请选择要操作的内容!");		
	
		return false;
	}
}


//批量移动
function changecate(o){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){		
		
		$("#listform").submit();		
	}
	else{
		alert("请选择要操作的内容!");
		
		return false;
	}
}

//批量复制
function changecopy(o){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){	
		var i = 0;
	    $("input[name='id[]']").each(function(){
	  		if (this.checked==true) {
				i++;
			}		
	    });
		if(i>1){ 
	    	alert("只能选择一条信息!");
			$(o).find("option:first").prop("selected","selected");
		}else{
		
			$("#listform").submit();		
		}	
	}
	else{
		alert("请选择要复制的内容!");
		$(o).find("option:first").prop("selected","selected");
		return false;
	}
}

</script>
</body>
</html>
