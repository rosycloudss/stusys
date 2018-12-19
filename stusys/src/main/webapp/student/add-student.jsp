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
	href="<%=request.getContextPath()%>/static/h-ui.admin/skin/default/skin.css" id="skin" />
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
		学生管理 <span class="c-gray en">&gt;</span>添加学生<a
			class="btn btn-success radius r"
			style="line-height: 1.6em; margin-top: 3px"
			href="javascript:location.replace(location.href);" title="刷新"><i
			class="Hui-iconfont">&#xe68f;</i></a>
	</nav>

	<div class="page-container">
		<form action="<%=request.getContextPath() %>/student?flag=add" method="post" enctype="multipart/form-data" id="form-student-add">
			<table style="width: 95%" align="center"
				class="table table-border table-bordered table-bg table-sort"
				id="studentInfoTb">
				<tr>
					<td colspan="5" style="font-weight: bold; text-align: center"
						class="">添加学生信息</td>
				</tr>
				<tr>
					<td width="25%" class="title" style="width: 18%"><label for="stuName">姓名：</label></td>
					<td width="25%"><input type="text" name="stuName"
						class="input-text"></td>
						<!-- 
					<td width="25%" class="title" style="width: 18%">头像：</td>
					<td width="25%"><input type="file" name="stuPhoto"></td>
						 -->
				</tr>
				<tr>
					<td class="title" style="width: 18%">性别：</td>
					<td><input name="sex" checked value="男" type="radio">男 <input
						name="sex" type="radio" value="女">女</td>
					<td class="title" style="width: 18%">身份证号：</td>
					<td><input name="idCard" class="input-text" type="text">
					</td>
				</tr>
				<tr>
					<td class="title" style="width: 18%">年级：</td>
					<td><select name="grade" class="input-text">
							<option value="2018">2018</option>
							<option value="2017">2017</option>
							<option value="2016">2016</option>
							<option value="2015">2015</option>
							<option value="2014">2014</option>
					</select></td>
					<td class="title" style="width: 18%">学历：</td>
					<td><select name="education" class="input-text">
							<option value="本科">本科</option>
							<option value="研究生">研究生</option>
							<option value="博士">博士</option>
					</select></td>
				</tr>
				<tr>
					<td class="title" style="width: 18%">院系：</td>
					<td><select name="dept" id="dept" class="input-text">
							<c:if test="${sessionScope.deptList != null }">
								<c:forEach items="${sessionScope.deptList }" var="dept">
									<option value="${dept.getDeptNo() }">${dept.getDeptName() }[${dept.getDeptNo() }]</option>
								</c:forEach>
							</c:if>
					</select></td>
					<td class="title" style="width: 18%">专业：</td>
					<td><select name="major" id="major" class="input-text">
					</select></td>
				</tr>
				<tr>
					<td class="title" style="width: 18%">入校时间：</td>
					<td><input name="enterTime" type="date" class="input-text">
					</td>
					<td class="title" style="width: 18%">学籍状态：</td>
					<td><select name="state" class="input-text">
							<option value="1">在读</option>
							<option value="2">毕业</option>
							<option value="3">休学</option>
							<option value="4">劝退</option>
					</select></td>
				</tr>
				<tr>
					<td class="title" style="width: 18%">联系电话1：</td>
					<td><input name="phone1" type="tel" class="input-text">
					</td>
					<td class="title" style="width: 18%">联系电话2：</td>
					<td><input name="phone2" type="tel" class="input-text"></td>
				</tr>
				<tr>
					<td class="title" style="width: 18%">QQ：</td>
					<td><input name="qq" type="text" class="input-text"></td>
					<td class="title" style="width: 18%">邮箱：</td>
					<td><input name="email" type="email" class="input-text"></td>
				</tr>
				<tr>
					<td class="title" style="width: 18%">家庭住址：</td>
					<td><input name="address" type="text" class="input-text"></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" class="btn-primary radius input-text" value="提交"
						></td>
					<td colspan="2"><input type="reset" class="btn-primary radius input-text"
						value="重置"></td>

				</tr>
			</table>
		</form>
	</div>

	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript" src="<%=request.getContextPath()%>/lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/lib/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/h-ui/js/H-ui.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/static/h-ui.admin/js/H-ui.admin.js"></script>
	<!--/_footer 作为公共模版分离出去-->

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/lib/jquery.validation/1.14.0/validate-methods.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/lib/jquery.validation/1.14.0/messages_zh.js"></script>
	<script type="text/javascript">
	$().ready(function(){
		$("#form-student-add").validate({
			rules:{
				stuName:{
					required:true,
				},
				sex:{
					required:true,
				},
				idCard:{
					required:true,
					minlength:18,
					maxlength:18,
				},
				grade:{
					required:true,
				},
				education:{
					required:true,
				},
				dept:{
					required:true,
				},
				major:{
					required:true,
				},
				enterTime:{
					required:true,
				},
				state:{
					required:true,
				},
				email:{
					required:false,
					email:true
				}
			},
			
			messages:{
				stuName:"请输入姓名",
				sex:"请选择性别",
				idCard:{
					required:"请输入身份证号",
					minlength:"身份证格式错误",
					maxlength:"身份证格式错误",
				},
				grade:{
					required:"请输入年级",
				},
				education:{
					required:"请输入学历",
				},
				dept:{
					required:"请输入院系",
				},
				major:{
					required:"请输入专业",
				},
				enterTime:{
					required:"请输入入学时间",
				},
				state:{
					required:"请输入学籍状态",
				},
				email:{
					required:"请输入邮箱",
					email:"邮箱格式错误",
				}
			}
		});
	});
		$("#dept").change(function(){
		  $("#major").html("");
			$.ajax({
				type: 'POST',
				url: 'http://localhost:8080/stusys/major/getbydeptno?deptNo=' + $("#dept").val(),
				dataType: 'json',
				success: function(data){
					dataObj = data; //返回的result为json格式的数据
					 $.each(dataObj,function(index,item){
						 alert(item.majorNo);
						 $("#major").append("<option value='"+item.majorNo+"'>"+item.majorName+"</option>")
					 });
				},
				error:function(data) {
					layer.confirm("获取专业信息失败！",null);
				},
			});	
		});
		
	</script>
</body>
</html>
