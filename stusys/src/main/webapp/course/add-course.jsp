<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
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
<title>添加课程</title>
<link
	href="<%=request.getContextPath()%>/lib/webuploader/0.1.5/webuploader.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="page-container">
		<form action="<%=request.getContextPath() %>/course?f=a" class="form form-horizontal" id="form-article-add" method="post">
			<div class="row cl">
				<label class="form-label col-xs-2 col-sm-2">课程名称：</label>
				<div class="formControls col-xs-4 col-sm-4">
					<input type="text" class="input-text" value="" placeholder="" id=""
						name="courseName">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-2 col-sm-2">课程简介：</label>
				<div class="formControls col-xs-6 col-sm-7">
					<textarea name="courseDescription" cols="" rows="" class="textarea"
						placeholder="输入课程简介" datatype="*10-100" dragonfly="true"
						nullmsg="简介不能为空！" onKeyUp="$.Huitextarealength(this,200)"></textarea>
					<p class="textarea-numberbar">
						<em class="textarea-length">0</em>/200
					</p>
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-2 col-sm-2">专业：</label>
				<div class="formControls col-xs-4 col-sm-4">
					<span class="select-box"> <select name="major" class="select">
							<c:if test="${deptList != null }">
								<c:forEach items="${deptList }" var="dept">
									<c:forEach items="${dept.getMajors() }" var="m">
										<option value="${m.getMajorNo() }">${m.getMajorName() }</option>
									</c:forEach>
								</c:forEach>
							</c:if>
					</select>
					</span>
				</div>

			</div>
			<div class="row cl">
				<label class="form-label col-xs-2 col-sm-2">学分：</label>
				<div class="formControls col-xs-1 col-sm-1">
					<select name="credt" class="select">
						<option value="0.5">0.5</option>
						<option value="1">1</option>
						<option value="1.5">1.5</option>
						<option value="2">2</option>
						<option value="2.5">2.5</option>
						<option value="3">3</option>
						<option value="3.5">3.5</option>
						<option value="4">4</option>
						<option value="4.5">4.5</option>
						<option value="5">5</option>
						<option value="5.5">5.5</option>
						<option value="6">6</option>
					</select>
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-2 col-sm-2">学时：</label>
				<div class="formControls col-xs-1 col-sm-1">
					<select name="classHour" class="select">
						<option value="8">8</option>
						<option value="16">16</option>
						<option value="32">32</option>
						<option value="64">64</option>
					</select>
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-2 col-sm-2">专业：</label>
				<div class="formControls col-xs-4 col-sm-4">
					<span class="select-box"> <select name="courseType" class="select">
							<option value="工科">工科</option>
							<option value="理科">理科</option>
							<option value="文科">文科</option>
							<option value="医科">医科</option>
					</select>
					</span>
				</div>
			</div>
			
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<input onClick="article_save_submit();"
					class="btn btn-primary radius" type="submit" value="提交">
				<input onClick="layer_close();" class="btn btn-default radius"
					type="reset" value="&nbsp;&nbsp;取消&nbsp;&nbsp;">
			</div>
		</form>
	</div>
	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/lib/layer/2.4/layer.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/static/h-ui/js/H-ui.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/static/h-ui.admin/js/H-ui.admin.js"></script>
	<!--/_footer /作为公共模版分离出去-->

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/lib/jquery.validation/1.14.0/validate-methods.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/lib/jquery.validation/1.14.0/messages_zh.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/lib/webuploader/0.1.5/webuploader.min.js"></script>
</body>
</html>