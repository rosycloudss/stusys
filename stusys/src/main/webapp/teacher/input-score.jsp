<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
<title>教师列表</title>
</head>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>
		录入分数 <a class="btn btn-success radius r"
			style="line-height: 1.6em; margin-top: 3px"
			href="javascript:location.replace(location.href);" title="刷新"><i
			class="Hui-iconfont">&#xe68f;</i></a>
	</nav>

	<div class="page-container">
		<span style="margin-left: 10px;" class="l">课程编号：${teacherCourse.getCourse().getCourseNo() }</span>
		<span style="margin-left: 10px;" class="l">课程名称：${teacherCourse.getCourse().getCourseName() }
		</span>
		<div class="mt-20">
			<form action="<%=request.getContextPath() %>/student/course?f=u"  class="form form-horizontal" method="post">
				<table
					class="table table-border table-bordered table-hover table-bg ">
					<thead>
						<tr class="text-c">
							<th width="80">学号</th>
							<th width="80">姓名</th>
							<th width="80">分数</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${scList != null }">
							<c:forEach items="${scList }" var="sc">
								<tr class="text-c">
									<td>${sc.getStudent().getStuNo() }</td>
									<td>${sc.getStudent().getName() }</td>
									<td><input name="${sc.getScNo() }"  class="input-text"
										value="${sc.getScore().getScore() != -1 ? sc.getScore().getScore():0 }"></td>
								</tr>
							</c:forEach>
						</c:if>
					</tbody>
				</table>
				<div align="center" style="width: 100%; align-content: center">
					<input type="submit" class="btn btn-primary radius" value="提交">
				</div>
			</form>
		</div>
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
	<!--/_footer 作为公共模版分离出去-->

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/lib/laypage/1.2/laypage.js"></script>

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/lib/jquery.contextmenu/jquery.contextmenu.r2.js"></script>


</body>
</html>