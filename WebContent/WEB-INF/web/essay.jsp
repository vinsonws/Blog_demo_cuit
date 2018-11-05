<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>文章：${sessionScope.essay.essayName }</title>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">  
<link rel="stylesheet"  href="css/bootstrapMagic.css" />
<link rel="stylesheet"  href="css/essay.css" />
<link rel="stylesheet"  href="css/footer.css" />
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<jsp:include page="top_nav.jsp" />

<div style="height:100px;"></div>
  <div class="blog-header">
    <div class="container">
      <h1>${sessionScope.essay.essayName }</h1>
      <p class="lead blog-description">作者：${sessionScope.essay.author } 日期：${sessionScope.essay.time }</p>
    </div>
  </div>

<div class="container minhei">

  <div class="row">

    <div class="blog-main">
		${sessionScope.essay.content }
      
        
    </div>
    <!-- /.blog-main -->

    <!-- /.blog-sidebar -->
	<div style="height:100px;"></div>
  </div>
  <!-- /.row -->

</div>
<!-- /.container -->


<jsp:include page="footer.jsp" />
</body>
</html>