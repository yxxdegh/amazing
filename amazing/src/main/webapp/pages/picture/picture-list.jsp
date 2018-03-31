<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html>  
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/layui/css/layui.css"/>
<title>图片列表</title>
</head>
<body>
  
	<blockquote class="layui-elem-quote quoteBox">
			<div class="layui-inline">
				<input type="text" class="layui-input" placeholder=" 图片名称" id="">
			</div>
			<div class="layui-inline">
				<button name="" id="" class="layui-btn" type="submit">搜图片</button>
				<button class="layui-btn layui-btn-normal layui-btn-sm" id="doQuery" name="doQuery" data-type="reload"><i class="layui-icon">&#xe615;</i> 查询</button>
			</div>
	</blockquote>
	
	<blockquote class="layui-elem-quote quoteBox">
		<button id="addPicture" class="layui-btn layui-btn-primary layui-btn-sm "><i class="layui-icon">&#xe654;</i></button>
	</blockquote>
	
	<table id="pictureList" class="layui-hide" ></table>


<script type="text/javascript" src="<%=basePath%>/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="<%=basePath%>/layuicms2.0/layui/layui.js"></script> 
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript">
$(function(){
	
	layui.use(['layer','table','element','laydate'],function(){
		var table = layui.table;
		var layer = layui.layer;
		var element =layui.element;
		var laydate = layui.laydate;
		
		table.render({
			elem : '#pictureList',// 指定原始表格元素选择器（推荐id选择器）
			url : 'listAllPicture.do',
			page : {
				    theme : '#5eb95e' , // 分页主题颜色
				   	curr :  1,// 起始页  默认值1
				    limit : 5,  // 每页显示的条数  默认值10
				    limits : [5,10,15,20],
				    layout : [ 'count','prev', 'page', 'next','skip','limit'], // 自定义排版
				    first : '首页 ', // 自定义“首页”的内容
				    last : '尾页 ',  // 自定义“尾页 ”的内容
				    groups :3,  // 连续出现的页码个数 默认是5
			} ,// 开启分页
			cols : [[ // 表头
			         {type:'checkbox'},
			         {field: 'id', title: 'ID', width:80, sort: true},
			         {field: 'pictureName', title: '图片名字'},
			         {field: 'src', title: '路径',templet:'#showImg'},
			         {field: 'description', title: '图片描述'},
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
	})
	
		
	//添加图片
	$("#addPicture").on("click", function(){
		layer.open({
			type: 2, // iframe层
			title: '新建图片信息',
			area: ['800px', '550px'],
			maxmin: true,
			content: 'picture-add.jsp'
		})
	});

})
	
</script>
<script type="text/html" id="showImg">
	<div><img src="{{d.src}}"></div>
</script>
</body>
</html>