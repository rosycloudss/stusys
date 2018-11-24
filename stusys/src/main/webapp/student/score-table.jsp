<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<div align="center">
			日期范围： <input type="text"
				onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'logmax\')||\'%y-%M-%d\'}' })"
				placeholder="起始时间" id="logmin" class="input-text Wdate"
				style="width: 120px;"> - <input type="text"
				onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'logmin\')}',maxDate:'%y-%M-%d' })"
				placeholder="结束时间" id="logmax" class="input-text Wdate"
				style="width: 120px;">
			<button name="" id="" class="btn btn-success" type="submit">
				<i class="Hui-iconfont">&#xe665;</i> 确认
			</button>
		</div>
		<div class="cl pd-5 bg-1 bk-gray mt-20">
			<span style="margin-left: 10px;" class="l">学号：20162430211</span> <span
				style="margin-left: 10px;" class="l">姓名：李伟 </span> <span
				style="margin-left: 10px;" class="1">班级：软件工程(卓越工程师)一班</span>
			<div class="mt-20">
				<table
					class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
					<thead>
						<tr>
							<th width="10%">学年学期</th>
							<th width="10%">课程代码</th>
							<th width="10%">课程序号</th>
							<th width="20%">课程名称</th>
							<th width="14%">课程类别</th>
							<th width="9%">学分</th>
							<th width="9%">成绩</th>
							<th width="9%">绩点</th>
						</tr>

					</thead>

					<tbody id="grid11563218371_data">
						<tr>
							<td>2017-2018 2</td>
							<td>225043</td>
							<td></td>
							<td>大学物理实验A(II)</td>
							<td>必修课</td>
							<td>1.5</td>
							<td style="">81</td>
							<td>3.2</td>
						</tr>
						<tr>
							<td>2017-2018 2</td>
							<td>243202</td>
							<td>24320201</td>
							<td>面向对象原理与语言</td>
							<td>必修课</td>
							<td>4</td>
							<td style="">84</td>
							<td>3.2</td>
						</tr>
						<tr>
							<td>2017-2018 2</td>
							<td>243203</td>
							<td>24320301</td>
							<td>计算机网络原理与技术</td>
							<td>必修课</td>
							<td>5</td>
							<td style="">82</td>
							<td>3.2</td>
						</tr>
						<tr>
							<td>2017-2018 2</td>
							<td>243325</td>
							<td>24332501</td>
							<td>数据库技术与应用</td>
							<td>必修课</td>
							<td>3</td>
							<td>88</td>
							<td>3.7</td>
						</tr>
						<tr>
							<td>2017-2018 2</td>
							<td>391503</td>
							<td>39150322</td>
							<td>毛泽东思想和中国特色社会主义理论体系概论 (下)</td>
							<td>必修课</td>
							<td>3</td>
							<td style="">88</td>
							<td>3.7</td>
						</tr>
						<tr>
							<td>2017-2018 2</td>
							<td>371019</td>
							<td></td>
							<td>大学英语读写（IV）</td>
							<td>必修课</td>
							<td>2</td>
							<td style="">67</td>
							<td>1.7</td>
						</tr>
						<tr>
							<td>2017-2018 2</td>
							<td>371024</td>
							<td></td>
							<td>大学英语听说（Ⅳ）</td>
							<td>必修课</td>
							<td>1</td>
							<td style="">60</td>
							<td>1.2</td>
						</tr>
						<tr>
							<td>2017-2018 2</td>
							<td>491004</td>
							<td>491004.28</td>
							<td>体育（IV）</td>
							<td>必修课</td>
							<td>1</td>
							<td style="">78</td>
							<td>2.7</td>
						</tr>
						<tr>
							<td>2017-2018 2</td>
							<td>391014</td>
							<td>39101425</td>
							<td>马克思主义基本原理</td>
							<td>必修课</td>
							<td>3</td>
							<td style="">78</td>
							<td>2.7</td>
						</tr>
						<tr>
							<td>2017-2018 2</td>
							<td>242310</td>
							<td>24231001</td>
							<td>软件工程概论</td>
							<td>必修课</td>
							<td>2</td>
							<td style="">85</td>
							<td>3.7</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
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
		src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="../lib/laypage/1.2/laypage.js"></script>
</body>
</html>
