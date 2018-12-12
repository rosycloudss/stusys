<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/static/h-ui.admin/css/style.css" />
<title>我的课表</title>
</head>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>
		我的 <span class="c-gray en">&gt;</span> 我的成绩 <a
			class="btn btn-success radius r"
			style="line-height: 1.6em; margin-top: 3px"
			href="javascript:location.replace(location.href);" title="刷新"><i
			class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<div class="page-container">
		<div  align="center">
			<form action="<%=request.getContextPath()%>/student/course?flag=query&flag1=sl&stuNo=${student.getStuNo() }" method="post">
				<select name="semester" style="height: 30px;">
					<c:forEach items="${semesterList }" var="semester">
						<option value="${semester }" ${semester==currentSemester?"selected":"" } >${semester }</option>
					</c:forEach>
				</select>
				<input name="" id="" class="btn btn-success" type="submit" value="切换学期">
			</form>
		</div>
		<div class="cl pd-5 bg-1 bk-gray mt-20">
			<span style="margin-left: 10px;" class="l">学号：${student.getStuNo() }</span> <span
				style="margin-left: 10px;" class="l">姓名：${student.getName() } </span> 
			<div class="mt-20">
				<table
					class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
					<thead>
						<tr>
							<th width="10%">学年学期</th>
							<th width="10%">课程编号</th>
							<th width="20%">课程名称</th>
							<th width="14%">课程类别</th>
							<th width="9%">学分</th>
							<th width="9%">成绩</th>
							<th width="9%">绩点</th>
						</tr>

					</thead>
					<tbody>
					<c:forEach items="${scList }" var="sc">
						<tr class="text-c">
								<td>${sc.getTc().getSemester() }</td>
								<td>${sc.getTc().getCourse().getCourseNo() }</td>
								<td>${sc.getTc().getCourse().getCourseName() }</td>
								<td>${sc.getTc().getCourse().getCourseType() }</td>
								<td>${sc.getTc().getCourse().getCredt() }</td>
								<td>${sc.getScore().getScore() }
								<td>${sc.getScore().getGradePoint() }</td>
							</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript" src="<%=request.getContextPath() %>/lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/lib/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/static/h-ui/js/H-ui.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath() %>/static/h-ui.admin/js/H-ui.admin.js"></script>
	<!--/_footer 作为公共模版分离出去-->

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="<%=request.getContextPath() %>/lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript"
		src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/lib/laypage/1.2/laypage.js"></script>
</body>
</html>
