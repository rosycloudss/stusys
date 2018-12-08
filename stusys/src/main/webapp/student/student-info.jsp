<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->

<link rel="stylesheet" type="text/css"
	href="../static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="../static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="../lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="../static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css"
	href="../static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
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
		我的 <span class="c-gray en">&gt;</span>学籍信息<a
			class="btn btn-success radius r"
			style="line-height: 1.6em; margin-top: 3px"
			href="javascript:location.replace(location.href);" title="刷新"><i
			class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<!-- 
	
	<div class="cl pd-5 bg-1 bk-gray mt-20">
		<span class="l"><button onclick="show_table1()"
				class="btn btn-danger radius">
				<i class="Hui-iconfont">&#xe6e2;</i> 学籍信息
			</button>
			<button class="btn btn-primary radius" onclick="show_table2()">
				<i class="Hui-iconfont">&#xe600;</i> 修改个人信息
			</button></span>
	</div>
	 -->

	<div class="page-container" id="tabPage1">
		<table style="width: 95%" align="center"
			class="table table-border table-bordered table-bg table-sort"
			id="studentInfoTb">
			<tr>
				<td colspan="5" style="font-weight: bold; text-align: center"
					class="">学籍信息</td>
			</tr>
			<tr>
				<td width="25%" class="title" style="width: 18%">学号：</td>
				<td width="25%">${student.getStuNo() }</td>
				<td width="25%" class="title" style="width: 18%">姓名：</td>
				<td>${student.getName() }</td>
				<td width="11%" rowspan="9" id='photoImg'><img width="80px"
					height="110px" src="" alt="${student.getName() }"
					title="${student.getName() }" /></td>
			</tr>
			<tr>
				<td class="title" style="width: 18%">性别：</td>
				<td>${student.getGender() }</td>
				<td class="title" style="width: 18%">身份证号：</td>
				<td>${student.getIdCard() }</td>
			</tr>
			<tr>
				<td class="title" style="width: 18%">年级：</td>
				<td>2016</td>
				<td class="title" style="width: 18%">学历：</td>
				<td>${student.getEducation() }</td>
			</tr>
			<tr>
				<td class="title" style="width: 18%">学生类别：</td>
				<td>${student.getEducation() }</td>
				<td class="title" style="width: 18%">院系：</td>
				<td>信息工程学院[24]</td>
			</tr>
			<tr>
				<td class="title" style="width: 18%">专业：</td>
				<td>${student.getMajor().getMajorName() }</td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td class="title" style="width: 18%">入校时间：</td>
				<td>${student.getEnterTime() }</td>
				<td class="title" style="width: 18%">学籍状态：</td>
				<td>${student.getStateStr() }</td>
			</tr>
			<tr>
				<td class="title" style="width: 18%">联系电话1：</td>
				<td>${student.getPhone1() }</td>
				<td class="title" style="width: 18%">联系电话2：</td>
				<td>${student.getPhone2() }</td>
			</tr>
			<tr>
				<td class="title" style="width: 18%">QQ：</td>
				<td>${student.getQq() }</td>
				<td class="title" style="width: 18%">邮箱：</td>
				<td>${student.getEmail() }</td>
			</tr>
			<tr>
				<td class="title" style="width: 18%">家庭住址：</td>
				<td>${student.getAddress() }</td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</div>

	<!-- 
	<div id="tabPage2" class="ajax_container">
		<form action="" method="post" class="form form-horizontal"
			id="form-member-add">
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red">*</span>电子邮件：</label>
				<div class="formControls col-xs-4 col-sm-4">
					<input type="text" class="input-text"
						value="${student.getEmail() }" placeholder="" id="username"
						name="username">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red">*</span>联系电话：</label>
				<div class="formControls col-xs-4 col-sm-4">
					<input type="text" class="input-text" value="" placeholder=""
						id="phone" name="phone">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span
					class="c-red">*</span>联系地址：</label>
				<div class="formControls col-xs-4 col-sm-4">
					<input type="text" class="input-text" value="" placeholder=""
						id="adddress" name="address">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3 row-xs-4 row-sm-4"><span
					class="c-red">*</span>申请内容：</label>
				<div class="col-xs-6 col-sm-6 row-xs-4 row-sm-4 ">
					<textarea rows="4" cols="40" id="applyContext" name="applyContext"></textarea>
				</div>
			</div>
			<div class="row cl">
				<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
					<input class="btn btn-primary radius" type="submit"
						value="&nbsp;&nbsp;提交&nbsp;&nbsp;"> <input
						class="btn btn-primary radius" type="reset"
						value="&nbsp;&nbsp;重置&nbsp;&nbsp;">
				</div>
			</div>
		</form>
	</div>
	 -->

	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="../lib/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="../static/h-ui/js/H-ui.min.js"></script>
	<script type="text/javascript"
		src="../static/h-ui.admin/js/H-ui.admin.js"></script>
	<!--/_footer 作为公共模版分离出去-->

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="../lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript"
		src="../lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="../lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript">
		$("#tabPage2").hide();

		function show_table1() {
			$("#tabPage1").show();
			$("#tabPage2").hide();
		}
		function show_table2() {
			$("#tabPage1").hide();
			$("#tabPage2").show();
		}
	</script>
</body>
</html>
