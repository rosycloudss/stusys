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
<title>课程列表</title>
</head>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>
		课程列表 <a class="btn btn-success radius r"
			style="line-height: 1.6em; margin-top: 3px"
			href="javascript:location.replace(location.href);" title="刷新"><i
			class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<div class="page-container">
		<div class="mt-20">
			<table
				class="table table-border table-bordered table-hover table-bg ">
				<thead>
					<tr class="text-c">
						<th width="100">课程编号</th>
						<th width="40">课程名称</th>
						<th width="80">简介</th>
						<th width="20">专业</th>
						<th width="10">学分</th>
						<th width="10">学时</th>
						<th width="70">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${courseList != null }">
						<c:forEach items="${courseList }" var="course">
							<tr class="text-c">
								<td>${course.getCourseNo() }</td>
								<td>${course.getCourseName() }</td>
								<td>${course.getCourseDescription() }</td>
								<td>${course.getMajor().getMajorName() }</td>
								<td>${course.getCredt() }</td>
								<td>${course.getClassHour() }</td>
								<td>
								<a class="btn btn-success radius"
									href="#" onclick="teacher_select('老师选课','<%=request.getContextPath()%>/course?flag=query&flag1=select&courseNo=${course.getCourseNo() }','','')">选课</a>
									<a class="btn btn-success radius" onclick="course_del(this,${course.getCourseNo() })" style="background: red;">删除</a></td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
	</div>
	
	
	<script type="text/javascript">
	/*课程-删除*/
	function course_del(obj,courseNo){
		layer.confirm('确认要删除吗？',function(index){
			$.ajax({
				type: 'POST',
				url: 'http://localhost:8080/stusys/course?flag=delete&courseNo='+courseNo,
				dataType: 'json',
				success: function(data){
					if(data.delResult > 0){
						$(obj).parent("td").parents("tr").remove();
						layer.msg('已删除!',{icon:1,time:1000});
					}else{
						layer.msg('删除失败!',{icon:0,time:1000});
					}
				}, 
				error:function(data) {
					console.log(data.msg);
				},
			});		
		});
	}
	/*老师-选课*/
	function teacher_select(title,url,w,h){
		layer_show(title,url,w,h);
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