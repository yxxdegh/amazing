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
	<form action="" method="post" class="layui-form" id="form-userUpdate">
	<input type="hidden" id="id" name="id" value="">
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
		    <div class="layui-input-block">
		    	<input id="submit" type="submit" class="layui-btn" value="提交">
		    </div>
		</div>
	</form>

<script type="text/javascript" src="<%=basePath%>/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="<%=basePath%>/layuicms2.0/layui/layui.js"></script> 
<script type="text/javascript" src="<%=basePath%>/lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="<%=basePath%>/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="<%=basePath%>/common/js/cmn.js"></script> 
<!--请在下方写此页面业务相关的脚本--> 
<script type="text/javascript">
$(function(){
	layui.use(['layer'],function(){
		var layer = layui.layer;
		
		var id = getQueryString("Id");
		$('#id').val(id); 
		$.post("getUserById.do",{"id":id},function(data){
			if(data.msg == 1){
				var user=data.user;
				$('#userName').val(user.userName);
				$('#email').val(user.email);
			}
		},"json"); 
		
	  // 在键盘按下并释放及提交后验证提交表单                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
		$("#form-userUpdate").validate({
			rules: {
		    	userName: {
		        required: true,
		        minlength: 2
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
			email: "请输入一个正确的邮箱",
		    }
		}); 
	});
	 $.validator.setDefaults({
	    submitHandler: function() {
	    	layer.load(2);// 进度转动动画
		 	var param = $("#form-userUpdate").serialize(); // 序列化表单数据  如果想忽略某些字段，那么只需要把name去掉，或者设置disabled="disabled"即可
		 	var index = parent.layer.getFrameIndex(window.name);// 获取当前子窗口索引
		 	$.ajax({
		 		type : "post",
		 		url : "updateUser.do",
		 		data : param,
		 		dateType : "json",
		 		success : function(data) {
		 			layer.closeAll('loading');// 关闭进度转动动画
		 			if(data.msg != 1) {
		 				layer.msg("修改失败");
		 				return;
		 			}
		 			// 父窗口弹出提示
		 			parent.layer.msg("修改成功",{
		 				icon:1,
		 				time: 2000 //2秒关闭（如果不配置，默认是3秒）
		 			},function(){
		 				//parent.location.reload();// 父页面刷新
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