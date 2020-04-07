var curr = 1;
$(function () {
    load(curr);
});
function load(curr) {
    $.ajax({
    	url: "moviehallListByPage.do",
        timeout: 300000,
        data:{"currentPage":curr},
        dataType: "json",
        type: "post",
        success: function (data) {
            var html = "";
            $.each(data.content, function (i, item) {
                html += " <tr> " +
                		" <td>" + item.hid +"</td> " +
                        " <td>" + item.hname + "</td> " +
                        " <td>" + item.hnum + "</td> " +
                        " <td>" + item.hstate + "</td> " +
                        " <td><a class=\"btn btn-info\" onclick='openedt(\"" + item.hid + "\");'>修改</a>&nbsp;&nbsp;<a class=\"btn btn-warning\" onclick='del(\"" + item.hid + "\");'>删除</a></td> " +
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
           
         }
      });
}
function first(){
	//$("#first").attr("href","<%=path%>/moviehallListByPage.do&currentPage=1");
	load(1);
}
function last(totalPage){
	alert(totalPage);
	//$("#last").attr("href","<%=path%>/moviehallListByPage.do&currentPage="+totalPage);
	load(totalPage);
}
function pre(currentPage){
	if(currentPage==1){
		alert("已经第一页了");
	}else{
		//$("#pre").attr("href","<%=path%>/moviehallListByPage.do&currentPage="+(currentPage-1));
		load(currentPage-1);
	}
}
function next(currentPage,totalPage){
	if(currentPage==totalPage){
		alert("已经最后一页了");
	}else{
		//$("#next").attr("href","<%=path%>/moviehallListByPage.do&currentPage="+(currentPage+1));
		
		load(Number(currentPage)+Number(1));
	}
}
function openadd() {
	  $("#myModalLabel").text("添加影厅");
	    $("#userName").attr("readonly", false);
	    $("input:not(:radio)").val("");
	    $("#addModal").modal("show");
	    $("#add").show();
	    $("#edt").hide();
}


function add() {
   /* if ($("#userName").val() == "") {
        layer.tips('姓名不能为空', '#userName');
        return;
    }
    if ($("#code").val() == "") {
        layer.tips('学号不能为空', '#code');
        return;
    }
    if ($("#age").val() == "") {
        layer.tips('年龄不能为空', '#age');
        return;
    }*/
    var formdata = {
        hname: $("#hname").val(),
        hnum: $("#hnum option:checked").text(),
        hstate: $("#hstate option:checked").text(),
    }
    $.ajax({
        url: "addMovieHall.do",
        timeout: 300000,
        type: "post",
        data:formdata,
        success: function (data) {
            $("#addModal").modal("hide");
            layer.alert(data);
            $("input").val("");
            load(curr);
        }
    });
}
function openedt(hid) {
	$("#hid").val(hid);//给对话框中的隐藏sid标签赋值
    $.ajax({
        url: "findById.do",
        timeout: 300000,
        dataType: "json",
        type: "post",
        data: {"hid": hid },
        success: function (data) {
        	//ajax请求成功后弹出修改数据的对话框
            $("#myModalLabel").text("修改影厅");
            //将查询出来的数据显示到对话框中
            $("#hid").val(data.hid);
            $("#hname").val(data.hname);
            $("#hnum").val(data.hnum);
            $("#hstate").val(data.hstate);
            $("#edt").show();
            $("#add").hide();
            $("#addModal").modal("show");
        }
    });
}

function edt() {
	 var formdata = {
			 hid:$("#hid").val(),
		     hname: $("#hname").val(),
		     hnum: $("#hnum option:checked").text(),
		     hstate: $("#hstate option:checked").text(),
		    /* hnum: $("#code").val(),
		     hstate: $("input:checked").val(),*/
	}
    $.ajax({
        url: "updateMovieHall.do",
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


function del(hid) {
    //询问框
    layer.confirm('您确定要删除？', {
        btn: ['确定', '取消'] //按钮
    }, function () {
        $.ajax({
            url: "del.do",
            timeout: 300000,
            type: "post",
            data: {"hid": hid },
            success: function (data) {
                layer.alert(data);
                load(curr);
            }
        });
    }, function () {
          layer.close();
    });

}