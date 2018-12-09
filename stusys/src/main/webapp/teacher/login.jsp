<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<link href=" <%=request.getContextPath() %>/static/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href=" <%=request.getContextPath() %>/static/h-ui.admin/css/H-ui.login.css" rel="stylesheet" type="text/css" />
<link href=" <%=request.getContextPath() %>/static/h-ui.admin/css/style.css" rel="stylesheet" type="text/css" />
<link href=" <%=request.getContextPath() %>/lib/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css" />
<title>lw学生管理系统登录</title>
<meta name="keywords" content="lw学生管理系统">
<meta name="description" content="lw学生管理系统">
</head>
<body>
<input type="hidden" id="TenantId" name="TenantId" value="" />
<div class="header"></div>
<div class="loginWraper">
  <div id="loginform" class="loginBox">
    <form class="form form-horizontal" action=" <%=request.getContextPath() %>/student/loginServlet" method="post">
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
        <div class="formControls col-xs-8"> 
          <input id="" name="teacherNo" type="text" placeholder="学号" class="input-text size-L">
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
        <div class="formControls col-xs-8">
          <input id="" name="password" type="password" placeholder="密码" class="input-text size-L">
        </div>
      </div>
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <input name="" type="submit" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
          <input name="" type="reset" class="btn btn-default radius size-L" value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;">
        </div>
      </div>
    </form>
  </div>
</div>
<script type="text/javascript" src=" <%=request.getContextPath() %>/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src=" <%=request.getContextPath() %>/static/h-ui/js/H-ui.min.js"></script>
<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "https://hm.baidu.com/hm.js?080836300300be57b7f34f4b3e97d911";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
</script>
</body>
</html>