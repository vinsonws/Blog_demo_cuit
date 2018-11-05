<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>审核页面</title>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">  
<link rel="stylesheet"  href="css/bootstrapMagic.css" />
<link rel="stylesheet"  href="css/footer.css" />
<link rel="stylesheet"  href="css/index.css" />
<link rel="stylesheet"  href="css/listmenu.css" />
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="top_nav.jsp" />
<div class="nav2"></div>
<div class="container-fluid">
  <div class="row"  style="min-height:800px">
    <nav class="col-sm-3 col-md-2 d-none d-sm-block bg-light sidebar">
      <ul class="nav nav-pills flex-column">
        <li class="nav-item">
          <a class="nav-link active bg-info" href="#">审核中
            <span class="sr-only">(current)</span>
          </a>
        </li>
        
      </ul>
    </nav>

    <main role="main" class="col-sm-9 ml-sm-auto col-md-10 pt-3">
     
      <h2>审核列表</h2>
      <div class="table-responsive">
        <table class="table table-striped">
          <thead>
            <tr>
              <th>编号</th>
              <th>标题</th>
              <th>作者</th>
              <th>类别</th>
              <th>上传时间</th>
              <th>是否通过</th>
            </tr>
          </thead>
          <tbody>
          <c:forEach var="testingEssay" items="${sessionScope.testingList }">
            <tr>
              <td>${testingEssay.id }</td>
              <td><a href="essay?className=${testingEssay.className }&essay_id=${testingEssay.id }">${testingEssay.essayName}</a></td>
              <td>${testingEssay.author }</td>
              <th>${testingEssay.className }</th>
              <td>${testingEssay.time }</td>
              <td><a href="test?className=${testingEssay.className }&essay_id=${testingEssay.id }&instruct=pass">通过</a>|<a href="test?className=${testingEssay.className }&essay_id=${testingEssay.id }&instruct=failed">否</a></td>
            </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </main>
  </div>
</div>

<jsp:include page="footer.jsp" />
</body>
</html>