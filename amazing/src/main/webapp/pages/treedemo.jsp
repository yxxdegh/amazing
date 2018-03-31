<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html>  
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<script type="text/javascript" src="lib/PIE-2.0beta1/PIE_IE678.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="<%=basePath%>/common/css/total.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/layui/css/layui.css" />
<link rel="stylesheet" href="<%=basePath%>/lib/zTree/v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>用户列表</title>
</head>
<body>
<div>
	<ul id="treeDemo" class="ztree"></ul>
</div>


<script type="text/javascript" src="<%=basePath%>/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="<%=basePath%>/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="<%=basePath%>/h-ui.admin/js/H-ui.admin.js"></script>
<script type="text/javascript" src="<%=basePath%>/layui/layui.js"></script> 
<script type="text/javascript" src="<%=basePath%>/lib/zTree/v3/js/jquery.ztree.core-3.5.js"></script> 
<script type="text/javascript">

var zTreeObj;

setting = {
		data: {
			simpleData: {
				enable: true,
				idKey: "Id",
				pIdKey: "PId",
				rootPId: 0
			}
		}
};

var nodes = [
         	 	{"Id":1, "PId":0, "name":"动物"},
			    {"Id":2, "PId":1, "name":"老虎"},
			    {"Id":3, "PId":1, "name":"狮子"},
			    {"Id":4, "PId":2, "name":"老虎1"},
			    {"Id":5, "PId":2, "name":"老虎2"}
         ];

$(function(){
	$.ajax({
		 type : "post",
		 async : false, // 同步请求
		 cache : false,// 不使用ajax缓存
		 contentType : "application/json",
		 url : "getTree.do",
		 dataType : "json",
		 success : function(data){
			 if (data.msg == 1) {
				layer.msg('成功');
				var nodes= data.nodes
				$.fn.zTree.init($("#treeDemo"), setting, nodes);
			 }
		 }
	 })
	

});		
	
</script>
</body>
</html>