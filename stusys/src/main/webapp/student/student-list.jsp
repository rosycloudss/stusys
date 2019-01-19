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
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/static/bootstrap/css/bootstrap.min.css">
<script
	src="<%=request.getContextPath()%>/static/bootstrap/js/bootstrap.min.js"></script>

<title>修改学生信息</title>
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
		<div align="center">
			<form action="<%=request.getContextPath()%>/student"
				method="get">
				<input type="hidden" name="f" value="q">
				<span>学号：</span><input type="text" class="input-text"
					style="width: 120px;" name="stuNo"> <span>姓名：</span><input
					type="text" class="input-text" style="width: 120px;" name="stuName">
				<input name="" id="" class="btn btn-success" type="submit"
					value="搜索">
			</form>
		</div>
		<div class="mt-20">
			<table
				class="table table-border table-bordered table-hover table-bg ">
				<thead>
					<tr class="text-c">
						<th width="100">学号</th>
						<th width="80">姓名</th>
						<th width="20">性别</th>
						<th width="60">专业</th>
						<th width="150">身份证号</th>
						<th width="20">学历</th>
						<th width="20">状态</th>
						<th width="60">入校时间</th>
						<th width="100">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${stuList != null }">
						<c:forEach items="${stuList }" var="stu">
							<tr class="text-c">
								<td><a href="javascript:;"
									onclick="student_edit('学生修改','http://localhost:8080/stusys/student?f=q&f1=one&stuNo=${stu.getStuNo()}','','510')">${stu.getStuNo() }</a></td>
								<td>${stu.getName() }</td>
								<td>${stu.getGender() }</td>
								<td>${stu.getMajor().getMajorName() }</td>
								<td>${stu.getIdCard() }</td>
								<td>${stu.getEducation() }</td>
								<td>${stu.getStateStr() }</td>
								<td>${stu.getEnterTime() }</td>
								<td><a class="btn btn-success radius" href="javascript:;"
									onclick="student_edit('学生修改','http://localhost:8080/stusys/student?f=q&f1=one&stuNo=${stu.getStuNo()}','','510')">查看</a>
									<c:if test="${teacher.getRole() == 2 }">
										<a class="btn btn-success radius"
											onclick="student_del(this,${stu.getStuNo() })"
											style="background: red;">删除</a>
									</c:if></td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
			<!-- 分页设置 -->
			<div align="center">
				<!--******************** 设置上一页和下一页******************************** -->
				<c:set var="previousPage"
					value="${requestScope.page.getPageCurrent() - 1 }"></c:set>
				<c:set var="nextPage"
					value="${requestScope.page.getPageCurrent() + 1 }"></c:set>

				<c:if test="${previousPage <= 0 }">
					<c:set var="previousPage" value="1"></c:set>
				</c:if>

				<c:if test="${nextPage > requestScope.page.getTotalPage() }">
					<c:set var="nextPage" value="${requestScope.page.getTotalPage() }"></c:set>
				</c:if>

				<ul class="pagination">
					<li><a href="${page.getPath()}&currentPage=1">&laquo;</a></li>
					<li><a href="${page.getPath()}&currentPage=${previousPage}">上一页</a></li>

					<c:choose>
						<c:when test="${requestScope.page.getTotalPage() <= 5 }">
							<c:set var="begin" value="1"></c:set>
							<c:set var="end" value="${requestScope.page.getTotalPage()}"></c:set>
						</c:when>
						<c:when test="${requestScope.page.getPageCurrent() <= 3 }">
							<c:set var="begin" value="1"></c:set>
							<c:set var="end" value="5"></c:set>
						</c:when>
						<c:otherwise>
							<c:set var="begin"
								value="${requestScope.page.getPageCurrent() - 2 }"></c:set>
							<c:set var="end"
								value="${requestScope.page.getPageCurrent() + 2 }"></c:set>
							<c:if test="${end > requestScope.page.getTotalPage() }">
								<c:set var="begin"
									value="${requestScope.page.getTotalPage() - 4 }"></c:set>
								<c:set var="end" value="${requestScope.page.getTotalPage() }"></c:set>
							</c:if>
						</c:otherwise>
					</c:choose>
					<c:forEach begin="${begin }" end="${end}" var="num">
						<c:if test="${num == requestScope.page.getPageCurrent() }">
							<li class="active"><a href="${page.getPath()}&currentPage=${num}">${num}</a></li>
						</c:if>
						<c:if test="${num != requestScope.page.getPageCurrent() }">
							<li><a href="${page.getPath()}&currentPage=${num}">${num }</a></li>
						</c:if>
					</c:forEach>
					<li><a href="${page.getPath()}&currentPage=${nextPage}">下一页</a></li>
					<li><a
						href="${page.getPath()}&currentPage=${requestScope.page.totalPage}">&raquo;</a></li>
				</ul>
			</div>

		</div>
	</div>
	<!-- 
	href="<%=request.getContextPath()%>/student?flag=query&flag1=update&stuNo=${stu.getStuNo()}"
	 -->
	<script type="text/javascript">
	/*学生-删除*/
	function student_del(obj,stuNo){
		layer.confirm('确认要删除吗？',function(index){
			$.ajax({
				type: 'POST',
				url: 'http://localhost:8080/stusys/student?f=d&stuNo='+stuNo,
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
	/*学生-编辑*/
	function student_edit(title,url,w,h){
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