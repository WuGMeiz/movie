var curr = 1;
$(function () {
	load(curr);
	getHallName();
	getMovieName();
	getTime();
});
//查询影厅
function getHallName(){
	$.ajax({
		url: "findAllHall.do",
		timeout: 300000,
		dataType: "json",
		type: "post",
		success: function (data) {
			var html = "";
			$.each(data, function (i, item) {
				html += " <option value='"+item.hname+"'>" + item.hname + "</option> " ;
			});
			$("#hall").append(html);
			$("#movigeHall").append(html);
		}
	});
}
//查询影片
function getMovieName(){
	$.ajax({
		url: "findAllMovie.do",
		timeout: 300000,
		dataType: "json",
		type: "post",
		success: function (data) {
			var html = "";
			$.each(data, function (i, item) {
				html += " <option value='"+item.mname+"'>" + item.mname + "</option> " ;
			});
			$("#movies").append(html);
		}
	});
}
//查询全部时间段
function getTime(){
	$.ajax({
		url: "findAllTime.do",
		timeout: 300000,
		dataType: "json",
		type: "post",
		success: function (data) {
			var html = "";
			$.each(data, function (i, item) {
				html += " <option value='"+item.timespace+"'>" + item.timespace + "</option> " ;
			});
			$("#times").append(html);
		}
	});
}
//条件查询
function find(){
	if($("#userName").val()!=null&&$("#userName").val()!=""){
		if($("#hall").val()!=null&&$("#hall").val()!=""){
			var mname=$("#userName").val();
			var hall=$("#hall").val();
			$.ajax({
		    	url: "findByNameAndHall.do",
		        timeout: 300000,
		        dataType: "json",
		        type: "post",
		        data: {"mname": mname,"hname": hall},
		        success: function (data) {
		            var html = "";
		            $.each(data, function (i, item) {
		                html += " <tr> " +
		                        " <td>" + item.m_m_id+ "</td> " +
		                        " <td>" + item.movie.mname + "</td> " +
		                        " <td>" + item.movieHall.hname + "</td> " +
		                        " <td>" + item.time.timespace + "</td> " +
		                        " <td>" + item.movie.mprice +"元"+ "</td> " +
		                        " <td><a class=\"btn btn-info\" onclick='openedt(\"" + item.m_m_id + "\");'>修改</a>&nbsp;&nbsp;<a class=\"btn btn-warning\" onclick='del(\"" + item.m_m_id + "\");'>删除</a></td> " +
		                        " </tr>";
		            });
		            $("#tbody").html(html);
		        }
		    });
		}else{
			var mname=$("#userName").val();
			$.ajax({
		    	url: "findByName.do",
		        timeout: 300000,
		        dataType: "json",
		        type: "post",
		        data: {"userName": mname},
		        success: function (data) {
		            var html = "";
		            $.each(data, function (i, item) {
		                html += " <tr> " +
		                        " <td>" + item.m_m_id+ "</td> " +
		                        " <td>" + item.movie.mname + "</td> " +
		                        " <td>" + item.movieHall.hname + "</td> " +
		                        " <td>" + item.time.timespace + "</td> " +
		                        " <td>" + item.movie.mprice +"元"+ "</td> " +
		                        " <td><a class=\"btn btn-info\" onclick='openedt(\"" + item.m_m_id + "\");'>修改</a>&nbsp;&nbsp;<a class=\"btn btn-warning\" onclick='del(\"" + item.m_m_id + "\");'>删除</a></td> " +
		                        " </tr>";
		            });
		            $("#tbody").html(html);
		        }
		    });
		}
	}else{
		if($("#hall").val()!=null&&$("#hall").val()!=""){
			var hall=$("#hall").val();
			$.ajax({
		    	url: "findByHall.do",
		        timeout: 300000,
		        dataType: "json",
		        type: "post",
		        data: {"hall": hall},
		        success: function (data) {
		            var html = "";
		            $.each(data, function (i, item) {
		                html += " <tr> " +
		                        " <td>" + item.m_m_id+ "</td> " +
		                        " <td>" + item.movie.mname + "</td> " +
		                        " <td>" + item.movieHall.hname + "</td> " +
		                        " <td>" + item.time.timespace + "</td> " +
		                        " <td>" + item.movie.mprice +"元"+ "</td> " +
		                        " <td><a class=\"btn btn-info\" onclick='openedt(\"" + item.m_m_id + "\");'>修改</a>&nbsp;&nbsp;<a class=\"btn btn-warning\" onclick='del(\"" + item.m_m_id + "\");'>删除</a></td> " +
		                        " </tr>";
		            });
		            $("#tbody").html(html);
		        }
		    });
		}
	}
}
//查询全部，
function load(curr) {
    $.ajax({
    	url: "getAllPage.do",
        timeout: 300000,
        dataType: "json",
        data:{"currentPage":curr},
        type: "post",
        success: function (data) {
            var html = "";
            $.each(data.content, function (i, item) {
                html += " <tr> " +
                        " <td>" + item.m_m_id+ "</td> " +
                        " <td>" + item.movie.mname + "</td> " +
                        " <td>" + item.movieHall.hname + "</td> " +
                        " <td>" + item.time.timespace + "</td> " +
                        " <td>" + item.movie.mprice +"元"+ "</td> " +
                        " <td><a class=\"btn btn-info\" onclick='openedt(\"" + item.m_m_id + "\");'>修改</a>&nbsp;&nbsp;<a class=\"btn btn-warning\" onclick='del(\"" + item.m_m_id + "\");'>删除</a></td> " +
                        " </tr>";
            });
            html += "<tr>" + 
            " <td colspan='5'>"+
             "共"+ data.totalNum+"条记录 &nbsp;&nbsp;&nbsp;&nbsp;"+ 
             "<a id='first' onclick='first()'><span>首页</span></a>"+
             "&nbsp;&nbsp;&nbsp;&nbsp;<a id='pre' onclick='pre(\"" + data.currentPage + "\")'><span>上一页</span></a>"+
             "&nbsp;&nbsp;&nbsp;&nbsp;<a id='next' onclick='next(\"" + data.currentPage + '","' + data.totalPage + "\")'><span>下一页</span></a>"+
             "&nbsp;&nbsp;&nbsp;&nbsp;<a id='last' onclick='last(\"" + data.totalPage + "\")'><span>尾页</span></a>"+
             "</td>"+
            " </tr>";
            $("#tbody").html(html);
           /* laypage({
                cont: 'page', //容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：<div id="page1"></div>
                pages: Math.ceil(data.cnt / 10), //通过后台拿到的总页数
                skin: "#49afcd",
                curr: curr || 1, //当前页
                jump: function (obj, first) { //触发分页后的回调
                    if (!first) { //点击跳页触发函数自身，并传递当前页：obj.curr
                        curr = obj.curr;
                        load(curr);
                    }
                }
            });*/
        }
    });
}
function first(){
	load(1);
}
function last(totalPage){
	load(totalPage);
}
function pre(currentPage){
	if(currentPage==1){
		alert("已经第一页了");
	}else{
		load(currentPage-1);
	}
}
function next(currentPage,totalPage){
	if(currentPage==totalPage){
		alert("已经最后一页了");
	}else{
		load(Number(currentPage)+Number(1));
	}
}
//弹出框
function openadd() {
	  $("#myModalLabel").text("添加排片");
	    $("#userName").attr("readonly", false);
	    $("input:not(:radio)").val("");
	    $("#addModal").modal("show");
	    $("#add").show();
	    $("#edt").hide();
}

