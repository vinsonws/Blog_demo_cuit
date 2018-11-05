<%@page import="java.util.List"%>
<%@page import="entity.Essay"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${sessionScope.logUser.userName }</title>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">  
<link rel="stylesheet"  href="css/bootstrapMagic.css" />
<link rel="stylesheet"  href="css/footer.css" />
<link rel="stylesheet"  href="css/index.css" />
</head>
<body>
<jsp:include page="top_nav.jsp" />
<div style="height:100px;"></div>
  <div class="blog-header">
    <div class="container">
      <h1>${sessionScope.logUser.userName }的信息管理</h1>
    </div>
  </div>
  <hr>
  <div class="container">
	  <form class="form-signin" action="userPage" method="post" style="margin:0 auto">
	    用户名
	    <input type="text" id="inputEmail" class="" placeholder="${sessionScope.logUser.userName }" readOnly="true" name="userName"> 
	    不可更改
	    <div style="height:20px"></div>
	    密码
	    <input type="password" id="inputPassword" class="" placeholder="***************" required name="password"><div style="height:20px"></div>
	    <button class="btn btn-lg btn-primary btn-block" type="submit" style="width:200px;margin:0">提交编辑</button>
	  </form>
	  
  <hr>
   <div class="blog-header">
    <div class="container">
      <h3>${sessionScope.logUser.userName }发表的文章</h3>
    </div>
  </div>
  
	<div class="panel-body">
 		<ul class=" nav nav-pills flex-column" style="display: flex;flex-wrap: wrap;padding-left: 0;margin-bottom: 0;list-style: none; ">
			      		<%for(Essay essay:(List<Essay>)session.getAttribute("userEssay")){ %>
		      			<li class="nav-item" style="width:800px">
				         	 <a class="nav-link" href="essay?className=<%=essay.getClassName() %>&essay_id=<%=essay.getId() %>"><%=essay.getEssayName() %>
				         <!--  <p class="listtime">${essay.time }</p>-->
				         <p class="listtime" style="float:right">${essay.time }</p></a>
				        </li>
			      		<%} %>
				</ul>
				</div>
	</div>
	
</body>
</html>