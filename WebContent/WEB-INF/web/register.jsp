<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册</title>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">  
<link rel="stylesheet"  href="css/bootstrapMagic.css" />
<link rel="stylesheet"  href="css/login.css" />
<link rel="stylesheet"  href="css/footer.css" />
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="top_nav.jsp" />
<div class="nav2"></div>
<div class="container mixlogin">
  <form class="form-signin" action="register" method="post">
    <h2 class="form-signin-heading">注册</h2>
    <label for="inputEmail" class="sr-only">用户名</label>
    <input type="userName" id="userName" class="form-control" placeholder="用户名" required autofocus name="userName">
    <label for="inputPassword" class="sr-only">密码</label>
    <input type="password" id="inputPassword" class="form-control" placeholder="密码" required name="inputPassword">
    <label for="reInputPassword" class="sr-only">确认密码</label>
    <input type="password" id="reInputPassword" class="form-control" placeholder="确认密码" required name="reInputPassword">
    
    <button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>
  </form>

</div>
<!-- /container -->
<jsp:include page="footer.jsp" />
</body>
</html>