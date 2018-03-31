<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html>
<html class="loginHtml">
<head>
	<meta charset="utf-8">
	<title>登录amazing</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="icon" href="<%=basePath%>/favicon.png"/>
	<link rel="stylesheet" href="<%=basePath%>/layuicms2.0/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="<%=basePath%>/layuicms2.0/css/public.css" media="all" />
</head>
<body class="loginBody">
	<form class="layui-form">
		<div class="login_face"><img src="<%=basePath%>/layuicms2.0/images/face.jpg" class="userAvatar"></div>
		<div class="layui-form-item input-item">
			<input type="text" placeholder="请输入用户名" id="userName" class="layui-input" >
		</div>
		<div class="layui-form-item input-item">
			<input type="password" placeholder="请输入密码"  id="password" class="layui-input">
		</div>
	<!-- 	<div class="layui-form-item input-item" id="imgCode">
			<label for="code">验证码</label>
			<input type="text" placeholder="请输入验证码" autocomplete="off" id="code" class="layui-input">
			<img src="../../images/code.jpg">
		</div> -->
		<div class="layui-form-item">
			<input id="login" type="button" class="layui-btn layui-block" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
		</div>
	</form>
	<!-- <div class="footer">Copyright© 2013-<span id="year"></span> All Rights Reserved. 天一文化传播有限公司 版权所有</div> -->
	<script type="text/javascript" src="<%=basePath%>/layuicms2.0/layui/layui.js"></script>
	<script type="text/javascript">
	layui.use(['layer','jquery'],function(){
	    layer = parent.layer === undefined ? layui.layer : top.layer
	        $ = layui.jquery;

	    //登录按钮
	    document.onkeydown=function(event){
			var e = event || window.event || arguments.callee.caller.arguments[0];
			if(e && e.keyCode==13){ 
				$('#login').click();
			}
		};  
		$('#login').on("click",function(){
			var userName=$("#userName").val();
			var password=$("#password").val();
			if (userName == "") {
				layer.msg("请输入用户名");
				return;
			}
			if (password == "") {
				layer.msg("请输入密码");
				return;
			}
			var data = {userName:userName,password:password};
			$.ajax({
				url : "login.do",
				data : data,
				type : "post",
				dataType : "json",
				success:function(data){
					if(data.msg != 1){
						layer.msg("登录失败，请检查用户名或密码");
		    			$('#password').val('');
		    			$('#userName').val('');
		    			return;
		    		}else{
		    			layer.msg('登录成功！');
		    			setTimeout(function(){
		    				//登录后跳转
			    			window.location.href= data.url;
		    			},1000)
		    		}
				}
			})
		});

	    //表单输入效果
	    $(".loginBody .input-item").click(function(e){
	        e.stopPropagation();
	        $(this).addClass("layui-input-focus").find(".layui-input").focus();
	    })
	    $(".loginBody .layui-form-item .layui-input").focus(function(){
	        $(this).parent().addClass("layui-input-focus");
	    })
	    $(".loginBody .layui-form-item .layui-input").blur(function(){
	        $(this).parent().removeClass("layui-input-focus");
	        if($(this).val() != ''){
	            $(this).parent().addClass("layui-input-active");
	        }else{
	            $(this).parent().removeClass("layui-input-active");
	        }
	    })
	    
	    
	    
	})

	</script>
</body>
</html>