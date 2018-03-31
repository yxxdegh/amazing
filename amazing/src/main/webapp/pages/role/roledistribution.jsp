<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="<%=basePath%>/layui/css/layui.css" />
<title></title>
</head>
<body class="childrenBody">
	<blockquote class="layui-elem-quote quoteBox">
		<button id="update" class="layui-btn layui-btn-primary layui-btn-sm"><i class="layui-icon">&#xe642;角色分配</i></button>
	</blockquote>
	<table id="list" class="layui-hide" lay-filter="list"></table>
 
<script type="text/javascript" src="<%=basePath%>/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="<%=basePath%>/layui/layui.js"></script> 
<script type="text/javascript">
$(function(){
	layui.use(['layer','table'],function(){
		
		var table = layui.table;
		var layer = layui.layer;
		var laydate = layui.laydate;
		
		table.render({
			elem : '#list',// 指定原始表格元素选择器（推荐id选择器）
			url : 'listAllUserRole.do',
			page : {
				    theme : '#1E9FFF' , // 分页主题颜色
				   	curr :  1,// 起始页  默认值1
				    limit : 5,  // 每页显示的条数  默认值10
				    limits : [5,10,15,20],
				    layout : [ 'count','prev', 'page', 'next','skip','limit'], // 自定义排版
				    first : '首页 ^_^o ', // 自定义“首页”的内容
				    last : '尾页 ^_^o ',  // 自定义“尾页 ”的内容
				    groups :3,  // 连续出现的页码个数 默认是5
			} ,// 开启分页
			cols : [[ // 表头
			         {type:'checkbox'},
			         {field: 'id', title: 'ID', width:80, sort: true},
			         {field: 'userName', title: '姓名'},
			         {field: 'roleNames', title: '拥有的角色'},
			       ]],
			method : 'post',
			request : {
	    		pageName : 'currentPage', // 页码的参数名称，默认：page
	    		limitName : 'pageSize' // 每页数据量的参数名，默认：limit
	    	 },
	    	text: {
	    		    none: '暂无相关数据哦，请重新查找.....' //默认：无数据。
	    		  },
			done: function(res, curr, count){
				
			}	 
		})
		
		
		// 修改
		$("#update").click(function(){
			var checkStatus = table.checkStatus('list');// list即为基础参数id对应的值
			var selectCount = checkStatus.data.length;// 获取选中行数量，可作为是否有选中行的条件
			 if (selectCount != 1) {
				layer.msg("请选择其中1个修改！");
				return false;
			} 
			var data=checkStatus.data;// 获取选中行的数据
			var id=data[0].id;// 获取选中行的id
			layer.open({
				title : '添加角色',
				type : 2,
				maxmin: true,
				area : ['800px','550px'],
				content : 'roledistribution-update.jsp?Id='+id,
			});
		})
	})
})
</script> 		
</body>
</html>