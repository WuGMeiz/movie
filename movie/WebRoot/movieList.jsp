<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
         $("#mainForm").attr("action", "<%=path%>/findmoviepage.do?currentPage=" + (new_page_index+1));
		  $("#mainForm").submit();
		   	 return false;
      };
  </script>
  <body>

  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
    <form method="post" action="<%=path %>/findmoviepage.do" name="form1" id="mainForm">
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <li>
          <input type="text" placeholder="请输入搜索关键字" name="condition" value="${condition}" class="input" style="width:250px; line-height:17px;display:inline-block" />
          <button onclick="check(form1)" class="button border-main icon-search"> 搜索</button></li>
          <li>&nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp; &nbsp; &nbsp;</li>
          <li><a class="button border-main icon-plus-square-o" href="<%=path %>/addmovie.do">添加影片</a> </li>
      </ul>
    </div>
   
    <h2 align="center"><font  color="red">${error3 }</font></h2>
    <table class="table table-hover text-center" >
      <tr>
       <!--  <th width="100" style="text-align:left; padding-left:20px;">序列</th>
        <th width="10%">排序</th> -->
        
        <th width="6%"><input type="checkbox" id="checkall"/></th>
        <th width="9%">影片名称</th>
        <th width="12%">图片</th>
        <th width="8%">国家</th>
        <th width="12%">导演</th>
	    <th width="16%">主演</th>
        <th width="3%">价格</th>
        <th width="10%">上映时间</th>
        <th width="9%">上架/下架</th>
        <th width="15%">操作</th>
      </tr>
      <c:forEach items="${page.content}" var="m" varStatus="b">
      	<tr>
        <td><input type="checkbox" name="id[]" id="d"><input type="hidden" name="mid" value="${m.mid }"></td>
        <td>${m.mname}</td>
        <td><img src="<%=path%>/${m.mpic}" width="100px"></td>
        <td>${m.mcountry }</td>
        <td>${m.mauthor }</td>
	    <td>${m.mactor }</td>
        <td>${m.mprice}</td>
        <td><fmt:formatDate value="${m.mdate }" type="date"/></td>
       	<td>
       		<c:if test="${m.mstate==1}">上架</c:if>
       		<c:if test="${m.mstate==0}">下架</c:if>
       	</td>
       	<td><div class="button-group"> <a class="button border-main" href="<%=path %>/updatemovie.do?mid=${m.mid }"><span class="icon-edit"></span> 修改</a> <a class="button border-red" href="<%=path%>/deletemovie.do?mid=${m.mid}" onclick="return confirm('确认删除？')"><span class="icon-trash-o"></span> 删除</a> </div></td>
        </tr>
      </c:forEach>
  		<tr>
        <td colspan="9">
        <div class="pagelist">
            <input  type="button" value="删除" id="delAll" style="float: left">
            <div class="pagination" style="text-align: center;line-height: 20px">
            
			  <pre>共${page.totalNum}条记录 </pre>     
			</div>
           <div id="News-Pagination" class="pagination"></div>
		</div>
		</td>
      	</tr> 
      	    
    </table>
     </form>
  </div>

<script type="text/javascript">
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
 $("#delAll").click(function(){
    	var mark=$("#d").next("input");
    	var allid="";
    	mark.each(function(){
            allid+=($(this).val()+",");
        });
        alert(allid);
    	$("#mainForm").attr("action","doDelAllId.do?allid="+allid);
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


</script>
</body>
</html>
