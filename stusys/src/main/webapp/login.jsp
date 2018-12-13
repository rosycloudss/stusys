<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<link href=" <%=request.getContextPath()%>/static/h-ui/css/H-ui.min.css"
	rel="stylesheet" type="text/css" />
<link
	href=" <%=request.getContextPath()%>/static/h-ui.admin/css/H-ui.login.css"
	rel="stylesheet" type="text/css" />
<link
	href=" <%=request.getContextPath()%>/static/h-ui.admin/css/style.css"
	rel="stylesheet" type="text/css" />
<link
	href=" <%=request.getContextPath()%>/lib/Hui-iconfont/1.0.8/iconfont.css"
	rel="stylesheet" type="text/css" />
<style type="text/css">
.leftloginBox {
	position: absolute;
	width: 617px;
	height: 330px;
	background: url(static/h-ui.admin/images/admin-loginform-bg.png)
		no-repeat;
	left: 50%;
	top: 50%;
	margin-left: -620px;
	margin-top: -184px;
	padding-top: 38px
}

.rightloginBox {
	position: absolute;
	width: 617px;
	height: 330px;
	background: url(static/h-ui.admin/images/admin-loginform-bg.png)
		no-repeat;
	left: 50%;
	top: 50%;
	margin-left: 20px;
	margin-top: -184px;
	padding-top: 38px
}
</style>
<title>lw学生管理系统登录</title>
</head>
<body>
	<input type="hidden" id="TenantId" name="TenantId" value="" />
	<div class="header"></div>
	<div class="loginWraper">
		<div id="loginform" class=loginWraper"">
			<div class=leftloginBox>
				<!-- 学生登录 -->
				<form id="student_login" class="form form-horizontal" title="学生登录"
					action=" <%=request.getContextPath()%>/studentLogin"
					method="post">
					<div class="row cl">
						<label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
						<div class="formControls col-xs-8">
							<input id="" name="stuNo" type="text" placeholder="学号"
								class="input-text size-L">
						</div>
					</div>
					<div class="row cl">
						<label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
						<div class="formControls col-xs-8">
							<input id="" name="password" type="password" placeholder="密码"
								class="input-text size-L">
						</div>
					</div>
					<div class="row cl">
						<div class="formControls col-xs-8 col-xs-offset-3">
							<input name="" type="submit"
								class="btn btn-success radius size-L"
								value="学生登录"> <input
								name="" type="reset" class="btn btn-default radius size-L"
								value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;">
						</div>
					</div>
				</form>
			</div>
			<div class="rightloginBox">
				<!-- 教师登录 -->
				<form id="teacher-login" class="form form-horizontal"
					action=" <%=request.getContextPath()%>/teacherLogin" method="post">
					<div class="row cl">
						<label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
						<div class="formControls col-xs-8">
							<input id="" name="teacherNo" type="text" placeholder="教师编号"
								class="input-text size-L">
						</div>
					</div>
					<div class="row cl">
						<label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
						<div class="formControls col-xs-8">
							<input id="" name="password" type="password" placeholder="密码"
								class="input-text size-L">
						</div>
					</div>
					<div class="row cl">
						<div class="formControls col-xs-8 col-xs-offset-3">
							<input name="" type="submit"
								class="btn btn-success radius size-L"
								value="教师登录"> <input
								name="" type="reset" class="btn btn-default radius size-L"
								value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src=" <%=request.getContextPath()%>/lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript"
		src=" <%=request.getContextPath()%>/static/h-ui/js/H-ui.min.js"></script>
	<script type="text/javascript">
		$("#student_login_button").click(function() {
			$("#student_login").show();
			$("#teacher_login").hide();
		});
		$("#teacher_login_button").click(function() {
			$("#student_login").hide();
			$("#teacher_login").show();
		});
	</script>
</body>
</html>