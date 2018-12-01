<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">

<link rel="stylesheet" type="text/css" href="../static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="../static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="../lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="../static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="../static/h-ui.admin/css/style.css" />
<title>课程列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 课程列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
<!--
	<div class="text-c"> 课程名称：
		<input type="text"  id="course-name" class="input-text" style="width:200px;">
		<button type="submit" class="btn btn-success radius" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜课程</button>
	</div>
	
-->
	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg ">
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
			<tr class="text-c">
				<td>1001</td>
				<td>计算机图形学</td>
				<td>。。。。</td>
				<td>计算机类</td>
				<td>张三</td>
				<td>2</td>
				<td>32</td>
				<td>选修</td>
				<td>北1101</td>
				<td>30/100</td>
				<td><a href="#" class="btn btn-success radius">选择</a></td>
			</tr>
		</tbody>
	</table>
	</div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="../lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="../static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="../static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="../lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="../lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="../lib/laypage/1.2/laypage.js"></script>

</body>
</html>