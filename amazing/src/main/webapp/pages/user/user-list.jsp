<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html>  
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="<%=basePath%>/layuicms2.0/css/public.css" media="all" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/layuicms2.0/layui/css/layui.css" />
<title></title>
</head>
<body class="childrenBody">
	<blockquote class="layui-elem-quote quoteBox">
			<div class="layui-inline">开始日期:</div>
			<div class="layui-inline">
				<input type="text" class="layui-input" id="startTime" >
			</div>
			<div class="layui-inline">结束日期:</div>
			<div class="layui-inline">
				<input type="text" class="layui-input" id="endTime"  >
			</div>
			<div class="layui-inline">搜索ID:</div>	
			<div class="layui-inline">
				<input type="text" class="layui-input"  placeholder="输入查询条件" id="id" name="id" >
			</div>
			<div class="layui-inline">姓名:</div>
			<div class="layui-inline">
				<input  type="text" class="layui-input"  placeholder="输入查询条件" id="userName" name="userName">
			</div>
			<div class="layui-inline">
				<button class="layui-btn layui-btn-normal layui-btn-sm" id="doQuery" name="doQuery" data-type="reload"><i class="layui-icon">&#xe615;</i> 查询</button>
			</div>
	</blockquote>

	<blockquote class="layui-elem-quote quoteBox">
			<button id="addUser" class="layui-btn layui-btn-primary layui-btn-sm "><i class="layui-icon">&#xe654;</i></button>
			<button id="updateUser" class="layui-btn layui-btn-primary layui-btn-sm "><i class="layui-icon">&#xe642;</i></button>
			<button id="deleteIds" class="layui-btn layui-btn-primary layui-btn-sm"><i class="layui-icon">&#xe640;</i></button>
	</blockquote>
	
	<table id="userList" class="layui-hide" lay-filter="userList"></table>
	

<script type="text/javascript" src="<%=basePath%>/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="<%=basePath%>/layuicms2.0/layui/layui.js"></script> 

<script type="text/javascript">
$(function(){
	layui.use(['layer','table','laydate'],function(){
		
		var table = layui.table;
		var layer = layui.layer;
		var laydate = layui.laydate;
		
		table.render({
			elem : '#userList',// 指定原始表格元素选择器（推荐id选择器）
			url : 'listAllUser.do',
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
			         {field: 'email', title: '邮箱'},
			         {field: 'createTime', title: '创建时间'},
			         {field: 'lastLoginTime', title: '最后登录时间'}
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
		
		var a = laydate.render({
			elem: '#startTime',
			done: function(value, date, endDate) {
				b.config.min = {
					year: date.year,
					month: date.month - 1,
					date: date.date,
					hours: date.hours,
					minutes: date.minutes,
					seconds: date.seconds
				}
			}
		});
		var b = laydate.render({
			elem: '#endTime',
			min: '2017-09-20'
		});
		
		var active = {
	    	reload: function(){
		      	var id = $('#id').val();
		      	var userName = $('#userName').val();
		      	var startTime = $('#startTime').val();
		      	var endTime = $('#endTime').val();
	      	// 执行重载
	      		table.reload('userList', {
	       			where: {
	       				id : id,
	       				userName : userName,
			 	        startTime : startTime,  
			 	        endTime : endTime  
	        		}
	     		 });
	   	 	}
	  	};
		
		// 条件查询
		 $('#doQuery').on("click",function(){
		    var type = $(this).data('type');
		    active[type] ? active[type].call(this) : '';
		 });
		
		// 修改用户
		$("#updateUser").on("click",function(){
			var checkStatus = table.checkStatus('userList');// userList即为基础参数id对应的值
			var selectCount = checkStatus.data.length;// 获取选中行数量，可作为是否有选中行的条件
			 if (selectCount != 1) {
				layer.msg("请选择其中1个修改！");
				return false;
			} 
			var data=checkStatus.data;// 获取选中行的数据
			var id=data[0].id;// 获取选中行的id
			layer.open({
				title : '修改用户',
				type : 2,
				area : ['800px','550px'],
				maxmin: true,
				content : 'user-update.jsp?Id='+id,
			});
		})
		
		// 删除用户 支持批量
		$("#deleteIds").on("click",function(){
			var checkStatus = table.checkStatus('userList');// userList即为基础参数id对应的值
			var selectCount = checkStatus.data.length;// 获取选中行数量，可作为是否有选中行的条件
			if (selectCount == 0){
				layer.msg('请选择要删除的项',function(){});
				return false;
			}
			layer.confirm('真的要删除选中的项吗？',function(index){
				layer.close(index);
				layer.load(2);
				var ids = new Array(selectCount);
				for(var i=0; i<selectCount; i++){
					ids[i]=checkStatus.data[i].id;
				}
				var jsonIds= JSON.stringify(ids);
				$.ajax({
					 type : "post",
					 async : false, // 同步请求
					 cache : false,// 不使用ajax缓存
					 contentType : "application/json",
					 url : "deleteUserByIds.do",
					 data : jsonIds,
					 dataType : "json",
					 success : function(data){
						 if (data.msg == 1) {
							layer.closeAll('loading');
							$(".layui-laypage-btn")[0].click(); // 当前页刷新.思路是模拟点击分页按钮
							layer.msg('成功删除'+data.successCount+'个用户');
						 }
					 }
				 })
			}) 
		})
	})

	
	//添加用户
	$("#addUser").on("click",function(){
		layer.open({
			type: 2, // iframe层
			title: '新建用户信息',
			area: ['800px', '550px'],
			maxmin: true,
			content: 'user-add.jsp'
		})
	});

});	
</script>
</body>
</html>