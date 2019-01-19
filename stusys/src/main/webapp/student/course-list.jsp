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
						<th width="50">课程编号</th>
						<th width="80">课程名称</th>
						<th width="200">课程描述</th>
						<th width="60">专业</th>
						<th width="50">讲师</th>
						<th width="20">学分</th>
						<th width="20">学时</th>
						<th width="40">种类</th>
						<th width="70">上课地点</th>
						<th width="40">人数</th>
						<th width="100">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${teacherCourseList != null}">
						<c:forEach items="${teacherCourseList}" var="teacherCourse">
							<tr class="text-c">
								<td>${teacherCourse.getCourse().getCourseNo() }</td>
								<td>${teacherCourse.getCourse().getCourseName() }</td>
								<td>${teacherCourse.getCourse().getCourseDescription() }</td>
								<td>${teacherCourse.getCourse().getMajor().getMajorName() }</td>
								<td>${teacherCourse.getTeacher().getTeacherName() }</td>
								<td>${teacherCourse.getCourse().getCredt() }</td>
								<td>${teacherCourse.getCourse().getClassHour() }</td>
								<td>${teacherCourse.getCourse().getCourseType() }</td>
								<td>${teacherCourse.getTeachAddressTime() }</td>
								<td>${teacherCourse.getSelectNum() }/${teacherCourse.getStudentNum() }</td>
								<td><a href="#" onclick="course_select(this,${student.getStuNo() },${teacherCourse.getTcNo() })" class="btn btn-success radius">选择</a></td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
	</div>
	
	<script type="text/javascript">
	/*学生-选课*/
	function course_select(obj,stuNo,tcNo){
		if(obj.text == '选择'){
			layer.confirm('确认要选择吗？',function(index){
				$.ajax({
					type: 'POST',
					url: 'http://localhost:8080/stusys/student/course?f=a&stuNo='+stuNo+'&tcNo='+tcNo,
					dataType: 'json',
					success: function(data){
						if(data.select > 0){
							layer.msg('选择成功!',{icon:1,time:1000});
							obj.text='已选择';
						}else if(data.select == 0){
							layer.msg('选择失败!',{icon:0,time:1000});
						}else {
							layer.msg('你已选择该课程!',{icon:1,time:1000});
							obj.text='已选择';
						}
					}, 
					error:function(data) {
						console.log(data.msg);
					},
				});		
			});
		}
		
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

</body>
</html>