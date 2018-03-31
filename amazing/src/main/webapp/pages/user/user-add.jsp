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

	<form action="" method="post" class="layui-form" id="form-userSave">
		<div class="layui-form-item">
			<label class="layui-form-label">用户名：</label>
			<div class="layui-input-block">
     			<input type="text" class="layui-input" placeholder="请输入用户名" id="userName" name="userName">
    		</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">邮箱：</label>
			<div class="layui-input-block">
     			<input type="text" class="layui-input" placeholder="请输入邮箱" id="email" name="email">
    		</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">密码：</label>
			<div class="layui-input-inline">
     			<input type="password" class="layui-input" placeholder="请输入密码" id="password" name="password">
    		</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">确认密码：</label>
			<div class="layui-input-inline">
     			<input type="password" class="layui-input" placeholder="请确认密码" id="password2" name="password2">
    		</div>
    		<div class="col-xs-8 col-sm-6 col-xs-offset-4 col-sm-offset-3"></div>
		</div>
		<div class="layui-form-item">
		    <div class="layui-input-block">
		    	<input id="submit" type="submit" class="layui-btn" value="提交">
		    </div>
		</div>
	</form>

<script type="text/javascript" src="<%=basePath%>/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/layuicms2.0/layui/layui.js"></script>  
<script type="text/javascript" src="<%=basePath%>/lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="<%=basePath%>/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<!--请在下方写此页面业务相关的脚本--> 
<script type="text/javascript">
$(function(){	
	layui.use(['layer'],function(){
	var layer = layui.layer;
	// 在键盘按下并释放及提交后验证提交表单
	$("#form-userSave").validate({
		rules: {
			userName: {
		    required: true,
		    minlength: 2
			},
		password: {
		    required: true,
		    minlength: 6
			},
		password2: {
		    required: true,
		    equalTo: "#password"
		  	},
		email: {
		    required: true,
		    email: true
		  	},
		},
		messages: {
			userName: {
		    required: "请输入用户名",
		    minlength: "用户名必需由两个字母组成"
		  	},
		  password: {
		    required: "请输入密码",
		    minlength: "密码长度不能小于 5 个字母"
		  	},
		  password2: {
		    required: "请输入密码",
		    equalTo: "两次密码输入不一致"
		  	},
		  email: "请输入一个正确的邮箱",
		}
	});
	});	
});	
$.validator.setDefaults({
    submitHandler: function() {
    	layer.load(2);// 进度转动动画
    	var param = $("#form-userSave").serialize(); // 序列化表单数据
    	var index = parent.layer.getFrameIndex(window.name);// 获取当前子窗口索引
	 	$.ajax({
	 		type : "post",
	 		url : "saveUser.do",
	 		data : param,
	 		dateType : "json",
	 		success : function(data) {
	 			layer.closeAll('loading');// 关闭进度转动动画
	 			if(data.msg != 1) {
	 				layer.msg("添加失败");
	 				return;
	 			}
	 			// 父窗口弹出提示
	 			parent.layer.msg("添加成功",{
	 				icon:1,
	 				time: 2000 //2秒关闭（如果不配置，默认是3秒）
	 			},function(){
	 				parent.$(".layui-laypage-btn")[0].click(); // 当前页刷新.思路是模拟点击分页按钮
	                parent.layer.close(index);// 关闭当前窗口
	 			});
	 		},
	 		error : function() {
	 			layer.closeAll('loading');
				layer.msg('数据加载超时，请刷新重试！');
			}
	 	})
    }
});
</script>
<style>
.error{
	color:red;
}
</style> 
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>