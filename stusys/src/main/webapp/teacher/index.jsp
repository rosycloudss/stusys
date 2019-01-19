<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">

<link rel="Bookmark" href="/favicon.ico">
<link rel="Shortcut Icon" href="/favicon.ico" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href=" <%=request.getContextPath()%>/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href=" <%=request.getContextPath()%>/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href=" <%=request.getContextPath()%>/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css"
	href=" <%=request.getContextPath()%>/static/h-ui.admin/css/style.css" />
<title>学生管理系统</title>
</head>
<body>
	<header class="navbar-wrapper">
		<div class="navbar navbar-fixed-top">
			<div class="container-fluid cl">
				<a class="logo navbar-logo f-l mr-10 hidden-xs"
					href="/aboutHui.shtml">学生管理系统</a> <span
					class="logo navbar-slogan f-l mr-10 hidden-xs">v1.0</span>
				<nav id="Hui-userbar"
					class="nav navbar-nav navbar-userbar hidden-xs">
					<ul class="cl">
						<li>${teacher.getRoleStr() }</li>
						<li class="dropDown dropDown_hover"><a href="#"
							class="dropDown_A">${teacher.getTeacherName() } <i class="Hui-iconfont">&#xe6d5;</i></a>
							<ul class="dropDown-menu menu radius box-shadow">
								<li><a href="<%=request.getContextPath()%>/logout">退出登录</a></li>
							</ul></li>
						
						<li id="Hui-skin" class="dropDown right dropDown_hover"><a
							href="javascript:;" class="dropDown_A" title="换肤"><i
								class="Hui-iconfont" style="font-size: 18px">&#xe62a;</i></a>
							<ul class="dropDown-menu menu radius box-shadow">
								<li><a href="javascript:;" data-val="default"
									title="默认（黑色）">默认（黑色）</a></li>
								<li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li>
								<li><a href="javascript:;" data-val="green" title="绿色">绿色</a></li>
								<li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
								<li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>
								<li><a href="javascript:;" data-val="orange" title="橙色">橙色</a></li>
							</ul></li>
					</ul>
				</nav>
			</div>
		</div>
	</header>


	<aside class="Hui-aside">
		<div class="menu_dropdown bk_2">
			<dl id="menu-member">
				<dt>
					<i class="Hui-iconfont">&#xe616;</i> 我的<i
						class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
				</dt>
				<dd>
					<ul>
						<li><a data-href="<%=request.getContextPath()%>/teacher_course?f=q&role=teacher&teacherNo=${teacher.getTeacherNo() }" data-title="我的授课"
							href="javascript:void(0)">我的授课</a></li>
					</ul>
				</dd>
			</dl>
		</div>
		<div class="menu_dropdown bk_2">
			<dl id="menu-member">
				<dt>
					<i class="Hui-iconfont">&#xe616;</i> 学生管理<i
						class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
				</dt>
				<dd>
					<ul>
						<li><a data-href="<%=request.getContextPath()%>/student?f=q" data-title="学生列表"
							href="javascript:void(0)">学生列表</a></li>
						<li><a
							data-href="<%=request.getContextPath()%>/student/add-student.jsp"
							data-title="添加学生" href="javascript:void(0)">添加学生</a></li>
					</ul>
				</dd>
			</dl>
			<c:if test="${teacher.getRole() == 2 }">
				<dl id="menu-picture">
					<dt>
						<i class="Hui-iconfont">&#xe613;</i> 教师管理<i
							class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
					</dt>
					<dd>
						<ul>
							<li><a data-href="<%=request.getContextPath()%>/teacher?f=q" data-title="教师列表"
								href="javascript:void(0)">教师列表</a></li>
							<li><a data-href="<%=request.getContextPath()%>/teacher/add-teacher.jsp" data-title="添加教师"
								href="javascript:void(0)">添加教师</a></li>
						</ul>
					</dd>
				</dl>
			</c:if>
			<dl id="menu-product">
				<dt>
					<i class="Hui-iconfont">&#xe620;</i> 课程管理<i
						class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
				</dt>
				<dd>
					<ul>
						<li><a data-href="<%=request.getContextPath()%>/course/add-course.jsp" data-title="添加课程"
							href="javascript:void(0)">添加课程</a></li>
						<li><a data-href="<%=request.getContextPath()%>/course?f=q" data-title="课程列表"
							href="javascript:void(0)">课程列表</a></li>
					</ul>
				</dd>
			</dl>
		</div>
	</aside>
	<div class="dislpayArrow hidden-xs">
		<a class="pngfix" href="javascript:void(0);"
			onClick="displaynavbar(this)"></a>
	</div>
	<section class="Hui-article-box">
		<div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
			<div class="Hui-tabNav-wp">
				<ul id="min_title_list" class="acrossTab cl">
					<li class="active"><span title="我的桌面" data-href="home.html">我的桌面</span>
						<em></em></li>
				</ul>
			</div>
			<div class="Hui-tabNav-more btn-group">
				<a id="js-tabNav-prev" class="btn radius btn-default size-S"
					href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a><a
					id="js-tabNav-next" class="btn radius btn-default size-S"
					href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a>
			</div>
		</div>
		<div id="iframe_box" class="Hui-article">
			<div class="show_iframe">
				<div style="display: none" class="loading"></div>
				<iframe scrolling="yes" frameborder="0" src="<%=request.getContextPath()%>/home.html"></iframe>
			</div>
		</div>
	</section>

	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript" src=" <%=request.getContextPath()%>/lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src=" <%=request.getContextPath()%>/lib/layer/2.4/layer.js"></script>
	<script type="text/javascript" src=" <%=request.getContextPath()%>/static/h-ui/js/H-ui.min.js"></script>
	<script type="text/javascript"
		src=" <%=request.getContextPath()%>/static/h-ui.admin/js/H-ui.admin.js"></script>
	<!--/_footer 作为公共模版分离出去-->

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/lib/jquery.contextmenu/jquery.contextmenu.r2.js"></script>
</body>
</html>