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
	<c:if test="${course!=null }">
	<form action="#" onsubmit="return false" class="form form-horizontal" id="form-teacher-select" method="post">
			<div class="row cl">
				<label class="form-label col-xs-2 col-sm-2">课程编号：</label>
				<div class="formControls col-xs-4 col-sm-4">
					<input type="text" disabled="disabled" class="input-text" value="${course.getCourseNo() }" placeholder="" id="">
					<input type="hidden" value="${course.getCourseNo() }" name="courseNo">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-2 col-sm-2">课程名称：</label>
				<div class="formControls col-xs-4 col-sm-4">
					<input type="text"  disabled="disabled" class="input-text" value="${course.getCourseName() }" placeholder="" id=""
						name="courseName">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-2 col-sm-2">学分：</label>
				<div class="formControls col-xs-1 col-sm-1">
					<input type="text" class="input-text"  disabled="disabled" value="${course.getCredt() }" placeholder="" id=""
						name="credt">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-2 col-sm-2">学时：</label>
				<div class="formControls col-xs-1 col-sm-1">
					<input type="text"  disabled="disabled" class="input-text" value="${course.getClassHour() }" placeholder="" id=""
							name="classHour">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-2 col-sm-2">专业：</label>
				<div class="formControls col-xs-4 col-sm-4">
					<input type="text"  disabled="disabled" class="input-text" value="${course.getMajor().getMajorName() }" placeholder="" id=""
							name="courseType">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-2 col-sm-2">学期：</label>
				<div class="formControls col-xs-4 col-sm-4">
					<span class="select-box"> <select name="semester" class="select">
						<c:forEach items="${semesterList }" var="semester">
							<option value="${semester }" ${semester==currentSemester?"selected":"" } >${semester }</option>
						</c:forEach>
					</select>
					</span>
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-2 col-sm-2">上课时间：</label>
				<div class="formControls col-xs-4 col-sm-4">
					<span class="select-box"> <select name="teachTime" class="select">
						<option value="周一上午一二节课">周一上午一二节课</option>
						<option value="周一上午三四节课">周一上午三四节课</option>
						<option value="周一下午五六节课">周一下午五六节课</option>
						<option value="周一下午七八节课">周一下午七八节课</option>
						<option value="周一晚上七八节课">周一下午九十节课</option>
					</select>
					</span>
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-2 col-sm-2">上课地点：</label>
				<div class="formControls col-xs-4 col-sm-4">
					<span class="select-box"> <select name="teachAddress" class="select">
						<option value="北1101">北1101</option>
						<option value="北1102">北1102</option>
						<option value="北1103">北1103</option>
						<option value="北1104">北1104</option>
					</select>
					</span>
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-2 col-sm-2">学生数量：</label>
				<div class="formControls col-xs-4 col-sm-4">
					<span class="select-box"> <select name="studentNum" class="select">
						<option value="40">40</option>
						<option value="50">50</option>
						<option value="60">60</option>
						<option value="70">70</option>
						<option value="80">80</option>
						<option value="90">90</option>
						<option value="100">100</option>
						<option value="150">150</option>
						<option value="200">200</option>
						<option value="250">250</option>
						<option value="300">300</option>
						<option value="350">350</option>
						<option value="400">400</option>
					</select>
					</span>
				</div>
			</div>
			<input type="hidden" name="teacherNo" value="${teacher.getTeacherNo() }">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<input onClick="form_submit();"
					class="btn btn-primary radius" type="button" value="提交">
				<input onClick="layer_close();" class="btn btn-default radius"
					type="reset" value="&nbsp;&nbsp;取消&nbsp;&nbsp;">
			</div>
			
		</form>
		</c:if>
	</div>
	<script type="text/javascript">
		function form_submit(){
			$.ajax({
				type: 'POST',
				url: 'http://localhost:8080/stusys/teacher_course?flag=add',
				dataType: 'json',
				data:$("#form-teacher-select").serialize(),
				success: function(result){
					if(result.addResult > 0){
						alert("选择成功！");
					}else{
						alert("选择失败！");
					}
					var index = parent.layer.getFrameIndex(window.name);
					//parent.$('.btn-refresh').click();
					parent.layer.close(index);
				}, 
				error:function(result) {
					console.log(result.msg);
				},
			});		
		}
	</script>
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