<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="<%=basePath%>/layui/css/layui.css" />
<title>角色分配</title>
</head>
<body class="childrenBody">

<form action="" id="form" class="layui-form" method="post">
	<table class="layui-table" lay-skin="line">
		<tbody></tbody>
	</table>
</form>
<button id="save" class="layui-btn">保存</button>
 
<script type="text/javascript" src="<%=basePath%>/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="<%=basePath%>/layui/layui.js"></script>  
<script type="text/javascript" src="<%=basePath%>/common/js/cmn.js"></script>
<!--请在下方写此页面业务相关的脚本--> 
<script type="text/javascript">
$(function(){	
	layui.use(['layer','form'],function(){
		var layer = layui.layer;
		var form = layui.form;
		var id = getQueryString("Id");
		var index = parent.layer.getFrameIndex(window.name);// 获取当前子窗口索引
		$.post("getRolesByUserId.do",{"id":id},function(data) {
				//console.log(JSON.stringify(data));
			 if(data && data.length) {
				 var html =[];
				 $.each(data,function() {
						html.push("<tr><td><input type='checkbox' lay-skin='primary' id='");
						html.push(this.id);
						html.push("'");
						if(this.check){
							html.push(" checked='checked'");
						}
						html.push("name='RoleBo' title='");
						html.push(this.roleName);
						html.push("'/></td>");
						html.push("</tr>");
				});
				$("tbody").html(html.join(''));
				form.render(); // 强行刷新表单，否则动态生成的表单没有layui样式
			}
		},"json");
		
		
		$("#save").click(function(){
			var checked = $("#form  :checked");
			var ids=[]
			$.each(checked,function(){
				ids.push(this.id);
			});
			var data= JSON.stringify({"ids":ids,"userId":id});
			var load = layer.load();
			$.ajax({
				type : "post",
				cache : false,// 不使用ajax缓存
				async : false,
				contentType : "application/json",// data只能是json字符串
				url : 'saveRoleToUser.do',
				data : data,
				dataType : "json",
				success : function(data) {
				layer.close(load);
				if (data.msg != 1) {
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
			 			parent.layer.close(index);// 关闭当前窗口
						layer.msg('数据加载超时，请刷新重试！');
				 }
			})
		})
			
		
	})
});

</script> 
</body>
</html>