function edt() {
	 var formdata = {
			 mname:$("#movies").val(),
		     hname: $("#movieHall").val(),
		     timespace: $("#times").val(),
		     m_m_id:$("#m_m_id").val(),
	};
   $.ajax({
       url: "updateMsg.do",
       timeout: 300000,
       dataType: "json",
       type: "post",
       data: formdata,
       success: function (data) {
           $("#addModal").modal("hide");
           layer.alert(data);
           load(curr);
       }
   });
}
//修改拍片信息
function openedt(m_m_id) {
	$("#m_m_id").val(m_m_id);
    $.ajax({
        url: "getOne.do",
        timeout: 300000,
        dataType: "json",
        type: "post",
        data: {"sid": m_m_id },
        success: function (data) {
        	//ajax请求成功后弹出修改数据的对话框
            $("#myModalLabel").text("修改排片信息");
            //将查询出来的数据显示到对话框中
            $("#movies").val(data.movie.mname);
            $("#movieHall").val(data.movieHall.hname);
            $("#times").val(data.time.timespace);
            $("#edt").show();
            $("#add").hide();
            $("#addModal").modal("show");
        }
    });
}



//删除操作
function del(m_m_id) {
    //询问框
    layer.confirm('您确定要删除？', {
        btn: ['确定', '取消'] //按钮
    }, function () {
        $.ajax({
            url: "deleteMsg.do",
            timeout: 300000,
            type: "post",
            data: {"scode": m_m_id },
            success: function (data) {
                layer.alert(data);
                load(curr);
            }
        });
    }, function () {
        //  layer.close();
    });
}
//检查时间段
$("#movieHall").blur(function(){
	var mname=$("#movies").val();
	var hall=$("#movieHall").val();
	$.ajax({
    	url: "checkTime.do",
        timeout: 300000,
        dataType: "json",
        type: "post",
        data: {"hname": hall},
        success: function (data) {
        	$("#times").html(data);
        }
    });
});
