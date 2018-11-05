<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
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
  <form class="form-signin" action="login" method="post">
  	<c:if test="${sessionScope.userError != null }">
    	<h5 class="bg-danger">用户名或密码错误！</h5>
    	<%session.removeAttribute("userError"); %>
    </c:if>
    <h2 class="form-signin-heading">请登陆</h2>
    <label for="inputEmail" class="sr-only">用户名</label>
    <input type="text" id="inputEmail" class="form-control" placeholder="用户" required autofocus name="userName">
    <label for="inputPassword" class="sr-only">密码</label>
    <input type="password" id="inputPassword" class="form-control" placeholder="密码" required name="password">
    <div class="checkbox">
      <label>
        <input type="checkbox" value="rememberme" name="autoLogin"> 记住我（一周）
      </label>
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
  </form>

</div>
<!-- /container -->
<jsp:include page="footer.jsp" />
</body>
</html>