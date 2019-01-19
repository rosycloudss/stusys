<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/static/h-ui.admin/skin/default/skin.css"
	id="skin" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/static/h-ui.admin/css/style.css" />

<title>修改密码</title>
<body>
	<article class="page-container">
		<form action="<%=request.getContextPath()%>/student?f=u&f1=up" method="post" class="form form-horizontal"
			id="form-teacher-update" onsubmit="validate_form()">
			<input type="hidden" name="stuno" value="${student.getStuNo() }">
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red"></span>旧密码：</label>
				<div class="formControls col-xs-4 col-sm-4">
					<input type="password" class="input-text" value="" placeholder="请输入旧密码"
						id="old_password" name="old_password">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red"></span>新密码：</label>
				<div class="formControls col-xs-4 col-sm-4">
					<input type="password" class="input-text" value="" placeholder="请输入新密码"
						id="new_password" name="new_password">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red"></span>确认新密码：</label>
				<div class="formControls col-xs-4 col-sm-4">
					<input type="password" class="input-text" value="" placeholder="确认新密码"
						id="confirm_new_password" name="confirm_new_password">
				</div>
			</div>
			<div class="row cl">
				<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
					<input class="btn btn-primary radius" type="submit"
						value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
				</div>
			</div>
		</form>
	</article>

	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript" src="<%=request.getContextPath()%>/lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/lib/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/h-ui/js/H-ui.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/h-ui.admin/js/H-ui.admin.js"></script>
	<!--/_footer 作为公共模版分离出去-->

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/lib/jquery.validation/1.14.0/validate-methods.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/lib/jquery.validation/1.14.0/messages_zh.js"></script>
	<!--/请在上方写此页面业务相关的脚本-->
	
	<script type="text/javascript">
	
		function validate_form(){
			var old_password = $("#old_password").val();
			var new_password = $("#new_password").val();
			var confirm_new_password = $("#confirm_new_password").val();
			
			if(old_password == null || old_password == ""){
				alert("旧密码不能为空！");
				return false;
			}
			if(new_password == null || new_password == ""){
				alert("新密码不能为空！");
				return false;
			}
			
			if(new_password != confirm_new_password){
				alert("两次输入新密码不一致！");
				return false;
			}
		}
		
	</script>
	
</body>
</html>