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
<title>用户管理</title>
<style>
.title {
	background: #B3B3B3;
	text-align: center;
}
</style>

</head>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>
		学生管理 <span class="c-gray en">&gt;</span>修改学生信息<a
			class="btn btn-success radius r"
			style="line-height: 1.6em; margin-top: 3px"
			href="javascript:location.replace(location.href);" title="刷新"><i
			class="Hui-iconfont">&#xe68f;</i></a>
	</nav>

	<div class="page-container">
		<c:if test="${queryedStu != null }">
			<form action="<%=request.getContextPath()%>/student?flag=update"
				method="post" id="form-student-update">
				<table style="width: 95%" align="center"
					class="table table-border table-bordered table-bg table-sort"
					id="studentInfoTb">
					<tr>
						<td colspan="5" style="font-weight: bold; text-align: center"
							class="">添加学生信息</td>
					</tr>
					<tr>
						<td width="25%" class="title" style="width: 18%">学号：</td>
						<td width="25%"><input type="text" name="stuNo"
							value="${queryedStu.getStuNo() }" class="input-text"></td>
						<td width="25%" class="title" style="width: 18%">姓名：</td>
						<td width="25%"><input type="text" name="stuName"
							value="${queryedStu.getName() }" class="input-text"></td>
						<td width="30%" class="title" colspan="9" style="width: 18%">
							<div>
								<img align="middle" alt="${queryedStu.getName() }" src="${queryedStu.getPhotoPath() }"
									width="100px" height="100px"> <br>
							</div>
						</td>

					</tr>
					<tr>
						<td class="title" style="width: 18%">性别：</td>
						<td><input name="sex"
							${queryedStu.getGender() eq '男'  ? 'checked' : '' } value="男"
							type="radio">男 <input name="sex"
							${queryedStu.getGender() eq '女'  ? 'checked' : '' } type="radio"
							value="女">女</td>
						<td class="title" style="width: 18%">身份证号：</td>
						<td><input name="idCard" class="input-text" type="text"
							value="${queryedStu.getIdCard() }"></td>
					</tr>
					<tr>
						<td class="title" style="width: 18%">年级：</td>
						<td><select name="grade" class="input-text">
								<option ${queryedStu.getGrade() eq '2018'?'selected':'' } value="2018">2018</option>
								<option ${queryedStu.getGrade() eq '2017'?'selected':'' } value="2017">2017</option>
								<option ${queryedStu.getGrade() eq '2016'?'selected':'' } value="2016">2016</option>
								<option ${queryedStu.getGrade() eq '2015'?'selected':'' } value="2015">2015</option>
								<option ${queryedStu.getGrade() eq '2014'?'selected':'' } value="2014">2014</option>
						</select></td>
						<td class="title" style="width: 18%">学历：</td>
						<td><select name="education" class="input-text">
								<option ${queryedStu.getEducation() eq '本科'?'selected':''}
									value="本科">本科</option>
								<option ${queryedStu.getEducation() eq '研究生'?'selected':''}
									value="研究生">研究生</option>
								<option ${queryedStu.getEducation() eq '博士'?'selected':''}
									value="博士">博士</option>
						</select></td>
					</tr>
					<tr>
						<td class="title" style="width: 18%">院系：</td>
						<td><select name="dept" id="dept" class="input-text">
								<c:if test="${sessionScope.deptList != null }">
									<c:forEach items="${sessionScope.deptList }" var="dept">
										<option ${queryedStu.getMajor().getDept().getDeptNo()==dept.getDeptNo()?'selected':'' } value="${dept.getDeptNo() }">${dept.getDeptName() }[${dept.getDeptNo() }]</option>
									</c:forEach>
								</c:if>
						</select></td>
						<td class="title" style="width: 18%">专业：</td>
						<td><select name="major" id="major" class="input-text">
								<c:if test="${sessionScope.deptList != null }">
									<c:forEach items="${sessionScope.deptList }" var="dept">
										<c:if
											test="${queryedStu.getMajor().getDept().getDeptNo()==dept.getDeptNo()}">
											<c:forEach items="${dept.getMajors()}" var="major">
												<option ${queryedStu.getMajor().getMajorNo()==major.getMajorNo()?'selected':'' } value="${major.getMajorNo() }">${major.getMajorName() }</option>
											</c:forEach>
										</c:if>
									</c:forEach>
								</c:if>
						</select></td>
					</tr>
					<tr>
						<td class="title" style="width: 18%">学籍状态：</td>
						<td><select name="state" class="input-text">
								<option ${queryedStu.getState() eq 1?'selected':'' } value="1">在读</option>
								<option ${queryedStu.getState() eq 2?'selected':'' } value="2">毕业</option>
								<option ${queryedStu.getState() eq 3?'selected':'' } value="3">休学</option>
								<option ${queryedStu.getState() eq 4?'selected':'' } value="4">劝退</option>
						</select></td>
						<td class="title" style="width: 18%">联系电话1：</td>
						<td><input name="phone1" type="tel" class="input-text"
							value="${queryedStu.getPhone1() }"></td>
					</tr>
					<tr>
						<td class="title" style="width: 18%">联系电话2：</td>
						<td><input name="phone2" type="tel" class="input-text"
							value="${queryedStu.getPhone2() }"></td>
						<td class="title" style="width: 18%">QQ：</td>
						<td><input name="qq" type="text" class="input-text"
							value="${queryedStu.getQq() }"></td>

					</tr>
					<tr>
						<td class="title" style="width: 18%">邮箱：</td>
						<td><input name="email" type="email" class="input-text"
							value="${queryedStu.getEmail() }"></td>
						<td class="title" style="width: 18%">家庭住址：</td>
						<td><input name="address" type="text" class="input-text"
							value="${queryedStu.getAddress() }"></td>
					</tr>
					<tr>
						<td colspan="4"><input type="button" class=" input-text" onclick="student_update()"
							value="确认修改"></td>
					</tr>
				</table>
			</form>
		</c:if>
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
		<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
	<script type="text/javascript" src="<%=request.getContextPath()%>/lib/jquery.validation/1.14.0/validate-methods.js"></script> 
	<script type="text/javascript" src="<%=request.getContextPath()%>/lib/jquery.validation/1.14.0/messages_zh.js"></script>
	<script type="text/javascript">
		$("#dept").change(function(){
		  $("#major").html("");
			$.ajax({
				type: 'POST',
				url: 'http://localhost:8080/stusys/major/getbydeptno?deptNo=' + $("#dept").val(),
				dataType: 'json',
				success: function(data){
					dataObj = data; //返回的result为json格式的数据
					 $.each(dataObj,function(index,item){
						 $("#major").append("<option  value='"+item.majorNo+"'>"+item.majorName+"</option>")
					 });
				},
				error:function(data) {
					layer.confirm("获取专业信息失败！",null);
				},
			});	
		});
		
		/*修改学生信息*/
		function student_update(){
			$.ajax({
				type: 'POST',
				url: 'http://localhost:8080/stusys/student?flag=update',
				dataType: 'json',
				data:$("#form-student-update").serialize(),
				success: function(result){
					if(result.updateResult > 0){
						alert("修改成功！");
					}else{
						alert("修改失败！");
					}
					var index = parent.layer.getFrameIndex(window.name);
					parent.layer.close(index);
				}, 
				error:function(result) {
					console.log(result.msg);
				},
			});		
		}
	</script>

</body>
</html>
