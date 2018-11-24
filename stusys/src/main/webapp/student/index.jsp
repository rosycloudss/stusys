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
<link rel="Bookmark" href="/favicon.ico">
<link rel="Shortcut Icon" href="/favicon.ico" />
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
						<li>超级管理员</li>
						<li class="dropDown dropDown_hover"><a href="#"
							class="dropDown_A">admin <i class="Hui-iconfont">&#xe6d5;</i></a>
							<ul class="dropDown-menu menu radius box-shadow">
								<li><a href="javascript:;" onclick="myselfinfo()">个人信息</a></li>
								<li><a href="#">切换账户</a></li>
								<li><a href="#">退出</a></li>
							</ul></li>
						<li id="Hui-msg"><a href="#" title="消息"><span
								class="badge badge-danger">1</span><i class="Hui-iconfont"
								style="font-size: 18px">&#xe68a;</i></a></li>
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
						<li><a data-href="student-info.jsp" data-title="学籍信息"
							href="javascript:void(0)">学籍信息</a></li>
						<li><a data-href="" data-title="我的课表"
							href="javascript:void(0)">我的课表</a></li>
						<li><a data-href="article-list.html" data-title="选课"
							href="javascript:void(0)">选课</a></li>
						<li><a data-href="score-table.jsp" data-title="我的成绩"
							href="javascript:void(0)">我的成绩</a></li>
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
						<li><a data-href="article-list.html" data-title="学生列表"
							href="javascript:void(0)">学生列表</a></li>
						<li><a data-href="article-list.html" data-title="添加学生"
							href="javascript:void(0)">添加学生</a></li>
					</ul>
				</dd>
			</dl>
			<dl id="menu-picture">
				<dt>
					<i class="Hui-iconfont">&#xe613;</i> 教师管理<i
						class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
				</dt>
				<dd>
					<ul>
						<li><a data-href="picture-list.html" data-title="教师列表"
							href="javascript:void(0)">教师列表</a></li>
						<li><a data-href="picture-list.html" data-title="添加教师"
							href="javascript:void(0)">添加教师</a></li>
					</ul>
				</dd>
			</dl>
			<dl id="menu-product">
				<dt>
					<i class="Hui-iconfont">&#xe620;</i> 课程管理<i
						class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
				</dt>
				<dd>
					<ul>
						<li><a data-href="product-brand.html" data-title="添加课程"
							href="javascript:void(0)">添加课程</a></li>
						<li><a data-href="product-category.html" data-title="课程列表"
							href="javascript:void(0)">课程列表</a></li>
					</ul>
				</dd>
			</dl>
			<dl id="menu-comments">
				<dt>
					<i class="Hui-iconfont">&#xe622;</i> 院系管理<i
						class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
				</dt>
				<dd>
					<ul>
						<li><a data-href="http://h-ui.duoshuo.com/admin/"
							data-title="院系列表" href="javascript:;">院系列表</a></li>
						<li><a data-href="feedback-list.html" data-title="添加院系"
							href="javascript:void(0)">添加院系</a></li>
					</ul>
				</dd>
			</dl>
			<dl id="menu-member">
				<dt>
					<i class="Hui-iconfont">&#xe60d;</i> 会员管理<i
						class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
				</dt>
				<dd>
					<ul>
						<li><a data-href="member-list.html" data-title="会员列表"
							href="javascript:;">会员列表</a></li>
						<li><a data-href="member-del.html" data-title="删除的会员"
							href="javascript:;">删除的会员</a></li>
						<li><a data-href="member-level.html" data-title="等级管理"
							href="javascript:;">等级管理</a></li>
						<li><a data-href="member-scoreoperation.html"
							data-title="积分管理" href="javascript:;">积分管理</a></li>
						<li><a data-href="member-record-browse.html"
							data-title="浏览记录" href="javascript:void(0)">浏览记录</a></li>
						<li><a data-href="member-record-download.html"
							data-title="下载记录" href="javascript:void(0)">下载记录</a></li>
						<li><a data-href="member-record-share.html" data-title="分享记录"
							href="javascript:void(0)">分享记录</a></li>
					</ul>
				</dd>
			</dl>
			<dl id="menu-admin">
				<dt>
					<i class="Hui-iconfont">&#xe62d;</i> 管理员管理<i
						class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
				</dt>
				<dd>
					<ul>
						<li><a data-href="admin-role.html" data-title="角色管理"
							href="javascript:void(0)">角色管理</a></li>
						<li><a data-href="admin-permission.html" data-title="权限管理"
							href="javascript:void(0)">权限管理</a></li>
						<li><a data-href="admin-list.html" data-title="管理员列表"
							href="javascript:void(0)">管理员列表</a></li>
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
					<li class="active"><span title="我的桌面" data-href="welcome.html">我的桌面</span>
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
				<iframe scrolling="yes" frameborder="0" src="welcome.html"></iframe>
			</div>
		</div>
	</section>

	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="../lib/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="../static/h-ui/js/H-ui.min.js"></script>
	<script type="text/javascript" src="../static/h-ui.admin/js/H-ui.admin.js"></script>
	<!--/_footer 作为公共模版分离出去-->

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="lib/jquery.contextmenu/jquery.contextmenu.r2.js"></script>
	